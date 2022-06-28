package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import mike.kor.capitalcountry.model.Capital;
import mike.kor.capitalcountry.model.Country;

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

    //32.Создаём 4 переменных для записи значений, получаемых в результате работы кнопок
    int num_1 = 0;
    int num_2 = 0;
    int num_3 = 0;
    int num_4 = 0;

//41.Создаём 2 переменные для вывода числовых значений: num_corr num_incorr
    int num_corr;
    int num_incorr;

    //Создаём 2 переменные для текстового поля @+id/num_corr and @+id/num_incorr
    private TextView num_corr_t;
    private TextView num_incorr_t;



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
    private Country[] listQ = new Country[]
            {
                    new Country(R.string.country_Australia_0),
                    new Country(R.string.country_Brazil_1),
                    new Country(R.string.country_GreatBritain_2),
                    new Country(R.string.country_Germany_3),
                    new Country(R.string.country_Egypt_4),
                    new Country(R.string.country_India_5),
                    new Country(R.string.country_Indonesia_6),
                    new Country(R.string.country_Spain_7),
                    new Country(R.string.country_Italy_8),
                    new Country(R.string.country_Canada_9),
                    new Country(R.string.country_China_10),
                    new Country(R.string.country_KoreaSouth_11),
                    new Country(R.string.country_Mexico_12),
                    new Country(R.string.country_Poland_13),
                    new Country(R.string.country_RussianFederation_14),
                    new Country(R.string.country_SaudiArabia_15),
                    new Country(R.string.country_UnitedStatesOfAmerica_16),
                    new Country(R.string.country_Turkey_17),
                    new Country(R.string.country_France_18),
                    new Country(R.string.country_Japan_19),

            };

    //9.Создаём переменную для индекса массива listQ и инициализируем её через 0
    private int ind_cou = 0;

    //10.Создаём 5 записей в файле countries.xml, их мы будем добавлять в наш массив с объектами для выбора текста
    //10.1 Создаём 5 записей в файле capitals.xml, для добавления в массив столиц

    //12.Создаём список listA на основе класса Answer, из которого будем брать значения столиц
    private Capital[] listA = new Capital[]
            {
                    new Capital(R.string.cap_Canberra_0),
                    new Capital(R.string.cap_Vein_1),
                    new Capital(R.string.cap_Baku_2),
                    new Capital(R.string.cap_Tirana_3),
                    new Capital(R.string.cap_Algeria_4),
            };
    //13. удалена

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
        int question = listQ[ind_cou].getCountryResId();
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
        //answer_capital - массив порядковых номеров! Это не массив значений!
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




//Страна
        show_1 = (TextView) findViewById(R.id.show_1);

//Столица которая на кнопке
        show_2 = (TextView) findViewById(R.id.show_2);

//Столица которая нам нужна
        show_3 = (TextView) findViewById(R.id.show_3);

//Проверочная переменная для показа промежуточных значений других переменных
        show_4 = (TextView) findViewById(R.id.show_4);


        //41.Сохраняем значения в переменные
        num_1 = answer_capital[0];
        num_2 = answer_capital[1];
        num_3 = answer_capital[2];
        num_4 = answer_capital[3];
        //42.Инициализируем счётчики правильных и неправильных ответов
num_corr = 0;
num_incorr = 0;
//43.Создаём 2 переменных, для внутренних ответов, внутри кода кнопок
        int co = 0;
        int in = 0;

//43.Подключаем виджеты полей @+id/num_corr and @+id/num_incorr
        String numCorr = Integer.toString(num_corr);
        num_corr_t = (TextView) findViewById(R.id.correct_answer);
        num_corr_t.setText(numCorr);

        String numInCorr = Integer.toString(num_incorr);
        num_incorr_t = (TextView) findViewById(R.id.incorrect_answer);
        num_incorr_t.setText(numInCorr);

        //Первая кнопка
        but_cap_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //35.Сразу после нажатия кнопки мы определяем, "правильную" кнопку нажали или нет,
                // правильность определяем по соответствию индекса из списка стран и индекса из
                // списка столиц. В случае верного нажатия, в текстовое поле (answerCheck) добавляем
                // надпись - Правильный ответ! или Ошибка




//По номеру страны получаем столицу из списка
// !!! В кнопках, которые не нажаты, остаются старые значения, которые не соответствуют ушедщим вперёд значениям от других кнопок!!!
                //Делаем для каждой кнопки вывод значений...
                //Создаём 2 переменные, куда записываем значения 2х полей: номер текущей кнопки и номер кнопки, которая необходима из списка столиц

                //Загружаем значения в переменные в начале работы кнопки
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;
                //Загружаем на входе в код кнопки значения из истории нажатий

                //Проверяем правильность выбранной столицы
if (ind_cou == num_1) {
    anCheck.setText(R.string.correct_answer);
num_corr++;
} else {
    anCheck.setText(R.string.incorrect_answer);
num_incorr++;
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listQ[ind_cou].getCountryResId();
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
                int question = listQ[ind_cou].getCountryResId();
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



//Проверочная переменная для показа промежуточных значений других переменных
//Страна
                show_1 = (TextView) findViewById(R.id.show_1);
                show_1.setText(listQ[ind_cou].getCountryResId());

//Проверочная переменная для показа промежуточных значений других переменных
//Столица которая на кнопке
                show_2 = (TextView) findViewById(R.id.show_2);
                show_2.setText(listA[answer_capital[0]].getCapitalResId());


//Проверочная переменная для показа промежуточных значений других переменных
//Столица которая нам нужна
                show_3 = (TextView) findViewById(R.id.show_3);
                show_3.setText(listA[ind_cou].getCapitalResId());

//Проверочная переменная для показа промежуточных значений других переменных
                String s4 = Integer.toString(answer_capital[3]);
                show_4 = (TextView) findViewById(R.id.show_4);
                show_4.setText(s4);

                //Сохраняем значения в переменные в конце работы кнопки
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
//Сохраняем значения:

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
                //Загружаем значения в переменные в начале работы кнопки
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;

                //Проверяем правильность выбранной столицы
                if (ind_cou == num_2) {
                    anCheck.setText(R.string.correct_answer);

                } else {
                    anCheck.setText(R.string.incorrect_answer);
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listQ[ind_cou].getCountryResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);

                }

                //Задаём значение для
                ind_cou = (ind_cou + 1) % listQ.length;
                int question = listQ[ind_cou].getCountryResId();
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

//Сохраняем значения в переменные в конце работы кнопки
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
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
                //Загружаем значения в переменные в начале работы кнопки
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;

                //Проверяем правильность выбранной столицы
                if (ind_cou == num_3) {
                    anCheck.setText(R.string.correct_answer);

                } else {
                    anCheck.setText(R.string.incorrect_answer);
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listQ[ind_cou].getCountryResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);

                }

                //Задаём значение для индекса следющей страны
                ind_cou = (ind_cou + 1) % listQ.length;
                int question = listQ[ind_cou].getCountryResId();
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

//Сохраняем значения в переменные в конце работы кнопки
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
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
                //Загружаем значения в переменные в начале работы кнопки
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;

                //Проверяем правильность выбранной столицы
                if (ind_cou == num_4) {
                    anCheck.setText(R.string.correct_answer);

                } else {
                    anCheck.setText(R.string.incorrect_answer);
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listQ[ind_cou].getCountryResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);

                }

                //Задаём значение для
                ind_cou = (ind_cou + 1) % listQ.length;
                int question = listQ[ind_cou].getCountryResId();
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

//Сохраняем значения в переменные в конце работы кнопки
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
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