package com.example.hablamundi

import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.*
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hablamundi.R.*
import kotlinx.android.synthetic.main.activity_colors.*

class ColorsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_colors)
        setFlag()
        setup()
    }

    private fun setup()
    {
        buttonBack.setOnClickListener{
            showHome(email ?: "")
        }

        buttonColorsRed.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val red = MediaPlayer.create(this,R.raw.red)
                    red.start()
                }
                "Español" -> {
                    val red = MediaPlayer.create(this,R.raw.rojo)
                    red.start()
                }
                "Portugues" -> {
                    val red = MediaPlayer.create(this,R.raw.vermello)
                    red.start()
                }
            }
        }
        buttonColorsBlue.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val blue = MediaPlayer.create(this,R.raw.blue)
                    blue.start()
                }
                "Español" -> {
                    val blue = MediaPlayer.create(this,R.raw.azul)
                    blue.start()
                }
                "Portugues" -> {
                    val blue = MediaPlayer.create(this,R.raw.azulbr)
                    blue.start()
                }
            }
        }
        buttonColorsGreen.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val green = MediaPlayer.create(this,R.raw.green)
                    green.start()
                }
                "Español" -> {
                    val green = MediaPlayer.create(this,R.raw.verde)
                    green.start()
                }
                "Portugues" -> {
                    val green = MediaPlayer.create(this,R.raw.verdebr)
                    green.start()
                }
            }
        }
        buttonColorsYellow.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val yellow = MediaPlayer.create(this,raw.yellow)
                    yellow.start()
                }
                "Español" -> {
                    val yellow = MediaPlayer.create(this,raw.amarillo)
                    yellow.start()
                }
                "Portugues" -> {
                    val yellow = MediaPlayer.create(this,raw.amarelo)
                    yellow.start()
                }
            }
        }
        buttonColorsPink.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val pink = MediaPlayer.create(this,raw.pink)
                    pink.start()
                }
                "Español" -> {
                    val pink = MediaPlayer.create(this,raw.rosa)
                    pink.start()
                }
                "Portugues" -> {
                    val pink = MediaPlayer.create(this,raw.rosabr)
                    pink.start()
                }
            }
        }

        imageViewIdiomaColor.setOnClickListener{
            imageViewIdiomaColor.setOnClickListener{
                flag++
                if(flag>2)
                {
                    flag=0
                }

                when (flag) {
                    0 -> flagIdioma = "Ingles"
                    1 -> flagIdioma = "Español"
                    2 -> flagIdioma = "Portugues"
                }

                when (flagIdioma) {
                    "Ingles" -> {imageViewIdiomaColor.setImageResource(drawable.banderainglaterra) }
                    "Español" -> {imageViewIdiomaColor.setImageResource(drawable.banderaespana) }
                    "Portugues" -> {imageViewIdiomaColor.setImageResource(drawable.banderaportugal) }
                }

            }
        }

    }

    private fun setFlag()
    {
        when (flagIdioma) {
            "Ingles" ->{
                flag = 0
                imageViewIdiomaColor.setImageResource(drawable.banderainglaterra)
            }
            "Español" -> {
                flag = 1
                imageViewIdiomaColor.setImageResource(drawable.banderaespana)
            }
            "Portugues" -> {
                flag = 2
                imageViewIdiomaColor.setImageResource(drawable.banderaportugal)
            }
        }
    }

    private fun showHome(email: String) {
        val homeIntent: Intent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
        }
        startActivity(homeIntent)
    }

}