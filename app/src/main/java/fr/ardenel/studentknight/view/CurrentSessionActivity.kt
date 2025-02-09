package fr.ardenel.studentknight.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import fr.ardenel.studentknight.R
import org.w3c.dom.Text

class CurrentSessionActivity : ComponentActivity() {

    private lateinit var breakButton : Button
    private lateinit var endButton : Button

    private lateinit var totalTime : TextView
    private lateinit var noBreak: TextView
    private lateinit var breakTime: TextView
    private lateinit var earnedGold : TextView
    private lateinit var earnedExp : TextView

    private var currentTotalTime = "00:00"
    private var currentnoBreak = 0
    private var currentBreakTime = "00:00"

    private var gold = 0
    private var xp = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_session)

        breakButton = findViewById(R.id.currentSessionBreakButton)
        endButton = findViewById(R.id.currentSessionEndButton)

        totalTime = findViewById(R.id.currentSessionTotalTime)
        noBreak = findViewById(R.id.currentSessionNumOfBreak)
        breakTime = findViewById(R.id.currentSessionTimeBeforeBreak)

        earnedGold = findViewById(R.id.currentSessionGoldEarned)
        earnedExp = findViewById(R.id.currentSessionXpEarned)

        breakButton.setOnClickListener{}

        endButton.setOnClickListener{
            val intent = Intent(this, EndSessionActivity::class.java)
            startActivity(intent)
        }
    }
}