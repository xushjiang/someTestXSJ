package xu.sheng.jiang.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;

public class CreateWordByPOI {

	/**
	 * 创建新的word文档
	 * 
	 * @throws Exception
	 */
	public static void createNewWord() throws Exception {

		// 设置新的文档
		XWPFDocument doc = new XWPFDocument();

		// 设置页面大小
//		CTDocument1 document = doc.getDocument();
//		CTBody body = document.getBody();
//		if (!body.isSetSectPr()) {
//			body.addNewSectPr();
//		}
//		CTSectPr section = body.getSectPr();
//
//		if (!section.isSetPgSz()) {
//			section.addNewPgSz();
//		}
//		CTPageSz pageSize = section.addNewPgSz();
//		setpageSize(doc);

		// 设置一个段落
		XWPFParagraph pa1 = doc.createParagraph();
		pa1.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun run = pa1.createRun();
		run.setText("监理日志");
		run.setFontSize(21);// 字体打xiao
		run.setBold(true);

		// 创建表格并设置表格内容
		XWPFTable table = doc.createTable(3, 4);
		createTable(table);

		// 加入图片
		XWPFParagraph pic = doc.createParagraph();
		List<String> picturePath = new ArrayList<>();
		File thisPic = new File(
				"E:/WorkSpace4/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/webapps/dhyt/file/user/log/320/4f5880bc-dcbb-4ac2-9ec0-0e64f380c073.png");
		if (thisPic.exists()) {
			picturePath.add(
					"E:\\WorkSpace4\\.metadata/.plugins/org.eclipse.wst.server.core/tmp1/webapps/dhyt/file/user/log/320/4f5880bc-dcbb-4ac2-9ec0-0e64f380c073.png");
			addPicture(pic, picturePath, 200, 200);
		}

		// 超链接
		XWPFParagraph linkPara = doc.createParagraph();
		String link = "http://192.168.1.236:8080/dhyt/file/jintai/check/55/24/a6f5abd9-a6e3-4c40-9e6a-60eb88081a3a.jpg";
		String linkName = "通知文件";
		externalHyperlink(linkPara, link, linkName);
		externalHyperlink(linkPara, link, linkName);
		System.err.println(table.getCellMarginBottom());

		// 输出文档
		OutputStream out = new FileOutputStream("E://simpleTable1.docx");
		doc.write(out);
		out.close();
		doc.close();
	}

	// 创建表格
	private static void createTable(XWPFTable table) throws Exception {
		CTTblPr newCtt = table.getCTTbl().addNewTblPr();
		newCtt.addNewTblW().setW(BigInteger.valueOf(8000));
		newCtt.addNewJc().setVal(STJc.CENTER);

		CTTcPr c1 = table.getRow(0).getCell(0).getCTTc().addNewTcPr();
		c1.addNewTcW().setW(BigInteger.valueOf(1500));
		XWPFParagraph cellName2 = table.getRow(0).getCell(0).addParagraph();
		cellName2.setAlignment(ParagraphAlignment.CENTER);
		cellName2.createRun().setText("天气");
		CTTcPr c2 = table.getRow(0).getCell(1).getCTTc().addNewTcPr();
		c2.addNewTcW().setW(BigInteger.valueOf(2500));
		table.getRow(0).getCell(1).setText(
				" at org.apache.\n poi.xwpf.usermodel.\n \n XWPFTableCell.setParagraph\n\n(XWPFTableCell.java:133)");

		CTTcPr c3 = table.getRow(0).getCell(2).getCTTc().addNewTcPr();
		c3.addNewTcW().setW(BigInteger.valueOf(1500));
		XWPFParagraph cellName1 = table.getRow(0).getCell(2).addParagraph();
		cellName1.setAlignment(ParagraphAlignment.CENTER);
		cellName1.createRun().setText("日期");

		CTTcPr c4 = table.getRow(0).getCell(3).getCTTc().addNewTcPr();
		c4.addNewTcW().setW(BigInteger.valueOf(2500));
		table.getRow(0).getCell(3).setText(".getCTTc().addNewTcPr() ");

		mergeCellsHorizontal(table, 1, 0, 3);
		String str = " at org.apache.\n poi.xwpf.usermodel.\n \n XWPFTableCell.setParagraph\n\n(XWPFTableCell.java:133)";
		String[] strArray = str.split("\n");
		XWPFParagraph text = table.getRow(1).getCell(0).addParagraph();
		XWPFRun textRun = text.createRun();
		for (int i = 0; i < strArray.length; i++) {
			textRun.setText(strArray[i]);
			textRun.addBreak();
		}

		CTTcPr c5 = table.getRow(2).getCell(0).getCTTc().addNewTcPr();
		c5.addNewTcW().setW(BigInteger.valueOf(1500));
		XWPFParagraph cellName3 = table.getRow(2).getCell(0).addParagraph();
		cellName3.setAlignment(ParagraphAlignment.CENTER);
		cellName3.createRun().setText("总监工程师");
		CTTcPr c6 = table.getRow(2).getCell(1).getCTTc().addNewTcPr();
		c6.addNewTcW().setW(BigInteger.valueOf(2500));
		XWPFParagraph pic1 = table.getRow(2).getCell(1).addParagraph();// 插入图片
		List<String> picturePath1 = new ArrayList<>();
		picturePath1.add(
				"E://文件//picture//61434d637f691276d6660daad38ceca3.png");
		addPicture(pic1, picturePath1, 120, 50);

		CTTcPr c7 = table.getRow(2).getCell(2).getCTTc().addNewTcPr();
		c7.addNewTcW().setW(BigInteger.valueOf(1500));
		XWPFParagraph cellName4 = table.getRow(2).getCell(2).addParagraph();
		cellName4.setAlignment(ParagraphAlignment.CENTER);
		cellName4.createRun().setText("记录");
		CTTcPr c8 = table.getRow(2).getCell(3).getCTTc().addNewTcPr();
		c8.addNewTcW().setW(BigInteger.valueOf(2500));
		XWPFParagraph pic2 = table.getRow(2).getCell(3).addParagraph();// 插入图片
		List<String> picturePath = new ArrayList<>();
		picturePath.add("E://文件//picture//61434d637f691276d6660daad38ceca3.png");
		addPicture(pic2, picturePath, 120, 50);
	}

	// 添加超链接
	private static void externalHyperlink(XWPFParagraph p, String link, String linkName) throws Exception {

		// 插入超链接
//		XWPFRun r = p.createRun();
//		r.setText("附件：");
//		r.setBold(true);// 粗体
//		r.setItalic(true);// 斜体
//		r.addCarriageReturn();
		appendExternalHyperlink(
				"http://192.168.1.236:8080/dhyt/file/jintai/check/55/24/a6f5abd9-a6e3-4c40-9e6a-60eb88081a3a.jpg",
				"通知文件", p);
	}

	// word跨列合并单元格
	private static void mergeCellsHorizontal(XWPFTable table, int row, int fromCell, int toCell) {

		for (int cellIndex = fromCell; cellIndex <= toCell; cellIndex++) {
			XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
			if (cellIndex == fromCell) {
				// The first merged cell is set with RESTART merge value
				cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
			} else {
				// Cells which join (merge) the first one, are set with CONTINUE
				cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
			}
		}
	}

	// word跨行并单元格
	private static void mergeCellsVertically(XWPFTable table, int col, int fromRow, int toRow) {

		for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
			XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
			if (rowIndex == fromRow) {
				// The first merged cell is set with RESTART merge value
				cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
			} else {
				// Cells which join (merge) the first one, are set with CONTINUE
				cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
			}
		}
	}

	// 设置超链接
	private static void appendExternalHyperlink(String url, String text, XWPFParagraph paragraph) {

		// Add the link as External relationship
		String id = paragraph.getDocument().getPackagePart()
				.addExternalRelationship(url, XWPFRelation.HYPERLINK.getRelation()).getId();
		// Append the link and bind it to the relationship
		CTHyperlink cLink = paragraph.getCTP().addNewHyperlink();
		cLink.setId(id);

		// Create the linked text
		CTText ctText = CTText.Factory.newInstance();
		ctText.setStringValue(text);
		CTR ctr = CTR.Factory.newInstance();
		CTRPr rpr = ctr.addNewRPr();

		// 设置超链接样式
		CTColor color = CTColor.Factory.newInstance();
		color.setVal("0000FF");
		rpr.setColor(color);
		rpr.addNewU().setVal(STUnderline.SINGLE);

		// 设置字体
		CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii("微软雅黑");
		fonts.setEastAsia("微软雅黑");
		fonts.setHAnsi("微软雅黑");

		// 设置字体大小
		CTHpsMeasure sz = rpr.isSetSz() ? rpr.getSz() : rpr.addNewSz();
		sz.setVal(new BigInteger("24"));

		ctr.setTArray(new CTText[] { ctText });
		// Insert the linked text into the link
		cLink.setRArray(new CTR[] { ctr });

		// 设置段落居中
		paragraph.setAlignment(ParagraphAlignment.LEFT);
//			paragraph.setVerticalAlignment(TextAlignment.CENTER);
	}

	// 设置纸张大小
	private static void setpageSize(XWPFDocument doc) throws Exception {

		CTDocument1 document = doc.getDocument();
		CTBody body = document.getBody();

		if (!body.isSetSectPr()) {
			body.addNewSectPr();
		}
		CTSectPr section = body.getSectPr();

		if (!section.isSetPgSz()) {
			section.addNewPgSz();
		}
		CTPageSz pageSize = section.addNewPgSz();

//		Letter       612x792
//		LetterSmall  612x792
//		Tabloid      792x1224
//		Ledger       1224x792
//		Legal        612x1008
//		Statement    396x612
//		Executive    540x720
//		A0           2384x3371
//		A1           1685x2384
//		A2           1190x1684
//		A3           842x1190
//		A4           595x842
//		A4Small      595x842
//		A5           420x595
//		B4           729x1032
//		B5           516x729
//		Folio        612x936
//		Quarto       610x780
//		10x14        720x1008

		// 必须要设置下面两个参数，否则整个的代码是无效的
		pageSize.setW(BigInteger.valueOf(15840));
		pageSize.setH(BigInteger.valueOf(12240));
		pageSize.setOrient(STPageOrientation.LANDSCAPE);
	}

	// 添加图片
	private static void addPicture(XWPFParagraph p, List<String> picturePath, long whith, long hight) throws Exception {
		XWPFRun r = p.createRun();
		for (String imgFile : picturePath) {
			int format;

			if (imgFile.endsWith(".emf"))
				format = XWPFDocument.PICTURE_TYPE_EMF;
			else if (imgFile.endsWith(".wmf"))
				format = XWPFDocument.PICTURE_TYPE_WMF;
			else if (imgFile.endsWith(".pict"))
				format = XWPFDocument.PICTURE_TYPE_PICT;
			else if (imgFile.endsWith(".jpeg") || imgFile.endsWith(".jpg"))
				format = XWPFDocument.PICTURE_TYPE_JPEG;
			else if (imgFile.endsWith(".png"))
				format = XWPFDocument.PICTURE_TYPE_PNG;
			else if (imgFile.endsWith(".dib"))
				format = XWPFDocument.PICTURE_TYPE_DIB;
			else if (imgFile.endsWith(".gif"))
				format = XWPFDocument.PICTURE_TYPE_GIF;
			else if (imgFile.endsWith(".tiff"))
				format = XWPFDocument.PICTURE_TYPE_TIFF;
			else if (imgFile.endsWith(".eps"))
				format = XWPFDocument.PICTURE_TYPE_EPS;
			else if (imgFile.endsWith(".bmp"))
				format = XWPFDocument.PICTURE_TYPE_BMP;
			else if (imgFile.endsWith(".wpg"))
				format = XWPFDocument.PICTURE_TYPE_WPG;
			else {
				System.err.println("Unsupported picture: " + imgFile
						+ ". Expected emf|wmf|pict|jpeg|png|dib|gif|tiff|eps|bmp|wpg");
				continue;
			}
			r.addPicture(new FileInputStream(imgFile), format, imgFile, (int) Math.rint(12700 * whith),
					(int) Math.rint(12700 * hight));// 200x200
			r.addCarriageReturn();
		}
	}

	public static void main(String[] args) {

		try {
			createNewWord();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
