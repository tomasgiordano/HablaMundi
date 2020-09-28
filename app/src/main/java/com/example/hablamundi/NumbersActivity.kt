package com.example.hablamundi
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_colors.*
import kotlinx.android.synthetic.main.activity_colors.buttonBack
import kotlinx.android.synthetic.main.activity_numbers.*

class NumbersActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)
        setFlag()
        setup()
    }

    private fun setup()
    {
        buttonBack.setOnClickListener{
            showHome(email ?: "")
        }

        imageViewIdiomaNumber.setOnClickListener {
            flag++
            if (flag > 2) {
                flag = 0
            }

            when (flag) {
                0 -> flagIdioma = "Ingles"
                1 -> flagIdioma = "Español"
                2 -> flagIdioma = "Portugues"
            }

            when (flagIdioma) {
                "Ingles" -> {
                    imageViewIdiomaNumber.setImageResource(R.drawable.banderainglaterra)
                }
                "Español" -> {
                    imageViewIdiomaNumber.setImageResource(R.drawable.banderaespana)
                }
                "Portugues" -> {
                    imageViewIdiomaNumber.setImageResource(R.drawable.banderaportugal)
                }
            }
        }

        buttonNumbersOne.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val one = MediaPlayer.create(this,R.raw.one)
                    one.start()
                }
                "Español" -> {
                    val one = MediaPlayer.create(this,R.raw.uno)
                    one.start()
                }
                "Portugues" -> {
                    val one = MediaPlayer.create(this,R.raw.um)
                    one.start()
                }
            }
        }

        buttonNumbersTwo.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val two = MediaPlayer.create(this,R.raw.two)
                    two.start()
                }
                "Español" -> {
                    val two = MediaPlayer.create(this,R.raw.dos)
                    two.start()
                }
                "Portugues" -> {
                    val two = MediaPlayer.create(this,R.raw.dois)
                    two.start()
                }
            }
        }

        buttonNumbersThree.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val three = MediaPlayer.create(this,R.raw.three)
                    three.start()
                }
                "Español" -> {
                    val three = MediaPlayer.create(this,R.raw.tres)
                    three.start()
                }
                "Portugues" -> {
                    val three = MediaPlayer.create(this,R.raw.tresbr)
                    three.start()
                }
            }
        }

        buttonNumbersFour.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val four = MediaPlayer.create(this,R.raw.four)
                    four.start()
                }
                "Español" -> {
                    val four = MediaPlayer.create(this,R.raw.cuatro)
                    four.start()
                }
                "Portugues" -> {
                    val four = MediaPlayer.create(this,R.raw.cuatrobr)
                    four.start()
                }
            }
        }

        buttonNumbersFive.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val five = MediaPlayer.create(this,R.raw.five)
                    five.start()
                }
                "Español" -> {
                    val five = MediaPlayer.create(this,R.raw.cinco)
                    five.start()
                }
                "Portugues" -> {
                    val five = MediaPlayer.create(this,R.raw.cincu)
                    five.start()
                }
            }
        }
    }

    private fun setFlag()
    {
        when (flagIdioma) {
            "Ingles" ->{
                flag = 0
                imageViewIdiomaNumber.setImageResource(R.drawable.banderainglaterra)
            }
            "Español" -> {
                flag = 1
                imageViewIdiomaNumber.setImageResource(R.drawable.banderaespana)
            }
            "Portugues" -> {
                flag = 2
                imageViewIdiomaNumber.setImageResource(R.drawable.banderaportugal)
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