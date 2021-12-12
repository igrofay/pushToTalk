package talk.push.faceter.feature.navigation.app

sealed class NavigationRoute(val route: String){
    object FunctionalRoute : NavigationRoute("functional_route")

}
