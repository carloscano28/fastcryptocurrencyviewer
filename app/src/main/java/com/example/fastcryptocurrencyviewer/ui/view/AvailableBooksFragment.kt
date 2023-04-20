package com.example.fastcryptocurrencyviewer.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fastcryptocurrencyviewer.R
import com.example.fastcryptocurrencyviewer.databinding.FragmentAvailableBooksBinding
import com.example.fastcryptocurrencyviewer.ui.adapters.AvailableBooksAdapter
import com.example.fastcryptocurrencyviewer.ui.viewmodel.AvailableBooksVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AvailableBooksFragment : Fragment() {

    private lateinit var binding: FragmentAvailableBooksBinding
    private val availableBooksVM :AvailableBooksVM by activityViewModels()

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

        /**
         *  Vinvulacion de vista con Flow
         */
        viewLifecycleOwner.lifecycleScope.launch {
            availableBooksVM.state.collect{
                binding.progressBar.isVisible = it.isLoading
                val adaptador = AvailableBooksAdapter(it.characters){
                    findNavController().navigate(
                        R.id.action_availableBooksFragment_to_detailFragment,
                        bundleOf("book" to it)
                    )
                }
                binding.rvAvailableBooks.layoutManager = LinearLayoutManager(activity)
                binding.rvAvailableBooks.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
                binding.rvAvailableBooks.adapter = adaptador

                if (!it.errorMessage.isNullOrEmpty()) {
                    Toast.makeText(requireActivity(), "${it.errorMessage}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}