package com.example.fastcryptocurrencyviewer.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fastcryptocurrencyviewer.R
import com.example.fastcryptocurrencyviewer.databinding.AvailableBooksItemBinding
import com.example.fastcryptocurrencyviewer.utils.EventDevice

class AvailableBooksAdapter(private val dataSet: Array<String>, val presenterDevices: EventDevice) :
    RecyclerView.Adapter<AvailableBooksAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.available_books_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.linkItem(dataSet, presenterDevices)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        private var binding = AvailableBooksItemBinding.bind(view)


        init {

        }

        fun linkItem(dataSet: Array<String>, presenterDevices: EventDevice){

            with(binding){
                cryptoOrderBook.text = dataSet[adapterPosition]
                cryptoOrderBook.setOnClickListener {
                    Log.i("item clicked", "Clicked: ${dataSet[adapterPosition]}")
                    presenterDevices.onClickedDevice(dataSet[adapterPosition])

                }

            }

        }

    }

    override fun getItemCount() = dataSet.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

}
