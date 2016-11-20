package com.georgiev.rename.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static int extractLastNumberFromString(String s) {

		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(s);
		int ind = 0;
		while (m.find()) {
			ind = Integer.valueOf(m.group());
		}
		return ind;
	}

	public static String getFileNameExtension(String fileName) {
		String extension = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}

}
