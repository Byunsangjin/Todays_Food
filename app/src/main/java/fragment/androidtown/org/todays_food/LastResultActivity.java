package fragment.androidtown.org.todays_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

public class LastResultActivity extends AppCompatActivity {
    ImageView lastResultImage;
    int[] images = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4, R.drawable.food5, R.drawable.food6, R.drawable.food7, R.drawable.food8 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_result);

        Intent intent = getIntent();
        int imageNum = intent.getIntExtra("lastResult", -1 );

        lastResultImage = (ImageView)findViewById(R.id.lastResultImage);
        if(imageNum==-1)
            Toast.makeText(getApplicationContext(), "선택 한 음식이 아무것도 없습니다", Toast.LENGTH_LONG).show();
        else
            lastResultImage.setImageResource(images[imageNum]);

    }
}
