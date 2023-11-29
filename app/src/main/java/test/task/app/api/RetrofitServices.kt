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

interface RetrofitServices {

    @Headers(
        "Content-Type: application/json",
        "app-key: 12345",
        "v: 1"
    )
    @POST("/api-test/login")
    fun postLogin(@Body user: User) : Call<Token>

    @Headers(
        "Content-Type: application/json",
        "app-key: 12345",
        "v: 1",
    )
    @GET("/api-test/payments")
    fun getPayments(@Header("token") token: String) : Call<Payments>
}