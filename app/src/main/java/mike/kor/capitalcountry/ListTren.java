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




    public void goToPrompt (View v){
        Intent intent = new Intent(this, Prompt.class);
        startActivity(intent);
    }
    public void goToTren20 (View v){
        Intent intent = new Intent(this, Tren_20.class);
        startActivity(intent);
    }
    public void goToTren50 (View v){
        Intent intent = new Intent(this, Tren_50.class);
        startActivity(intent);
    }
    public void goToTren100 (View v){
        Intent intent = new Intent(this, Tren_100.class);
        startActivity(intent);
    }
    public void goToTrenOON (View v){
        Intent intent = new Intent(this, Tren_OON.class);
        startActivity(intent);
    }
    public void goToTrenAll (View v){
        Intent intent = new Intent(this, Tren_All.class);
        startActivity(intent);
    }
    public void goToMain (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void goToBaseKnowledge(View v){
        Intent intent = new Intent(this, BaseKnowledge.class);
        startActivity(intent);
    }
}