package test.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class ImageTest {

	public static String image2Base64() throws Exception {

		StringBuffer base64 = new StringBuffer("data:image/png;base64,");
		String imagePath = "E:/creatFile/tu.png";
		FileInputStream imageStream = new FileInputStream(new File(imagePath));
		byte[] imageByte = new byte[imageStream.available()];
		imageStream.read(imageByte);
		imageStream.close();
		BASE64Encoder base64En = new BASE64Encoder();
		base64En.encode(imageByte);
		base64.append(base64En.encode(imageByte));
		return base64.toString();
	}

	public static String Base64ToImage() {

		try {

			String base64 = image2Base64();

			if (!base64.isEmpty()) {
				String base64String = base64.replace("data:image/png;base64,", "");
				BASE64Decoder decoder = new BASE64Decoder();
				// 解码base64
				byte[] byteArray = decoder.decodeBuffer(base64String);
				// 文件名
				String filename = "E:/creatFile/image/image" + ".png";
				// 创建文件夹
				File descFile = new File(filename);
				if (!descFile.exists()) { // 不存在文件夹 自动创建
					descFile.getParentFile().mkdirs();
				}
				OutputStream image = new FileOutputStream(descFile);
				image.write(byteArray);
				image.close();
				return filename;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base64ToImage();
	}

}
