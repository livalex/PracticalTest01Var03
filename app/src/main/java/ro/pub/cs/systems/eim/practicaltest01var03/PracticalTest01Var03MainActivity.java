package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private EditText firstEditText;
    private EditText secondEditText;
    private Button plusButton;
    private Button minusButton;
    private TextView textView;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.plus_button) {
                if (firstEditText.getText().toString().matches("")
                        || secondEditText.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Complete all fields",
                            Toast.LENGTH_LONG).show();
                } else {
                    int nr1 = Integer.parseInt(firstEditText.getText().toString());
                    int nr2 = Integer.parseInt(secondEditText.getText().toString());
                    int add = nr1 + nr2;
                    String resString = firstEditText.getText().toString() + " + " +
                            secondEditText.getText().toString() + " = " + add;
                    textView.setText(resString);
                }
            } else if (view.getId() == R.id.minus_button) {
                if (firstEditText.getText().toString().matches("")
                        || secondEditText.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Complete all fields",
                            Toast.LENGTH_LONG).show();
                } else {
                    int nr1 = Integer.parseInt(firstEditText.getText().toString());
                    int nr2 = Integer.parseInt(secondEditText.getText().toString());
                    int sub = nr1 - nr2;
                    String resString = firstEditText.getText().toString() + " - " +
                            secondEditText.getText().toString() + " = " + sub;
                    textView.setText(resString);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        plusButton = (Button) findViewById(R.id.plus_button);
        minusButton = (Button) findViewById(R.id.minus_button);
        firstEditText = (EditText) findViewById(R.id.first_editText);
        secondEditText = (EditText) findViewById(R.id.second_editText);
        textView = (TextView) findViewById(R.id.textView);

        firstEditText.setText(String.valueOf(1));
        secondEditText.setText(String.valueOf(1));

        plusButton.setOnClickListener(buttonClickListener);
        minusButton.setOnClickListener(buttonClickListener);
    }
}