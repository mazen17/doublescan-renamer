package com.georgiev.rename.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForwardRenamer {

	private String newFileName;

	public ForwardRenamer(String newFileName) {
		this.newFileName = newFileName;
	}

	public Map<String, String> getNewFileNames(List<String> names) {
		Map<String, String> newFileNames = new HashMap<String, String>();
		for (String fileName : names) {
			newFileNames.put(fileName, getNewFileName(fileName));
		}
		return newFileNames;
	}

	private String getNewFileName(String fileName) {
		return newFileName + String.format("%03d", getNewIndex(fileName)) + "."
				+ StringUtils.getFileNameExtension(fileName);
	}

	private int getNewIndex(String fileName) {
		return 2 * StringUtils.extractLastNumberFromString(fileName) - 1;
	}
}
