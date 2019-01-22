package com.example.sondre.oblig_1_name_quizz

import android.app.ActionBar
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract
import android.renderscript.Script
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.*

import kotlinx.android.synthetic.main.activity_data.*
import org.w3c.dom.Text

class DataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        setSupportActionBar(toolbar)

        //Back knapp
        supportActionBar!!.title = resources.getString(R.string.back)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        val layout = findViewById<LinearLayout>(R.id.linear);

        val imgs:TypedArray = getResources().obtainTypedArray(R.array.quizzpictures);


        for (i in 0..imgs.length()-1) {

            imgs.getResourceId(i, 0);

            //Imageview og textview
            val imgView = ImageView(this);
            val nameTextView = TextView(this)

            //Konverterer dp til piksler
            val height: Int = (300 * resources.displayMetrics.density).toInt()
            val width: Int = (300 * resources.displayMetrics.density).toInt()


            imgView.setImageResource(imgs.getResourceId(i, 0));
            //Setter størrelse på Imageviewet.
            val lp = LinearLayout.LayoutParams(width, height)
            imgView.setLayoutParams(lp)
            layout.addView(imgView)

            //Hashmap med bilde og navn
            val dataPic = HashMap<ImageView, String>()
            dataPic.put(imgView, "Navn")

            nameTextView.setText(dataPic.get(imgView))
            nameTextView.gravity = Gravity.CENTER

            layout.addView(nameTextView)
        }
        imgs.recycle();
    }

}
