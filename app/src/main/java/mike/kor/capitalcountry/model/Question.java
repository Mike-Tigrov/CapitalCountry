package mike.kor.capitalcountry.model;

public class Question {

    //Текст вопроса, будет хранить идентификатор строкового ресурса с текстом вопроса
    private int mTextResId;


    public Question(int textResId){
        mTextResId = textResId;

    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }
}
