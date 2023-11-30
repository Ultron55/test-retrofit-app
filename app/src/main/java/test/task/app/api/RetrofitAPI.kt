package test.task.app.api

object RetrofitAPI {
    private val BASE_URL = "https://easypay.world/api-test/"
    val retrofitServices: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
    var token : String? = null
}