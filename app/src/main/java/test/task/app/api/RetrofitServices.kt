package test.task.app.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
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
}