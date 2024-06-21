import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import composablefabbuttonsmultiplatform.composeapp.generated.resources.Res
import composablefabbuttonsmultiplatform.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var expanded by remember { mutableStateOf(false) }
        val rotation by animateFloatAsState(targetValue = if (expanded) 45f else 0f)

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            if (expanded) {
                FloatingActionButton(
                    onClick = { /* TODO: Handle secondary FAB click */ },
                    backgroundColor = MaterialTheme.colors.secondary,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Icon(Icons.Default.Email, contentDescription = null)
                }
                FloatingActionButton(
                    onClick = { /* TODO: Handle secondary FAB click */ },
                    backgroundColor = MaterialTheme.colors.secondary,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Icon(Icons.Default.Phone, contentDescription = null)
                }
            }
            FloatingActionButton(
                onClick = { expanded = !expanded },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = null, Modifier.rotate(rotation))
            }
        }
    }
}