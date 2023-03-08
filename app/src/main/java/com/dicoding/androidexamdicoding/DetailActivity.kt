package com.dicoding.androidexamdicoding

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.dicoding.androidexamdicoding.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var exo: Exo

    companion object{
        var EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnActionShare.setOnClickListener(this)

        exo = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra(EXTRA_DETAIL, Exo::class.java)!!
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DETAIL)!!
        }

        if (exo != null){
            binding.tvNameItem.text = exo.name
            binding.imgPhotoProfile.setImageResource(exo.photo)
            binding.tvDescription.text = exo.desc
            binding.includeBiodata.textStageName.text = exo.stageName
            binding.includeBiodata.textBirthName.text = exo.birthName
            binding.includeBiodata.textPosition.text = exo.position
            binding.includeBiodata.textBirthday.text = exo.birthday
            binding.includeBiodata.textNationality.text = exo.nationality
            binding.includeBiodata.textBloodType.text = exo.bloodType
            binding.includeBiodata.textMbti.text = exo.mbti
            binding.includeBiodata.textIg.text = exo.insta
            binding.includeBiodata.textWeibo.text = exo.weibo
            binding.includeFacts.textListFacts.text = exo.facts
        }
    }

    override fun onClick(view: View?) {

        val appPackageName:String = packageName

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Check more information using our App at: https://play.google.com/store/apps/details?id= "+ appPackageName)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}