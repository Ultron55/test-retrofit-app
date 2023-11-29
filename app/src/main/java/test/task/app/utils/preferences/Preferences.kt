package test.task.app.utils.preferences

import android.content.SharedPreferences
import javax.inject.Inject

class Preferences @Inject constructor(private val sharedPreferences: SharedPreferences):
    PreferencesContract {

    companion object {
        const val PREF_KEY_TOKEN = "token"
    }

    override fun saveToken(token: String?) {
        putString(PREF_KEY_TOKEN, token)
    }

    override fun getToken(): String? = getString(PREF_KEY_TOKEN)

    override fun clear() {
        sharedPreferences.edit().clear().apply()
    }

    private fun getString(preferencesKey: String, defaultValue: String? = null) =
        sharedPreferences.getString(preferencesKey, defaultValue) ?: defaultValue

    private fun getInt(preferencesKey: String, defaultValue: Int) = sharedPreferences.getInt(preferencesKey, defaultValue)

    private fun getLong(preferencesKey: String, defaultValue: Long) = sharedPreferences.getLong(preferencesKey, defaultValue)

    private fun getFloat(preferencesKey: String, defaultValue: Float) = sharedPreferences.getFloat(preferencesKey, defaultValue)

    private fun getBoolean(preferencesKey: String, defaultValue: Boolean = true) =
        sharedPreferences.getBoolean(preferencesKey, defaultValue)

    private fun putString(preferencesKey: String, value: String?) = sharedPreferences.edit().putString(preferencesKey, value).apply()

    private fun putInt(preferencesKey: String, value: Int) = sharedPreferences.edit().putInt(preferencesKey, value).apply()

    private fun putFloat(preferencesKey: String, value: Float) = sharedPreferences.edit().putFloat(preferencesKey, value).apply()

    private fun putBoolean(preferencesKey: String, value: Boolean) = sharedPreferences.edit().putBoolean(preferencesKey, value).apply()

    private fun putLong(preferencesKey: String, value: Long) = sharedPreferences.edit().putLong(preferencesKey, value).apply()


}