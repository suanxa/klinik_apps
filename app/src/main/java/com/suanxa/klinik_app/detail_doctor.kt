package com.suanxa.klinik_app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class detail_doctor : AppCompatActivity() {
    private lateinit var imgDoctor : ImageView
    private lateinit var nameDoctor:  TextView
    private lateinit var bidangDoctor : TextView
    private lateinit var totalReview : TextView
    private lateinit var angkaReview :TextView
    private lateinit var date : TextView
    private lateinit var time : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_doctor)

        val tombol1: TextView = findViewById(R.id.txtback)
        tombol1.setOnClickListener {
            val intent = Intent(this, doctor_page::class.java)
            startActivity(intent)
        }

        val detailImage = intent.getIntExtra("doctor",0)
        val detailNama = intent.getStringExtra("image")
        val detailBidang = intent.getStringExtra("BidangDr")
        val detailreview = intent.getStringExtra("totalReview")
        val detailangka = intent.getStringExtra("angkaReview")
        val detaildate = intent.getStringExtra("date")
        val detailtime = intent.getStringExtra("time")

        imgDoctor = findViewById(R.id.imgDoctor)
        nameDoctor = findViewById(R.id.txtNamaDoctor)
        bidangDoctor = findViewById(R.id.txtBidang)
        totalReview = findViewById(R.id.txtJumlahReview)
        angkaReview = findViewById(R.id.txtJumlahRating)
        date = findViewById(R.id.date2)
        time = findViewById(R.id.time2)

        imgDoctor.setImageResource(detailImage)
        nameDoctor.setText(detailNama)
        bidangDoctor.setText(detailBidang)
        totalReview.setText(detailreview)
        angkaReview.setText(detailangka)
        date.setText(detaildate)
        time.setText(detailtime)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}