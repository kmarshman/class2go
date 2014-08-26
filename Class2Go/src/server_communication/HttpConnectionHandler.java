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
		
		/*
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(new ShortAnswerQuestion("-5 - (-9)", "Complete the Subtraction Problem", "4", 5));
		questions.add(new TrueFalseQuestion("-5 + (-9)", "Complete the Subtraction Problem", "-14", 5));
		questions.add(new TrueFalseQuestion("-5 - 9", "Complete the Subtraction Problem", "-14", 5));
		questions.add(new ShortAnswerQuestion("-5 + 9", "Complete the Subtraction Problem", "4", 5));
		questions.add(new ShortAnswerQuestion("5 - (-9)", "Complete the Subtraction Problem", "14", 5));
		
		MultipleChoiceQuestion mc = new MultipleChoiceQuestion("-13 + 12", "Complete the Addition Problem", "-1", 5);
		mc.addOption("15");
		mc.addOption("-15");
		mc.addOption("1");
		mc.addOption("-1");
		mc.addOption("-2");
		questions.add(mc);
		
		
		ArrayList<Question> questions2 = new ArrayList<Question>();
		questions2.add(new ShortAnswerQuestion("-5 - (-9)", "Complete the Multiplication Problem", "4", 5));
		questions2.add(new ShortAnswerQuestion("-5 + (-9)", "Complete the Multiplication Problem", "-14", 5));
		questions2.add(new ShortAnswerQuestion("-5 - 9", "Complete the Multiplication Problem", "-14", 5));
		questions2.add(new ShortAnswerQuestion("-5 + 9", "Complete the Multiplication Problem", "4", 5));
		questions2.add(new ShortAnswerQuestion("5 - (-9)", "Complete the Multiplication Problem", "14", 5));
		
		ArrayList<Question> questions3 = new ArrayList<Question>();
		questions3.add(new ShortAnswerQuestion("|-9|", "Find the Absolute Value", "4", 5));
		questions3.add(new ShortAnswerQuestion("|0|", "Find the Absolute Value", "-14", 5));
		questions3.add(new ShortAnswerQuestion("|3|", "Find the Absolute Value", "-14", 5));
		questions3.add(new ShortAnswerQuestion("|-(-98)|", "Find the Absolute Value", "4", 5));
		questions3.add(new ShortAnswerQuestion("|21|", "Find the Absolute Value", "14", 5));
		
		ArrayList<Question> questions4 = new ArrayList<Question>();
		questions4.add(new ShortAnswerQuestion("-5 - (-9)", "Complete the Addition Problem", "4", 5));
		questions4.add(new ShortAnswerQuestion("-5 + (-9)", "Complete the Addition Problem", "-14", 5));
		questions4.add(new ShortAnswerQuestion("-5 - 9", "Complete the Addition Problem", "-14", 5));
		questions4.add(new ShortAnswerQuestion("-5 + 9", "Complete the Addition Problem", "4", 5));
		questions4.add(new ShortAnswerQuestion("5 - (-9)", "Complete the Addition Problem", "14", 5));
		
		ArrayList<Assignment> assignments = new ArrayList<Assignment>();
		assignments.add(new Assignment(23, "Subtracting Negative Numbers", questions, new GregorianCalendar(2014, 8, 29)));
		assignments.add(new Assignment(231, "Mulitplying and Dividing Negative Numbers", questions2, new GregorianCalendar(2014, 8, 31)));
		assignments.add(new Assignment(234, "Absolute Values", questions3, new GregorianCalendar(2014, 8, 27)));
		assignments.add(new Assignment(237, "Adding Negative Numbers", questions4, new GregorianCalendar(2014, 8, 21)));
		
		
		Schedule schedule = new Schedule(assignments);
		
		
		InstructorCurriculum curriculum = new InstructorCurriculum("Algebra 1");
		curriculum.addUnit(new Unit("Arithmetic with Negative Numbers", 1));
		curriculum.addUnit(new Unit("Tranforming Equations", 2));
		curriculum.addUnit(new Unit("Polynomials", 3));
		
		User student = new User("Michael", "Giusti", new Student());
		Course c1 = new Course("Algebra", curriculum);
		c1.setSchedule(schedule);
		Course c2 = new Course("Ceramics", curriculum);
		c2.setSchedule(schedule);
		Course c3 = new Course("Western Civilization", curriculum);
		c3.setSchedule(schedule);
		student.addCourse(c1);
		student.addCourse(c2);
		student.addCourse(c3);
		
		return student;
		*/
		
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
