import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale

@Composable
fun RippleImage(imageResId: Int, modifier: Modifier = Modifier) {
    var time by remember { mutableStateOf(0f) }

    LaunchedEffect(Unit) {
        while(true) {
            withFrameNanos { frameTime ->
                time = (frameTime / 1_000_000_000f) % 1f
            }
        }
    }

    val density = LocalDensity.current.density
    val paint = remember {
        Paint().asFrameworkPaint().apply {
            shader = RuntimeShader(RIPPLE_SHADER)
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawIntoCanvas { canvas ->
                (paint as AndroidPaint).shader.setFloatUniform("time", time)
                paint.shader.setFloatUniform("resolution", size.width * density, size.height * density)
                canvas.nativeCanvas.drawPaint(paint)
            }
        }
    }
}

private const val RIPPLE_SHADER = """
    uniform float2 resolution;
    uniform float time;
    
    float2 ripple(float2 uv, float2 center, float t) {
        float2 p = uv - center;
        float len = length(p);
        float amplitude = 0.05 * exp(-len * 4.0);
        float phase = -len * 20.0 - t * 5.0;
        return uv + p / len * amplitude * sin(phase);
    }
    
    half4 main(in float2 fragCoord) {
        float2 uv = fragCoord / resolution;
        float2 center = float2(0.5, 0.5);
        
        uv = ripple(uv, center, time);
        uv = ripple(uv, center + float2(0.1, 0.1), time * 1.1);
        uv = ripple(uv, center - float2(0.1, 0.1), time * 0.9);
        
        return half4(uv, 0.0, 1.0);
    }
"""

@Composable
fun RippleImageScreen() {
    RippleImage(imageResId = R.drawable.your_image)
}