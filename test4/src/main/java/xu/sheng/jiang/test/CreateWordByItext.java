package xu.sheng.jiang.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Anchor;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.style.RtfParagraphStyle;

public class CreateWordByItext {

	private static String WORD_PATH = "E://simpleTable2.doc";

	// 创建word文档
	public static void createWord() throws Exception {

		File wordFile = new File(WORD_PATH);
		if (!wordFile.exists()) {
			wordFile.createNewFile();
		}

		Document document = new Document(PageSize.A4);
		RtfWriter2.getInstance(document, new FileOutputStream(wordFile));
		document.open();

		Paragraph tableheader = new Paragraph("监理日志");
		tableheader.setAlignment(Element.ALIGN_CENTER);
		RtfParagraphStyle rtfGsBt1 = RtfParagraphStyle.STYLE_HEADING_1;
		rtfGsBt1.setAlignment(Element.ALIGN_CENTER);
		rtfGsBt1.setStyle(Font.BOLD);
		rtfGsBt1.setSize(16);
		tableheader.setFont(rtfGsBt1);
		document.add(tableheader);

		// 创建表格
		Table table = new Table(4);
		int[] cellWiths = { 20, 30, 20, 30 };
		table.setWidths(cellWiths);
		float tableWidth = table.getWidth();
		System.err.println(tableWidth);
		Cell cell1 = new Cell();
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.addElement(new Paragraph("项目名称"));
		table.addCell(cell1);
		Cell cell2 = new Cell();
		cell2.setVerticalAlignment(Element.ALIGN_CENTER);
		cell2.addElement(new Paragraph("国家地理科技产业园"));
		table.addCell(cell2);
		Cell cell3 = new Cell();
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell3.addElement(new Paragraph("日期"));
		table.addCell(cell3);
		Cell cell4 = new Cell();
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.addElement(new Paragraph("2018年2月26日"));
		System.err.println(cell4.getWidth());
		table.addCell(cell4);

		Cell mergeCell = new Cell("合并单 \n 元格");
		mergeCell.setColspan(4);
		table.addCell(mergeCell);

		Cell row3Col1 = new Cell("总监工程师");
		row3Col1.setVerticalAlignment(Element.ALIGN_CENTER);
		row3Col1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(row3Col1);

		// 图片
		Image img = Image.getInstance("E://文件//picture//61434d637f691276d6660daad38ceca3.png");
		img.scaleAbsolute(100, 60);
		Cell row3Col2 = new Cell(img);
		table.addCell(row3Col2);

		document.add(table);
		document.add(new Paragraph("\n"));

		createHyperLink(document, "超链接1", "http://www.baidu.com");
		createHyperLink(document, "超链接1", "http://www.baidu.com");

		List<String> pictureUrl = new ArrayList<>();
		pictureUrl.add("E://文件//picture//61434d637f691276d6660daad38ceca3.png");
		pictureUrl.add("E://文件//picture//61434d637f691276d6660daad38ceca3.png");
		pictureUrl.add("E://文件//picture//61434d637f691276d6660daad38ceca3.png");
		createPicture(document, pictureUrl);

		document.close();
	}

	// 图片
	private static void createPicture(Document document, List<String> pictureUrl) throws Exception {

		if (pictureUrl == null || pictureUrl.isEmpty()) {
			return;
		}

		Paragraph picture = new Paragraph();
		for (String url : pictureUrl) {
			Image img = Image.getInstance(url);
			img.scaleAbsolute(200, 200);
			picture.add(img);
			picture.add("  ");
		}
		document.add(picture);
	}

	// 超链接
	private static void createHyperLink(Document document, String linkName, String url) throws Exception {

		Anchor link = new Anchor(linkName);
		link.setReference(url);
		Font linkFont = new Font();
		linkFont.setColor(0, 0, 255);
		linkFont.setStyle(Font.UNDERLINE);
		link.setFont(linkFont);
		Paragraph linkParagraph = new Paragraph();
		linkParagraph.add(link);
		linkParagraph.add("、");
		linkParagraph.add(link);
		document.add(linkParagraph);
	}

	public static void main(String[] args) {
		try {
			createWord();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
