package com.example.examplelivedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.examplelivedata.R
import com.example.examplelivedata.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var mainBinding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainBinding = FragmentMainBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        with(mainBinding) {
            calculateBtn.setOnClickListener {
                viewModel.doSume(
                    number1Et.text.toString().toInt(),
                    number2Et.text.toString().toInt()
                )
            }
        }

        viewModel.sumDone.observe(viewLifecycleOwner) {
            mainBinding.totalTv.text = it.toString()
        }

        return mainBinding.root
    }

}