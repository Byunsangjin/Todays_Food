package fragment.androidtown.org.todays_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");
        final int result = intent.getIntExtra("result", -1);
        final int lastResult = intent.getIntExtra("lastResult", -1);

        ImageButton lastResultButton = (ImageButton)findViewById(R.id.lastResultButton);
        ImageButton startButton = (ImageButton)findViewById(R.id.startButton);

        lastResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LastResultActivity.class);
                intent.putExtra("userID", userID);
                intent.putExtra("lastResult", lastResult);
                MainActivity.this.startActivity(intent);
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodWorldCupActivity.class);
                intent.putExtra("userID", userID);
                intent.putExtra("lastResult", result);
                MainActivity.this.startActivity(intent);
            }
        });

    }
}
