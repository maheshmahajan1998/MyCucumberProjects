package read;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadLogin {

	static JSONObject obj;

	String uname;
	String pass;

	public ReadLogin() {
		readLoginData();
	}

	public void readLoginData() {
		JSONParser jp=new JSONParser();
		
		try {
			obj=(JSONObject) jp.parse(new FileReader("JSON//login.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUserName()
	{
		uname=(String) obj.get("username");
		return uname;
		
	}
	public String getPassword()
	{
		pass=(String) obj.get("password");
		return pass;
		
	}

}
