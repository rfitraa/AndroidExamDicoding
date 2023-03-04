package com.dicoding.androidexamdicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvEmail:TextView
    private lateinit var tvName:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.title = "About Me"

        tvEmail = findViewById(R.id.about_me_email)
        tvName = findViewById(R.id.tv_about_me_name)

        val btnShare:Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val email = tvEmail.text.toString()
        val name = tvName.text.toString()

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Hey I'm $name and you send me directly message to $email")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}