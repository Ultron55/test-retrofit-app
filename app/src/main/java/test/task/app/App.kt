package test.task.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import test.task.app.utils.preferences.PreferencesContract
import javax.inject.Inject


@HiltAndroidApp
class App : Application(){
    @Inject
    lateinit var preferences: PreferencesContract
}