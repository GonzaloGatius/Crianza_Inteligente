package com.gonzalogatius.crianza_inteligente

import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var typeFaceBaskervilleBold = Typeface.createFromAsset(assets, "fonts/LibreBaskerville-Bold.ttf")
        var typeFaceBaskervilleItalic = Typeface.createFromAsset(assets, "fonts/LibreBaskerville-Italic.ttf")
        var typeFaceBaskervilleRegular = Typeface.createFromAsset(assets, "fonts/LibreBaskerville-Regular.ttf")


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var title : TextView = findViewById(R.id.tv_title)
        title.typeface = typeFaceBaskervilleBold

        var login : TextView = findViewById(R.id.button_Login)
        login.typeface = typeFaceBaskervilleRegular

        var register : TextView = findViewById(R.id.button_Register)
        register.typeface = typeFaceBaskervilleRegular
    }
}