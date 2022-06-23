package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import mike.kor.capitalcountry.model.Question;

public class Tren1 extends AppCompatActivity {

    //Кнопки выбора варианта ответа (1 правильная и 3 неправильных)
    private Button mTrueButton;
    private Button mFalseButton1;
    private Button mFalseButton2;
    private Button mFalseButton3;

    //Список вариантов вопросов
    private TextView mQuestionTextView;

    //Кнопка далее
    private Button mNextButton;

    //Генератор случайных значений
    Random random = new Random();

    //Создаём список стран c ответами
    private Question[] mCountryList = new Question[] {
            new Question(R.string.question_Australia, R.string.cap_Canberra),
            new Question(R.string.question_Austria, R.string.cap_Vein),
            new Question(R.string.question_Azerbaijan, R.string.cap_Baku),
            new Question(R.string.question_Albania, R.string.cap_Tirana),
            new Question(R.string.question_Algeria, R.string.cap_Algeria),
    };
    //Переменная для индекса массива (по ней мы получаем следующий вопрос)
private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tren1);

        //Кнопки выбора вариантов ответа столицы страны
        //Кнопка с правильным ответом
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