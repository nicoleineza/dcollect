package com.example.dcollect

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.dcollect.data.Farmer
import com.example.dcollect.domain.FarmerViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FarmerFormScreen(
    viewModel: FarmerViewModel,
    onNavigateBack: () -> Unit
) {
    // State holders for form fields
    var name by remember { mutableStateOf("") }
    var idNumber by remember { mutableStateOf("") }
    var cropType by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        Text(
            "Register New Farmer",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )

        // Name Input Field
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Farmer Name") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                focusedLabelColor = MaterialTheme.colorScheme.primary
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        // ID Number Input Field
        OutlinedTextField(
            value = idNumber,
            onValueChange = { idNumber = it },
            label = { Text("ID Number") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                focusedLabelColor = MaterialTheme.colorScheme.primary
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        // Crop Type Input Field
        OutlinedTextField(
            value = cropType,
            onValueChange = { cropType = it },
            label = { Text("Crop Type") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                focusedLabelColor = MaterialTheme.colorScheme.primary
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.weight(1f)) // Push button to bottom

        // Submit Button
        Button(
            onClick = {
                viewModel.insert(
                    Farmer(
                        name = name.trim(),
                        idNumber = idNumber.trim(),
                        cropType = cropType.trim()
                    )
                )
                onNavigateBack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            enabled = name.isNotBlank() && idNumber.isNotBlank() && cropType.isNotBlank(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text("Register Farmer")
        }
    }
}

// ------------------------------------
// PREVIEW — uses a mock ViewModel
// ------------------------------------

@Preview(showBackground = true)
@Composable
fun FarmerFormScreenPreview() {
    // Fake ViewModel that does nothing, for preview only
    val fakeViewModel = object : FarmerViewModel(Application()) {
        override fun insert(farmer: Farmer): Job {
            // Simulate insert in preview
            return CoroutineScope(Dispatchers.Main).launch { /* no-op */ }
        }
    }

    FarmerFormScreen(
        viewModel = fakeViewModel,
        onNavigateBack = {} // No navigation for preview
    )
}
