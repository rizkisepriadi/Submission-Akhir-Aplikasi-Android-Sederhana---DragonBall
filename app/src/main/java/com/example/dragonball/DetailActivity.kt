package com.example.dragonball


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.dragonball.databinding.ActivityDetailBinding

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    private lateinit var handler: Handler
    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        handler = Handler(Looper.getMainLooper())
        supportActionBar?.title = "Detail Character"

        val data = intent.getParcelableExtra<DragonBall>(EXTRA_NAME)
        Log.d("DetailActivity", "Received data: $data")

        when (data?.name) {
            "Son Goku" -> setBackground(R.color.goku_secondary)
            "Son Gohan" -> setBackground(R.color.gohan)
            "Son Goten" -> setBackground(R.color.goten)
            "Vegeta" -> setBackground(R.color.vegeta)
            "Piccolo" -> setBackground(R.color.piccolo)
            "Future Trunks" -> setBackground(R.color.trunks)
            "Master Roshi" -> setBackground(R.color.roshi)
            "Tenshinhan" -> setBackground(R.color.tenshinhan)
            "Krillin" -> setBackground(R.color.krillin)
            "Yamcha" -> setBackground(R.color.yamcha)
        }

        Glide.with(this@DetailActivity).load(data?.photo).into(detailBinding.ivPhoto)

        with(detailBinding) {
            tvName.text = data?.name
            tvRace.text = data?.race
            tvHeight.text = "${data?.height} cm"
            tvWeight.text = "${data?.weight} kg"
            tvSkill.text = data?.technique
            tvForm.text = data?.transfromation
            tvReferences.text = data?.references
            tvDescription.text = data?.description

            fabShare.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(
                    Intent.EXTRA_TEXT,
                    ("${data?.name}")
                )
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent, "Send To"))
            }

            detailBinding.tvReferences.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(data?.references)
                startActivity(intent)
            }
        }
    }

    private fun setBackground(background: Int) {
        val resolvedBackgroundColor = ContextCompat.getColor(this, background)

        with(detailBinding) {
            vBackground.setBackgroundColor(resolvedBackgroundColor)
        }

    }
}