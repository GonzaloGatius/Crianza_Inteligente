package com.gonzalogatius.crianza_inteligente

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttontestlogin: Button
    private lateinit var bt_Preparto: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(1800)
        setTheme(R.style.Base_Theme_Crianza_Inteligente)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttontestlogin = findViewById(R.id.buttontestlogin)
        bt_Preparto = findViewById(R.id.bt_Preparto)


        buttontestlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent) }

        bt_Preparto.setOnClickListener {
            val intent = Intent(this, PrepartoActivity::class.java)
            startActivity(intent) }
    }

}