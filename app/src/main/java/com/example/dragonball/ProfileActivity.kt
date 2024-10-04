package com.example.dragonball

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dragonball.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var profileBinding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(profileBinding.root)

        supportActionBar?.title = "Profile"

        profileBinding.button.setOnClickListener {
            val intent = Intent(this, AboutMe::class.java)
            startActivity(intent)
        }
    }
}