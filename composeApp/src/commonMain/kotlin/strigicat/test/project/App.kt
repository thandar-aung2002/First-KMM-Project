package strigicat.test.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import adkmm.composeapp.generated.resources.Res
import adkmm.composeapp.generated.resources.compose_multiplatform
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun App() {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showContent by remember { mutableStateOf(false) }
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextField(
                value = userName,
                onValueChange = { userName = it},
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = { password = it},
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { showContent = !showContent}){
                Text("Login")
            }
            androidx.compose.animation.AnimatedVisibility(showContent){
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Welcome $userName")
                }
            }
        }
    }
}