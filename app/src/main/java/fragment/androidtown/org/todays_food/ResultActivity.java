package fragment.androidtown.org.todays_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {
    ImageView resultImage;
    int[] images = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4, R.drawable.food5, R.drawable.food6, R.drawable.food7, R.drawable.food8 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageButton searchButton = (ImageButton)findViewById(R.id.searchButton);
        resultImage = (ImageView)findViewById(R.id.resultImage);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");
        final int result = intent.getIntExtra("result", -1);

        resultImage.setImageResource(images[result]);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, SearchRestaurantActivity.class);
                intent.putExtra("userID", userID);
                intent.putExtra("result", result);
                ResultActivity.this.startActivity(intent);
            }
        });

    }
}
