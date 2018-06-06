package fragment.androidtown.org.todays_food;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by byunsangjin on 2018. 6. 6..
 */

public class RegisterRequest extends StringRequest{
    final static private String URL = "http://sjbyun93.cafe24.com/Register.php";
    private Map<String, String> parmeters;

    public RegisterRequest(String userID, String userPassword, String userName, int userAge, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);
        parmeters = new HashMap<>();
        parmeters.put("userID", userID);
        parmeters.put("userPassword", userPassword);
        parmeters.put("userName", userName);
        parmeters.put("userAge", userAge + "");
    }

    @Override
    public Map<String, String> getParams(){
        return parmeters;
    }
}
