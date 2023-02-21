package com.example.fastcryptocurrencyviewer.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fastcryptocurrencyviewer.R
import com.example.fastcryptocurrencyviewer.databinding.FragmentAvailableBooksBinding
import com.example.fastcryptocurrencyviewer.ui.adapters.AvailableBooksAdapter
import com.example.fastcryptocurrencyviewer.utils.EventDevice

private const val ARG_PARAM1 = "param1"

class AvailableBooksFragment : Fragment(), EventDevice {

    private lateinit var binding: FragmentAvailableBooksBinding
    private var param1: String? = null
    var Lista2 = arrayOf("fdsfsd", "dsafdfs", "dsafdfs", "dsafdfs", "dsafdfs", "dsafdfs", "dsafdfs")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvailableBooksBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*   ADAPTADOR    */
        binding.rvAvailableBooks.layoutManager = LinearLayoutManager(activity)
        val adaptador = AvailableBooksAdapter(Lista2, this)
        binding.rvAvailableBooks.adapter = adaptador
        /*   ADAPTADOR    */

    }

    override fun onClickedDevice(s: String) {
        findNavController().navigate(
            R.id.action_availableBooksFragment_to_detailFragment,
            bundleOf("book" to s)
        )


    }
}