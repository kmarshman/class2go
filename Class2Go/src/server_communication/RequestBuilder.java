package server_communication;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class RequestBuilder {
	
	public static String buildPost(String[] variableNames, String[] variableValues){
		if (variableNames.length > 0 && variableValues.length > 0 && variableNames.length == variableValues.length){
			try {
				String post = variableNames[0] + "=" + URLEncoder.encode(variableValues[0], "UTF-8");
				for(int i = 1; i < variableNames.length; i++){
					post += "&" + variableNames[i] + "=" + URLEncoder.encode(variableValues[i], "UTF-8");
				}
				return post;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
