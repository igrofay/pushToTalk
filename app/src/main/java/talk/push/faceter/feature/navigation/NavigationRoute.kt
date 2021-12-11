package talk.push.faceter.feature.navigation

sealed class NavigationRoute(val route: String){
    object FunctionalRoute : NavigationRoute("functional_route")

}
