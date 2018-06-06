package fragment.androidtown.org.todays_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FoodWorldCupActivity extends AppCompatActivity {

    int[] images = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4, R.drawable.food5, R.drawable.food6, R.drawable.food7, R.drawable.food8 };
    int[] imageNum = {0,1,2,3,4,5,6,7};
    ImageView imageView1;
    ImageView imageView2;
    int imageCount = 8;
    int tempCount = 8;
    int winNum;
    int image1Num, image2Num, temp;
    Random rand = new Random();
    Boolean flag = true;
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_world_cup);

        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        titleText = (TextView)findViewById(R.id.titleText);

        setImage1Num();
        setImage2Num();
        setImage1(image1Num);
        setImage2(image2Num);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempCount--;

                if(tempCount==1) {
                    Intent intent = new Intent(FoodWorldCupActivity.this, LoginActivity.class);
                    FoodWorldCupActivity.this.startActivity(intent);
                    Toast.makeText(getApplicationContext(), "선택완료", Toast.LENGTH_SHORT).show();
                }
                else {
                    imageNum[image2Num] = -1;
                    imageNum[image1Num] += 100;
                    if (tempCount == 4) {
                        init();
                        changeTitle();
                    }
                    if (tempCount == 2) {
                        init();
                        changeTitle();
                    }
                    setImage1Num();
                    setImage2Num();
                    setImage1(image1Num);
                    setImage2(image2Num);
                }

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempCount--;

                if(tempCount==1) {
                    Intent intent = new Intent(FoodWorldCupActivity.this, LoginActivity.class);
                    FoodWorldCupActivity.this.startActivity(intent);
                    Toast.makeText(getApplicationContext(), "선택완료", Toast.LENGTH_SHORT).show();
                }
                else {
                    imageNum[image1Num] = -1;
                    imageNum[image2Num] += 100;
                    if (tempCount == 4) {
                        init();
                        changeTitle();
                    }
                    if (tempCount == 2) {
                        init();
                        changeTitle();
                    }
                    setImage1Num();
                    setImage2Num();
                    setImage1(image1Num);
                    setImage2(image2Num);
                }

            }
        });
    }

    public void setImage1Num(){
        while(true) {
            temp = rand.nextInt(imageCount);
            if (imageNum[temp] != -1 && imageNum[temp] < 8) {
                image1Num = temp;
                break;
            }
        }
    }
    public void setImage2Num(){
        while(true) {
            temp = rand.nextInt(imageCount);
            if (temp != image1Num && imageNum[temp] != -1 && imageNum[temp] < 8) {
                image2Num = temp;
                break;
            }
        }
    }

    public void init(){
        for(int i=0;i<8;i++){
            if(imageNum[i] > 0)
                imageNum[i] -= 100;
        }
    }

    public void setImage1(int resId){
        imageView1.setImageResource(images[resId]);
    }
    public void setImage2(int resId){
        imageView2.setImageResource(images[resId]);
    }

    public void changeTitle(){
        if(tempCount==2)
            titleText.setText("결승");
        else
            titleText.setText(tempCount+"강");
    }

}
