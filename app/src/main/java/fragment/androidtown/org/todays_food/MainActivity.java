package fragment.androidtown.org.todays_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeMessage = (TextView)findViewById(R.id.welcomMessage);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String message = "환영합니다, " + userID + "님!";

        welcomeMessage.setText(message);

    }
}
