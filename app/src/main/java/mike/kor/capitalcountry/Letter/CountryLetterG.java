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


public class CountryLetterG extends AppCompatActivity {
    //1. Создаём объект на основе класса RecyclerView c названием countryRecycler
    RecyclerView countryRecycler;
    //2 (после всего что было сделано ниже) Создаём новый объект
    ACountryAdapter aCountryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_letter_g);
        //Создаём список List<> из различных категорий
        //Каждый элемент - на основе класса ACountry, это в <>
        //Название списка - ACountryList
        //Выделяем память, прописываем после "=" - "new ArrayList"
        List<ACountry> ACountryList = new ArrayList<>();
        //Обращаемся к ACountryList
        //Обращаемся к методу add
        //И добавляем новые элементы на основе класса ACountry
        //В скобках указываем № элемента (идентификатор) и название

        ACountryList.add(new ACountry(1, "1. Габон - Либревиль"));
        ACountryList.add(new ACountry(2, "2. Гаити - Порт-о-Пренс"));
        ACountryList.add(new ACountry(3, "3. Гайана - Джорджтаун"));
        ACountryList.add(new ACountry(4, "4. Гамбия - Банжул"));
        ACountryList.add(new ACountry(5, "5. Гана - Аккра"));
        ACountryList.add(new ACountry(6, "6. Гваделупа (заморский департамент Франции) - Бас-Тер"));
        ACountryList.add(new ACountry(7, "7. Гватемала - Гватемала"));
        ACountryList.add(new ACountry(8, "8. Гвиана (заморский регион Франции) - Кайенна"));
        ACountryList.add(new ACountry(9, "9. Гвинея - Конакри"));
        ACountryList.add(new ACountry(10, "10. Гвинея-Бисау - Бисау"));
        ACountryList.add(new ACountry(11, "11. Экваториальная Гвинея - Малабо"));
        ACountryList.add(new ACountry(12, "12. Германия - Берлин"));
        ACountryList.add(new ACountry(13, "13. Гернси (коронная земля Великобритании) - Сент-Питер-Порт"));
        ACountryList.add(new ACountry(14, "14. Гибралтар (заморская территория Великобритании) - Гибралтар"));
        ACountryList.add(new ACountry(15, "15. Гондурас - Тегусигальпа"));
        ACountryList.add(new ACountry(15, "16. Гонконг (специальный административный район Китая) - Гонконг"));
        ACountryList.add(new ACountry(16, "17. Гренада - Сент-Джорджес"));
        ACountryList.add(new ACountry(17, "18. Гренландия (автономный регион Дании) - Нуук (Готхоб)"));
        ACountryList.add(new ACountry(18, "19. Греция - Афины"));
        ACountryList.add(new ACountry(19, "20. Грузия - Тбилиси"));
        ACountryList.add(new ACountry(20, "21. Гуам (неприсоединённая территория США) - Хагатна"));

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