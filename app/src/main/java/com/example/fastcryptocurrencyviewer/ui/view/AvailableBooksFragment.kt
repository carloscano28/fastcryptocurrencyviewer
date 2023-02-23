package com.example.fastcryptocurrencyviewer.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fastcryptocurrencyviewer.R
import com.example.fastcryptocurrencyviewer.data.network.RetrofitClientImpl
import com.example.fastcryptocurrencyviewer.databinding.FragmentAvailableBooksBinding
import com.example.fastcryptocurrencyviewer.domain.AvailableBooksUseCase
import com.example.fastcryptocurrencyviewer.repository.AvailableBooksRepoImpl
import com.example.fastcryptocurrencyviewer.ui.adapters.AvailableBooksAdapter
import com.example.fastcryptocurrencyviewer.utils.Utils
import com.example.fastcryptocurrencyviewer.viewmodel.AvailableBooksVM
import com.example.fastcryptocurrencyviewer.viewmodel.AvailableBooksVMFactory
import kotlinx.coroutines.launch

class AvailableBooksFragment : Fragment() {

    private lateinit var binding: FragmentAvailableBooksBinding

    private val availableBooksVM by viewModels<AvailableBooksVM> {
        AvailableBooksVMFactory(
            AvailableBooksUseCase(AvailableBooksRepoImpl(
                RetrofitClientImpl()
            ))
        )
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

        availableBooksVM.getAvailableBookInvoke()

        availableBooksVM.stateAvailableLD.observe(viewLifecycleOwner){
            //binding.rvAvailableBooks
        }

        viewLifecycleOwner.lifecycleScope.launch {

            availableBooksVM.state.collect{
                val adaptador = AvailableBooksAdapter(it.characters){
                    findNavController().navigate(
                        R.id.action_availableBooksFragment_to_detailFragment,
                        bundleOf("book" to it)
                    )
                }
                binding.rvAvailableBooks.layoutManager = LinearLayoutManager(activity)
                binding.rvAvailableBooks.adapter = adaptador
                binding.progressBar.isVisible = it.isLoading
                if (!it.errorMessage.isNullOrEmpty()) {
                    Utils.errorDialog(requireContext(), it.errorMessage)
                }
            }
        }
    }
}