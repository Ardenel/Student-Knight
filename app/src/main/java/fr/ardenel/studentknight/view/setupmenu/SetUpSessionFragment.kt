package fr.ardenel.studentknight.view.setupmenu

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

    private var hourTimer : Int = 0
    private var minTimer : Int = 0
    private var breakNumber : Int = 0

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

        binding.setUpMenuStartButton.isEnabled = false
        binding.setUpMenuSetTimerMinusMinButton.isEnabled = false
        binding.setUpMenuSetTimerMinusHourButton.isEnabled = false

        binding.setUpMenuStartButton.setOnClickListener{
            val fragment : FragmentManager = parentFragmentManager
            val fragmentTransaction : FragmentTransaction = fragment.beginTransaction()
            val currentSessionFragment = CurrentSessionFragment()
            fragmentTransaction.replace(R.id.mainMenuFragmentContainer, currentSessionFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.setUpMenuReturnButton.setOnClickListener{
            val fragment : FragmentManager = parentFragmentManager
            val fragmentTransaction : FragmentTransaction = fragment.beginTransaction()
            val mainMenuFragment = MainMenuFragment()
            fragmentTransaction.replace(R.id.mainMenuFragmentContainer, mainMenuFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.setUpMenuSetTimerPlusHourButton.setOnClickListener{setTime("hour",1)}
        binding.setUpMenuSetTimerMinusHourButton.setOnClickListener{setTime("hour", -1)}
        binding.setUpMenuSetTimerPlusMinButton.setOnClickListener{setTime("min",5)}
        binding.setUpMenuSetTimerMinusMinButton.setOnClickListener{setTime("min", -5)}

        binding.setUpMenuEditBreakText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isNotEmpty()) {
                    breakNumber = s.toString().toInt()
                    binding.setUpMenuEditBreakText.error = null
                    binding.setUpMenuStartButton.isEnabled = true
                } else {
                    binding.setUpMenuEditBreakText.error = "Please enter a number"
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

    }

    private fun setTime(unit : String, value: Int) {
        when (unit) {
            "hour" -> {
                hourTimer = (hourTimer + value).coerceIn(0, 23)
                if (hourTimer == 23)
                    binding.setUpMenuSetTimerPlusHourButton.isEnabled = false
                else if (hourTimer == 0)
                    binding.setUpMenuSetTimerMinusHourButton.isEnabled = false
                else {
                    binding.setUpMenuSetTimerPlusHourButton.isEnabled = true
                    binding.setUpMenuSetTimerMinusHourButton.isEnabled = true
                }
                binding.setUpMenuSetTimerHourText.text = String.format("%02d", hourTimer)
            }
            "min" -> {
                minTimer = (minTimer + value).coerceIn(-5, 60)
                if (minTimer == 60)
                    if (hourTimer < 23) {
                        minTimer = 0
                        hourTimer++
                    } else {
                        minTimer = 55
                        binding.setUpMenuSetTimerPlusMinButton.isEnabled = false
                } else if (minTimer == -5)
                    if (hourTimer > 0) {
                        minTimer = 55
                        hourTimer--
                    } else {
                        minTimer = 0
                        binding.setUpMenuSetTimerMinusMinButton.isEnabled = false
                    }
                else {
                    binding.setUpMenuSetTimerPlusMinButton.isEnabled = true
                    binding.setUpMenuSetTimerMinusMinButton.isEnabled = true
                }
                binding.setUpMenuSetTimerHourText.text = String.format("%02d", hourTimer)
                binding.setUpMenuSetTimerMinText.text = String.format("%02d", minTimer)
            }
        }
    }

}