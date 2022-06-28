package mike.kor.capitalcountry.model;

public class Country {

    //Текст вопроса, будет хранить идентификатор строкового ресурса с текстом вопроса
    private int mCountryResId;


    public Country(int countryResId){
        mCountryResId = countryResId;

    }

    public int getCountryResId() {
        return mCountryResId;
    }

    public void setCountryResId(int countryResId) {
        mCountryResId = countryResId;
    }
}
