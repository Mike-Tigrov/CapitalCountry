package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class ListTren extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_tren);
    }

    public void goToBaseKnowledge(View v){
        Intent intent = new Intent(this, BaseKnowledge.class);
        startActivity(intent);
    }


    public void goToPrompt (View v){
        Intent intent = new Intent(this, Prompt.class);
        startActivity(intent);
    }



    public void goToMain (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void goToTren1 (View v){
        Intent intent = new Intent(this, Tren1.class);
        startActivity(intent);
    }
    public void goToTren20 (View v){
        Intent intent = new Intent(this, Tren_20.class);
        startActivity(intent);
    }
    public void goResult (View v){
        Intent intent = new Intent(this, Result.class);
        startActivity(intent);
    }
}