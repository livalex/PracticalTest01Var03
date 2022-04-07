package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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