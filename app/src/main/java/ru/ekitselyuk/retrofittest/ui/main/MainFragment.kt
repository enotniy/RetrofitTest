package ru.ekitselyuk.retrofittest.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ru.ekitselyuk.retrofittest.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.message)
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when(state) {
                is MainUIState.Loading -> {

                }
                is MainUIState.Success -> {
                    state.data
                }
            }
        }

        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.clickButton()
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.saveState()
    }
}