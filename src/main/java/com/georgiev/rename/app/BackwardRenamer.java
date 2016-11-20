package com.georgiev.rename.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackwardRenamer {

	private String startName;
	private int numberFiles;

	public BackwardRenamer(String startName, int numberFiles) {
		this.startName = startName;
		this.numberFiles = numberFiles;
	}

	public Map<String, String> getNewFileNames(List<String> names) {
		Map<String, String> newFileNames = new HashMap<String, String>();

		numberFiles = names.size();
		for (String fileName : names) {
			newFileNames.put(fileName, getNewFileName(fileName));
		}
		return newFileNames;
	}

	private String getNewFileName(String fileName) {
		return startName + String.format("%03d", getNewIndex(fileName)) + "."
				+ StringUtils.getFileNameExtension(fileName);
	}

	private int getNewIndex(String fileName) {
		return 2 * (numberFiles - StringUtils.extractLastNumberFromString(fileName) + 1);
	}
}
