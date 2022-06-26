package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import mike.kor.capitalcountry.model.Answer;
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
    //16.Создаём переменную для кнопки @+id/but_1
    private Button but_cap_1;
    //17.Создаём переменную для кнопки @+id/but_2
    private Button but_cap_2;
    //21.Создаём ещё 2 кнопки в файле activity_tren_2: @+id/but_3 и @+id/but_4, удаляем у них поле text:
    private Button but_cap_3;
    private Button but_cap_4;

    //30.Создаём 2 переменные: количество правильных и неправильных ответов
    private int correct;
    private int incorrect;

    //32.Создаём 5 переменных для проверки правильности ответа (1 правильное значение и 4 проверяемых)
    private int num_0 = 0;
    private int num_1 = 0;
    private int num_2 = 0;
    private int num_3 = 0;
    private int num_4 = 0;



    //15.Создаём генератор случайных занчений
    Random random = new Random();

    //0.Создаём список listQ на основе класса Question[] из которого будем брать значения стран
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
    //10.1 Создаём 5 записей в файле capitals.xml, для добавления в массив столиц

    //12.Создаём список listA на основе класса Answer, из которого будем брать значения столиц
    private Answer[] listA = new Answer[]
            {
                    new Answer(R.string.cap_Canberra_1),
                    new Answer(R.string.cap_Vein_2),
                    new Answer(R.string.cap_Baku_3),
                    new Answer(R.string.cap_Tirana_4),
                    new Answer(R.string.cap_Algeria_5),
            };
    //13.Переменная для индекса массива Answer
    private int ind_Cap = 0;

//14.Создаём в activity_tren_2 кнопки: с Правильным и Неправильным ответом
    //Для этого создаём linearLayout(horizontal) и помещаем в него 2 кнопки
//Кнопкам присваиваем id: @+id/but_1 and @+id/but_2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tren_2);

        //11.Подключаем виджет TextView, он задаёт текст из списка на позицию
        rText = (TextView) findViewById(R.id.roll_text);
        int question = listQ[mCurrentIndex].getTextResId();
        rText.setText(question);

        //18.Получаем ссылку на виджеты кнопок @+id/but_1 и @+id/but_2 и удаляем их поля в
        //activity_tren_2 - android:text="Button"
        but_cap_1 = (Button) findViewById(R.id.but_1);
        //29.Копируем содержимое rButton.setOnClickListener(new View.OnClickListener() {},
        //переименовывая rButton на but_cap_1
        but_cap_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % listQ.length;
                int question = listQ[mCurrentIndex].getTextResId();
                //setText - вписываем текст
                rText.setText(question);

                //19.Добавляем функцию установления текста в кнопку 1,2,3,4
                //Создаём временную int переменную для генератора случайных значений
                //И добавляем условие, чтобы переменные не дублировались
                int temp_1 = mCurrentIndex;

                int temp_2 = random.nextInt(listA.length);
                while (temp_1 == temp_2) {
                    temp_2 = random.nextInt(listA.length);
                }
                int temp_3 = random.nextInt(listA.length);
                while (temp_3 == temp_1 || temp_3 == temp_2) {
                    temp_3 = random.nextInt(listA.length);
                }
                int temp_4 = random.nextInt(listA.length);
                while (temp_4 == temp_1 || temp_4 == temp_2 || temp_4 == temp_3) {
                    temp_4 = random.nextInt(listA.length);
                }
//24.Создаём массив, в который записываем все полученные значения временных переменных позиций столиц (temp_1,2,3,4)
                int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//25.Генератором случайных чисел, находим число temp_i (позицию, на которую поставим правильный ответ)
                int temp_i = random.nextInt(answer_capital.length);
//26.Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
                int temp = answer_capital[temp_i];
//27.На место, выбранное генератором, переносим правильное значение столицы
                answer_capital[temp_i] = answer_capital[0];
//28.На место правильного значения записываем значение с заменённой позиции
                answer_capital[0] = temp;


                int cap1 = listA[answer_capital[0]].getCapitalResId();
                but_cap_1.setText(cap1);

//20.Добавляем функцию установления текста в кнопку 2
                int cap2 = listA[answer_capital[1]].getCapitalResId();
                but_cap_2.setText(cap2);

                //23.Добавляем функцию установления текста в кнопки 3 и 4
                int cap3 = listA[answer_capital[2]].getCapitalResId();
                but_cap_3.setText(cap3);
                int cap4 = listA[answer_capital[3]].getCapitalResId();
                but_cap_4.setText(cap4);


            }
        });

        but_cap_2 = (Button) findViewById(R.id.but_2);

        //22.Получаем ссылку на виджеты кнопок @+id/but_3 и @+id/but_4
        but_cap_3 = (Button) findViewById(R.id.but_3);
        but_cap_4 = (Button) findViewById(R.id.but_4);



        //5.Получаем ссылку на виджет кнопки
        rButton = (Button) findViewById(R.id.roll_button);

        //7.Мы реализуем интерфейс слушателя события. Собитие у нас - клик по кнопке
        //В круглых скобках "...stener(new View ... });" создаётся новый безымянный класс,
        //который будет реализован вызываемым методом onClick
        //То есть после тыкания, запускается выбор индекса
        //При этом текст для Страны уже задан, а для кнопок задаётся после нажатия на кнопку.
        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % listQ.length;
                int question = listQ[mCurrentIndex].getTextResId();
                //setText - вписываем текст
                rText.setText(question);

                //19.Добавляем функцию установления текста в кнопку 1,2,3,4
                //Создаём временную int переменную для генератора случайных значений
                //И добавляем условие, чтобы переменные не дублировались
                int temp_1 = mCurrentIndex;
                num_0 = temp_1;

                int temp_2 = random.nextInt(listA.length);
                while (temp_1 == temp_2) {
                    temp_2 = random.nextInt(listA.length);
                }
                int temp_3 = random.nextInt(listA.length);
                while (temp_3 == temp_1 || temp_3 == temp_2) {
                    temp_3 = random.nextInt(listA.length);
                }
                int temp_4 = random.nextInt(listA.length);
                while (temp_4 == temp_1 || temp_4 == temp_2 || temp_4 == temp_3) {
                    temp_4 = random.nextInt(listA.length);
                }
//24.Создаём массив, в который записываем все полученные значения временных переменных позиций столиц (temp_1,2,3,4)
                int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//25.Генератором случайных чисел, находим число temp_i (позицию, на которую поставим правильный ответ)
                int temp_i = random.nextInt(answer_capital.length);
//26.Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
                int temp = answer_capital[temp_i];
//27.На место, выбранное генератором, переносим правильное значение столицы
                answer_capital[temp_i] = answer_capital[0];
//28.На место правильного значения записываем значение с заменённой позиции
                answer_capital[0] = temp;


                int cap1 = listA[answer_capital[0]].getCapitalResId();
                but_cap_1.setText(cap1);
                num_1 = cap1;

//20.Добавляем функцию установления текста в кнопку 2
                int cap2 = listA[answer_capital[1]].getCapitalResId();
                but_cap_2.setText(cap2);
                num_2 = cap2;

                //23.Добавляем функцию установления текста в кнопки 3 и 4
                int cap3 = listA[answer_capital[2]].getCapitalResId();
                but_cap_3.setText(cap3);
                num_3 = cap3;

                int cap4 = listA[answer_capital[3]].getCapitalResId();
                but_cap_4.setText(cap4);
                num_4 = cap4;




            }
        });

        //8. Мы удаляем строку android:text="TextView" из файла activity_tren_2.xml, туда
        // мы будем подставлять текст из списка String[] list

        //6.Получаем ссылку на виджет текстового поля
        rText = (TextView) findViewById(R.id.roll_text);




    }
//31.Создаём метод определения правильных и неправильных ответов
    private void checkAnswer(int check) {
        int messageResId = 0;
if (num_0 == num_1){

        messageResId = R.string.correct_toast;
    }
    else {
        messageResId = R.string.incorrect_toast;
    }
    Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

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