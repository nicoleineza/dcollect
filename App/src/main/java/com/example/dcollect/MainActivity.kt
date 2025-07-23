package com.example.dcollect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.dcollect.domain.FarmerViewModel
import com.example.dcollect.ui.theme.DcollectTheme
import com.example.dcollect.FarmerRegistrationApp as FarmerRegistrationApp1

class MainActivity : ComponentActivity() {
    private val viewModel: FarmerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DcollectTheme {  }
                FarmerRegistrationApp1(viewModel = viewModel)
            }
        }
    }

@Composable
fun FarmerRegistrationApp(viewModel: FarmerViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "farmerList"
    ) {
        composable("farmerList") {
            FarmerListScreen(
                viewModel = viewModel,
                onAddFarmer = { navController.navigate("farmerForm") }
            )
        }
        composable("farmerForm") {
            FarmerFormScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}

fun composable(s: String, function: @Composable () -> Unit) {

}
