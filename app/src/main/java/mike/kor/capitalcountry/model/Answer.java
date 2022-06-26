package mike.kor.capitalcountry.model;

public class Answer  {

    //Текст, который будет хранить название столицы
    private int mCapitalResId;
//Создаём конструктор, принимающий цифру (точно) и отдающий текст (вероятно) по цифре-номеру позиции
    public Answer(int capitalResId) {
        mCapitalResId = capitalResId;
    }

    public int getCapitalResId() {
        return mCapitalResId;
    }

    public void setCapitalResId(int capitalResId) {
        mCapitalResId = capitalResId;
    }
}
