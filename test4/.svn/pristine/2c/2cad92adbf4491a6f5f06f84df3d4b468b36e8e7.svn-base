package xu.sheng.jiang.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class Html2Pdf {

	public static void main(String[] args) {

		String outFilePath = "E:/creatFile/transhtml.pdf";
		String inFilePath = System.getProperty("user.dir") + "/WebContent/WEB-INF/html/JLTZ.html";
//		String inFilePath = "E:/creatFile/transhtml.html";
		try {
			htmlToPDF(inFilePath, outFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * html转pdf
	 * 
	 * @param inputPath
	 *            html模板路径
	 * @param outputPath
	 *            pdf输出文件夹
	 * @param outFileName
	 *            pdf文件名称
	 * @throws Exception
	 */
	public static void htmlToPDF(String inputPath, String outputPath) throws Exception {

		/* 创建文件夹 */
		File file_outputPath = new File(outputPath);
		if (!file_outputPath.exists()) {
			file_outputPath.getParentFile().mkdirs();
		}
		new File(outputPath);

		// 打印输出路径
		System.out.println(file_outputPath.getParentFile());

		// 创建一个文档
		Document document = new Document();
		PdfCopy pdfCopy = new PdfCopy(document, new FileOutputStream(outputPath));
		document.open();

		// 读取HTML
		PdfReader pdfReader;
		pdfReader = new PdfReader(parseHtml(inputPath));
		pdfCopy.addDocument(pdfReader);
		pdfReader.close();

		document.close();

		// 打印根目录
		String str = "http://192.168.1.236:8081/rqjlzs/file/scene/66046/fed380fb-697f-412e-9e93-d0277d3415c9.jpg";
		System.out.println(System.getProperty("user.dir") + ":" + str.split("rqjlzs")[1]);
	}

	public static byte[] parseHtml(String html) throws DocumentException, IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, baos);
		document.open();
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(html));
		document.close();
		return baos.toByteArray();
	}

}
