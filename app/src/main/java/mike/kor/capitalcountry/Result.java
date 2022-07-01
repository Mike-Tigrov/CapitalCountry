package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    //Это страница результата. Здесь будет основой текст - поздравление с окончанием теста, 4 пункта и 3 кнопки

//Создаём 2 текстовых поля для вывода числовых значений правильных и неправильных ответов:
private TextView result_2;
    private TextView result_4;

    //Создаём 2 переменные для принятия значений из тренировки
    public static String num_correct_result;
    public static String num_incorrect_result;

//41.1.Создаём 2 переменные для вывода числовых значений правильных и неправильных ответов:
// num_correct num_incorrect



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_result);

//объявляем текствью в который выведем текст
        result_2 = (TextView) findViewById(R.id.result_2);
        Bundle extras = getIntent().getExtras();
        result_2.setText(extras.getString(num_correct_result));

     //   result_4 = (TextView) findViewById(R.id.result_4);
        //принимаем интент посланый из Tren_20
 //       Bundle extrasIncor = getIntent().getExtras();
        //выводим что получили
  //      result_4.setText(extrasIncor.getString(num_incorrect_result));



        //43.Подключаем виджеты полей @+id/num_correct and @+id/num_incorrect для вывода количества
// правильных и ошибочных ответов
       // String numCorr = Integer.toString(num_correct);
        //где result_2 - имя переменной с типом TextView,   result_2 - имя текстового поля в разметке,


     //   String numInCorr = Integer.toString(num_incorrect);



    }
    public void goToBaseKnowledge(View v){
        Intent intent = new Intent(this, BaseKnowledge.class);
        startActivity(intent);
    }

    public void goToListTren(View v){
        Intent intent = new Intent(this, ListTren.class);
        startActivity(intent);
    }
    public void goToTren20(View v){
        Intent intent = new Intent(this, Tren_20.class);
        startActivity(intent);
    }
}