package server_communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionHandler {
	
	private URL url;
	private URLConnection connection;
	private OutputStreamWriter out;
	private BufferedReader in;
	
	public URLConnectionHandler(){
		try {
			url = new URL("http://server-class2go.rhcloud.com/");
			connection = url.openConnection();
			connection.setDoInput (true);
			connection.setDoOutput (true);
			connection.setUseCaches(false);
			out = new OutputStreamWriter(connection.getOutputStream());
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String writeRequest(String request){
		try {
			out.write(request);
			String buffer;
			String result = "";
			while((buffer = in.readLine()) != null) result += buffer;
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void close(){
		try {
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
