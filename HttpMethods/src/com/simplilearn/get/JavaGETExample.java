package com.simplilearn.get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;



public class JavaGETExample {

	public static void main(String[] args) throws IOException {
		
		JavaGETExample obj = new JavaGETExample();
		obj.getRequest();

	}
	
	
	public void getRequest() throws IOException {
		
		String url = "https://www.google.com/";	
		
		URL urlForGetRequest = new URL(url);
		
		String read = null;
		
		HttpURLConnection connection = (HttpURLConnection)urlForGetRequest.openConnection();
		
		connection.setRequestMethod("GET");
		
		connection.setRequestProperty("userId", "abcde");
		
		int responseCode = connection.getResponseCode();
		
		if(responseCode == HttpURLConnection.HTTP_OK)
		{
			InputStreamReader isrObj = new InputStreamReader(connection.getInputStream());
			
			BufferedReader bf = new BufferedReader(isrObj);
			
			StringBuffer responseStr = new StringBuffer();
			
			while((read = bf.readLine()) != null) {
				responseStr.append(read);
				
			}
			
			bf.close();
			connection.disconnect();
			
			System.out.println("HTML String Result is:\n" + responseStr);
			
		}
		else {
			System.out.println("GET Request didn't work");
		}
		
		
	}

}
