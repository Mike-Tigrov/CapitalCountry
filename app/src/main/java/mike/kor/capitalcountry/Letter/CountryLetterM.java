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


public class CountryLetterM extends AppCompatActivity {
    //1. Создаём объект на основе класса RecyclerView c названием countryRecycler
    RecyclerView countryRecycler;
    //2 (после всего что было сделано ниже) Создаём новый объект
    ACountryAdapter aCountryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_letter_m);
        //Создаём список List<> из различных категорий
        //Каждый элемент - на основе класса ACountry, это в <>
        //Название списка - ACountryList
        //Выделяем память, прописываем после "=" - "new ArrayList"
        List<ACountry> ACountryList = new ArrayList<>();
        //Обращаемся к ACountryList
        //Обращаемся к методу add
        //И добавляем новые элементы на основе класса ACountry
        //В скобках указываем № элемента (идентификатор) и название

        ACountryList.add(new ACountry(1, "1. Маврикий - Порт-Луи"));
        ACountryList.add(new ACountry(2, "2. Мавритания - Нуакшот"));
        ACountryList.add(new ACountry(3, "3. Мадагаскар - Антананариву"));
        ACountryList.add(new ACountry(4, "4. Мадейра (автономный регион Португалии) - Фуншал"));
        ACountryList.add(new ACountry(5, "5. Майотта (заморский регион Франции; в ООН признан, как часть Коморских островов) - Мамудзу"));
        ACountryList.add(new ACountry(6, "6. Северная Македония - Скопье"));
        ACountryList.add(new ACountry(7, "7. Малави - Лилонгве"));
        ACountryList.add(new ACountry(8, "8. Малайзия - Куала-Лумпур"));
        ACountryList.add(new ACountry(9, "9. Мали - Бамако"));
        ACountryList.add(new ACountry(10, "10. Мальдивы - Мале"));
        ACountryList.add(new ACountry(11, "11. Мальта - Валетта"));
        ACountryList.add(new ACountry(12, "12. Марокко - Рабат"));
        ACountryList.add(new ACountry(13, "13. Мартиника (заморский департамент Франции) - Фор-де-Франс"));
        ACountryList.add(new ACountry(14, "14. Маршалловы острова - Маджуро"));
        ACountryList.add(new ACountry(15, "15. Мексика - Мехико"));
        ACountryList.add(new ACountry(16, "16. Мозамбик - Мапуту"));
        ACountryList.add(new ACountry(17, "17. Молдавия - Кишинев"));
        ACountryList.add(new ACountry(18, "18. Монако - Монако"));
        ACountryList.add(new ACountry(19, "19. Монголия - Улан-Батор"));
        ACountryList.add(new ACountry(20, "20. Монтсерра́т (заморская территория Великобритании) - Плимут (заброшен) и Брейдс (фактическая столица)"));
        ACountryList.add(new ACountry(21, "21. Мьянма - Нейпьидо"));

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