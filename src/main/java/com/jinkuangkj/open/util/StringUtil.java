package com.jinkuangkj.open.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	/**
	 * 过滤下表情
	 * @param str
	 * @return
	 */
	public static String filter(String str) {
	    if (str.trim().isEmpty()) {
	        return str;
	    }
	    String pattern = "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";
	    String reStr = "";
	    Pattern emoji = Pattern.compile(pattern);
	    Matcher emojiMatcher = emoji.matcher(str);
	    str = emojiMatcher.replaceAll(reStr);
	    return str;
	}

}
