package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import mike.kor.capitalcountry.model.Answer;
import mike.kor.capitalcountry.model.Question;

public class Tren_2 extends AppCompatActivity {

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

    //Создаём 2 тестовые временные переменные для показа на экран значений, которые выдаёт программа
    private TextView show_1;
    private TextView show_2;
    private TextView show_3;
    private TextView show_4;



    //32.удалён

    //36.Добавляем переменную для текстового поля answerCheck, где будет появлятся результат нажатия
    // кнопки - правильный или неправильный ответ. Текстовое поле располагаем
    // в linearLayout(horizontal), там где у нас кнопки, под ними. В файле strings добавляем 3 поля:
    //    <string name="wait_answer">Нажмите кнопку с вариантом столицы</string>
    //    <string name="correct_answer">Верный ответ!</string>
    //    <string name="incorrect_answer">Ошибка</string>
    private TextView anCheck;

    //41.Создали ещё 4 текстовых поля для вывода внизу страницы, над кнопками навигации, следующие поля: "Правильных ответов" : "количество" и "Ошибки" : "количество"

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
    private int ind_cou = 0;

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
    //Метод onCreate(Bundle ...) вызывается при создании экземпляра субкласса активности
    //С него начинается показ активностей на экране
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tren_2);

        //11.Подключаем виджет TextView, он задаёт текст из списка на позицию
        rText = (TextView) findViewById(R.id.roll_text);
        int question = listQ[ind_cou].getTextResId();
        rText.setText(question);

        //37.Подключаем виджет TextView, он будет задавать текст результата ответа
        anCheck = (TextView) findViewById(R.id.answerCheck);
        anCheck.setText(R.string.wait_answer);


        //33.Задаём значение виджетам кнопок 1,2,3,4
        //Создаём временную int переменную для генератора случайных значений
        //И добавляем условие, чтобы переменные не дублировались
        int temp_1 = ind_cou;

        //37.удалён



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

//18.Подключаем виджет Button и получаем ссылку на виджеты кнопок @+id/but_1 и @+id/but_2 и
        // удаляем их поля в activity_tren_2 - android:text="Button"
        but_cap_1 = (Button) findViewById(R.id.but_1);
//34.Устанавливаем первоначальное значение для кнопки 1
        int cap1 = listA[answer_capital[0]].getCapitalResId();
        but_cap_1.setText(cap1);
        //38.удалён

        //29.Копируем содержимое rButton.setOnClickListener(new View.OnClickListener() {},
        //переименовывая rButton на but_cap_1:
        //7.Мы реализуем интерфейс слушателя события. Собитие у нас - клик по кнопке
        //В круглых скобках "...stener(new View ... });" создаётся новый безымянный класс,
        //который будет реализован вызываемым методом onClick
        //То есть после тыкания, запускается выбор индекса
        //При этом первоначальный текст для Страны и 4 кнопок-Столиц уже задан,
        //а после нажатия, происходит очередная генерация значений для кнопок.

        //39.Подключаем 2 временные переменные, для демонстрации значений работы программы,
        // чтобы наглядно видеть, какие значения у нас получаются. При этом мы не можем вывести
        // число в поле TextView, для этого необходимо число преобразовать в текст



//Проверочная переменная для показа промежуточных значений других переменных
        String s1 = Integer.toString(answer_capital[0]);
        show_1 = (TextView) findViewById(R.id.show_1);
        show_1.setText(s1);

//Проверочная переменная для показа промежуточных значений других переменных
        String s2 = Integer.toString(answer_capital[1]);
        show_2 = (TextView) findViewById(R.id.show_2);
        show_2.setText(s2);

//Проверочная переменная для показа промежуточных значений других переменных
        String s3 = Integer.toString(answer_capital[2]);
        show_3 = (TextView) findViewById(R.id.show_3);
        show_3.setText(s3);

//Проверочная переменная для показа промежуточных значений других переменных
        String s4 = Integer.toString(answer_capital[3]);
        show_4 = (TextView) findViewById(R.id.show_4);
        show_4.setText(s4);


        //Первая кнопка
        but_cap_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //35.Сразу после нажатия кнопки мы определяем, "правильную" кнопку нажали или нет,
                // правильность определяем по соответствию индекса из списка стран и индекса из
                // списка столиц. В случае верного нажатия, в текстовое поле (answerCheck) добавляем
                // надпись - Правильный ответ! или Ошибка



/*

//Алгоритм проверки правильности выбора столицы:
            //Цикл поиска номера по списку столиц
            int num_cap = 0;
            for (int q = 0; q < capital.size(); q++) {
                if (answer_capital[number_int-1].equals(capital.get(q))) {
                    //System.out.println("Номер найденной позиции в списке столиц = " + capital.get(q));
                    num_cap = q;
*/
//По номеру страны получаем столицу из списка

if (listA[ind_cou].equals(answer_capital[0])) {
    anCheck.setText(R.string.correct_answer);
} else {
    anCheck.setText(R.string.incorrect_answer);
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listQ[ind_cou].getTextResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);
}


//С этого момента кнопка начинает переписывать содержимое страницы

//Задаём значение (текст) для страны
                ind_cou = (ind_cou + 1) % listQ.length;
                int question = listQ[ind_cou].getTextResId();
                //setText - вписываем текст
                rText.setText(question);

                //40.Добавляем условие окончания проверки знаний и перехода на новую страницу
                if (ind_cou > listQ.length){

                }




                //19.Добавляем функцию установления текста в кнопку 1,2,3,4
                //Создаём временную int переменную для генератора случайных значений
                //И добавляем условие, чтобы переменные не дублировались
                int temp_1 = ind_cou;

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



//Проверочная переменная для показа промежуточных значений других переменных
                String s1 = Integer.toString(answer_capital[0]);
                show_1 = (TextView) findViewById(R.id.show_1);
                show_1.setText(s1);

//Проверочная переменная для показа промежуточных значений других переменных
                String s2 = Integer.toString(answer_capital[1]);
                show_2 = (TextView) findViewById(R.id.show_2);
                show_2.setText(s2);

//Проверочная переменная для показа промежуточных значений других переменных
                String s3 = Integer.toString(answer_capital[2]);
                show_3 = (TextView) findViewById(R.id.show_3);
                show_3.setText(s3);

//Проверочная переменная для показа промежуточных значений других переменных
                String s4 = Integer.toString(answer_capital[3]);
                show_4 = (TextView) findViewById(R.id.show_4);
                show_4.setText(s4);

            }
        });

        but_cap_2 = (Button) findViewById(R.id.but_2);
//20.Добавляем функцию установления текста в кнопку 2
        int cap2 = listA[answer_capital[1]].getCapitalResId();
        but_cap_2.setText(cap2);



        //35.Копируем содержимое первой кнопки с изменениями для 2 кнопки:
        but_cap_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //35.Сразу после нажатия кнопки мы определяем, "правильную" кнопку нажали или нет,
                // правильность определяем по соответствию индекса из списка стран и индекса из
                // списка столиц. В случае верного нажатия, в текстовое поле (answerCheck) добавляем
                // надпись - Правильный ответ! или Ошибка
                if (answer_capital[1] == ind_cou) {
                    anCheck.setText(R.string.correct_answer);
                } else {
                    anCheck.setText(R.string.incorrect_answer);
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);

//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listQ[ind_cou].getTextResId();
                    show_2.setText(last_country);

//Это
                    show_3.setText(R.string.prompt_country_eto);

//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);
                }

                //Задаём значение для
                ind_cou = (ind_cou + 1) % listQ.length;
                int question = listQ[ind_cou].getTextResId();
                //setText - вписываем текст
                rText.setText(question);

                //19.Добавляем функцию установления текста в кнопку 1,2,3,4
                //Создаём временную int переменную для генератора случайных значений
                //И добавляем условие, чтобы переменные не дублировались
                int temp_1 = ind_cou;

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

        //22.Получаем ссылку на виджеты кнопок @+id/but_3 и @+id/but_4
        but_cap_3 = (Button) findViewById(R.id.but_3);
        //23.Добавляем функцию установления текста в кнопки 3 и 4
        int cap3 = listA[answer_capital[2]].getCapitalResId();
        but_cap_3.setText(cap3);
        //35.Копируем содержимое первой кнопки с изменениями для 3 кнопки:
        but_cap_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //35.Сразу после нажатия кнопки мы определяем, "правильную" кнопку нажали или нет,
                // правильность определяем по соответствию индекса из списка стран и индекса из
                // списка столиц. В случае верного нажатия, в текстовое поле (answerCheck) добавляем
                // надпись - Правильный ответ! или Ошибка
                if (answer_capital[2] == ind_cou) {
                    anCheck.setText(R.string.correct_answer);
                } else {
                    anCheck.setText(R.string.incorrect_answer);
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);

//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listQ[ind_cou].getTextResId();
                    show_2.setText(last_country);

//Это
                    show_3.setText(R.string.prompt_country_eto);

//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);
                }

                //Задаём значение для индекса следющей страны
                ind_cou = (ind_cou + 1) % listQ.length;
                int question = listQ[ind_cou].getTextResId();
                //setText - вписываем текст
                rText.setText(question);

                //19.Добавляем функцию установления текста в кнопку 1,2,3,4
                //Создаём временную int переменную для генератора случайных значений
                //И добавляем условие, чтобы переменные не дублировались
                int temp_1 = ind_cou;

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

        but_cap_4 = (Button) findViewById(R.id.but_4);
        int cap4 = listA[answer_capital[3]].getCapitalResId();
        but_cap_4.setText(cap4);
//36.Копируем содержимое первой кнопки с изменениями для 3 кнопки:
        but_cap_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //35.Сразу после нажатия кнопки мы определяем, "правильную" кнопку нажали или нет,
                // правильность определяем по соответствию индекса из списка стран и индекса из
                // списка столиц. В случае верного нажатия, в текстовое поле (answerCheck) добавляем
                // надпись - Правильный ответ! или Ошибка
                if (answer_capital[3] == ind_cou) {
                    anCheck.setText(R.string.correct_answer);
                } else {
                    anCheck.setText(R.string.incorrect_answer);
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);

//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listQ[ind_cou].getTextResId();
                    show_2.setText(last_country);

//Это
                    show_3.setText(R.string.prompt_country_eto);

//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);
                }

                //Задаём значение для
                ind_cou = (ind_cou + 1) % listQ.length;
                int question = listQ[ind_cou].getTextResId();
                //setText - вписываем текст
                rText.setText(question);

                //19.Добавляем функцию установления текста в кнопку 1,2,3,4
                //Создаём временную int переменную для генератора случайных значений
                //И добавляем условие, чтобы переменные не дублировались
                int temp_1 = ind_cou;

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

/* Временно отключаем кнопку, для проверки работоспособности кнопок-Столиц
        //5.Получаем ссылку на виджет кнопки
        rButton = (Button) findViewById(R.id.roll_button);

        //7.Мы реализуем интерфейс слушателя события. Собитие у нас - клик по кнопке
        //В круглых скобках "...stener(new View ... });" создаётся новый безымянный класс,
        //который будет реализован вызываемым методом onClick
        //То есть после тыкания, запускается выбор индекса
        //При этом первоначальный текст для Страны и 4 кнопок-Столиц уже задан,
        //а после нажатия, происходит очередная генерация значений для кнопок.
        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ind_cou = (ind_cou + 1) % listQ.length;
                int question = listQ[ind_cou].getTextResId();
                //setText - вписываем текст
                rText.setText(question);

                //19.Добавляем функцию установления текста в кнопку 1,2,3,4
                //Создаём временную int переменную для генератора случайных значений
                //И добавляем условие, чтобы переменные не дублировались
                int temp_1 = ind_cou;
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
*/
        //8. Мы удаляем строку android:text="TextView" из файла activity_tren_2.xml, туда
        // мы будем подставлять текст из списка String[] list






    }
//31.удалён






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