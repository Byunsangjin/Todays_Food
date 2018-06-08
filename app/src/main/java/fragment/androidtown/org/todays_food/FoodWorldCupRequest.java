package fragment.androidtown.org.todays_food;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by byunsangjin on 2018. 6. 8..
 */

public class FoodWorldCupRequest extends StringRequest{
    final static private String URL = "http://sjbyun93.cafe24.com/Result.php";
    private Map<String, String> parmeters;

    public FoodWorldCupRequest(String userID, int result, int lastResult, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);
        parmeters = new HashMap<>();
        parmeters.put("result", result+"");
        parmeters.put("lastResult", lastResult+"");
        parmeters.put("userID", userID);
    }

    @Override
    public Map<String, String> getParams(){
        return parmeters;
    }
}
