package com.example.root.lab3;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.textView);
        etInput = (EditText) findViewById(R.id.editText);
        bControl = (Button) findViewById(R.id.button);

        guess = (int) (Math.random() * 100);
        gameFinished = false;
    }

    public void onClick(View v) {
        if (!(etInput.getText().toString().isEmpty())) {
            if (!gameFinished) {
                int inp = Integer.parseInt(etInput.getText().toString());
                if (inp > guess)
                    tvInfo.setText(getResources().getString(R.string.ahead));
                if (inp < guess)
                    tvInfo.setText(getResources().getString(R.string.behind));
                if (!(inp <= 100 && inp >= 1))
                    tvInfo.setText(getResources().getString(R.string.error));
                if (inp == guess) {
                    tvInfo.setText(getResources().getString(R.string.hit));
                    bControl.setText(getResources().getString(R.string.play_more));
                    gameFinished = true;

                }
            } else {
                guess = (int) (Math.random() * 100);
                bControl.setText(getResources().getString(R.string.input_value));
                tvInfo.setText(getResources().getString(R.string.tru_to_guess));
                gameFinished = false;
            }
            etInput.setText("");
        }
        else
            tvInfo.setText(getResources().getString(R.string.error));
    }
}
