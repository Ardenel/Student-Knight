package fr.ardenel.studentknight.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import fr.ardenel.studentknight.R

class MainMenuActivity : ComponentActivity() {

    private lateinit var startButton: Button
    private lateinit var historyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        startButton = findViewById(R.id.mainMenuStartButton)
        historyButton = findViewById(R.id.mainMenuHistoryButton)

        startButton.setOnClickListener{
            val intent = Intent(this, SetUpSessionActivity::class.java)
            startActivity(intent)
        }

    }

}