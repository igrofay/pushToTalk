package talk.push.faceter.feature.navigation.app

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import talk.push.faceter.feature.ui.screen.dialogconmod.DialogConnectionMode
import talk.push.faceter.feature.ui.screen.functional.FunctionalScreen

@Composable
fun NavigationApp() {
    val nav = rememberNavController()
    NavHost(nav, NavigationRoute.FunctionalRoute.route){
        composable(NavigationRoute.FunctionalRoute.route){
            var visibleDialog by remember {
                mutableStateOf(false)
            }
            var relationshipMode = ""
            var connectionMode = ""
            FunctionalScreen{
                visibleDialog = true
                relationshipMode = it
            }
            DialogConnectionMode(
                visibleDialog,
                onDismiss = {visibleDialog = false}
            ) {
                connectionMode= it

            }
        }
    }
}