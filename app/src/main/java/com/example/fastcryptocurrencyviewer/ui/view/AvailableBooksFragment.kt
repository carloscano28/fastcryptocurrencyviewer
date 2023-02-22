package com.example.fastcryptocurrencyviewer.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fastcryptocurrencyviewer.data.api.BitsoApiService
import com.example.fastcryptocurrencyviewer.data.api.RetrofitSingleton
import com.example.fastcryptocurrencyviewer.databinding.FragmentAvailableBooksBinding
import com.example.fastcryptocurrencyviewer.ui.adapters.AvailableBooksAdapter
import com.example.fastcryptocurrencyviewer.utils.Utils
import com.example.fastcryptocurrencyviewer.viewmodel.AvailableBooksClient
import com.example.fastcryptocurrencyviewer.viewmodel.AvailableBooksVM
import com.example.fastcryptocurrencyviewer.viewmodel.AvailableBooksVMFactory
import kotlinx.coroutines.launch

private const val ARG_PARAM1 = "param1"

class AvailableBooksFragment : Fragment() {
//class AvailableBooksFragment : Fragment(), Utils.EventDevice {

    private lateinit var binding: FragmentAvailableBooksBinding
    private var param1: String? = null
    var ListaAux = arrayOf("fdsfsd", "dsafdfs", "dsafdfs", "dsafdfs", "dsafdfs", "dsafdfs", "dsafdfs")

    private val availableBooksVM by viewModels<AvailableBooksVM> {
        AvailableBooksVMFactory(
            AvailableBooksClient(RetrofitSingleton.retrofit.create(
            BitsoApiService::class.java))
        )
    }

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
        //binding.rvAvailableBooks.layoutManager = LinearLayoutManager(activity)
        //val adaptador = AvailableBooksAdapter(Lista2, this)
        //binding.rvAvailableBooks.adapter = adaptador
        /*   ADAPTADOR    */



        availableBooksVM.getAvailableBook()

        viewLifecycleOwner.lifecycleScope.launch {

            availableBooksVM.state.collect{

                /*repeat(50){

                    delay(5000)
                }*/

                val adaptador = AvailableBooksAdapter(it.characters)
                binding.rvAvailableBooks.layoutManager = LinearLayoutManager(activity)
                binding.rvAvailableBooks.adapter = adaptador

                binding.progressBar.isVisible = it.isLoading

                if (!it.errorMessage.isNullOrEmpty()) {
                    Utils.errorDialog(requireContext(), it.errorMessage)
                }



            }

        }

    }

    /*override fun onClickedDevice(s: String) {
        findNavController().navigate(
            R.id.action_availableBooksFragment_to_detailFragment,
            bundleOf("book" to s)
        )


    }*/
}