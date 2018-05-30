package xu.sheng.jiang.test;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePdf {

	public static void main(String[] args) {

		try {
			createPDfByItext5();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createPDfByItext5() throws Exception {

		String outFile = "E:/creatFile/1.pdf";
		String FONT = "WebContent/WEB-INF/fontResources/SIMFANG.TTF";
		Font font = new Font(BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED),
				10);

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(outFile));
		document.open();

		PdfPTable table = new PdfPTable(3);
		document.addLanguage("en-us");

		PdfPCell cell1 = new PdfPCell();
		cell1.setRowspan(2);
		cell1.addElement(new Paragraph("1-1"));
		table.addCell(cell1);
		table.addCell(new PdfPCell(new Paragraph("1-2")));
		table.addCell(new PdfPCell(new Paragraph("1-3")));
		table.addCell(new PdfPCell(new Paragraph("1-4")));
		table.addCell(new PdfPCell(new Paragraph("1-5")));

		document.add(table);
		document.close();
	}

}
