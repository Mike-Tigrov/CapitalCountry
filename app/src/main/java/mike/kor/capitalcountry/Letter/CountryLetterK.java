package mike.kor.capitalcountry.Letter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mike.kor.capitalcountry.BaseKnowledge;
import mike.kor.capitalcountry.ListTren;
import mike.kor.capitalcountry.Prompt;
import mike.kor.capitalcountry.R;
import mike.kor.capitalcountry.adapter.ACountryAdapter;
import mike.kor.capitalcountry.model.ACountry;


public class CountryLetterK extends AppCompatActivity {
    //1. Создаём объект на основе класса RecyclerView c названием countryRecycler
    RecyclerView countryRecycler;
    //2 (после всего что было сделано ниже) Создаём новый объект
    ACountryAdapter aCountryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_letter_k);
        //Создаём список List<> из различных категорий
        //Каждый элемент - на основе класса ACountry, это в <>
        //Название списка - ACountryList
        //Выделяем память, прописываем после "=" - "new ArrayList"
        List<ACountry> ACountryList = new ArrayList<>();
        //Обращаемся к ACountryList
        //Обращаемся к методу add
        //И добавляем новые элементы на основе класса ACountry
        //В скобках указываем № элемента (идентификатор) и название

        ACountryList.add(new ACountry(1, "1. Кабо-Верде - Прая"));
        ACountryList.add(new ACountry(2, "2. Казахстан - Нур-Султан (Астана)"));
        ACountryList.add(new ACountry(3, "3. Камбоджа - Пномпень"));
        ACountryList.add(new ACountry(4, "4. Камерун - Яунде"));
        ACountryList.add(new ACountry(5, "5. Канада - Оттава"));
        ACountryList.add(new ACountry(6, "6. Канарские острова (автономия Испании) - Са́нта-Крус-де-Тенери́фе или Лас-Па́льмас-де-Гран-Кана́рия (столица переезжает раз в 4 года)"));
        ACountryList.add(new ACountry(7, "7. Катар - Доха"));
        ACountryList.add(new ACountry(8, "8. Кения - Найроби"));
        ACountryList.add(new ACountry(9, "9. Кипр - Никосия"));
        ACountryList.add(new ACountry(10, "10. Северный Кипр (частично признан) - Лефкосия"));
        ACountryList.add(new ACountry(11, "11. Киргизия - Бишкек"));
        ACountryList.add(new ACountry(12, "12. Кирибати - Тарава"));
        ACountryList.add(new ACountry(13, "13. Китай - Пекин"));
        ACountryList.add(new ACountry(14, "14. Колумбия - Богота"));
        ACountryList.add(new ACountry(15, "15. Коморские острова - Морони"));
        ACountryList.add(new ACountry(16, "16. Конго - Браззавиль"));
        ACountryList.add(new ACountry(17, "17. Демократическая Република Конго (бывший Заир) - Киншаса"));
        ACountryList.add(new ACountry(18, "18. Корея Северная - Пхеньян"));
        ACountryList.add(new ACountry(19, "19. Корея Южная - Сеул"));
        ACountryList.add(new ACountry(20, "20. Республика Косово (частично признана) - Приштина"));
        ACountryList.add(new ACountry(21, "21. Коста-Рика - Сан-Хосе"));
        ACountryList.add(new ACountry(22, "22. Кот-д'Ивуар - Ямусукро"));
        ACountryList.add(new ACountry(23, "23. Куба - Гавана"));
        ACountryList.add(new ACountry(24, "24. Кувейт - Эль-Кувейт"));
        ACountryList.add(new ACountry(25, "25. Кюрасао (часть Королевства Нидерландов) - Виллемстад"));


//Вызываем свой собственный метод setCountryRecycler()
        //Передаём в него ACountryList

        setCountryRecycler(ACountryList);

        //С помощью всплывающей подсказки (слева вверху красная лампочка) создаём метод

    }

    private void setCountryRecycler(List<ACountry> aCountryList) {
//Указываем настройки для вывода всей информации
        //По умолчанию вся информация выводится вертикально, друг под другом
        //Автор примера хотел выводить не вертикально, а горизонтально, поэтому пишем следующую строку
        //this - говорит, что выполняться будет здесь, на этой странице
//RecyclerView.VERTICAL - вывод вертикальный, можно горизонтальный, но у нас - вертикальный
        //false - вывод в прямой последовательности, а не в обратной (по умолчанию)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        //Установим ссылку на нужный объект из дизайна
        countryRecycler = findViewById(R.id.countryRecycler);
        //Ещё раз обращаемся к нему и установим для него настройки
        countryRecycler.setLayoutManager(layoutManager);

//Выделяем память
        //Передаём в конструктор 2 параметра: this - то есть делать всё будем на этой же странице
        aCountryAdapter = new ACountryAdapter(this, aCountryList);
        countryRecycler.setAdapter(aCountryAdapter);

    }

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