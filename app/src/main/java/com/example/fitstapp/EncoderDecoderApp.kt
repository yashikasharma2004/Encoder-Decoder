package com.example.fitstapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EncoderDecoderApp() {

    var inputText by remember { mutableStateOf("") }
    var outputResult by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.2f)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xBB000000))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "🔐 Secret Message App",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Encode or decode your secret messages",
                fontSize = 13.sp,
                color = Color(0xFFAAAAAA),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Input Field
            OutlinedTextField(
                value = inputText,
                onValueChange = {
                    inputText = it
                    outputResult = ""
                    isError = false
                },
                label = { Text("Enter text to encode / decode", color = Color.White) },
                textStyle = TextStyle(color = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                maxLines = 5
            )

            // ENCODE Button
            Button(
                onClick = {
                    if (inputText.isBlank()) {
                        isError = true
                    } else {
                        isError = false
                        outputResult = encode(inputText)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF00BCD4)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    "🔒 Encode",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }

            // DECODE Button
            Button(
                onClick = {
                    if (inputText.isBlank()) {
                        isError = true
                    } else {
                        isError = false
                        outputResult = decode(inputText)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFFFF5722)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    "🔓 Decode",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }

            // CLEAR Button
            OutlinedButton(
                onClick = {
                    inputText = ""
                    outputResult = ""
                    isError = false
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("🗑️ Clear", color = Color.White, fontSize = 14.sp)
            }

            // Error Message
            if (isError) {
                Text(
                    text = "⚠️ Please enter some text first!",
                    color = Color(0xFFFF5252),
                    fontSize = 13.sp
                )
            }

            // Result Box
            if (outputResult.isNotEmpty()) {
                HorizontalDivider(color = Color(0xFF444444), thickness = 1.dp)

                Text(
                    text = "Result:",
                    fontSize = 14.sp,
                    color = Color(0xFFAAAAAA),
                    modifier = Modifier.fillMaxWidth()
                )

                SelectionContainer {
                    Text(
                        text = outputResult,
                        fontSize = 16.sp,
                        color = Color(0xFF00E5FF),
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF1A1A2E), RoundedCornerShape(10.dp))
                            .padding(16.dp)
                    )
                }

                Text(
                    text = "💡 Long press the result to copy!",
                    fontSize = 11.sp,
                    color = Color(0xFF777777),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

fun encode(input: String): String {
    return input.map { char ->
        (char.code + 2).toChar()
    }.joinToString("")
}

fun decode(input: String): String {
    return input.map { char ->
        (char.code - 2).toChar()
    }.joinToString("")
}