package com.example.android_practice_3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice_3.R
import com.example.android_practice_3.adapter.AnimeAdapter
import com.example.android_practice_3.databinding.FragmentMainBinding
import com.example.android_practice_3.viewmodel.MainViewModel


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAnime("naruto")

        viewModel.result.observe(viewLifecycleOwner, {
            binding.rvListAnime.adapter = AnimeAdapter(it.results)
        })

        binding.rvListAnime.layoutManager = LinearLayoutManager(context)
    }

}