package main;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FileSearchUtil {

	private List<String> paths = new ArrayList<String>();

	public String[] findAllFiles(String path) throws FileSearchException {
		File[] listFiles = new File(path).listFiles();

		if (listFiles != null) {

			for (int i = 0; i < listFiles.length; i++) {
				paths.add(listFiles[i].getAbsolutePath());
				if (listFiles[i].isDirectory()) {
					findAllFiles(listFiles[i].getAbsolutePath());
				}
			}
		}
		String[] filePaths = paths.toArray(new String[paths.size()]);
		return filePaths;

	}

	public String[] findAllDirectories(String path) throws FileSearchException  {
		List<String> directoryList = new ArrayList<String>();

		for (String string : findAllFiles(path)) {
			File file = new File(string);
			if (file.isDirectory()) {
				directoryList.add(string);
			}
		}

		String[] directoryPaths = directoryList.toArray(new String[directoryList.size()]);
		return directoryPaths;

	}

	public String[] findFilesByPattern(String path, String pattern) throws FileSearchException {
		List<String> PatternList = new ArrayList<String>();

		for (String string : findAllFiles(path)) {
			File file = new File(string);
			if (!file.isDirectory()) {
				if (string.matches(pattern)) {
					PatternList.add(string);
				}
			}
		}

		String[] filePaths = PatternList.toArray(new String[] {});

		return filePaths;

	}

	public String[] findFilesByLastChange(String path, Date date) throws FileSearchException {
		List<String> lastChangeList = new ArrayList<String>();

		for (String string : findAllFiles(path)) {
			File file = new File(string);

			if (new Date(file.lastModified()).before(date)) {
				lastChangeList.add(string);
			}
		}

		String[] filePaths = lastChangeList.toArray(new String[lastChangeList.size()]);

		return filePaths;

	}
}
