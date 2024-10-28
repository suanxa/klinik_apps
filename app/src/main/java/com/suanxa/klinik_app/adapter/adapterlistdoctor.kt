    package com.suanxa.klinik_app.adapter

    import android.content.Intent
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.ImageView
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView
    import com.suanxa.klinik_app.R
    import com.suanxa.klinik_app.detail_doctor
    import com.suanxa.klinik_app.model.modellistdoctor


    class adapterlistdoctor(
        val itemListDoctors: List<modellistdoctor>
    ): RecyclerView.Adapter<adapterlistdoctor.MyviewHolder>() {

        class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
            var txtNamaDoktor : TextView = itemView.findViewById(R.id.txtNamaDoctor)
            var imgDoctor : ImageView = itemView.findViewById(R.id.imgDoctor)
            var imgBintang : ImageView = itemView.findViewById(R.id.imgBintang)
            var txtBidang : TextView = itemView.findViewById(R.id.txtBidang)
            var txtTotalReview : TextView = itemView.findViewById(R.id.txtJumlahReview)
            var txtTotalRating : TextView = itemView.findViewById(R.id.txtJumlahRating)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
            val nView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_doctor,parent,false)
            return MyviewHolder(nView)
        }

        override fun getItemCount(): Int {
            return itemListDoctors.size
        }

        override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
            val currentItem = itemListDoctors[position]
            holder.txtNamaDoktor.setText(currentItem.doctor)
            holder.imgDoctor.setImageResource(currentItem.image)
            holder.imgBintang.setImageResource(currentItem.imagebintang)
            holder.txtBidang.setText(currentItem.bidang)
            holder.txtTotalRating.setText(currentItem.totalreview)
            holder.txtTotalReview.setText(currentItem.angkareview)

            holder.itemView.setOnClickListener {
                val context = holder.itemView.context
                val intent = Intent(context, detail_doctor::class.java)

                intent.putExtra("image", currentItem.doctor)
                intent.putExtra("doctor", currentItem.image)
                intent.putExtra("BidangDr", currentItem.bidang)
                intent.putExtra("totalReview", currentItem.totalreview)
                intent.putExtra("angkaReview", currentItem.angkareview)
                intent.putExtra("date", currentItem.date)
                intent.putExtra("time", currentItem.time)

                context.startActivity(intent)
            }
        }
    }