package fragment.androidtown.org.todays_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

        Button lastResultButton = (Button)findViewById(R.id.lastResultButton);
        Button startButton = (Button)findViewById(R.id.startButton);

        lastResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LastResultActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodWorldCupActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

    }
}
