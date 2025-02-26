package fr.ardenel.studentknight.view.session

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.ardenel.studentknight.R
import fr.ardenel.studentknight.databinding.FragmentCurrentSessionBinding


class CurrentSessionFragment : Fragment() {

    private lateinit var binding: FragmentCurrentSessionBinding

    private var currentTotalTime = "00:00"
    private var currentnoBreak = 0
    private var currentBreakTime = "00:00"

    private var gold = 0
    private var xp = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCurrentSessionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.currentSessionBreakButton.setOnClickListener{}

        binding.currentSessionEndButton.setOnClickListener{
            val fragment = EndSessionFragment()
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.mainMenuFragmentContainer, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}