package com.example.dragonball

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dragonball.databinding.ActivityAboutMeBinding
import com.example.dragonball.databinding.ActivityMainBinding

class AboutMe : AppCompatActivity() {
    private lateinit var aboutMeBinding: ActivityAboutMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aboutMeBinding = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(aboutMeBinding.root)

        supportActionBar?.title = "About Me"

        aboutMeBinding.btnOk.setOnClickListener {
            finish()
        }

        aboutMeBinding.btnLinkedIn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/in/rizkisepriadi-057b8a233")
            startActivity(intent)
        }

        aboutMeBinding.btnInstagram.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://instagram.com/rizki.sepriadi/")
            startActivity(intent)
        }
    }
}
