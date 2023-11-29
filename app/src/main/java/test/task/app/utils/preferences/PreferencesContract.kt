package test.task.app.utils.preferences

interface PreferencesContract {

    fun saveToken(token: String?)
    fun getToken() : String?
    fun clear()
}