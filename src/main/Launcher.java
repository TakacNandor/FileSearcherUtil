package main;

import java.awt.List;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Launcher {

	public static void main(String[] args) throws FileSearchException {
		File file = new File("C:\\Users\\P3502443\\Documents\\Eshop");
		FileSearchUtil search = new FileSearchUtil();
		String path = file.getAbsolutePath();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date(file.lastModified());
		
		
		/*for (String string : search.findAllDirectories(path)) {
			System.out.println(string);
		}*/
		String[] files = search.findFilesByPattern(path, ".*[.]java");
		
		
		for (String string : files) {
			System.out.println(string);
		}
		//search.findFilesByPattern(file.getAbsolutePath(), ".*[.]java");
		
		

	}

}
