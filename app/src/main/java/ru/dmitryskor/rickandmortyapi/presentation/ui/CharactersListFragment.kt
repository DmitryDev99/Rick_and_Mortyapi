package ru.dmitryskor.rickandmortyapi.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.dmitryskor.rickandmortyapi.databinding.FragmentChracterListBinding

/**
 * Created by Dmitry Skorodumov on 18.02.2023
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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}