package com.example.sqlite

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.RoomHelper
import com.example.room.RoomMemo
import com.example.room.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class RecyclerAdapter() : RecyclerView.Adapter<RecyclerAdapter.Holder>() {
    var listData = mutableListOf<RoomMemo>()
    var helper: RoomHelper? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }
    
    inner class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        var mRoomMemo: RoomMemo? = null

        init {
            binding.buttonDelete.setOnClickListener {
                helper?.roomMemoDao()?.delete(mRoomMemo!!)
                listData.remove(mRoomMemo)
                notifyDataSetChanged()
            }
        }

        fun setMemo(memo: RoomMemo) {
            binding.textNo.text = "${memo.no}"
            binding.textContent.text = memo.content
            val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
            binding.textDatetime.text = sdf.format(memo.datetime)
            this.mRoomMemo = memo
        }
    }
}
