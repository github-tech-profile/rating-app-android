package ramakrishna.movierating

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Model object
    private val rating = Rating()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI elements
        val movieNameInput = findViewById<EditText>(R.id.movieNameInput)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val commentsInput = findViewById<EditText>(R.id.commentsInput)
        val recommendCheckBox = findViewById<CheckBox>(R.id.recommendCheckBox)
        val displayButton = findViewById<Button>(R.id.displayButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        // Listeners to update the model
        displayButton.setOnClickListener {
            rating.movieName = movieNameInput.text.toString()
            rating.rating = ratingBar.rating
            rating.comments = commentsInput.text.toString()
            rating.wouldRecommend = recommendCheckBox.isChecked

            // Display the stored values
            val result = getString(R.string.rating_result, rating.movieName, rating.rating, rating.comments, if (rating.wouldRecommend) "Yes" else "No")
            resultText.text = result
        }
    }
}
