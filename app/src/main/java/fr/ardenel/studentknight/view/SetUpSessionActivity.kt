package fr.ardenel.studentknight.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import fr.ardenel.studentknight.R

class SetUpSessionActivity : ComponentActivity() {

    private lateinit var startButton: Button
    private lateinit var returnButton: Button

    private lateinit var increaseHourButton: Button
    private lateinit var decreaseHourButton: Button
    private lateinit var increaseMinButton: Button
    private lateinit var decreaseMinButton: Button
    private lateinit var increaseSecButton: Button
    private lateinit var decreaseSecButton: Button

    private lateinit var setUpHourText: TextView
    private lateinit var setUpMinText: TextView
    private lateinit var setUpSecText: TextView

    private var hourTimer = 0
    private var minTimer = 0
    private var secTimer = 0

    private val handler = Handler(Looper.getMainLooper())
    private var runnable: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_session)

        startButton = findViewById(R.id.setUpMenuStartButton)
        returnButton = findViewById(R.id.setUpMenuReturnButton)

        increaseHourButton = findViewById(R.id.setUpMenuSetTimerPlusHourButton)
        decreaseHourButton = findViewById(R.id.setUpMenuSetTimerMinusHourButton)
        increaseMinButton = findViewById(R.id.setUpMenuSetTimerPlusMinButton)
        decreaseMinButton = findViewById(R.id.setUpMenuSetTimerMinusMinButton)
        increaseSecButton = findViewById(R.id.setUpMenuSetTimerPlusSecButton)
        decreaseSecButton = findViewById(R.id.setUpMenuSetTimerMinusSecButton)

        setUpHourText = findViewById(R.id.setUpMenuSetTimerHourText)
        setUpMinText = findViewById(R.id.setUpMenuSetTimerMinText)
        setUpSecText = findViewById(R.id.setUpMenuSetTimerSecText)

        //Send to next activity the session parameters (not directly using the intent method) so to do and to determine
        startButton.setOnClickListener{
            val intent = Intent(this, CurrentSessionActivity::class.java)
            startActivity(intent)
        }

        returnButton.setOnClickListener{
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }


        //Find a better way to keep increasing with long touch
        increaseHourButton.setOnClickListener{setTime("hour",1)}
        decreaseHourButton.setOnClickListener{setTime("hour", -1)}
        increaseMinButton.setOnClickListener{setTime("min",1)}
        decreaseMinButton.setOnClickListener{setTime("min", -1)}
        increaseSecButton.setOnClickListener{setTime("sec",1)}
        decreaseSecButton.setOnClickListener{setTime("sec", -1)}

    }

    private fun setTime(unit : String, value: Int) {
        when (unit) {
            "hour" -> {
                hourTimer = (hourTimer + value).coerceIn(0, 23)
                setUpHourText.text = String.format("%02d", hourTimer)
            }
            "min" -> {
                minTimer = (minTimer + value).coerceIn(0, 59)
                setUpMinText.text = String.format("%02d", minTimer)
            }
            "sec" -> {
                secTimer = (secTimer + value).coerceIn(0,59)
                setUpSecText.text = String.format("%02d", secTimer)
            }
        }
    }

}