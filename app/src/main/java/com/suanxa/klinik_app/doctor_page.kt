package com.suanxa.klinik_app

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.ColorSpace.Model
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suanxa.klinik_app.R
import com.suanxa.klinik_app.adapter.adapterlistdoctor
import com.suanxa.klinik_app.adapter.adaptermenuicon
import com.suanxa.klinik_app.model.modelicon
import com.suanxa.klinik_app.model.modellistdoctor

class doctor_page : AppCompatActivity() {

    private lateinit var RecyclerViewMenu : RecyclerView
    private lateinit var AdapterMenu : adaptermenuicon

    private lateinit var RecyclerViewDoctor : RecyclerView
    private lateinit var AdapterDoctor : adapterlistdoctor

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctor_page)

        //data contoh untuk menu
        val menuIcons = listOf(
            modelicon(R.drawable.iconheart,"cardiologist"),
            modelicon(R.drawable.iconeye,"Ophthalmologyst"),
            modelicon(R.drawable.icontooth,"Dentist")
        )


        //inisialisasi recyclerview dan adapter
        RecyclerViewMenu = findViewById(R.id.recycleViewMenu)
        RecyclerViewMenu.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        AdapterMenu = adaptermenuicon(menuIcons)
        RecyclerViewMenu.adapter = AdapterMenu

        //data untuk dokter
        val menudokter = listOf(
            modellistdoctor("Dr.Floyd Miles",R.drawable.dokter1,R.drawable.bintang,"Pediatrics","(123 reviews)","4.9","20-Sep-2024","09.00pm"),
            modellistdoctor("Dr.Guy Hawkins",R.drawable.dokter2,R.drawable.bintang,"Dentist","(85 reviews)","4.9","18-Sep-2024","10.00pm"),
            modellistdoctor("Dr.Jane Cooper",R.drawable.dokter3,R.drawable.bintang,"Cardiologist","(44 reviews)","4.7","28-Sep-2024","07.00pm"),
            modellistdoctor("Dr.Jacob Jones",R.drawable.dokter4,R.drawable.bintang,"Nephrologyst","(101 reviews)","5.0","7-Sep-2024","09.00am"),
            modellistdoctor("Dr.Savannah Nguyen",R.drawable.dokter5,R.drawable.bintang,"Urologist","(168 reviews)","4.8","4-Sep-2024","02.00pm")
        )

        //inisialisasi recycleview dan adapter
        RecyclerViewDoctor = findViewById(R.id.recycleViewDoctor)
        RecyclerViewDoctor.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        AdapterDoctor= adapterlistdoctor(menudokter)
        RecyclerViewDoctor.adapter = AdapterDoctor


        val tombol1: TextView = findViewById(R.id.textView7)
        tombol1.setOnClickListener {
            val intent = Intent(this, pagelogin::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}