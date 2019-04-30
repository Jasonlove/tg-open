package com.jinkuangkj.open.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLUtil {
	
	public static String getParamByUrl(String url, String name) {
	    url += "&";
	    String pattern = "(\\?|&){1}#{0,1}" + name + "=[a-zA-Z0-9]*(&{1})";

	    Pattern r = Pattern.compile(pattern);

	    Matcher m = r.matcher(url);
	    if (m.find( )) {
	        return m.group(0).split("=")[1].replace("&", "");
	    } else {
	        return null;
	    }
	}

}
