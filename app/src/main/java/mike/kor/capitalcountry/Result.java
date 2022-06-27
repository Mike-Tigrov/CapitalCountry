package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_result);
    }
    public void countryState(View v){
        Intent intent = new Intent(this, SpisokStran.class);
        startActivity(intent);
    }
    public void prompt (View v){
        Intent intent = new Intent(this, Prompt.class);
        startActivity(intent);
    }
    public void goToMain (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}