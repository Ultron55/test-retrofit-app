package test.task.app.authorization

data class Payments (
    var success: Boolean,
    var response: List<Payment>
)

data class Payment(
    val id: Long?,
    val title: String?,
    val amount: String?,
    val created: String?
)