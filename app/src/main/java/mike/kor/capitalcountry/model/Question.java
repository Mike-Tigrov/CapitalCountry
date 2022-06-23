package mike.kor.capitalcountry.model;

public class Question {

    //Текст вопроса, будет хранить идентификатор строкового ресурса с текстом вопроса
    private int mTextResId;

    //Правильный ответ, хранит идентификатор строкового ресурса с текстом правильного ответа
    private int mAnswerTrue;

    public Question(int textResId, int answerTrue){
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public int getAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(int answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
