package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Tren_2 extends AppCompatActivity {
//Задача.Пробуем реализовать простой цикл из 1 текста и 1 кнопки
    //Текст будет появлятся случайным образом из списка
    //Кнопка будет генерировать новое значение текста
//1.Присваиваем кнопке из activity_tren_2.xml значение @+id/Roll_button (это на вкладке activity_tren_2.xml)
//2.Присваиваем текстовому полю из activity_tren_2.xml значение @+id/text_roll (это на вкладке activity_tren_2.xml)

    //3.Создаём переменную для кнопки @+id/roll_button
    private Button rButton;
    //4.Создаём переменную для текстового поля @+id/text_roll
    private TextView rText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tren_2);

        //5.Получаем ссылку на виджет кнопки
        rButton = (Button) findViewById(R.id.roll_button);
        //7.Мы реализуем интерфейс слушателя события. Собитие у нас - клик по кнопке
        //В круглых скобках "...stener(new View ... });" создаётся новый безымянный класс, который будет реализован вызываемым методом onClick
        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Пока ничего не делает, но скоро будет!
            }
        });

        //6.Получаем ссылку на виджет текстового поля
        rText = (TextView) findViewById(R.id.roll_text);
    }





    //0.Создаём список из которого будем брать значения
String[] list = new String[5];
    {
        list[0] = "Первый";
        list[1] = "Второй";
        list[2] = "Третий";
        list[3] = "Четвёртый";
        list[4] = "Пятый";

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


}