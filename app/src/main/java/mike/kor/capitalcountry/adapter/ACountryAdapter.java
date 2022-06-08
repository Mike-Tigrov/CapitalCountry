package mike.kor.capitalcountry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mike.kor.capitalcountry.R;
import mike.kor.capitalcountry.model.ACountry;

public class ACountryAdapter extends RecyclerView.Adapter<ACountryAdapter.ACountryViewHolder> {

    // Каждый элемент - объект на основе нашей модели - ACountry
    Context context;
    //И этот объект мы назовём countries
    List<ACountry> countries;

//Генерируем конструктор на основании 2х полей выше (Контекст и Лист)
    public ACountryAdapter(Context context, List<ACountry> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public ACountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Создаём объект на основе класса View
        //Назовём объект countryItems =
        //И указываем, какой конкретно дизайн мы используем для отображения всех наших категорий - обращаемся к классу = LayoutInflater
        //Обращаемся к методу from()
        //В методе from указываем context, он сюда будет передаваться
        //Далее обращаемся к методу inflate()
        //В методе inflate() в качестве первого параметра указываем R.layout.country_a,...
        //... где country_a - тот файл в папке layout, который мы создавали для дизайна
        //Второй параметр - parent - класс-родитель/родительский объект
        //Третий параметр - false - что говорит, что мы НЕ прикрепляем весь дизайн к нашему родительскому объекту
        View countryItems = LayoutInflater.from(context).inflate(R.layout.country_a, parent, false);

        //Возвращаем объект, на основе класса ACountryViewHolder, перед классом пишем new
        //Передаём в этот объект countryItems, он из строчки выше
        return new ACountryViewHolder(countryItems);

        //То есть для всех наших элементов мы будем использовать дизайн layout.country_a
    }

    @Override
    public void onBindViewHolder(@NonNull ACountryViewHolder holder, int position) {
//Тут мы пишем, что конкретно в каждое поле будем подставлять
        //Для этого мы обращаемся к передаваемому параметру holder
        //Обращаемся к нужному нам полю countryTitleA
        //И устанавливаем в неё текстовую надпись setText()
        //Вписываем в setText() - countries
        //Добавляем к countries метод (обращаемся к методу)
        //И в качестве индекса будет параметр position (он в строке выше), это номер записи
        //Затем вызываем метод getTitle - получающий текст, мы создавали его в классе ACountry.java
        //этот метод возвращает нам текстовую надпись (страна-столица)
        holder.countryTitleA.setText(countries.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        //Мы должны возвращать количество элементов, которые будут выведены в списке countries
        return countries.size();
    }

    public static class ACountryViewHolder extends RecyclerView.ViewHolder{

        //Создаём объекты, с которыми будем взаимодействовать
        //Назовём этот объект countryTitleA, название точно такое же, как в country_a.xml в объекте TextView

        TextView countryTitleA;

        public ACountryViewHolder(@NonNull View itemView) {
            super(itemView);
            //В этом конструкторе мы указываем значение нашего поля countryTitleA
            //Обращаемся к параметру itemView - это каждый наш конкретный элемент, который будет выведен в нашем списке
            //Обращаемся к каждому конкретному элементу findViewById()
            //В этом конкретном элементе мы ищем объект по id как countryTitleA
            countryTitleA = itemView.findViewById(R.id.countryTitleA);

            //То есть в этом классе мы прописали с какими полями мы будем взаимодействовать
            //В данном случае мы взаимодействуем с одной текстовой надписью
        }
    }
}
