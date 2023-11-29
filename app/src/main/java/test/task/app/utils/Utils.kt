package test.task.app.utils

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDirections

fun safeNavigate(navController: NavController, direction: NavDirections) {
    val action = navController.currentDestination?.getAction(direction.actionId)
    action.run {
        navController.navigate(direction)
    }
}

fun inDevDebugLog(m: Any?) { Log.d("IDDL", m.toString())}