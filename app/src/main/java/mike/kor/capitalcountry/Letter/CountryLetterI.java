package mike.kor.capitalcountry.Letter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mike.kor.capitalcountry.MainActivity;
import mike.kor.capitalcountry.Prompt;
import mike.kor.capitalcountry.R;
import mike.kor.capitalcountry.SpisokStran;
import mike.kor.capitalcountry.adapter.ACountryAdapter;
import mike.kor.capitalcountry.model.ACountry;


public class CountryLetterI extends AppCompatActivity {
    //1. Создаём объект на основе класса RecyclerView c названием countryRecycler
    RecyclerView countryRecycler;
    //2 (после всего что было сделано ниже) Создаём новый объект
    ACountryAdapter aCountryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_letter_i);
        //Создаём список List<> из различных категорий
        //Каждый элемент - на основе класса ACountry, это в <>
        //Название списка - ACountryList
        //Выделяем память, прописываем после "=" - "new ArrayList"
        List<ACountry> ACountryList = new ArrayList<>();
        //Обращаемся к ACountryList
        //Обращаемся к методу add
        //И добавляем новые элементы на основе класса ACountry
        //В скобках указываем № элемента (идентификатор) и название

        ACountryList.add(new ACountry(1, "1. Израиль - Иерусалим"));
        ACountryList.add(new ACountry(2, "2. Индия - Нью-Дели"));
        ACountryList.add(new ACountry(3, "3. Индонезия - Джакарта"));
        ACountryList.add(new ACountry(4, "4. Иордания - Амман"));
        ACountryList.add(new ACountry(5, "5. Ирак - Багдад"));
        ACountryList.add(new ACountry(6, "6. Иран - Тегеран"));
        ACountryList.add(new ACountry(7, "7. Ирландия - Дублин"));
        ACountryList.add(new ACountry(8, "8. Исландия - Рейкьявик"));
        ACountryList.add(new ACountry(9, "9. Испания - Мадрид"));
        ACountryList.add(new ACountry(10, "10. Италия - Рим"));

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

    public void goToMain (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void countryState(View v){
        Intent intent = new Intent(this, SpisokStran.class);
        startActivity(intent);
    }
    public void prompt (View v){
        Intent intent = new Intent(this, Prompt.class);
        startActivity(intent);
    }
}