package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	//Get method
	
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse chr= httpclient.execute(httpget);//hit the api ,it will give Response obeject
		return chr;
		/*//Get Status code		
		int statusCode =chr.getStatusLine().getStatusCode();
		System.out.println("Status code is -->"+statusCode);
		

		//Get Response		
		String response=EntityUtils.toString(chr.getEntity(),"UTF-8");
		JSONObject jo = new JSONObject(response);
		System.out.println("Json response is -->"+jo);

		//All Headers	
		Header[] header=chr.getAllHeaders();
		HashMap<String,String> headers=new HashMap<String,String>();
		for(Header hd:header)
	
		{
			headers.put(hd.getName(), hd.getValue()); 
		}
	
		System.out.println("Headers are-->"+header);
	*/	
	} 
}
