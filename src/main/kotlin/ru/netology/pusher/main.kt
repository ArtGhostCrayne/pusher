package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fmc.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
//        .putData("action", "LIKE")
        .putData("action", "POST")
//        .putData("content", """{
//          "userId": 1,
//          "userName": "Vasiliy",
//          "postId": 2,
//          "postAuthor": "Netology"
//        }""".trimIndent())
        .putData("content", """{
          "author": "Нетология",
          "title": "Меняем карьеру через образование",
          "content": "В Новый год могут исполниться любые желания — главное, правильно их сформулировать. Кевин Маккаллистер устал ссориться с семьёй и загадал остаться один дома, хотя можно было попросить у волшебника Санты лучший в мире праздник с морем газировки, сладостей и фильмами до самого утра."
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}
