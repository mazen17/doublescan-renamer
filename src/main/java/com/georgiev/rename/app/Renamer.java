package com.georgiev.rename.app;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Renamer {

	private String pathRoot = "C:/scan";
	private String target = "new";
	private String separator = File.separator;
	private String newFileName = "new";

	public List<String> getFilesInDir(String dirName) {
		String fullPath = pathRoot + separator + dirName;
		File dir = new File(fullPath);
		String[] filesInDir = dir.list();
		return new ArrayList<String>(Arrays.asList(filesInDir));

	}

	public void getForwardFileNames(String dirName) {
		List<String> fileNames = getFilesInDir(dirName);
		ForwardRenamer fRenamer = new ForwardRenamer(newFileName);
		Map<String, String> fileNamesMap = fRenamer.getNewFileNames(fileNames);
		renameFiles(fileNamesMap, dirName);
	}

	public void getBackwardFileNames(String dirName) {
		List<String> fileNames = getFilesInDir(dirName);
		BackwardRenamer bRenamer = new BackwardRenamer(newFileName, fileNames.size());
		Map<String, String> fileNamesMap = bRenamer.getNewFileNames(fileNames);
		renameFiles(fileNamesMap, dirName);
	}

	public void renameFiles(Map<String, String> fileNames, String dirName) {

		String targetPath = pathRoot + separator + target;
		String oldPath = pathRoot + separator + dirName;

		for (String oldFileName : fileNames.keySet()) {
			File oldFile = new File(oldPath, oldFileName);
			File newFile = new File(targetPath, fileNames.get(oldFileName));
			try {
				boolean success = oldFile.renameTo(newFile);
				if (!success) {
					System.out.println("File " + oldFileName + " was not successfully renamed");
				}
			} catch (Exception e) {
			}
		}

	}
}
