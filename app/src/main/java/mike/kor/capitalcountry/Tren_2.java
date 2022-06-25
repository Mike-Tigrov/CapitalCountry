package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import mike.kor.capitalcountry.model.Question;

public class Tren_2 extends AppCompatActivity {
//Задача. Реализовать простой цикл из 1 текста и 1 кнопки
    //Текст будет появлятся случайным образом из списка
    //Кнопка будет генерировать новое значение текста

//1.Присваиваем кнопке из activity_tren_2.xml значение @+id/roll_button (это на вкладке activity_tren_2.xml)
//2.Присваиваем текстовому полю из activity_tren_2.xml значение @+id/roll_text (это на вкладке activity_tren_2.xml)

    //3.Создаём переменную для кнопки @+id/roll_button
    private Button rButton;
    //4.Создаём переменную для текстового поля @+id/text_roll
    private TextView rText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tren_2);

        //11.Подключаем виджет TextView, он задаёт текст из списка на позицию
        rText = (TextView) findViewById(R.id.roll_text);
        int question = listQ[mCurrentIndex].getTextResId();
        rText.setText(question);

        //5.Получаем ссылку на виджет кнопки
        rButton = (Button) findViewById(R.id.roll_button);

        //7.Мы реализуем интерфейс слушателя события. Собитие у нас - клик по кнопке
        //В круглых скобках "...stener(new View ... });" создаётся новый безымянный класс,
        //который будет реализован вызываемым методом onClick
        //То есть после тыкания, запускается выбор индекса
        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % listQ.length;
                int question = listQ[mCurrentIndex].getTextResId();
                rText.setText(question);

            }
        });

        //8. Мы удаляем строку android:text="TextView" из файла activity_tren_2.xml, туда
        // мы будем подставлять текст из списка String[] list

        //6.Получаем ссылку на виджет текстового поля
        rText = (TextView) findViewById(R.id.roll_text);
    }


    //0.Создаём список listQ на основе класса Question[] из которого будем брать значения
private Question[] listQ = new Question[]
    {
        new Question(R.string.cou_Australia_1),
        new Question(R.string.cou_Austria_2),
        new Question(R.string.cou_Azerbaijan_3),
        new Question(R.string.cou_Albania_4),
        new Question(R.string.cou_Algeria_5),


    };

    //9.Создаём переменную для индекса массива listQ и инициализируем её через 0
    private int mCurrentIndex = 0;

    //10.Создаём 5 записей в файле countries.xml, их мы будем добавлять в наш массив с объектами для выбора текста




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