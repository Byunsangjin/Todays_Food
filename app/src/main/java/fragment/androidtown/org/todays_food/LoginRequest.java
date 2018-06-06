package fragment.androidtown.org.todays_food;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by byunsangjin on 2018. 6. 6..
 */

public class LoginRequest extends StringRequest{
    final static private String URL = "http://sjbyun93.cafe24.com/Login.php";
    private Map<String, String> parmeters;

    public LoginRequest(String userID, String userPassword, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);
        parmeters = new HashMap<>();
        parmeters.put("userID", userID);
        parmeters.put("userPassword", userPassword);
    }

    @Override
    public Map<String, String> getParams(){
        return parmeters;
    }
}
