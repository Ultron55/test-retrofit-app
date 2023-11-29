package test.task.app.authorization

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login")
    var login: String,
    @SerializedName("password")
    var password: String,
)
