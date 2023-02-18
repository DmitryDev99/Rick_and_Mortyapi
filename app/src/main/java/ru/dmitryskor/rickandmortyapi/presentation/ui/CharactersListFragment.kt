package ru.dmitryskor.rickandmortyapi.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.dmitryskor.rickandmortyapi.databinding.FragmentChracterListBinding
import ru.dmitryskor.rickandmortyapi.di.network.ProviderAppService

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 *
 * Фрагмент содержит список персонажей с постраничной подгрузкой
 */
class CharactersListFragment : Fragment() {

    private var _binding: FragmentChracterListBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<CharactersListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChracterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch(Dispatchers.IO) {
            println(ProviderAppService.getAppService().get("character", mapOf("page" to "1")).body())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}