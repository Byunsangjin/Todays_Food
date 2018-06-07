package fragment.androidtown.org.todays_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {
    ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultImage = (ImageView)findViewById(R.id.resultImage);

        Intent intent = getIntent();
        int image = intent.getIntExtra("result", 0);
        resultImage.setImageResource(image);
    }
}
