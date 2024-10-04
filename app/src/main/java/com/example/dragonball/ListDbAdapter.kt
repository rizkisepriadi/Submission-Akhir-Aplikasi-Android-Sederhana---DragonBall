package com.example.dragonball

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dragonball.databinding.ItemDragonBallBinding

class ListDbAdapter(private val listDb: ArrayList<DragonBall>) :
    RecyclerView.Adapter<ListDbAdapter.ListDbViewHolder>() {

    inner class ListDbViewHolder(private val itemDragonBallBinding: ItemDragonBallBinding) :
        RecyclerView.ViewHolder(itemDragonBallBinding.root) {
        fun bindItem(dragonBall: DragonBall) {
            with(itemDragonBallBinding) {
                tvName.text = dragonBall.name
                tvDescription.text = dragonBall.description
            }

            with(itemDragonBallBinding.ivThumbnail) {
                setBackgroundResource(R.drawable.circle_db)
                Glide.with(itemView)
                    .load(dragonBall.thumbnail)
                    .apply(RequestOptions.circleCropTransform())
                    .into(this)
            }

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_NAME, dragonBall)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListDbViewHolder {
        val adapter =
            ItemDragonBallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListDbViewHolder(adapter)
    }

    override fun onBindViewHolder(holder: ListDbViewHolder, position: Int) {
        holder.bindItem(listDb[position])
    }

    override fun getItemCount(): Int = listDb.size
}