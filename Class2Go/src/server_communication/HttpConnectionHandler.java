package server_communication;

//import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import class2go.User;
import class2go.curriculum.Assignment;
import class2go.curriculum.Question;
import class2go.curriculum.Unit;

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
	
	public Object sendPost(String urlParameters, String type) {
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr;
		try {
			wr = new DataOutputStream(con.getOutputStream());
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
			case "Report":
				return collectReportResult();
			case "Unit":
				return collectUnitResult();
			case "Assignment":
				return collectAssignmentResult();
			case "Question":
				return collectQuestionResult();
			case "Remove":
				return null;
			default:
				System.out.println("invalid request type");
				return null;
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	private Assignment collectReportResult() throws IOException{
		/*
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
		    System.out.println(inputLine);
		in.close();
		*/
		Assignment assignment = null;
		if (con.getInputStream().available() > 0){
			ObjectMapper mapper = new ObjectMapper();
			try
			{
				assignment =  mapper.readValue(con.getInputStream(), Assignment.class);
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
			System.out.println("assignment not graded");
		}
		con.disconnect();
		return assignment;
	}

	private User collectLoginResult() throws IOException{
		/*
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
		    System.out.println(inputLine);
		in.close();
		*/
		User user = null;
		if (con.getInputStream().available() > 0){
			ObjectMapper mapper = new ObjectMapper();
			try
			{
				user =  mapper.readValue(con.getInputStream(), User.class);
			} catch (JsonGenerationException e)
			{	
				System.out.println(e.getMessage());
				//e.printStackTrace();
			} catch (JsonMappingException e)
			{
				System.out.println(e.getMessage());
				//e.printStackTrace();
			} catch (IOException e)
			{
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
		} else {
			System.out.println("invalid login");
		}
		con.disconnect();
		return user;
	}
	
	private Assignment collectAssignmentResult() throws IOException{
		/*
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
		    System.out.println(inputLine);
		in.close();
		*/
		Assignment assignment = null;
		if (con.getInputStream().available() > 0){
			ObjectMapper mapper = new ObjectMapper();
			try
			{
				System.out.println("trying to get assigment object");
				assignment =  mapper.readValue(con.getInputStream(), Assignment.class);
				System.out.println("have assignment object");
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
			System.out.println("no assignment sent");
		}
		con.disconnect();
		return assignment;
	}
	
	private Unit collectUnitResult() throws IOException{
		/*
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
		    System.out.println(inputLine);
		in.close();
		*/
		Unit unit = null;
		if (con.getInputStream().available() > 0){
			ObjectMapper mapper = new ObjectMapper();
			try
			{
				unit =  mapper.readValue(con.getInputStream(), Unit.class);
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
			System.out.println("no unit sent");
		}
		con.disconnect();
		return unit;
	}
	
	private Question collectQuestionResult() throws IOException{
		/*
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
		    System.out.println(inputLine);
		in.close();
		*/
		Question question = null;
		if (con.getInputStream().available() > 0){
			ObjectMapper mapper = new ObjectMapper();
			try
			{
				question =  mapper.readValue(con.getInputStream(), Question.class);
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
			System.out.println("no unit sent");
		}
		con.disconnect();
		return question;
	}
}
