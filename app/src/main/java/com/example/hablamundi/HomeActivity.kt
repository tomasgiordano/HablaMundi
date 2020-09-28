package com.example.hablamundi

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.OrientationEventListener
import android.view.WindowManager
import androidx.core.view.marginTop
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_colors.*

import kotlinx.android.synthetic.main.activity_home.*


enum class ProviderType {
    EmailPassword
}

var flagIdioma : String = "Ingles"
var flag = 0
var email : String? = ""


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //Setup
        val bundle = intent.extras
        email = bundle?.getString("email")
        setFlag()
        setup(email ?: "")
    }


    private fun setup(email: String)
    {
        title = "Home"
        if(emailTextView!=null)
        {
            emailTextView.text = email
        }

        setFlag()
        logOutButton.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        onConfigurationChanged()

        buttonColors.setOnClickListener{
            showColors()
        }

        buttonAnimals.setOnClickListener{
            showAnimals()
        }

        buttonNumbers.setOnClickListener{
            showNumbers()
        }

        imageViewIdioma.setOnClickListener{
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
                "Ingles" -> imageViewIdioma.setImageResource(R.drawable.banderainglaterra)
                "Español" -> imageViewIdioma.setImageResource(R.drawable.banderaespana)
                "Portugues" -> imageViewIdioma.setImageResource(R.drawable.banderaportugal)
            }


        }
    }

    private fun showColors()
    {
        val colorsIntent = Intent(this, ColorsActivity::class.java)
        startActivity(colorsIntent)
    }

    private fun showAnimals()
    {
        val animalsIntent = Intent(this, AnimalsActivity::class.java)
        startActivity(animalsIntent)
    }

    private fun showNumbers()
    {
        val numbersIntent = Intent(this, NumbersActivity::class.java)
        startActivity(numbersIntent)
    }

    private fun setFlag()
    {
        when (flagIdioma) {
            "Ingles" ->{
                flag = 0
                imageViewIdioma.setImageResource(R.drawable.banderainglaterra)
            }
            "Español" -> {
                flag = 1
                imageViewIdioma.setImageResource(R.drawable.banderaespana)
            }
            "Portugues" -> {
                flag = 2
                imageViewIdioma.setImageResource(R.drawable.banderaportugal)
            }
        }
    }

    @Override public fun onConfigurationChanged()
    {

    }

}