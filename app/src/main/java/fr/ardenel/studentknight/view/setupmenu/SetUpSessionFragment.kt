package fr.ardenel.studentknight.view.setupmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import fr.ardenel.studentknight.R
import fr.ardenel.studentknight.databinding.FragmentSetUpSessionBinding
import fr.ardenel.studentknight.view.mainmenu.MainMenuFragment
import fr.ardenel.studentknight.view.session.CurrentSessionFragment


class SetUpSessionFragment : Fragment() {

    private lateinit var binding : FragmentSetUpSessionBinding

    private var hourTimer = 0
    private var minTimer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSetUpSessionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.setUpMenuStartButton.setOnClickListener{
            val fragment : FragmentManager = parentFragmentManager
            val fragmentTransaction : FragmentTransaction = fragment.beginTransaction()
            val currentSessionFragment = CurrentSessionFragment()
            fragmentTransaction.add(R.id.mainMenuFragmentContainer, currentSessionFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.setUpMenuReturnButton.setOnClickListener{
            val fragment : FragmentManager = parentFragmentManager
            val fragmentTransaction : FragmentTransaction = fragment.beginTransaction()
            val mainMenuFragment = MainMenuFragment()
            fragmentTransaction.add(R.id.mainMenuFragmentContainer, mainMenuFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


        //Find a better way to keep increasing with long touch
        binding.setUpMenuSetTimerPlusHourButton.setOnClickListener{setTime("hour",1)}
        binding.setUpMenuSetTimerMinusHourButton.setOnClickListener{setTime("hour", -1)}
        binding.setUpMenuSetTimerPlusMinButton.setOnClickListener{setTime("min",5)}
        binding.setUpMenuSetTimerMinusMinButton.setOnClickListener{setTime("min", -5)}

    }

    private fun setTime(unit : String, value: Int) {
        when (unit) {
            "hour" -> {
                hourTimer = (hourTimer + value).coerceIn(0, 23)
                binding.setUpMenuHourText.text = String.format("%02d", hourTimer)
            }
            "min" -> {
                minTimer = (minTimer + value).coerceIn(0, 59)
                binding.setUpMenuMinText.text = String.format("%02d", minTimer)
            }
        }
    }

}