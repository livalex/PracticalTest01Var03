package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01var03SecondaryActivity extends AppCompatActivity {
    private TextView numberOfClicksTextView;
    private Button correctButton;
    private Button incorrectButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.correct_button) {
                setResult(RESULT_OK, null);
            } else if (view.getId() == R.id.incorrect_button) {
                setResult(RESULT_CANCELED, null);
            }

            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01var03_secondary);

        correctButton = (Button) findViewById(R.id.correct_button);
        incorrectButton = (Button) findViewById(R.id.incorrect_button);
        numberOfClicksTextView = (TextView) findViewById(R.id.textView_secondActiv);

        correctButton.setOnClickListener(buttonClickListener);
        incorrectButton.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getExtras().containsKey(Constants.CALCULUS)) {
                String textViewReceived = intent.getExtras().get(Constants.CALCULUS).toString();
                numberOfClicksTextView.setText(String.valueOf(textViewReceived));
            }
        }
    }
}