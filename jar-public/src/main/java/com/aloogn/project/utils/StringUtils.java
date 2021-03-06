/**  
 * @Title:  StringUtils.java   
 * @Package com.tansun.util   
 * @Description:  该类为，字符串 常用工具类。   
 * @date:  2018年12月15日    下午3:07:28   
 * @version V1.0 
 */
package com.aloogn.project.utils;

import java.util.*;

public class StringUtils {
	public static  boolean isEmpty(String str){
		if(str == null){
			return true;
		}
		if(str.length() == 0 || str.trim().length() == 0){
			return true;
		}
		return false;	
	}
	public static  boolean notEmpty(String str){
		return !isEmpty(str);
	}
	public static String [] toArray(String strings){
		if(isEmpty(strings)){
			return new String []{};
		}
		return strings.trim().split(",");
	}
	public static Set<String> toSet(String strings){
		String [] values = toArray(strings);
		Set<String> valueSet = new HashSet<>();
		for(String value:values){
			if(isEmpty(value)){
				continue;
			}
			valueSet.add(value.trim());
		}
		return valueSet;
	}

	public static boolean isNullOrBlock(Object string) {
		if (string == null || "".equals(string.toString()))
			return true;
		return false;
	}

	public static boolean isNotNullOrBlock(Object string) {
		return !isNullOrBlock(string);
	}

	public static boolean afterTrimIsNullOrBlock(String string) {
		if (string == null || "".equals(string))
			return true;
		string = string.trim();
		if (string == null || "".equals(string))
			return true;
		return false;
	}

	public static boolean afterTrimIsNotNullOrBlock(String string) {
		return !afterTrimIsNullOrBlock(string);
	}

	public static String fristCharToUpperCase(String string) {
		return (string.charAt(0) + "").toUpperCase() + string.substring(1);
	}

	public static String fristCharToLowerCase(String string) {
		return (string.charAt(0) + "").toLowerCase() + string.substring(1);
	}

	/**
	 * unicode 转换成 utf-8
	 *
	 * @author fanhui 2007-3-15
	 * @param theString
	 * @return
	 */
	public static String unicodeToUtf8(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
							case '0':
							case '1':
							case '2':
							case '3':
							case '4':
							case '5':
							case '6':
							case '7':
							case '8':
							case '9':
								value = (value << 4) + aChar - '0';
								break;
							case 'a':
							case 'b':
							case 'c':
							case 'd':
							case 'e':
							case 'f':
								value = (value << 4) + 10 + aChar - 'a';
								break;
							case 'A':
							case 'B':
							case 'C':
							case 'D':
							case 'E':
							case 'F':
								value = (value << 4) + 10 + aChar - 'A';
								break;
							default:
								throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}

	public static String list2String(List<?> list) {
		if (list == null || list.size() == 0)
			return "";
		StringBuffer stringBuffer = new StringBuffer();
		for (Object object : list) {
			stringBuffer.append(object.toString() + ",");
		}
		String rs = stringBuffer.toString();
		return rs.substring(0, rs.length() - 1);
	}


	/**
	 * 获取数字型随机数字
	 *
	 * @param numLen
	 *            随机码位数
	 * @return
	 * @throws Exception
	 */
	public static String getRandomNum(int numLen) {
		if (numLen <= 0 || numLen >= 100)
			numLen = 6;
		String rs = "";
		for (int i = 0; i < numLen; i++) {
			Random random = new Random();
			int randomInt = random.nextInt() % 10;
			rs += Math.abs(randomInt);
		}
		return rs;
	}

	/**
	 * 处理null对象转string
	 * @param value
	 * @return
	 */
	public static String handleObjectNull(Object value){
		if(value == null){
			return null;
		}
		return value.toString();
	}

	public static void main(String[] args) {
		Integer i = new Integer(2);
		System.out.println(i.toString());
	}

}
