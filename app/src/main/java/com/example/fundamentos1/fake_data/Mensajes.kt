package com.example.fundamentos1.fake_data

import com.example.fundamentos1.entidades.Usuario

class Mensajes {
    companion object{
        fun createMsgs(): List<Usuario>{
            var usuarios =  listOf(
                Usuario(
                    "Colleague",
                    "Test...Test...Test..."
                ),
                Usuario(
                    "Colleague",
                    "List of Android versions:\n" +
                            "Android KitKat (API 19)\n" +
                            "Android Lollipop (API 21)\n" +
                            "Android Marshmallow (API 23)\n" +
                            "Android Nougat (API 24)\n" +
                            "Android Oreo (API 26)\n" +
                            "Android Pie (API 28)\n" +
                            "Android 10 (API 29)\n" +
                            "Android 11 (API 30)\n" +
                            "Android 12 (API 31)\n"
                ),
                Usuario(
                    "Colleague",
                    "I think Kotlin is my favorite programming language.\n" +
                            "It's so much fun!"
                ),
                Usuario(
                    "Colleague",
                    "Searching for alternatives to XML layouts..."
                ),
                Usuario(
                    "Colleague",
                    "Hey, take a look at Jetpack Compose, it's great!\n" +
                            "It's the Android's modern toolkit for building native UI." +
                            "It simplifies and accelerates UI development on Android." +
                            "Less code, powerful tools, and intuitive Kotlin APIs :)"
                ),
                Usuario(
                    "Colleague",
                    "It's available from API 21+ :)"
                ),
                Usuario(
                    "Colleague",
                    "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
                ),
                Usuario(
                    "Colleague",
                    "Android Studio next version's name is Arctic Fox"
                ),
                Usuario(
                    "Colleague",
                    "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
                ),
                Usuario(
                    "Colleague",
                    "I didn't know you can now run the emulator directly from Android Studio"
                ),
                Usuario(
                    "Colleague",
                    "Compose Previews are great to check quickly how a composable layout looks like"
                ),
                Usuario(
                    "Colleague",
                    "Previews are also interactive after enabling the experimental setting"
                ),
                Usuario(
                    "Colleague",
                    "Have you tried writing build.gradle with KTS?"
                ),
            )
            return usuarios
        }
    }
}