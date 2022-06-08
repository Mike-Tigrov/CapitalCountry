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


public class CountryLetterS extends AppCompatActivity {
    //1. Создаём объект на основе класса RecyclerView c названием countryRecycler
    RecyclerView countryRecycler;
    //2 (после всего что было сделано ниже) Создаём новый объект
    ACountryAdapter aCountryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_letter_s);
        //Создаём список List<> из различных категорий
        //Каждый элемент - на основе класса ACountry, это в <>
        //Название списка - ACountryList
        //Выделяем память, прописываем после "=" - "new ArrayList"
        List<ACountry> ACountryList = new ArrayList<>();
        //Обращаемся к ACountryList
        //Обращаемся к методу add
        //И добавляем новые элементы на основе класса ACountry
        //В скобках указываем № элемента (идентификатор) и название

        ACountryList.add(new ACountry(1, "1. Сальвадор - Сан-Сальвадор"));
        ACountryList.add(new ACountry(2, "2. Восточное Самоа (невключённая неорганизованная территория США) - Паго-Паго"));
        ACountryList.add(new ACountry(3, "3. Западное Самоа - Апиа"));
        ACountryList.add(new ACountry(4, "4. Сан-Марино - Сан-Марино"));
        ACountryList.add(new ACountry(5, "5. Сан-Томе и Принсипи - Сан-Томе"));
        ACountryList.add(new ACountry(6, "6. Саудовская Аравия - Эр-Рияд"));
        ACountryList.add(new ACountry(7, "7. Северные Марианские Острова (территория под управлением США) - Сайпан"));
        ACountryList.add(new ACountry(8, "8. Сейшельские острова - Виктория"));
        ACountryList.add(new ACountry(9, "9. Сенегал - Дакар"));
        ACountryList.add(new ACountry(10, "10. Сен-Пьер и Микелон (зависимая территория Франции) - Сен-Пьер"));
        ACountryList.add(new ACountry(11, "11. Сент-Винсент и Гренадины - Кингстаун"));
        ACountryList.add(new ACountry(12, "12. Сент-Кристофер (Сент-Китс) и Невис (Британское Содружество) - Бастер"));
        ACountryList.add(new ACountry(13, "13. Сент-Люсия - Кастри"));
        ACountryList.add(new ACountry(14, "14. Сербия - Белград"));
        ACountryList.add(new ACountry(15, "15. Сингапур - Сингапур"));
        ACountryList.add(new ACountry(16, "16. Сирия - Дамаск"));
        ACountryList.add(new ACountry(17, "17. Словакия - Братислава"));
        ACountryList.add(new ACountry(18, "18. Словения - Любляна"));
        ACountryList.add(new ACountry(19, "19. Соединённые Штаты Америки - Вашингтон"));
        ACountryList.add(new ACountry(20, "20. Соломоновы острова - Хониаpа"));
        ACountryList.add(new ACountry(21, "21. Сомали - Могадишо"));
        ACountryList.add(new ACountry(22, "22. Сомалиленд (частично признана) - Харгейса"));
        ACountryList.add(new ACountry(23, "23. Судан - Хаpтум"));
        ACountryList.add(new ACountry(24, "24. Суринам - Паpамаpибо"));
        ACountryList.add(new ACountry(25, "25. Сьерра-Леоне - Фpитаун"));

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