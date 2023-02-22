package com.example.fastcryptocurrencyviewer.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController

import androidx.recyclerview.widget.RecyclerView
import com.example.fastcryptocurrencyviewer.R
import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailable
import com.example.fastcryptocurrencyviewer.databinding.AvailableBooksItemBinding
import com.example.fastcryptocurrencyviewer.utils.Utils

//class AvailableBooksAdapter(private val dataSet: Array<String>, val presenterDevices: Utils.EventDevice)
class AvailableBooksAdapter(private val dataSet: List<CryptoAvailable>) :
    RecyclerView.Adapter<AvailableBooksAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.available_books_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.linkItem(dataSet)
        //viewHolder.linkItem(dataSet, presenterDevices)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        private var binding = AvailableBooksItemBinding.bind(view)


        init {

        }

        //fun linkItem(dataSet: Array<String>, presenterDevices: Utils.EventDevice){
        fun linkItem(dataSet: List<CryptoAvailable>){

            with(binding){
                cryptoOrderBook.text = dataSet[adapterPosition].coin
                cryptoOrderBook.setOnClickListener {
                    Log.i("item clicked", "Clicked: ${dataSet[adapterPosition]}")
                    //presenterDevices.onClickedDevice(dataSet[adapterPosition])
                    /*findNavController().navigate(
                        R.id.action_availableBooksFragment_to_detailFragment,
                        bundleOf("book" )
                    )*/

                }

            }

        }

    }

    override fun getItemCount() = dataSet.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

}
