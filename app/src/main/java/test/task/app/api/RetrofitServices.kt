package test.task.app.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import test.task.app.authorization.Payments
import test.task.app.authorization.Token
import test.task.app.authorization.User
import test.task.app.utils.APP_KEY
import test.task.app.utils.V

interface RetrofitServices {

    @Headers(
        "Content-Type: application/json",
        "app-key: $APP_KEY",
        "v: $V"
    )
    @POST("login")
    fun postLogin(@Body user: User) : Call<Token>

    @Headers(
        "Content-Type: application/json",
        "app-key: $APP_KEY",
        "v: $V"
    )
    @GET("payments")
    fun getPayments(@Header("token") token: String) : Call<Payments>
}