package server_communication;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import class2go.User;

public class HttpConnectionHandler {
	
	private HttpURLConnection con;
	private String url;
	
	public HttpConnectionHandler() throws IOException{
		url = "http://server-class2go.rhcloud.com/HttpRequestHandler";
		URL obj = new URL(url);
		con = (HttpURLConnection) obj.openConnection();
 
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	}
	
	public Object sendPost(String urlParameters, String type) throws IOException{
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("Sending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		
		// Collect Result
		switch(type){
		case "Login":
			return collectLoginResult();
		default:
			System.out.println("invalid request type");
			return null;
		}
	}

	private User collectLoginResult() throws IOException{
		User user = null;
		if (con.getInputStream().available() > 0){
			ObjectMapper mapper = new ObjectMapper();
			try
			{
				user =  mapper.readValue(con.getInputStream(), User.class);
			} catch (JsonGenerationException e)
			{
				e.printStackTrace();
			} catch (JsonMappingException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("invalid login");
		}
		return user;
	}
}
