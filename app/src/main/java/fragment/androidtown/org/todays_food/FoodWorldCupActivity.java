package fragment.androidtown.org.todays_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class FoodWorldCupActivity extends AppCompatActivity {

    int[] images = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4, R.drawable.food5, R.drawable.food6, R.drawable.food7, R.drawable.food8 };
    int[] imageNum = {0,1,2,3,4,5,6,7};
    ImageView imageView1;
    ImageView imageView2;
    int imageCount = 8;
    int tempCount = 8;
    int image1Num, image2Num, temp;
    String userID;
    int result, lastResult;
    Random rand = new Random();
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_world_cup);

        final Intent getIntent = getIntent();
        userID = getIntent.getStringExtra("userID");
        lastResult = getIntent.getIntExtra("lastResult", -1 );

        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        titleText = (TextView)findViewById(R.id.titleText);

        setImages(); // 첫화면 뿌려주기

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempCount--;

                if(tempCount==1) {
                    result = image1Num;
                    if(lastResult == -1)
                        lastResult = result;
                    dbUpdate();
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
                    setImages(); // 음식 image 바꾸기
                }

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempCount--;

                if(tempCount==1) {
                    result = image2Num;
                    if(lastResult == -1)
                        lastResult = result;
                    dbUpdate();
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
                    setImages();
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
    public void setImage1(int resId){
        imageView1.setImageResource(images[resId]);
    }
    public void setImage2(int resId){
        imageView2.setImageResource(images[resId]);
    }

    // 각 토너먼트가 끝날때 image값 초기화
    public void init(){
        for(int i=0;i<8;i++){
            if(imageNum[i] > 0)
                imageNum[i] -= 100;
        }
    }

    // 타이틀 변경
    public void changeTitle(){
        if(tempCount==2)
            titleText.setText("결승");
        else
            titleText.setText(tempCount+"강");
    }

    // JsonObject를 이용하여 선택 결과 db 저장
    public void dbUpdate(){
        Response.Listener<String> responseLister = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        Intent intent = new Intent(FoodWorldCupActivity.this, ResultActivity.class);
                        intent.putExtra("userID", userID);
                        intent.putExtra("result", result);
                        intent.putExtra("lastResult", result);
                        FoodWorldCupActivity.this.startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplication(), "error", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (JSONException e){
                    e.printStackTrace();
                }

            }
        };
        FoodWorldCupRequest foodWorldCupRequest = new FoodWorldCupRequest(userID, result, result, responseLister);
        RequestQueue queue = Volley.newRequestQueue(FoodWorldCupActivity.this);
        queue.add(foodWorldCupRequest);
    }

    // 음식 image 랜덤으로 바꾸기
    public void setImages(){
        setImage1Num();
        setImage2Num();
        setImage1(image1Num);
        setImage2(image2Num);
    }

}
