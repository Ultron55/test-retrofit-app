package test.task.app.authorization

data class Token(
    var success: Boolean,
    var response: TokenResponce
)

data class TokenResponce(
    var token: String
)