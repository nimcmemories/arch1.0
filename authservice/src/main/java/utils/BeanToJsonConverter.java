package utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import com.model.RoleModel;

public class BeanToJsonConverter {
	public static void main(String[] args) {
		RoleModel rm = new RoleModel(1l,"nimesh","its my name");
		
		ObjectMapper objectMapper = new ObjectMapper();
		JSONObject json = new JSONObject(rm);
		System.out.println(" json : " + json);
	}
}
