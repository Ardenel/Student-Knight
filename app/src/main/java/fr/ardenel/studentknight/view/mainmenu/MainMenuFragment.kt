package fr.ardenel.studentknight.view.mainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import fr.ardenel.studentknight.R
import fr.ardenel.studentknight.databinding.FragmentMainMenuBinding
import fr.ardenel.studentknight.view.history.HistoryFragment
import fr.ardenel.studentknight.view.setupmenu.SetUpSessionFragment


class MainMenuFragment : Fragment() {

    private lateinit var binding : FragmentMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainMenuStartButton.setOnClickListener {
            val fragment : FragmentManager = parentFragmentManager
            val fragmentTransaction : FragmentTransaction = fragment.beginTransaction()
            val setUpSessionFragment = SetUpSessionFragment()
            fragmentTransaction.replace(R.id.mainMenuFragmentContainer, setUpSessionFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.mainMenuHistoryButton.setOnClickListener {
            val fragment : FragmentManager = parentFragmentManager
            val fragmentTransaction : FragmentTransaction = fragment.beginTransaction()
            val historyFragment = HistoryFragment()
            fragmentTransaction.replace(R.id.mainMenuFragmentContainer, historyFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }
    }
}