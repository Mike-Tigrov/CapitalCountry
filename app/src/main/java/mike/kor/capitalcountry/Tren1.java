package mike.kor.capitalcountry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class Tren1 extends AppCompatActivity {

    //Кнопки выбора варианта ответа
    private Button mTrueButton;
    private Button mFalseButton1;
    private Button mFalseButton2;
    private Button mFalseButton3;



//Кнопка изменения цвета
private ConstraintLayout layout;
private Button button_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tren1);

        //Кнопки выбора вариантов ответа столицы страны
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tren1.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            }
        });
        mFalseButton1 = (Button) findViewById(R.id.false_button1);
        mFalseButton1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tren1.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        }));
        mFalseButton2 = (Button) findViewById(R.id.false_button2);
        mFalseButton2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tren1.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        }));
        mFalseButton3 = (Button) findViewById(R.id.false_button3);
        mFalseButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tren1.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        });

//Кнопка изменения цвета
        layout = findViewById(R.id.layout);
        button_test = findViewById(R.id.button_test);

        button_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Создали новый генератор случайных чисел
                Random random = new Random();
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                layout.setBackgroundColor(color);

            }
        });
    }
    public void countryState(View v){
        Intent intent = new Intent(this, SpisokStran.class);
        startActivity(intent);
    }
    public void prompt (View v){
        Intent intent = new Intent(this, Prompt.class);
        startActivity(intent);
    }
    public void goToMain (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void goToTren1 (View v){
        Intent intent = new Intent(this, Tren1.class);
        startActivity(intent);
    }


}