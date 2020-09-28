package com.example.hablamundi

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_colors.*
import kotlinx.android.synthetic.main.activity_colors.buttonBack

class AnimalsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)
        setFlag()
        setup()
    }

    private fun setup()
    {
        buttonBack.setOnClickListener{
            showHome(email ?: "")
        }
        imageViewIdiomaAnimal.setOnClickListener {
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
                        imageViewIdiomaAnimal.setImageResource(R.drawable.banderainglaterra)
                    }
                    "Español" -> {
                        imageViewIdiomaAnimal.setImageResource(R.drawable.banderaespana)
                    }
                    "Portugues" -> {
                        imageViewIdiomaAnimal.setImageResource(R.drawable.banderaportugal)
                    }
                }
        }

        buttonAnimalsMonkey.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val monkey = MediaPlayer.create(this,R.raw.monkey)
                    monkey.start()
                }
                "Español" -> {
                    val monkey = MediaPlayer.create(this,R.raw.mono)
                    monkey.start()
                }
                "Portugues" -> {
                    val monkey = MediaPlayer.create(this,R.raw.macaco)
                    monkey.start()
                }
            }
        }

        buttonAnimalsLion.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val lion = MediaPlayer.create(this,R.raw.lion)
                    lion.start()
                }
                "Español" -> {
                    val lion = MediaPlayer.create(this,R.raw.leon)
                    lion.start()
                }
                "Portugues" -> {
                    val lion = MediaPlayer.create(this,R.raw.leao)
                    lion.start()
                }
            }
        }

        buttonAnimalsBear.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val bear = MediaPlayer.create(this,R.raw.bear)
                    bear.start()
                }
                "Español" -> {
                    val bear = MediaPlayer.create(this,R.raw.oso)
                    bear.start()
                }
                "Portugues" -> {
                    val bear = MediaPlayer.create(this,R.raw.urso)
                    bear.start()
                }
            }
        }

        buttonAnimalsDog.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val dog = MediaPlayer.create(this,R.raw.dog)
                    dog.start()
                }
                "Español" -> {
                    val dog = MediaPlayer.create(this,R.raw.perro)
                    dog.start()
                }
                "Portugues" -> {
                    val dog = MediaPlayer.create(this,R.raw.cachorro)
                    dog.start()
                }
            }
        }

        buttonAnimalsCat.setOnClickListener{
            when (flagIdioma) {
                "Ingles" -> {
                    val cat = MediaPlayer.create(this,R.raw.cat)
                    cat.start()
                }
                "Español" -> {
                    val cat = MediaPlayer.create(this,R.raw.gato)
                    cat.start()
                }
                "Portugues" -> {
                    val cat = MediaPlayer.create(this,R.raw.gatobr)
                    cat.start()
                }
            }
        }
    }

    private fun setFlag()
    {
        when (flagIdioma) {
            "Ingles" ->{
                flag = 0
                imageViewIdiomaAnimal.setImageResource(R.drawable.banderainglaterra)
            }
            "Español" -> {
                flag = 1
                imageViewIdiomaAnimal.setImageResource(R.drawable.banderaespana)
            }
            "Portugues" -> {
                flag = 2
                imageViewIdiomaAnimal.setImageResource(R.drawable.banderaportugal)
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