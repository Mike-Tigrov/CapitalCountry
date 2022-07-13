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

public class Tren_50 extends AppCompatActivity {

    //Создаём переменную для текстового поля @+id/text_roll (это на вкладке
// act_tren_50.xml) для последующего вывода очередной страны и удаляем поле text:
    private TextView rText;

    //Создаём переменные для кнопок @+id/but_1, @+id/but_2, @+id/but_3 и @+id/but_4 и
// удаляем из act_tren_50 поле text. В эти кнопки будут вписаны называния столиц для выбора
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

    //Создаём 4 переменных для записи значений, получаемых в результате работы кнопок.
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
    int num_questions = 49;

    //Создаём 2 переменные для подсчёта правильных и неправильных ответов во время нажатия кнопок
    int num_correct;
    int num_incorrect;

    //Создаём 2 переменные для текстового поля @+id/num_correct and @+id/num_incorrect, это будут
// выводиться на экран результаты верных или ошибочных ответов, в числовом выражении. Т.е.
// количество верных/неверных ответов можно будет наблюдать во время прохождения тестированя
    private TextView num_correct_t;
    private TextView num_incorrect_t;

    //Добавляем переменную для текстового поля answerCheck, где будет появлятся результат нажатия
// кнопки - правильный или неправильный ответ. Текстовое поле располагаем
// в linearLayout(horizontal), там где у нас кнопки, под ними. В файле strings добавляем 3 поля:
//    <string name="wait_answer">Нажмите кнопку с вариантом столицы</string>
//    <string name="correct_answer">Верный ответ!</string>
//    <string name="incorrect_answer">Ошибка</string>
    private TextView anCheck;

    //Создаём генератор случайных занчений
    Random random = new Random();

    //Создаём список listC на основе класса Country из каталога model, откуда мы
// будем брать значения стран
    private final Country[] listC = new Country[]
            {
                    new Country(R.string.country_50_Australia_0),
                    new Country(R.string.country_50_Austria_1),
                    new Country(R.string.country_50_Algiers_2),
                    new Country(R.string.country_50_Argentina_3),
                    new Country(R.string.country_50_Bangladesh_4),
                    new Country(R.string.country_50_Belgium_5),
                    new Country(R.string.country_50_Brazil_6),
                    new Country(R.string.country_50_GreatBritain_7),
                    new Country(R.string.country_50_Vietnam_8),
                    new Country(R.string.country_50_Germany_9),
                    new Country(R.string.country_50_Denmark_10),
                    new Country(R.string.country_50_Egypt_11),
                    new Country(R.string.country_50_Israel_12),
                    new Country(R.string.country_50_India_13),
                    new Country(R.string.country_50_Indonesia_14),
                    new Country(R.string.country_50_Iraq_15),
                    new Country(R.string.country_50_Iran_16),
                    new Country(R.string.country_50_Ireland_17),
                    new Country(R.string.country_50_Spain_18),
                    new Country(R.string.country_50_Italy_19),
                    new Country(R.string.country_50_Kazakhstan_20),
                    new Country(R.string.country_50_Canada_21),
                    new Country(R.string.country_50_China_22),
                    new Country(R.string.country_50_Colombia_23),
                    new Country(R.string.country_50_KoreaSouth_24),
                    new Country(R.string.country_50_Malaysia_25),
                    new Country(R.string.country_50_Mexico_26),
                    new Country(R.string.country_50_Nigeria_27),
                    new Country(R.string.country_50_Netherlands_28),
                    new Country(R.string.country_50_UnitedArabEmirates_29),
                    new Country(R.string.country_50_Pakistan_30),
                    new Country(R.string.country_50_Peru_31),
                    new Country(R.string.country_50_Poland_32),
                    new Country(R.string.country_50_Portugal_33),
                    new Country(R.string.country_50_RussianFederation_34),
                    new Country(R.string.country_50_Romania_35),
                    new Country(R.string.country_50_SaudiArabia_36),
                    new Country(R.string.country_50_Singapore_37),
                    new Country(R.string.country_50_UnitedStatesOfAmerica_38),
                    new Country(R.string.country_50_Thailand_39),
                    new Country(R.string.country_50_Turkey_40),
                    new Country(R.string.country_50_Ukraine_41),
                    new Country(R.string.country_50_Philippines_42),
                    new Country(R.string.country_50_France_43),
                    new Country(R.string.country_50_CzechRepublic_44),
                    new Country(R.string.country_50_Chile_45),
                    new Country(R.string.country_50_Switzerland_46),
                    new Country(R.string.country_50_Sweden_47),
                    new Country(R.string.country_50_RepublicOfSouthAfricaSAR_48),
                    new Country(R.string.country_50_Japan_49),
            };

    //Создаём переменную для индекса массива listC и инициализируем её через 0. По ней мы будем
// перебирать наш массив и выбирать страны. Также по этой переменной мы будем искать правильные
// столицы, так как порядковый номер Страны совпадает с порядковым номером подходящей
// для неё Столицы.
    private int ind_cou = 0;

    //Создаём список listA на основе класса Capital, из каталога model, из которого будем
// брать значения столиц
    private final Capital[] listA = new Capital[]
            {
                    new Capital(R.string.capital_50_Canberra_0),
                    new Capital(R.string.capital_50_Vienna_1),
                    new Capital(R.string.capital_50_Algeria_2),
                    new Capital(R.string.capital_50_BuenosAires_3),
                    new Capital(R.string.capital_50_Dhaka_4),
                    new Capital(R.string.capital_50_Brussels_5),
                    new Capital(R.string.capital_50_Brasilia_6),
                    new Capital(R.string.capital_50_London_7),
                    new Capital(R.string.capital_50_Hanoi_8),
                    new Capital(R.string.capital_50_Berlin_9),
                    new Capital(R.string.capital_50_Copenhagen_10),
                    new Capital(R.string.capital_50_Cairo_11),
                    new Capital(R.string.capital_50_Jerusalem_12),
                    new Capital(R.string.capital_50_NewDelhi_13),
                    new Capital(R.string.capital_50_Jakarta_14),
                    new Capital(R.string.capital_50_Baghdad_15),
                    new Capital(R.string.capital_50_Tehran_16),
                    new Capital(R.string.capital_50_Dublin_17),
                    new Capital(R.string.capital_50_Madrid_18),
                    new Capital(R.string.capital_50_Rome_19),
                    new Capital(R.string.capital_50_NurSultanAstana_20),
                    new Capital(R.string.capital_50_Ottawa_21),
                    new Capital(R.string.capital_50_Beijing_22),
                    new Capital(R.string.capital_50_Bogota_23),
                    new Capital(R.string.capital_50_CSeoul_24),
                    new Capital(R.string.capital_50_KualaLumpur_25),
                    new Capital(R.string.capital_50_MexicoCity_26),
                    new Capital(R.string.capital_50_Abuja_27),
                    new Capital(R.string.capital_50_Amsterdam_28),
                    new Capital(R.string.capital_50_AbuDhabi_29),
                    new Capital(R.string.capital_50_Islamabad_30),
                    new Capital(R.string.capital_50_Lima_31),
                    new Capital(R.string.capital_50_Warsaw_32),
                    new Capital(R.string.capital_50_Lisbon_33),
                    new Capital(R.string.capital_50_Moscow_34),
                    new Capital(R.string.capital_50_Bucharest_35),
                    new Capital(R.string.capital_50_Riyadh_36),
                    new Capital(R.string.capital_50_Singapore_37),
                    new Capital(R.string.capital_50_Washington_38),
                    new Capital(R.string.capital_50_Bangkok_39),
                    new Capital(R.string.capital_50_Ankara_40),
                    new Capital(R.string.capital_50_Kyiv_41),
                    new Capital(R.string.capital_50_Manila_42),
                    new Capital(R.string.capital_50_Paris_43),
                    new Capital(R.string.capital_50_Prague_44),
                    new Capital(R.string.capital_50_Santiago_45),
                    new Capital(R.string.capital_50_Bern_46),
                    new Capital(R.string.capital_50_Stockholm_47),
                    new Capital(R.string.capital_50_Pretoria_48),
                    new Capital(R.string.capital_50_Tokyo_49),
            };

    @Override
//Метод onCreate(Bundle ...) вызывается при создании экземпляра субкласса активности.
// С него начинается показ активностей на экране, которые загружаются из разметки
// по указанному адресу - в данном случае -  R.layout.activity_tren_20 (т.е. разметка
// расположена в папке res > layout > activity_tren_20.xml
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tren_50);

//Подключаем виджет TextView, он задаёт текст из списка на позицию, где будет
// появляться очередная Столица
        rText = (TextView) findViewById(R.id.roll_text);
        int question = listC[ind_cou].getCountryResId();
        rText.setText(question);

//Подключаем виджет TextView, он будет задавать текст результата ответа
        anCheck = (TextView) findViewById(R.id.answerCheck);
        anCheck.setText(R.string.wait_answer);

//Создаём переход на активность с результатом
        Intent intent = new Intent(this, Result_50.class);

//Создаём временные переменные temp_1,2,3,4. Переменная temp_1 - принимает значение правильной
// столицы (по индексу массива Столиц, т.к. индексы Стран совпадают с правильными индексами
// Столиц), а для temp_2,3,4 мы генерируем псевдослучайное число в диапазоне, ограниченном
// размерами массива Столиц. Так мы выбираем уникальную столицу для каждой кнопки.
// Значения кнопок не повторяются.
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
//Создаём массив из 4 позиций, в который записываем все полученные значения временных переменных
// позиций столиц (temp_1,2,3,4). answer_capital - массив порядковых номеров (НЕ массив значений!),
// который соответствует 4 кнопкам и определяет, на какой кнопке из 4х будет выводиться
// конкретная столица.
        int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//Генератором случайных чисел из массива возможных позиций (0,1.2.3), находим число temp_i
// (позицию, на которую поставим правильный ответ)
        int temp_i = random.nextInt(answer_capital.length);
//Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
        int temp = answer_capital[temp_i];
//На место, выбранное генератором, переносим правильное значение столицы
        answer_capital[temp_i] = answer_capital[0];
//На место правильного значения записываем значение с заменённой позиции. Т.е. по факту,
// мы поменяли значение кнопки 1, где расположена правильная Столица и значение случайной кнопки.
// Таким образом правильных ответ будет появляться на разных кнопках.
        answer_capital[0] = temp;

//Подключаем виджет Button и получаем ссылку на виджет кнопки @+id/but_1, при этом удаляем
// их поля в activity_tren_20.xml - android:text="Button", так как туда мы будем вставлять Столицу
        but_cap_1 = (Button) findViewById(R.id.but_1);
//Устанавливаем первоначальное значение для кнопки 1
        int cap1 = listA[answer_capital[0]].getCapitalResId();
        but_cap_1.setText(cap1);

//Подключаем переменные, для реакции на нажатие кнопки. Они расположены друг над другом.
// Следующие 4 поля нужны для вывода мотивирующей информации или подсказок, в случае ошибки
// (изначально в них отображались значения для отладки приложения).
        show_1 = (TextView) findViewById(R.id.show_1);
        show_2 = (TextView) findViewById(R.id.show_2);
        show_3 = (TextView) findViewById(R.id.show_3);
        show_4 = (TextView) findViewById(R.id.show_4);

//Сохраняем значения в переменные, потому что при клике по кнопке, в кнопке остаётся код,
// который становится "старым", т.е. он не обновляется одновременно с кодом в других кнопках.
// И при последующих проверках правильности выбора столицы это приводит к ошибке.
// Поэтому мы в самом начале кода кнопки загружаем в него новые значения, а на выходе из кода
// сохраняем в переменные, из которых потом загрузим во вновь нажатую кнопку. Наверное есть
// способ проще и лучше, но я пока его не знаю ;) Пища для рефакторинга и обновлений ;)
        num_1 = answer_capital[0];
        num_2 = answer_capital[1];
        num_3 = answer_capital[2];
        num_4 = answer_capital[3];

//Инициализируем счётчики правильных и неправильных ответов
        num_correct = 0;
        num_incorrect = 0;

//Подключаем виджеты полей @+id/num_correct and @+id/num_incorrect для вывода количества
// правильных и ошибочных ответов. При этом мы не можем просто вывести число int в поле TextView,
// для этого необходимо число преобразовать в текст методом
// String s = Integer.toString(преобразовываемое число);
        String numCorr = Integer.toString(num_correct);
        num_correct_t = (TextView) findViewById(R.id.num_correct);
        num_correct_t.setText(numCorr);

        String numInCorr = Integer.toString(num_incorrect);
        num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
        num_incorrect_t.setText(numInCorr);

//Первая кнопка с выбором столицы. Задаём значение виджету кнопки 1. Здесь мы реализуем интерфейс
// слушателя события. Собитие у нас - клик по кнопке. В круглых
// скобках "...stener(new View ... });" создаётся новый безымянный класс, который будет
// реализован вызываемым методом onClick. То есть после клика, запускается сразу несколько операций (проверка правильности, вывод результата.
// При этом первоначальный текст для Страны и 4 кнопок-Столиц уже задан, а после нажатия,
// происходит генерация новых значений для кнопок.

        but_cap_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Загружаем на входе в код кнопки значения из истории нажатий в переменные, чтобы данные в кнопке обновились,
// а то будут ошибки при подсчёте правильной столицы.
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;

//Проверяем правильность выбранной столицы. У нас есть номер Страны из списка стран, он
// соответствует номеру столицы из списка Столиц. То есть данные Страна и Столица расположены
// в двух списках на позициях с одинаковыми номерами. В случае верного нажатия, в текстовое
// поле (answerCheck) добавляем надпись - Правильный ответ! или Ошибка

                if (ind_cou == num_1) {
//Если номера совпадают, то Ответ правильный
                    anCheck.setText(R.string.correct_answer);

//Добавляем +1 к количеству правильных ответов
                    num_correct++;
//Выводим новое количество правильных ответов на экран в поле num_correct, перед этим мы
// преобразовываем цифру в текст
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
//В случае ошибочного ответа выдаётся сообщение об ошибке
                    anCheck.setText(R.string.incorrect_answer);

//Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
//Даём подсказку по прошлому, неправильному нажатию кнопки
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

//Окончание тренировки.
// Суммируем количество правильных и неправильных ответов. И когда получается число = 20,
// то мы переходим на другую активность Result, где будут результаты нашего прохождения.
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {

//Передаём данные по количеству правильных ответов в активность Result. Затем вычитаем из 20 это количество и
// получаем количество ответов с ошибкой. К сожалению передать количество ошибок не получилось.
// Почему-то при передаче двух значений (количества верных и количества неверных ответов), в поле
// выводилось только количество неверных значений. При этом количество неверных ответов выводилось
// одновременно в двух полях - где должны были появляться количества правильных и неправильных
// ответов. Найти причину ошибки не получилось (пища для рефакторинга). Поэтому оставил вывод
// правильных с вычетанием из 20.
                    //(Куда передаём: (НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемаяПеременная)
//Передавать получилось только текст, поэтому преобразовываем в текст перед отправкой
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result_50.num_correct_result, cor);
//Запускаем активность Result (act_result) с результатами тестирования
                    startActivity(intent);
                }

//С этого момента кнопка начинает переписывать содержимое страницы (индекс страны,
// массив вывода столиц для кнопок)

//Определяем значение (текст) для поля вывода Страны
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
//setText - вписываем текст
                rText.setText(question);

//Создаём временные переменные temp_1,2,3,4. Переменная temp_1 - принимает значение правильной
// столицы (по индексу массива Столиц, т.к. индексы Стран совпадают с правильными индексами
// Столиц), а для temp_2,3,4 мы генерируем псевдослучайное число в диапазоне, ограниченном
// размерами массива Столиц. Так мы выбираем уникальную столицу для каждой кнопки.
// Значения кнопок не повторяются.
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

//Создаём массив из 4 позиций, в который записываем все полученные значения временных переменных
// позиций столиц (temp_1,2,3,4). answer_capital - массив порядковых номеров (НЕ массив значений!),
// который соответствует 4 кнопкам и определяет, на какой кнопке из 4х будет выводиться
// конкретная столица.
                int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//Генератором случайных чисел из массива возможных позиций (0,1.2.3), находим число temp_i
// (позицию, на которую поставим правильный ответ)
                int temp_i = random.nextInt(answer_capital.length);

//Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
                int temp = answer_capital[temp_i];

//На место, выбранное генератором, переносим правильное значение столицы
                answer_capital[temp_i] = answer_capital[0];

//На место правильного значения записываем значение с заменённой позиции. Т.е. по факту,
// мы поменяли значение кнопки 1, где расположена правильная Столица и значение случайной кнопки.
// Таким образом правильных ответ будет появляться на разных кнопках.
                answer_capital[0] = temp;

//Устанавливаем столицы для 4х кнопок, исходя из позиций перемешанного списка answer_capital
                int cap1 = listA[answer_capital[0]].getCapitalResId();
                but_cap_1.setText(cap1);

                int cap2 = listA[answer_capital[1]].getCapitalResId();
                but_cap_2.setText(cap2);

                int cap3 = listA[answer_capital[2]].getCapitalResId();
                but_cap_3.setText(cap3);

                int cap4 = listA[answer_capital[3]].getCapitalResId();
                but_cap_4.setText(cap4);

//В конце работы кнопки сохраняем значения в переменные
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
            }
        });

//Подключаем виджет Button и получаем ссылку на виджет кнопки @+id/but_2, при этом удаляем
// их поля в activity_tren_20.xml - android:text="Button", так как туда мы будем вставлять Столицу
        but_cap_2 = (Button) findViewById(R.id.but_2);
//Устанавливаем в неё первоначальное значение (до клика)
        int cap2 = listA[answer_capital[1]].getCapitalResId();
        but_cap_2.setText(cap2);

//Копируем содержимое первой кнопки с изменениями для 2 кнопки:
        but_cap_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Загружаем на входе в код кнопки значения из истории нажатий в переменные, чтобы данные в кнопке обновились,
// а то будут ошибки при подсчёте правильной столицы.
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;

//Проверяем правильность выбранной столицы. У нас есть номер Страны из списка стран, он
// соответствует номеру столицы из списка Столиц. То есть данные Страна и Столица расположены
// в двух списках на позициях с одинаковыми номерами. В случае верного нажатия, в текстовое
// поле (answerCheck) добавляем надпись - Правильный ответ! или Ошибка

                if (ind_cou == num_2) {
//Если номера совпадают, то Ответ правильный
                    anCheck.setText(R.string.correct_answer);

//Добавляем +1 к количеству правильных ответов
                    num_correct++;
//Выводим новое количество правильных ответов на экран в поле num_correct, перед этим мы
// преобразовываем цифру в текст
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
//В случае ошибочного ответа выдаётся сообщение об ошибке
                    anCheck.setText(R.string.incorrect_answer);

//Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
//Даём подсказку по прошлому, неправильному нажатию кнопки
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

//Окончание тренировки.
// Суммируем количество правильных и неправильных ответов. И когда получается число = 20,
// то мы переходим на другую активность Result, где будут результаты нашего прохождения.
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {

//Передаём данные по количеству правильных ответов в активность Result. Затем вычитаем из 20 это количество и
// получаем количество ответов с ошибкой. К сожалению передать количество ошибок не получилось.
// Почему-то при передаче двух значений (количества верных и количества неверных ответов), в поле
// выводилось только количество неверных значений. При этом количество неверных ответов выводилось
// одновременно в двух полях - где должны были появляться количества правильных и неправильных
// ответов. Найти причину ошибки не получилось (пища для рефакторинга). Поэтому оставил вывод
// правильных с вычетанием из 20.
                    //(Куда передаём: (НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемаяПеременная)
//Передавать получилось только текст, поэтому преобразовываем в текст перед отправкой
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result_50.num_correct_result, cor);
//Запускаем активность Result (act_result) с результатами тестирования
                    startActivity(intent);
                }

//С этого момента кнопка начинает переписывать содержимое страницы (индекс страны,
// массив вывода столиц для кнопок)

//Определяем значение (текст) для поля вывода Страны
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
//setText - вписываем текст
                rText.setText(question);

//Создаём временные переменные temp_1,2,3,4. Переменная temp_1 - принимает значение правильной
// столицы (по индексу массива Столиц, т.к. индексы Стран совпадают с правильными индексами
// Столиц), а для temp_2,3,4 мы генерируем псевдослучайное число в диапазоне, ограниченном
// размерами массива Столиц. Так мы выбираем уникальную столицу для каждой кнопки.
// Значения кнопок не повторяются.
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

//Создаём массив из 4 позиций, в который записываем все полученные значения временных переменных
// позиций столиц (temp_1,2,3,4). answer_capital - массив порядковых номеров (НЕ массив значений!),
// который соответствует 4 кнопкам и определяет, на какой кнопке из 4х будет выводиться
// конкретная столица.
                int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//Генератором случайных чисел из массива возможных позиций (0,1.2.3), находим число temp_i
// (позицию, на которую поставим правильный ответ)
                int temp_i = random.nextInt(answer_capital.length);

//Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
                int temp = answer_capital[temp_i];

//На место, выбранное генератором, переносим правильное значение столицы
                answer_capital[temp_i] = answer_capital[0];

//На место правильного значения записываем значение с заменённой позиции. Т.е. по факту,
// мы поменяли значение кнопки 1, где расположена правильная Столица и значение случайной кнопки.
// Таким образом правильных ответ будет появляться на разных кнопках.
                answer_capital[0] = temp;

//Устанавливаем столицы для 4х кнопок, исходя из позиций перемешанного списка answer_capital
                int cap1 = listA[answer_capital[0]].getCapitalResId();
                but_cap_1.setText(cap1);

                int cap2 = listA[answer_capital[1]].getCapitalResId();
                but_cap_2.setText(cap2);

                int cap3 = listA[answer_capital[2]].getCapitalResId();
                but_cap_3.setText(cap3);

                int cap4 = listA[answer_capital[3]].getCapitalResId();
                but_cap_4.setText(cap4);

//В конце работы кнопки сохраняем значения в переменные
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
            }
        });

//Подключаем виджет Button и получаем ссылку на виджет кнопки @+id/but_3, при этом удаляем
// их поля в activity_tren_20.xml - android:text="Button", так как туда мы будем вставлять Столицу
        but_cap_3 = (Button) findViewById(R.id.but_3);
//Устанавливаем в неё первоначальное значение (до клика)
        int cap3 = listA[answer_capital[2]].getCapitalResId();
        but_cap_3.setText(cap3);
//Копируем содержимое первой кнопки с изменениями для 3 кнопки:
        but_cap_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Загружаем на входе в код кнопки значения из истории нажатий в переменные, чтобы данные в кнопке обновились,
// а то будут ошибки при подсчёте правильной столицы.
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;

//Проверяем правильность выбранной столицы. У нас есть номер Страны из списка стран, он
// соответствует номеру столицы из списка Столиц. То есть данные Страна и Столица расположены
// в двух списках на позициях с одинаковыми номерами. В случае верного нажатия, в текстовое
// поле (answerCheck) добавляем надпись - Правильный ответ! или Ошибка

                if (ind_cou == num_3) {
//Если номера совпадают, то Ответ правильный
                    anCheck.setText(R.string.correct_answer);

//Добавляем +1 к количеству правильных ответов
                    num_correct++;
//Выводим новое количество правильных ответов на экран в поле num_correct, перед этим мы
// преобразовываем цифру в текст
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
//В случае ошибочного ответа выдаётся сообщение об ошибке
                    anCheck.setText(R.string.incorrect_answer);

//Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
//Даём подсказку по прошлому, неправильному нажатию кнопки
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

//Окончание тренировки.
// Суммируем количество правильных и неправильных ответов. И когда получается число = 20,
// то мы переходим на другую активность Result, где будут результаты нашего прохождения.
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {

//Передаём данные по количеству правильных ответов в активность Result. Затем вычитаем из 20 это количество и
// получаем количество ответов с ошибкой. К сожалению передать количество ошибок не получилось.
// Почему-то при передаче двух значений (количества верных и количества неверных ответов), в поле
// выводилось только количество неверных значений. При этом количество неверных ответов выводилось
// одновременно в двух полях - где должны были появляться количества правильных и неправильных
// ответов. Найти причину ошибки не получилось (пища для рефакторинга). Поэтому оставил вывод
// правильных с вычетанием из 20.
                    //(Куда передаём: (НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемаяПеременная)
//Передавать получилось только текст, поэтому преобразовываем в текст перед отправкой
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result_50.num_correct_result, cor);
//Запускаем активность Result (act_result) с результатами тестирования
                    startActivity(intent);
                }

//С этого момента кнопка начинает переписывать содержимое страницы (индекс страны,
// массив вывода столиц для кнопок)

//Определяем значение (текст) для поля вывода Страны
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
//setText - вписываем текст
                rText.setText(question);

//Создаём временные переменные temp_1,2,3,4. Переменная temp_1 - принимает значение правильной
// столицы (по индексу массива Столиц, т.к. индексы Стран совпадают с правильными индексами
// Столиц), а для temp_2,3,4 мы генерируем псевдослучайное число в диапазоне, ограниченном
// размерами массива Столиц. Так мы выбираем уникальную столицу для каждой кнопки.
// Значения кнопок не повторяются.
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

//Создаём массив из 4 позиций, в который записываем все полученные значения временных переменных
// позиций столиц (temp_1,2,3,4). answer_capital - массив порядковых номеров (НЕ массив значений!),
// который соответствует 4 кнопкам и определяет, на какой кнопке из 4х будет выводиться
// конкретная столица.
                int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//Генератором случайных чисел из массива возможных позиций (0,1.2.3), находим число temp_i
// (позицию, на которую поставим правильный ответ)
                int temp_i = random.nextInt(answer_capital.length);

//Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
                int temp = answer_capital[temp_i];

//На место, выбранное генератором, переносим правильное значение столицы
                answer_capital[temp_i] = answer_capital[0];

//На место правильного значения записываем значение с заменённой позиции. Т.е. по факту,
// мы поменяли значение кнопки 1, где расположена правильная Столица и значение случайной кнопки.
// Таким образом правильных ответ будет появляться на разных кнопках.
                answer_capital[0] = temp;

//Устанавливаем столицы для 4х кнопок, исходя из позиций перемешанного списка answer_capital
                int cap1 = listA[answer_capital[0]].getCapitalResId();
                but_cap_1.setText(cap1);

                int cap2 = listA[answer_capital[1]].getCapitalResId();
                but_cap_2.setText(cap2);

                int cap3 = listA[answer_capital[2]].getCapitalResId();
                but_cap_3.setText(cap3);

                int cap4 = listA[answer_capital[3]].getCapitalResId();
                but_cap_4.setText(cap4);

//В конце работы кнопки сохраняем значения в переменные
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
            }
        });

//Подключаем виджет Button и получаем ссылку на виджет кнопки @+id/but_4, при этом удаляем
// их поля в activity_tren_20.xml - android:text="Button", так как туда мы будем вставлять Столицу
        but_cap_4 = (Button) findViewById(R.id.but_4);
        int cap4 = listA[answer_capital[3]].getCapitalResId();
//Устанавливаем в неё первоначальное значение (до клика)
        but_cap_4.setText(cap4);
//Копируем содержимое первой кнопки с изменениями для 4 кнопки:
        but_cap_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Загружаем на входе в код кнопки значения из истории нажатий в переменные, чтобы данные в кнопке обновились,
// а то будут ошибки при подсчёте правильной столицы.
                answer_capital[0] = num_1;
                answer_capital[1] = num_2;
                answer_capital[2] = num_3;
                answer_capital[3] = num_4;

//Проверяем правильность выбранной столицы. У нас есть номер Страны из списка стран, он
// соответствует номеру столицы из списка Столиц. То есть данные Страна и Столица расположены
// в двух списках на позициях с одинаковыми номерами. В случае верного нажатия, в текстовое
// поле (answerCheck) добавляем надпись - Правильный ответ! или Ошибка

                if (ind_cou == num_4) {
//Если номера совпадают, то Ответ правильный
                    anCheck.setText(R.string.correct_answer);

//Добавляем +1 к количеству правильных ответов
                    num_correct++;
//Выводим новое количество правильных ответов на экран в поле num_correct, перед этим мы
// преобразовываем цифру в текст
                    String numCorr = Integer.toString(num_correct);
                    num_correct_t = (TextView) findViewById(R.id.num_correct);
                    num_correct_t.setText(numCorr);

//Добавляем 4 надписи, для мотивации правильного ответа
                    show_1.setText(R.string.correct_answer_1);
                    show_2.setText(R.string.correct_answer_2);
                    show_3.setText(R.string.correct_answer_3);
                    show_4.setText(R.string.correct_answer_4);
                } else {
//В случае ошибочного ответа выдаётся сообщение об ошибке
                    anCheck.setText(R.string.incorrect_answer);

//Добавляем +1 к количеству неверных ответов и выводим на экран в поле num_incorrect
                    num_incorrect++;
                    String numInCorr = Integer.toString(num_incorrect);
                    num_incorrect_t = (TextView) findViewById(R.id.num_incorrect);
                    num_incorrect_t.setText(numInCorr);
//Даём подсказку по прошлому, неправильному нажатию кнопки
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

//Окончание тренировки.
// Суммируем количество правильных и неправильных ответов. И когда получается число = 20,
// то мы переходим на другую активность Result, где будут результаты нашего прохождения.
                int sum = (num_correct + num_incorrect);
                if (sum > num_questions) {

//Передаём данные по количеству правильных ответов в активность Result. Затем вычитаем из 20 это количество и
// получаем количество ответов с ошибкой. К сожалению передать количество ошибок не получилось.
// Почему-то при передаче двух значений (количества верных и количества неверных ответов), в поле
// выводилось только количество неверных значений. При этом количество неверных ответов выводилось
// одновременно в двух полях - где должны были появляться количества правильных и неправильных
// ответов. Найти причину ошибки не получилось (пища для рефакторинга). Поэтому оставил вывод
// правильных с вычетанием из 20.
                    //(Куда передаём: (НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемаяПеременная)
//Передавать получилось только текст, поэтому преобразовываем в текст перед отправкой
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result_50.num_correct_result, cor);
//Запускаем активность Result (act_result) с результатами тестирования
                    startActivity(intent);
                }

//С этого момента кнопка начинает переписывать содержимое страницы (индекс страны,
// массив вывода столиц для кнопок)

//Определяем значение (текст) для поля вывода Страны
                ind_cou = (ind_cou + 1) % listC.length;
                int question = listC[ind_cou].getCountryResId();
//setText - вписываем текст
                rText.setText(question);

//Создаём временные переменные temp_1,2,3,4. Переменная temp_1 - принимает значение правильной
// столицы (по индексу массива Столиц, т.к. индексы Стран совпадают с правильными индексами
// Столиц), а для temp_2,3,4 мы генерируем псевдослучайное число в диапазоне, ограниченном
// размерами массива Столиц. Так мы выбираем уникальную столицу для каждой кнопки.
// Значения кнопок не повторяются.
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

//Создаём массив из 4 позиций, в который записываем все полученные значения временных переменных
// позиций столиц (temp_1,2,3,4). answer_capital - массив порядковых номеров (НЕ массив значений!),
// который соответствует 4 кнопкам и определяет, на какой кнопке из 4х будет выводиться
// конкретная столица.
                int[] answer_capital = new int[] {temp_1, temp_2, temp_3, temp_4};

//Генератором случайных чисел из массива возможных позиций (0,1.2.3), находим число temp_i
// (позицию, на которую поставим правильный ответ)
                int temp_i = random.nextInt(answer_capital.length);

//Создаём временную переменную temp, куда сохраняем содержимое позиции, выпавшей в генераторе
                int temp = answer_capital[temp_i];

//На место, выбранное генератором, переносим правильное значение столицы
                answer_capital[temp_i] = answer_capital[0];

//На место правильного значения записываем значение с заменённой позиции. Т.е. по факту,
// мы поменяли значение кнопки 1, где расположена правильная Столица и значение случайной кнопки.
// Таким образом правильных ответ будет появляться на разных кнопках.
                answer_capital[0] = temp;

//Устанавливаем столицы для 4х кнопок, исходя из позиций перемешанного списка answer_capital
                int cap1 = listA[answer_capital[0]].getCapitalResId();
                but_cap_1.setText(cap1);

                int cap2 = listA[answer_capital[1]].getCapitalResId();
                but_cap_2.setText(cap2);

                int cap3 = listA[answer_capital[2]].getCapitalResId();
                but_cap_3.setText(cap3);

                int cap4 = listA[answer_capital[3]].getCapitalResId();
                but_cap_4.setText(cap4);

//В конце работы кнопки сохраняем значения в переменные
                num_1 = answer_capital[0];
                num_2 = answer_capital[1];
                num_3 = answer_capital[2];
                num_4 = answer_capital[3];
            }
        });
    }
    //Кнопка перехода к базе стран-столиц
    public void goToBaseKnowledge(View v){
        Intent intent = new Intent(this, BaseKnowledge.class);
        startActivity(intent);
    }
    //Кнопка перехода к Подсказке
    public void goToPrompt (View v){
        Intent intent = new Intent(this, Prompt.class);
        startActivity(intent);
    }
    //Кнопка перехода к Списку тренировок
    public void goToListTren (View v){
        Intent intent = new Intent(this, ListTren.class);
        startActivity(intent);
    }
}