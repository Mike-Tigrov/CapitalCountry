package mike.kor.capitalcountry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PrivacyPolicy2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_privacy_policy2);
    }
    public void goToBaseKnowledge(View v){
        Intent intent = new Intent(this, BaseKnowledge.class);
        startActivity(intent);
    }
    public void goToListTren (View v){
        Intent intent = new Intent(this, ListTren.class);
        startActivity(intent);
    }
    public void goToPrivacyPolicy1 (View v){
        Intent intent = new Intent(this, PrivacyPolicy1.class);
        startActivity(intent);
    }
    public void goToPrivacyPolicy (View v){
        Intent intent = new Intent(this, PrivacyPolicy.class);
        startActivity(intent);
    }
}