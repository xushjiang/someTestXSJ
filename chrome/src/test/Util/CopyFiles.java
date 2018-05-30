package test.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

public class CopyFiles {

	private static void copyImages() throws Exception {

		String orignal_path = "E:/simpleTable2.doc";
		String new_path = "E:/11/simpleTable2.doc";
		File new_file = new File(new_path);
		if (!new_file.exists()) {
			new_file.getParentFile().mkdirs();
		}
		Files.copy(new File(orignal_path).toPath(), new FileOutputStream(new_file));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			copyImages();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
