import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import composablefabbuttonsmultiplatform.composeapp.generated.resources.Res
import composablefabbuttonsmultiplatform.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var expanded by remember { mutableStateOf(false) }
        val transition = updateTransition(targetState = expanded, label = "FABs Animation")

        val fab1Offset by transition.animateDp(
            transitionSpec = { tween(durationMillis = 300) },
            label = "FAB 1 Offset"
        ) { if (it) 50.dp else 0.dp }

        val fab2Offset by transition.animateDp(
            transitionSpec = { tween(durationMillis = 300) },
            label = "FAB 2 Offset"
        ) { if (it) 100.dp else 0.dp }

        val fab3Offset by transition.animateDp(
            transitionSpec = { tween(durationMillis = 300) },
            label = "FAB 3 Offset"
        ) { if (it) 150.dp else 0.dp }

        val mainFabOffset by transition.animateDp(
            transitionSpec = { tween(durationMillis = 300) },
            label = "Main FAB Offset"
        ) { if (it) 200.dp else 0.dp }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ) {
            FloatingActionButton(
                onClick = {},
                backgroundColor = Color.Red,
                modifier = Modifier.offset(x = fab1Offset).padding(bottom = 16.dp)
            ) {
                Text("1", fontSize = 24.sp, color = Color.White)
            }
            FloatingActionButton(
                onClick = {},
                backgroundColor = Color.Green,
                modifier = Modifier.offset(x = fab2Offset).padding(bottom = 16.dp)
            ) {
                Text("2", fontSize = 24.sp, color = Color.White)
            }
            FloatingActionButton(
                onClick = {},
                backgroundColor = Color.Blue,
                modifier = Modifier.offset(x = fab3Offset).padding(bottom = 16.dp)
            ) {
                Text("3", fontSize = 24.sp, color = Color.White)
            }
            FloatingActionButton(
                onClick = { expanded = !expanded },
                backgroundColor = Color.Yellow,
                modifier = Modifier.offset(x = mainFabOffset)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Expand FAB")
            }
        }
    }
}