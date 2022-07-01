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

public class Tren_20 extends AppCompatActivity {


//2.Присваиваем текстовому полю из activity_tren_20.xml значение @+id/roll_text (это на вкладке activity_tren_2.xml)


    //4.Создаём переменную для текстового поля @+id/text_roll (это на вкладке
    // activity_tren_20.xml) для последующего вывода очередной страны и удаляем поле text:
    private TextView rText;
    //16.Создаём переменные для кнопок @+id/but_1, @+id/but_2, @+id/but_3 и @+id/but_4 и
    // удаляем из activity_tren_2 поле text. В эти кнопки будут вписаны называния столиц для выбора
    private Button but_cap_1;
    private Button but_cap_2;
    private Button but_cap_3;
    private Button but_cap_4;

    //Создаём 4 тестовые временные переменные для вывода на экран значений, которые выдаёт
    // программа. Эти значения будут использованы для мотивации в случае правильного ответа и
    // справки, в случае ошибки
    private TextView show_1;
    private TextView show_2;
    private TextView show_3;
    private TextView show_4;

    //32.Создаём 4 переменных для записи значений, получаемых в результате работы кнопок.
    // Эти переменные нужны для хранения данных, полученных в результате нажатия кнопок. Дело
    // в том, что много кода пока что расположено в кнопках (пища для рефакторинга). И переменные
    // нужны для обновления данных в кнопках, так как после нажатия там остаются старые значения,
    // что приводит к искажению проверки правильности выбранного варианта ответа
    int num_1 = 0;
    int num_2 = 0;
    int num_3 = 0;
    int num_4 = 0;

    //Переменная, которая определяет количество вопросов в тренировке (на самом деле, реально
    // вопросов на 1 больше, но мы начинаем с 0, поэтому и 19, а не 20).
    int num_questions = 19;

//41.Создали ещё 4 текстовых поля для вывода внизу страницы, над кнопками навигации, следующие поля: "Правильных ответов" : "количество" и "Ошибки" : "количество"

//41.1.Создаём 2 переменные для подсчёта правильных и неправильных ответов во время нажатия кнопок
    int num_correct;
    int num_incorrect;

    //Создаём 2 переменные для текстового поля @+id/num_correct and @+id/num_incorrect, это будут
    // выводиться на экран результаты верных или ошибочных ответов, в числовом выражении. Т.е.
    // количество верных/неверных ответов можно будет наблюдать во время прохождения тестированя
    private TextView num_correct_t;
    private TextView num_incorrect_t;

    //36.Добавляем переменную для текстового поля answerCheck, где будет появлятся результат нажатия
    // кнопки - правильный или неправильный ответ. Текстовое поле располагаем
    // в linearLayout(horizontal), там где у нас кнопки, под ними. В файле strings добавляем 3 поля:
    //    <string name="wait_answer">Нажмите кнопку с вариантом столицы</string>
    //    <string name="correct_answer">Верный ответ!</string>
    //    <string name="incorrect_answer">Ошибка</string>
    private TextView anCheck;

    //15.Создаём генератор случайных занчений
    Random random = new Random();

    //0.Создаём список listC на основе класса Country из каталога model, откуда мы
    // будем брать значения стран
    private Country[] listC = new Country[]
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

    //9.Создаём переменную для индекса массива listC и инициализируем её через 0. По ней мы будем
    // перебирать наш массив и выбирать страны. Также по этой переменной мы будем искать правильные
    // столицы, так как порядковый номер Страны совпадает с порядковым номером подходящей
    // для неё Столицы.
    private int ind_cou = 0;

    //10.Создаём 5 записей в файле countries_tren_20.xml, их мы будем добавлять в наш массив с объектами для выбора текста
    //10.1 Создаём 5 записей в файле capitals_tren_20.xml, для добавления в массив столиц

    //12.Создаём список listA на основе класса Capital, из каталога model, из которого будем
    // брать значения столиц
    private Capital[] listA = new Capital[]
            {
                    new Capital(R.string.cap_Canberra_0),
                    new Capital(R.string.cap_Brazil_1),
                    new Capital(R.string.cap_London_2),
                    new Capital(R.string.cap_Berlin_3),
                    new Capital(R.string.cap_Cairo_4),
                    new Capital(R.string.cap_NewDelhi_5),
                    new Capital(R.string.cap_Jakarta_6),
                    new Capital(R.string.cap_Madrid_7),
                    new Capital(R.string.cap_Rome_8),
                    new Capital(R.string.cap_Ottawa_9),
                    new Capital(R.string.cap_Beijing_10),
                    new Capital(R.string.cap_Seoul_11),
                    new Capital(R.string.cap_MexicoCity_12),
                    new Capital(R.string.cap_Warsaw_13),
                    new Capital(R.string.cap_Moscow_14),
                    new Capital(R.string.cap_Riyadh_15),
                    new Capital(R.string.cap_Washington_16),
                    new Capital(R.string.cap_Ankara_17),
                    new Capital(R.string.cap_Paris_18),
                    new Capital(R.string.cap_Tokyo_19),
            };

//14.Создаём в activity_tren_2 кнопки: с Правильным и Неправильным ответом
    //Для этого создаём linearLayout(horizontal) и помещаем в него 2 кнопки
//Кнопкам присваиваем id: @+id/but_1 and @+id/but_2


    @Override
    //Метод onCreate(Bundle ...) вызывается при создании экземпляра субкласса активности.
    // С него начинается показ активностей на экране, которые загружаются из разметки
    // по указанному адресу - в данном случае -  R.layout.activity_tren_20 (т.е. разметка
    // расположена в папке res > layout > activity_tren_20.xml
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tren_20);

        //11.Подключаем виджет TextView, он задаёт текст из списка на позицию
        rText = (TextView) findViewById(R.id.roll_text);
        int question = listC[ind_cou].getCountryResId();
        rText.setText(question);

        //37.Подключаем виджет TextView, он будет задавать текст результата ответа
        anCheck = (TextView) findViewById(R.id.answerCheck);
        anCheck.setText(R.string.wait_answer);


        //33.Задаём значение виджетам кнопок 1,2,3,4
        //Создаём временную int переменную для генератора случайных значений
        //И добавляем условие, чтобы переменные не дублировались
        int temp_1 = ind_cou;

        //42.Создаём диалоговое окно для вывода результатов прохождения теста. Отказался от
        // диалога, просто научился переходить на другую активность.
        /*
        //Создали новый диалог, он будет возникать в данной активности
        Dialog dialog = new Dialog(this);
        //Разметку окна диалога загружаем из act_result.xml
        dialog.setContentView(R.layout.act_result);

        //Первый текст, количество правильных ответов, ставим в это поле №1
                /*
        TextView text = (TextView) dialog.findViewById(R.id.result_1);
        //Текст первого поля берём из файла strings
        text.setText(R.string.result_1);

         */
//Создаём переход на активность с результатом
        Intent intent = new Intent(this, Result.class);



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
        //answer_capital - массив порядковых номеров! Это НЕ массив значений!
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
        //а после нажатия, происходит генерация новых значений для кнопок.

        //39.Подключаем 2 временные переменные, для демонстрации значений работы программы,
        // чтобы наглядно видеть, какие значения у нас получаются. При этом мы не можем вывести
        // число в поле TextView, для этого необходимо число преобразовать в текст методом toString()




//Страна
        show_1 = (TextView) findViewById(R.id.show_1);

//Столица которая на кнопке
        show_2 = (TextView) findViewById(R.id.show_2);

//Столица которая нам нужна
        show_3 = (TextView) findViewById(R.id.show_3);

//Проверочная переменная для показа промежуточных значений других переменных
        show_4 = (TextView) findViewById(R.id.show_4);


//41.Сохраняем значения в переменные, потому что при клике по кнопке, в кнопке остаётся код,
// который становится "старым", т.е. он не обновляется одновременно с кодом в других кнопках.
// И при последующих проверках правильности выбора столицы это приводит к ошибке.
// Поэтому мы в самом начале кода кнопки загружаем в него новые значения, а на выходе из кода
// сохраняем в переменные, из которых потом загрузим во вновь нажатую кнопку. Наверное есть
// способ проще и лучше, но я пока его не знаю ;)
        num_1 = answer_capital[0];
        num_2 = answer_capital[1];
        num_3 = answer_capital[2];
        num_4 = answer_capital[3];

        //42.Инициализируем счётчики правильных и неправильных ответов
num_correct = 0;
num_incorrect = 0;

//43.удалено

//43.Подключаем виджеты полей @+id/num_correct and @+id/num_incorrect для вывода количества
// правильных и ошибочных ответов
        String numCorr = Integer.toString(num_correct);
        num_correct_t = (TextView) findViewById(R.id.num_correct);
        num_correct_t.setText(numCorr);

        String numInCorr = Integer.toString(num_incorrect);
        num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
        num_incorrect_t.setText(numInCorr);



        //Первая кнопка с выбором столицы
        but_cap_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //35.Сразу после нажатия кнопки мы определяем, "правильную" кнопку нажали или нет,
                // правильность определяем по соответствию индекса из списка стран и индекса из
                // списка столиц. В случае верного нажатия, в текстовое поле (answerCheck) добавляем
                // надпись - Правильный ответ! или Ошибка


//По номеру страны получаем столицу из списка
// !!! В кнопках, которые не нажаты, остаются старые значения, которые не соответствуют ушедщим вперёд значениям от других кнопок!!!
                //Делаем для каждой кнопки ввод/вывод значений.
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

//Добавляем +1 к количеству правильных ответов и выводим новое количество правильных ответов на экран в поле num_correct
                    num_correct++;
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
                    anCheck.setText(R.string.incorrect_answer);

                    //Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
                    //Даём подсказку по прошлому, неправильному нажатию
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listC[ind_cou].getCountryResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);

                }
//Окончание тренировки. Суммируем количество правильных и неправильных ответов. И когда получается
// число = 20, то мы останавливаем тренировку. Выводим на экран, вместо Страны - Поздравление,
// вместо столиц - количество правильных и неправильных ответов. Но лучше - чтобы было перенаправление на другую страницу с результатом
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {
                    //И передаём1 данные по количетву правильных и неправильных ответов
                    //(1)куда передаём НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемая переменная)
                    String cor = Integer.toString(num_correct);
intent.putExtra(Result.num_correct_result, cor);
                    //запускаем2 активность Result (act_result) с результатом
                    startActivity(intent);

                }



//С этого момента кнопка начинает переписывать содержимое страницы (индекс страны, массив вывода столиц для кнопок)

//Задаём значение (текст) для страны
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
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

//Добавляем +1 к количеству правильных ответов и выводим новое количество правильных ответов на экран в поле num_correct
                    num_correct++;
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
                    anCheck.setText(R.string.incorrect_answer);

                    //Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
                    //Даём подсказку по прошлому, неправильному нажатию
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listC[ind_cou].getCountryResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);

                }
                //Окончание тренировки. Суммируем количество правильных и неправильных ответов. И когда получается
// число = 20, то мы останавливаем тренировку. Выводим на экран, вместо Страны - Поздравление,
// вместо столиц - количество правильных и неправильных ответов. Но лучше - чтобы было перенаправление на другую страницу с результатом
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {
                    //И передаём1 данные по количетву правильных и неправильных ответов
                    //(1)куда передаём НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемая переменная)
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result.num_correct_result, cor);
                    //запускаем2 активность Result (act_result) с результатом
                    startActivity(intent);

                }


                //Задаём значение для
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
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

//Добавляем +1 к количеству правильных ответов и выводим новое количество правильных ответов на экран в поле num_correct
                    num_correct++;
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
                    anCheck.setText(R.string.incorrect_answer);

                    //Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
                    //Даём подсказку по прошлому, неправильному нажатию
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listC[ind_cou].getCountryResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);

                }

                //Окончание тренировки. Суммируем количество правильных и неправильных ответов. И когда получается
// число = 20, то мы останавливаем тренировку. Выводим на экран, вместо Страны - Поздравление,
// вместо столиц - количество правильных и неправильных ответов. Но лучше - чтобы было перенаправление на другую страницу с результатом
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {
                    //И передаём1 данные по количетву правильных и неправильных ответов
                    //(1)куда передаём НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемая переменная)
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result.num_correct_result, cor);
                    //запускаем2 активность Result (act_result) с результатом
                    startActivity(intent);

                }
                //Задаём значение для индекса следющей страны
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
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

//Добавляем +1 к количеству правильных ответов и выводим новое количество правильных ответов на экран в поле num_correct
                    num_correct++;
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
                    anCheck.setText(R.string.incorrect_answer);

                    //Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
                    //Даём подсказку по прошлому, неправильному нажатию
//Правильная столица страны:
                    show_1.setText(R.string.prompt_country);
//Название страны, которая отображалась до нажатия кнопки
                    int last_country = listC[ind_cou].getCountryResId();
                    show_2.setText(last_country);
//Это
                    show_3.setText(R.string.prompt_country_eto);
//Правильная столица
                    int last_capital = listA[ind_cou].getCapitalResId();
                    show_4.setText(last_capital);

                }
//Окончание тренировки. Суммируем количество правильных и неправильных ответов. И когда получается
// число = 20, то мы останавливаем тренировку. Выводим на экран, вместо Страны - Поздравление,
// вместо столиц - количество правильных и неправильных ответов. Но лучше - чтобы было перенаправление на другую страницу с результатом
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {
                    //И передаём1 данные по количетву правильных и неправильных ответов
                    //(1)куда передаём НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемая переменная)
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result.num_correct_result, cor);
                    //запускаем2 активность Result (act_result) с результатом
                    startActivity(intent);

                }
                //Задаём значение для
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
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






    public void goToBaseKnowledge(View v){
        Intent intent = new Intent(this, BaseKnowledge.class);
        startActivity(intent);
    }
    public void goToPrompt (View v){
        Intent intent = new Intent(this, Prompt.class);
        startActivity(intent);
    }
    public void goToListTren (View v){
        Intent intent = new Intent(this, ListTren.class);
        startActivity(intent);
    }


}