package com.test.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonValidator {

	public static JSONObject response;
//Logic to validate JSON response
	
	public static String getValueByJPath(JSONObject response,String jpath)
	{
		Object obj = response;
		for (String s:jpath.split("/"))
			if(!s.isEmpty())
			if(!(s.contains("[")|| s.contains("]")))
				
			obj=((JSONObject)obj).get(s);
			else if (s.contains("[") ||s.contains("]"))
					obj=((JSONArray)((JSONObject)obj).get(s.split("\\[")[0])).
					get(Integer.parseInt(s.split("\\[")[1].replace("]","")));
					return obj.toString();
		
	}
}
