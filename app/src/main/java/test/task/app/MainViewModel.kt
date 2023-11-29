package test.task.app

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.task.app.api.RetrofitAPI
import test.task.app.authorization.Payments
import test.task.app.authorization.Token
import test.task.app.authorization.User
import test.task.app.utils.inDevDebugLog
import test.task.app.utils.preferences.PreferencesContract
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val preferences: PreferencesContract) : ViewModel() {
    val loginIs = MutableLiveData<Boolean>()

    fun login(login: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = User(login, password)
            RetrofitAPI.retrofitServices.postLogin(user).enqueue(object : Callback<Token> {
                override fun onResponse(call: Call<Token>,
                                        response: Response<Token>) {
                    RetrofitAPI.token =
                        if (response.body().success)
                            response.body().response.token
                        else
                            null
                    preferences.saveToken(RetrofitAPI.token)
                    loginIs.postValue(response.body().success)
                }

                override fun onFailure(call: Call<Token>?, t: Throwable?) {
                    Log.e("login", t?.message.toString())
                    loginIs.postValue(false)
                }
            })
        }
    }


    fun checkLogined(): Boolean {
        val token: String? = RetrofitAPI.token ?: preferences.getToken()
        RetrofitAPI.token = token
        preferences.saveToken(token)
        return token != null
    }

    fun getPayments() {
        if (RetrofitAPI.token == null) return
        RetrofitAPI.retrofitServices.getPayments(RetrofitAPI.token!!)
            .enqueue(object : Callback<Payments> {
                override fun onResponse(call: Call<Payments>?, response: Response<Payments>?) {
                    if (response == null) inDevDebugLog(null)
                    else {
                        inDevDebugLog(response.body())
                        response.body().response.forEach{
                            inDevDebugLog("${it.id} ${it.title} ${it.amount} ${it.created}")
                        }
                    }
                }

                override fun onFailure(call: Call<Payments>?, t: Throwable?) {
                    Log.e("getPayments", t?.message.toString())
                }
            })
    }

    fun logout(): Boolean{
        RetrofitAPI.token = null
        loginIs.postValue(false)
        preferences.saveToken(null)
        return RetrofitAPI.token.equals(null)
    }
}

