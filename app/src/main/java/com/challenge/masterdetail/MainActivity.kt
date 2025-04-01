package com.challenge.masterdetail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.challenge.master_detail.navigator.Navigator
import com.challenge.master_detail.navigator.NavigatorEvent
import com.challenge.master_detail.navigator.destination.ListNavigationDestination
import com.challenge.master_detail.ui.theme.MasterDetailTheme
import com.challenge.masterdetail.navigations.getNavigationDestinationScreenMap
import dagger.hilt.android.AndroidEntryPoint
import com.challenge.master_detail.navigator.destination.NavigationDestination
import com.challenge.master_detail.navigator.destination.toNavigationDestination
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MasterDetailTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()

                    val currentDestinationState by navController.currentBackStackEntryAsState()
                    val currentNavigationDestination = currentDestinationState?.destination?.route?.toNavigationDestination()

                    MainContent(
                        navController = navController,
                        currentDestination = currentNavigationDestination,
                        startDestination = ListNavigationDestination
                    )

                }
            }
        }
    }

    @Composable
    fun MainContent(
        modifier: Modifier = Modifier,
        navController: NavHostController,
        currentDestination: NavigationDestination?,
        startDestination: NavigationDestination
    ) {
        Scaffold(
            modifier = modifier,
            topBar = { }
        ) { paddingValues ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .consumeWindowInsets(paddingValues)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal
                        )
                    )
            ) {
                ManageNavController(navController)

                val composableDestinations = getNavigationDestinationScreenMap()

                NavHost(navController, startDestination = startDestination.route()) {
                    composableDestinations.forEach { entry ->
                        val destination = entry.key
                        composable(destination.route(), destination.arguments) {
                            entry.value()
                        }
                    }
                }
            }

        }
    }

    @Composable
    private fun ManageNavController(navController: NavHostController) {
        LaunchedEffect(navController) {
            navigator.destinations.collectLatest {
                when (val event = it) {
                    is NavigatorEvent.NavigateUp -> {
                        navController.navigateUp()
                    }
                    is NavigatorEvent.Directions -> {
                        navController.navigate(
                            event.destinationRoute,
                            event.builder
                        )
                    }
                }
            }
        }
    }
}



