package test.task.app

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.task.app.api.RetrofitClient
import test.task.app.api.RetrofitServices
import test.task.app.authorization.Token
import test.task.app.authorization.User
import test.task.app.utils.inDevDebugLog

class MainViewModel : ViewModel() {
    private val BASE_URL = "https://easypay.world/"
    val retrofitServices: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
    val loginIs = MutableLiveData<Boolean>()
    var token : String? = null

    fun login(login: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = User(login, password)
            retrofitServices.postLogin(user).enqueue(object : Callback<Token> {
                override fun onResponse(call: Call<Token>,
                                        response: Response<Token>) {
                    inDevDebugLog(call.request().headers())
                    inDevDebugLog(call.request())
                    inDevDebugLog("${response.isSuccessful}")
                    inDevDebugLog("body ${response.body()}")
                    token = response.body().response.token
                    inDevDebugLog("${response.code()}")
                    loginIs.postValue(response.isSuccessful)
                }

                override fun onFailure(call: Call<Token>?, t: Throwable?) {
                    Log.e("login", t?.message.toString())
                    loginIs.postValue(false)
                }
            })
        }
    }
}

