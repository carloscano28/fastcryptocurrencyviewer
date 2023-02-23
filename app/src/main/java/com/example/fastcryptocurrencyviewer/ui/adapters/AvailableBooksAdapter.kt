package com.example.fastcryptocurrencyviewer.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fastcryptocurrencyviewer.R
import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailable
import com.example.fastcryptocurrencyviewer.databinding.AvailableBooksItemBinding

class AvailableBooksAdapter(private val dataSet: List<CryptoAvailable>, private val click: (String) -> Unit) :
    RecyclerView.Adapter<AvailableBooksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.available_books_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.linkItem(dataSet, click)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var binding = AvailableBooksItemBinding.bind(view)
        init {

        }

        fun linkItem(dataSet: List<CryptoAvailable>, click: (String) -> Unit){
            with(binding){
                cryptoOrderBook.text = dataSet[adapterPosition].coin
                cardItem.setOnClickListener {
                    click.invoke(dataSet[adapterPosition].coin)
                }
            }
        }
    }

    override fun getItemCount() = dataSet.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

}
