package com.example.madlevel5task2.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.example.madlevel5task2.R
import com.example.madlevel5task2.databinding.FragmentAddGameBinding
import androidx.appcompat.widget.Toolbar
import com.example.madlevel5task2.viewmodel.GameViewModel
import androidx.navigation.fragment.findNavController
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : Fragment() {

    private lateinit var binding: FragmentAddGameBinding

    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        binding = FragmentAddGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        requireActivity().title = getString(R.string.add_game)

        activity?.findViewById<Toolbar>(R.id.toolbar)!!.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabSaveGame.setOnClickListener {
            addGame()
        }

        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun addGame(){
        val name = binding.etName.text.toString()
        val platform = binding.etPlatform.text.toString()
        val day = binding.etDay.text.toString()
        val month = binding.etMonth.text.toString()
        val year = binding.etYear.text.toString()
        val date = "$day $month $year"

//        if (name.isNotBlank() && platform.isNotBlank() && dateIsValid(day, month, year)) {
        if (name.isNotBlank() && platform.isNotBlank()) {
            this.viewModel.insertGame(name, platform, date)
            findNavController().navigate(R.id.action_addGameFragment_to_gameBacklogFragment)
        } else {
            Toast.makeText(context, getString(R.string.add_game_error_msg), Toast.LENGTH_SHORT)
                .show()
        }
    }

//    private fun dateIsValid(day: String, month: String, year: String): Boolean {
//        if (day.isNotBlank() && month.isNotBlank() && year.isNotBlank()) {
//            return day.toInt() in 1..31 && month.toInt() in 1..12 && year.toInt() > Calendar.getInstance()
//                .get(Calendar.YEAR)
//        }
//        return false
//    }
}