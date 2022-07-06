package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result_100 extends AppCompatActivity {

//Это страница результата. Здесь будет: основой текст - поздравление с окончанием теста,
// 4 пункта и 3 кнопки

    //Создаём 2 текстовых поля для вывода числовых значений правильных и неправильных ответов:
    private TextView result_2;
    private TextView result_4;

    //Создаём переменную для принятия значений количества правильных ответов из тренировки
    public static String num_correct_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_result_100);

//объявляем текствью в который выведем текст
        result_2 = (TextView) findViewById(R.id.result_2);
        Bundle extras = getIntent().getExtras();
        result_2.setText(extras.getString(num_correct_result));

//Превращаем строку в цифру и вычитаем из количества общих вопросов количество правильных
// ответов, затем результат выводим на экран, как количество ошибок
        int corNum = Integer.parseInt(extras.getString(num_correct_result));
        int incorrectNum = 100 - corNum;
        result_4 = (TextView) findViewById(R.id.result_4);
        String s = Integer.toString(incorrectNum);
        result_4.setText(s);
    }
    public void goToBaseKnowledge(View v){
        Intent intent = new Intent(this, BaseKnowledge.class);
        startActivity(intent);
    }

    public void goToListTren(View v){
        Intent intent = new Intent(this, ListTren.class);
        startActivity(intent);
    }
    public void goToTren100(View v){
        Intent intent = new Intent(this, Tren_100.class);
        startActivity(intent);
    }
}