package com.example.fastcryptocurrencyviewer.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fastcryptocurrencyviewer.R
import com.example.fastcryptocurrencyviewer.data.model.CryptoM
import com.example.fastcryptocurrencyviewer.databinding.AvailableBooksItemBinding

class AvailableBooksAdapter(private val dataSet: List<CryptoM>, private val click: (String) -> Unit) :
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

        @SuppressLint("SetTextI18n")
        fun linkItem(dataSet: List<CryptoM>, click: (String) -> Unit){
            with(binding){
                cryptoOrderBook.text = dataSet[adapterPosition].book.uppercase().dropLast(4)
                cryptoOrderAmount.text = ("$${dataSet[adapterPosition].minimum_amount}")
                cryptoOrderPrice.text = ("$${dataSet[adapterPosition].maximum_amount}")
                cardItem.setOnClickListener {
                    click.invoke(dataSet[adapterPosition].book)
                }
            }
        }
    }

    override fun getItemCount() = dataSet.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

}
