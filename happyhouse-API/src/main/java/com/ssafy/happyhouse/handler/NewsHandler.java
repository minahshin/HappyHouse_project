package com.ssafy.happyhouse.handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.happyhouse.model.news.Items;
import com.ssafy.happyhouse.model.news.NewsObject;

public class NewsHandler {
	public List<Items> getNewsItems(String keyword) throws JsonMappingException, JsonProcessingException {
		String response = getNews(keyword);
		
		ObjectMapper objectMapper = new ObjectMapper();
		NewsObject res = objectMapper.readValue(response, NewsObject.class);
		
		for(int i=0;i<res.getItems().size();i++) {
			res.getItems().get(i).setTitle(res.getItems().get(i).getTitle().replace("<b>", " ").replace("</b>", "").replace("&quot;", "\""));
		}
		
		return res.getItems();
	}
	
	private String getNews(String keyword) {
		URL url;
		String result="";		

		try {
			String encoded = URLEncoder.encode(keyword, "UTF-8");
			
			url = new URL("https://openapi.naver.com/v1/search/news.json?query=" + encoded + "&display=100&start=1&sort=sim" );
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
	        conn.setDoInput(true);
			
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("X-Naver-Client-Id", "wvCM8QlIojzW9SB41DLZ");
			conn.setRequestProperty("X-Naver-Client-Secret", "a0m7UzeIBa");
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	        
	        String inputLine="";
	        
	        while( (inputLine = br.readLine()) != null){
	    		result += inputLine.trim();
	    		
	    	}
	        
	        br.close();
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
