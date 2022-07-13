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

public class Tren_100 extends AppCompatActivity {

    //Создаём переменную для текстового поля @+id/text_roll для последующего вывода очередной страны и удаляем поле text:
    private TextView rText;

    //Создаём переменные для кнопок @+id/but_1, @+id/but_2, @+id/but_3 и @+id/but_4 и
// удаляем поле text. В эти кнопки будут вписаны называния столиц для выбора
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
    int num_questions = 99;

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
                    new Country(R.string.country_100_Australia_0),
                    new Country(R.string.country_100_Austria_1),
                    new Country(R.string.country_100_Azerbaijan_2),
                    new Country(R.string.country_100_Algeria_3),
                    new Country(R.string.country_100_Angola_4),
                    new Country(R.string.country_100_Argentina_5),
                    new Country(R.string.country_100_Afghanistan_6),
                    new Country(R.string.country_100_Bangladesh_7),
                    new Country(R.string.country_100_Bahrain_8),
                    new Country(R.string.country_100_Belarus_9),
                    new Country(R.string.country_100_Belgium_10),
                    new Country(R.string.country_100_Bulgaria_11),
                    new Country(R.string.country_100_Bolivia_12),
                    new Country(R.string.country_100_Brazil_13),
                    new Country(R.string.country_100_GreatBritain_14),
                    new Country(R.string.country_100_Hungary_15),
                    new Country(R.string.country_100_Vietnam_16),
                    new Country(R.string.country_100_Ghana_17),
                    new Country(R.string.country_100_Guatemala_18),
                    new Country(R.string.country_100_Germany_19),
                    new Country(R.string.country_100_Greece_20),
                    new Country(R.string.country_100_Denmark_21),
                    new Country(R.string.country_100_DominicanRepublic_22),
                    new Country(R.string.country_100_Egypt_23),
                    new Country(R.string.country_100_Zambia_24),
                    new Country(R.string.country_100_Israel_25),
                    new Country(R.string.country_100_India_26),
                    new Country(R.string.country_100_Indonesia_27),
                    new Country(R.string.country_100_Jordan_28),
                    new Country(R.string.country_100_Iraq_29),
                    new Country(R.string.country_100_Iran_30),
                    new Country(R.string.country_100_Ireland_31),
                    new Country(R.string.country_100_Spain_32),
                    new Country(R.string.country_100_Italy_33),
                    new Country(R.string.country_100_Kazakhstan_34),
                    new Country(R.string.country_100_Cambodia_35),
                    new Country(R.string.country_100_Cameroon_36),
                    new Country(R.string.country_100_Canada_37),
                    new Country(R.string.country_100_Qatar_38),
                    new Country(R.string.country_100_Kenya_39),
                    new Country(R.string.country_100_China_40),
                    new Country(R.string.country_100_Colombia_41),
                    new Country(R.string.country_100_Congo_42),
                    new Country(R.string.country_100_KoreaSouth_43),
                    new Country(R.string.country_100_CostaRica_44),
                    new Country(R.string.country_100_IvoryCoast_45),
                    new Country(R.string.country_100_Kuwait_46),
                    new Country(R.string.country_100_Laos_47),
                    new Country(R.string.country_100_Latvia_48),
                    new Country(R.string.country_100_Lebanon_49),
                    new Country(R.string.country_100_Libya_50),
                    new Country(R.string.country_100_Lithuania_51),
                    new Country(R.string.country_100_Luxembourg_52),
                    new Country(R.string.country_100_Malaysia_53),
                    new Country(R.string.country_100_Morocco_54),
                    new Country(R.string.country_100_Mexico_55),
                    new Country(R.string.country_100_Myanmar_56),
                    new Country(R.string.country_100_Nepal_57),
                    new Country(R.string.country_100_Nigeria_58),
                    new Country(R.string.country_100_Netherlands_59),
                    new Country(R.string.country_100_NewZealand_60),
                    new Country(R.string.country_100_Norway_61),
                    new Country(R.string.country_100_UnitedAraEmiratesUAE_62),
                    new Country(R.string.country_100_Pakistan_63),
                    new Country(R.string.country_100_Panama_64),
                    new Country(R.string.country_100_Paraguay_65),
                    new Country(R.string.country_100_Peru_66),
                    new Country(R.string.country_100_Poland_67),
                    new Country(R.string.country_100_Portugal_68),
                    new Country(R.string.country_100_RussianFederation_69),
                    new Country(R.string.country_100_Romania_70),
                    new Country(R.string.country_100_SaudiArabia_71),
                    new Country(R.string.country_100_Serbia_72),
                    new Country(R.string.country_100_Singapore_73),
                    new Country(R.string.country_100_Slovakia_74),
                    new Country(R.string.country_100_Slovenia_75),
                    new Country(R.string.country_100_USA_76),
                    new Country(R.string.country_100_Sudan_77),
                    new Country(R.string.country_100_Thailand_78),
                    new Country(R.string.country_100_Tanzania_79),
                    new Country(R.string.country_100_Tunisia_80),
                    new Country(R.string.country_100_Turkmenistan_81),
                    new Country(R.string.country_100_Turkey_82),
                    new Country(R.string.country_100_Uganda_83),
                    new Country(R.string.country_100_Uzbekistan_84),
                    new Country(R.string.country_100_Ukraine_85),
                    new Country(R.string.country_100_Uruguay_86),
                    new Country(R.string.country_100_Philippines_87),
                    new Country(R.string.country_100_Finland_88),
                    new Country(R.string.country_100_France_89),
                    new Country(R.string.country_100_Croatia_90),
                    new Country(R.string.country_100_Czech_91),
                    new Country(R.string.country_100_Chile_92),
                    new Country(R.string.country_100_Switzerland_93),
                    new Country(R.string.country_100_Sweden_94),
                    new Country(R.string.country_100_SriLanka_95),
                    new Country(R.string.country_100_Ecuador_96),
                    new Country(R.string.country_100_Ethiopia_97),
                    new Country(R.string.country_100_RepublicOfSouthAfrica_98),
                    new Country(R.string.country_100_Japan_99),
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
                    new Capital(R.string.capital_100_Canberra_0),
                    new Capital(R.string.capital_100_Vein_1),
                    new Capital(R.string.capital_100_Baku_2),
                    new Capital(R.string.capital_100_Algeria_3),
                    new Capital(R.string.capital_100_Luanda_4),
                    new Capital(R.string.capital_100_BuenosAires_5),
                    new Capital(R.string.capital_100_Kabul_6),
                    new Capital(R.string.capital_100_Dhaka_7),
                    new Capital(R.string.capital_100_Manama_8),
                    new Capital(R.string.capital_100_Minsk_9),
                    new Capital(R.string.capital_100_Brussels_10),
                    new Capital(R.string.capital_100_Sofia_11),
                    new Capital(R.string.capital_100_LaPaz_12),
                    new Capital(R.string.capital_100_Brasilia_13),
                    new Capital(R.string.capital_100_London_14),
                    new Capital(R.string.capital_100_Budapest_15),
                    new Capital(R.string.capital_100_Hanoi_16),
                    new Capital(R.string.capital_100_Accra_17),
                    new Capital(R.string.capital_100_Guatemala_18),
                    new Capital(R.string.capital_100_Berlin_19),
                    new Capital(R.string.capital_100_Athens_20),
                    new Capital(R.string.capital_100_Copenhagen_21),
                    new Capital(R.string.capital_100_SantoDomingo_22),
                    new Capital(R.string.capital_100_Cairo_23),
                    new Capital(R.string.capital_100_Lusaka_24),
                    new Capital(R.string.capital_100_Jerusalem_25),
                    new Capital(R.string.capital_100_NewDelhi_26),
                    new Capital(R.string.capital_100_Jakarta_27),
                    new Capital(R.string.capital_100_Amman_28),
                    new Capital(R.string.capital_100_Baghdad_29),
                    new Capital(R.string.capital_100_Tehran_30),
                    new Capital(R.string.capital_100_Dublin_31),
                    new Capital(R.string.capital_100_Madrid_32),
                    new Capital(R.string.capital_100_Rome_33),
                    new Capital(R.string.capital_100_NurSultanAstana_34),
                    new Capital(R.string.capital_100_PhnomPenh_35),
                    new Capital(R.string.capital_100_Yaounde_36),
                    new Capital(R.string.capital_100_Ottawa_37),
                    new Capital(R.string.capital_100_Doha_38),
                    new Capital(R.string.capital_100_Nairobi_39),
                    new Capital(R.string.capital_100_Beijing_40),
                    new Capital(R.string.capital_100_Bogota_41),
                    new Capital(R.string.capital_100_Brazzaville_42),
                    new Capital(R.string.capital_100_Seoul_43),
                    new Capital(R.string.capital_100_SanJose_44),
                    new Capital(R.string.capital_100_Yamoussoukro_45),
                    new Capital(R.string.capital_100_ElKuwait_46),
                    new Capital(R.string.capital_100_Vientiane_47),
                    new Capital(R.string.capital_100_Riga_48),
                    new Capital(R.string.capital_100_Beirut_49),
                    new Capital(R.string.capital_100_Tripoli_50),
                    new Capital(R.string.capital_100_Vilnius_51),
                    new Capital(R.string.capital_100_Luxembourg_52),
                    new Capital(R.string.capital_100_KualaLumpur_53),
                    new Capital(R.string.capital_100_Rabat_54),
                    new Capital(R.string.capital_100_MexicoCity_55),
                    new Capital(R.string.capital_100_Naypyidaw_56),
                    new Capital(R.string.capital_100_Kathmandu_57),
                    new Capital(R.string.capital_100_Abuja_58),
                    new Capital(R.string.capital_100_Amsterdam_59),
                    new Capital(R.string.capital_100_Wellington_60),
                    new Capital(R.string.capital_100_Oslo_61),
                    new Capital(R.string.capital_100_AbuDhabi_62),
                    new Capital(R.string.capital_100_Islamabad_63),
                    new Capital(R.string.capital_100_Panama_64),
                    new Capital(R.string.capital_100_Asuncion_65),
                    new Capital(R.string.capital_100_Lima_66),
                    new Capital(R.string.capital_100_Warsaw_67),
                    new Capital(R.string.capital_100_Lisbon_68),
                    new Capital(R.string.capital_100_Moscow_69),
                    new Capital(R.string.capital_100_Bucharest_70),
                    new Capital(R.string.capital_100_Riyadh_71),
                    new Capital(R.string.capital_100_Belgrade_72),
                    new Capital(R.string.capital_100_Singapore_73),
                    new Capital(R.string.capital_100_Bratislava_74),
                    new Capital(R.string.capital_100_Ljubljana_75),
                    new Capital(R.string.capital_100_Washington_76),
                    new Capital(R.string.capital_100_Khartoum_77),
                    new Capital(R.string.capital_100_Bangkok_78),
                    new Capital(R.string.capital_100_Dodoma_79),
                    new Capital(R.string.capital_100_Tunisia_80),
                    new Capital(R.string.capital_100_Ashgabat_81),
                    new Capital(R.string.capital_100_Ankara_82),
                    new Capital(R.string.capital_100_Kampala_83),
                    new Capital(R.string.capital_100_Tashkent_84),
                    new Capital(R.string.capital_100_Kyiv_85),
                    new Capital(R.string.capital_100_Montevideo_86),
                    new Capital(R.string.capital_100_Manila_87),
                    new Capital(R.string.capital_100_Helsinki_88),
                    new Capital(R.string.capital_100_Paris_89),
                    new Capital(R.string.capital_100_Zagreb_90),
                    new Capital(R.string.capital_100_Prague_91),
                    new Capital(R.string.capital_100_Santiago_92),
                    new Capital(R.string.capital_100_Berne_93),
                    new Capital(R.string.capital_100_Stockholm_94),
                    new Capital(R.string.capital_100_Colombo_95),
                    new Capital(R.string.capital_100_Quito_96),
                    new Capital(R.string.capital_100_AddisAbaba_97),
                    new Capital(R.string.capital_100_Pretoria_98),
                    new Capital(R.string.capital_100_Tokyo_99),
            };

    @Override
//Метод onCreate(Bundle ...) вызывается при создании экземпляра субкласса активности.
// С него начинается показ активностей на экране, которые загружаются из разметки
// по указанному адресу - в данном случае -  R.layout.act_tren_100 (т.е. разметка
// расположена в папке res > layout > act_tren_100.xml
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tren_100);

//Подключаем виджет TextView, он задаёт текст из списка на позицию, где будет
// появляться очередная Столица
        rText = (TextView) findViewById(R.id.roll_text);
        int question = listC[ind_cou].getCountryResId();
        rText.setText(question);

//Подключаем виджет TextView, он будет задавать текст результата ответа
        anCheck = (TextView) findViewById(R.id.answerCheck);
        anCheck.setText(R.string.wait_answer);

//Создаём переход на активность с результатом
        Intent intent = new Intent(this, Result_100.class);

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
// их поля в act_tren_100.xml - android:text="Button", так как туда мы будем вставлять Столицу
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
                    intent.putExtra(Result_100.num_correct_result, cor);
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
// их поля - android:text="Button", так как туда мы будем вставлять Столицу
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
                    intent.putExtra(Result_100.num_correct_result, cor);
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
// их поля в activity_tren_100.xml - android:text="Button", так как туда мы будем вставлять Столицу
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
// правильных с вычетанием из 100.
                    //(Куда передаём: (НазваниеАктивности.имяПеременнойПолучающейЗначение, передаваемаяПеременная)
//Передавать получилось только текст, поэтому преобразовываем в текст перед отправкой
                    String cor = Integer.toString(num_correct);
                    intent.putExtra(Result_100.num_correct_result, cor);
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
                    intent.putExtra(Result_100.num_correct_result, cor);
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