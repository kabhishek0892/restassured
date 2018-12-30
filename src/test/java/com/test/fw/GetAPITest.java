package com.test.fw;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.client.RestClient;
import com.test.util.JsonValidator;

public class GetAPITest extends BaseTest {

	BaseTest bt;
	String a,b,finalURL;
	RestClient rc;
	CloseableHttpResponse chr;

	@BeforeMethod
	public void SetUp() throws ClientProtocolException, IOException
	{
		bt= new BaseTest();

		//URL generation	
		a= prop.getProperty("url");
		b=prop.getProperty("testUrl");
		finalURL=a+b;



	}

	@Test
	public void Test1() throws ClientProtocolException, IOException
	{
		rc  = new RestClient();
		chr=	rc.get(finalURL); 

		//Get Status code		
		int statusCode =chr.getStatusLine().getStatusCode();
		System.out.println("Status code is -->"+statusCode);
		Assert.assertEquals(statusCode,RESPONSE_CODE_200,"Staus code is 200");

		//Get Response		
		String responsejson=EntityUtils.toString(chr.getEntity(),"UTF-8");
		JSONObject jo = new JSONObject(responsejson);
		System.out.println("Json response is -->"+jo);

		//Add Assertion Object
		String page=JsonValidator.getValueByJPath(jo,"/page");
		System.out.println("Page value is--> "+page);
		Assert.assertEquals(Integer.parseInt(page),2);
		
		//Add assertion on Array
		String id=JsonValidator.getValueByJPath(jo,"/data[2]/id");
		System.out.println("data ID is -->"+id);
		Assert.assertEquals(Integer.parseInt(id),6);

		// All Headers	
		Header[] header=chr.getAllHeaders();
		HashMap<String,String> headers=new HashMap<String,String>();
		for(Header hd:header)
		{
			headers.put(hd.getName(), hd.getValue()); 
		}
		System.out.println("Headers are -->"+header);

	} 
}

