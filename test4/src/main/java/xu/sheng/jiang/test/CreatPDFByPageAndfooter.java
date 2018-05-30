package xu.sheng.jiang.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 生成多页的pdf并加上脚标
 * 
 * @author xushjiang
 *
 */
public class CreatPDFByPageAndfooter {

	private static String PDF_PATH = "E://creatFile//CreatPDFByPageAndfooter.pdf";

	public static String updateString(String str) throws Exception {

		int size = 35;
		int str_lenth = str.length();
		int multi_size = str_lenth/size+1;
		StringBuffer sb = new StringBuffer(str);
		for (int i = 1; i < multi_size; i++) {
			sb.insert(35 * i, "\n");
		}
//		sb.append("\n");
		return sb.toString();
	}

	public static int pageNumber(String str, int number) throws Exception {

		String[] str_array = str.split("\n");
		int page_number = str_array.length / number;
		if (str_array.length % number > 0) {
			page_number = page_number + 1;
		}
		return page_number;
	}

	public static int getCharIndex(String str, int times, String ch) throws Exception {

		if (str.trim().isEmpty()) {
			return 0;
		}

//		if (times == 0) {
//			return 0;
//		}

		char[] char_array = str.toCharArray();
		int index = 0;
		for (int i = 0; i < char_array.length; i++) {
			String s = String.valueOf(char_array[i]);
			if (ch.equals(s)) {
				index++;
				if (index == times) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * 生成pdf模板
	 * 
	 * @throws Exception
	 */
	public static void createTemplatePDF(Document document, Map<String, Object> data, int currentPage, int tatolPage,
			PdfContentByte cb, String zhi_liang_kong_zhi) throws Exception {

		// 创建字体
		BaseFont unicode = BaseFont.createFont(
				System.getProperty("user.dir") + "/src/main/webapp/resources/qhj-resources/font/STSONG.TTF",
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(unicode, 12, Font.NORMAL, BaseColor.DARK_GRAY);
		BaseFont unicode1 = BaseFont.createFont(
				System.getProperty("user.dir") + "/src/main/webapp/resources/qhj-resources/font/STSONG.TTF",
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font1 = new Font(unicode1, 16, Font.BOLD, BaseColor.DARK_GRAY);

		if (currentPage == 1) {
			if (currentPage == 1) {
				Paragraph pa = new Paragraph(new Phrase("监理日志\n\n\n", font1));
				pa.setAlignment(Element.ALIGN_CENTER);
				document.add(pa);

				StringBuffer date = new StringBuffer();
				date.append("日期：").append(MapUtils.getString(data, "${2.1.1}", " "));
				ColumnText[] ct = new ColumnText[2];
				ct[0].showTextAligned(cb, Element.ALIGN_TOP,
						new Phrase("工程名称：" + MapUtils.getString(data, "${pg_name}", " "), font), document.left(),
						document.top(60f), 0);
				ct[1].showTextAligned(cb, Element.ALIGN_TOP, new Phrase(date.toString(), font), document.right(150f),
						document.top(60f), 0);
			}
		}

		// 编辑文档，填充数据
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100);

		table.addCell(new Phrase("单位工程", font));
		table.addCell(new Phrase(MapUtils.getString(data, "${project}", " "), font));
		table.addCell(new Phrase("施工单位", font));
		PdfPCell cell1 = new PdfPCell(new Phrase(MapUtils.getString(data, "unit", " "), font));
		cell1.setColspan(3);// 合并单元格
		cell1.setFixedHeight(25);// 单元格高度
		table.addCell(cell1);

		PdfPCell cell = new PdfPCell(new Phrase("风力", font));
		cell.setFixedHeight(25);// 单元格高度
		table.addCell(cell);
		table.addCell(new Phrase(MapUtils.getString(data, "${2.1.6}", " "), font));
		table.addCell(new Phrase("气温", font));
		table.addCell(new Phrase(MapUtils.getString(data, "${2.1.5}", " "), font));
		table.addCell(new Phrase("天气", font));
		table.addCell(new Phrase(MapUtils.getString(data, "${2.1.3}", " "), font));

		PdfPCell cell2_1 = new PdfPCell(new Phrase("进度控制", font));
		cell2_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell2_1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell2_1.setFixedHeight(150f);// 单元格高度
		table.addCell(cell2_1);
		PdfPCell cell2 = new PdfPCell(new Phrase(MapUtils.getString(data, "${3}", " "), font));
		cell2.setLeading(6, 1);// 设置行间距
		cell2.setColspan(5);
		table.addCell(cell2);

		PdfPCell cell3_1 = new PdfPCell(new Phrase("质量控制", font));
		cell3_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell3_1.setHorizontalAlignment(Element.ALIGN_CENTER);
		if (currentPage > 1 && currentPage != tatolPage) {
			cell3_1.setFixedHeight(350f);// 单元格高度
		} else {
			cell3_1.setFixedHeight(290f);// 单元格高度
		}
		table.addCell(cell3_1);
		PdfPCell cell3 = new PdfPCell(new Phrase(zhi_liang_kong_zhi.toString(), font));
		cell3.setColspan(5);
		cell3.setLeading(6, 1);// 设置行间距，（固定像素，字体大小倍数）
		table.addCell(cell3);

		StringBuffer j_shinei = new StringBuffer();
		j_shinei.append(MapUtils.getString(data, "${j_shinei}", ""));
		j_shinei.append("\n对现场检查发现的问题已通知施工单位整改。");
		PdfPCell cell4_1 = new PdfPCell(new Phrase("职业健康、安全、环境", font));
		cell4_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell4_1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell4_1.setFixedHeight(100f);// 单元格高度
		table.addCell(cell4_1);
		PdfPCell cell4 = new PdfPCell(new Phrase(j_shinei.toString(), font));
		cell4.setLeading(6, 1);// 设置行间距
		cell4.setColspan(5);
		table.addCell(cell4);

		StringBuffer others = new StringBuffer();
		others.append(MapUtils.getString(data, "${4.1}", ""));
		others.append(MapUtils.getString(data, "${4.2}", ""));
		PdfPCell cell5_1 = new PdfPCell(new Phrase("其他", font));
		cell5_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell5_1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5_1.setFixedHeight(80f);// 单元格高度
		table.addCell(cell5_1);
		PdfPCell cell5 = new PdfPCell(new Phrase(others.toString(), font));
		cell5.setLeading(6, 1);// 设置行间距
		cell5.setColspan(5);
		table.addCell(cell5);

		// 设置页码
		if (currentPage == tatolPage) {
			ColumnText[] ct = new ColumnText[3];
			ct[0].showTextAligned(cb, Element.ALIGN_BOTTOM, new Phrase("监理单位：" + data.get("${2.1.2}"), font),
					document.left(), document.bottom(30), 0);
			ct[1].showTextAligned(cb, Element.ALIGN_BOTTOM, new Phrase("监理人员：", font), document.right(200),
					document.bottom(30), 0);
			ct[2].showTextAligned(cb, Element.ALIGN_BOTTOM, new Phrase(String.format("%s/%s", currentPage, tatolPage)),
					document.right(), document.bottom(), 0);
		} else {
			ColumnText.showTextAligned(cb, Element.ALIGN_BOTTOM,
					new Phrase(String.format("%s/%s", currentPage, tatolPage)), document.right(), document.bottom(), 0);
		}

		// 将表格添加进文档
		document.add(table);

	}

	public static void main(String[] args) {

		try {

			int tatolPage = 1;
			int number = 15;

			// 设置文件路径
			File file1 = new File(PDF_PATH);
			file1.getParentFile().mkdirs();
			FileOutputStream file = new FileOutputStream(PDF_PATH);

			// 创建文档
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, file);
			document.open();
			PdfContentByte cb = writer.getDirectContent();

			// 文档数据
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("${4.2}", "");
			data.put("${4.1}", "无");
			data.put("${project}", "A村");
			data.put("${shiwai}", "按图施工，施工组织设计方案及专项方案,");
			data.put("${pg_name}", "双井乐成中心");
			data.put("${3}",
					"今日完成：\n中压（km）:1、阀井（座）:1、调压设备（套）:1、中压吹扫（km）:1\n累计完成：\n中压（km）:63、阀井（座）:49、调压设备（套）:43、中压吹扫（km）:50、中压试压（km）:52、低压（km）:46、低压吹扫（km）:23、低压试压（km）:25、立管（根）:28、挂表（块）:10、户内试压（户）:11、穿越（处）:12");
			data.put("${j_shinei}", "无");
			data.put("${2.1.1}", "2017年12月07日");
			data.put("${j_shinei}", "jxjjd模式：\n未按施工组织设计方案及专项方案施工,施工现场进场材料、构配件及设备储运不符合要求");
			data.put("${2.1.6}", "西北风3-4 级");
			data.put("${shiwaixianchang}", "jxjjd模式：\n未按施工组织设计方案及专项方案施工,施工现场进场材料、构配件及设备储运不符合要求");
			data.put("${shinei}",
					"jxjjd模式：\n未按施工组织设计方案及专项方案施工,施工现场进场材料、构配件及设备储运不符合要求jxjjd模式：\n未按施工组织设计方案及专项方案施工,施工现场进场材料、构配件及设备储运不符合要求");
			data.put("${2.1.3}", "多云转晴");
			data.put("${2.1.2}", "地厚云图");
			data.put("${no}",
					"jxjjd模式：\n未按施工组织设计方案及专项方案施工,施工现场进场材料、构配件及设备储运不符合要求jxjjd模式：\n未按施工组织设计方案及专项方案施工,施工现场进场材料、构配件及设备储运不符合要求");
			data.put("${excute_unit}", "12");
			data.put("${2.1.5}", "5℃~6℃,");
			data.put("{shineixianchang}=", "jxjjd模式：\n未按施工组织设计方案及专项方案施工,施工现场进场材料、构配件及设备储运不符合要求");

			String shinei = MapUtils.getString(data, "${shinei}", "");
			String shineixianchang = MapUtils.getString(data, "${shineixianchang}", "");
			String shiwai = MapUtils.getString(data, "${shiwai}", "");
			String shiwaixianchang = MapUtils.getString(data, "${shiwaixianchang}", "");
			String no = MapUtils.getString(data, "${no}", "");
			StringBuffer zhi_liang_kong_zhi_noupdate = new StringBuffer();// 不需要插入回车的字符串
			zhi_liang_kong_zhi_noupdate.append("1.室内：\n").append(shinei);
			zhi_liang_kong_zhi_noupdate.append(shineixianchang);
			zhi_liang_kong_zhi_noupdate.append("2.室外：\n").append(shiwai);
			zhi_liang_kong_zhi_noupdate.append(shiwaixianchang);
			zhi_liang_kong_zhi_noupdate.append("\n上述检查内容中不合格情况如下，其它为合格。");
			zhi_liang_kong_zhi_noupdate.append("\n3.不合格情况：\n").append(no);
			zhi_liang_kong_zhi_noupdate.append("\n4.整改情况\n").append("无\n \n \n对现场检查发现的问题已通知施工单位整改。");
			String zhi_liang_kong_zhi_noupdate_str = zhi_liang_kong_zhi_noupdate.toString();
			
			StringBuffer zhi_liang_kong_zhi = new StringBuffer();// 将来需要插入回车的字符串
			shinei = updateString(shinei);
			zhi_liang_kong_zhi.append("1.室内：\n").append(shinei);
			shineixianchang = updateString(shineixianchang);
			zhi_liang_kong_zhi.append(shineixianchang);
			shiwai = updateString(shiwai);
			zhi_liang_kong_zhi.append("2.室外：\n").append(shiwai);
			shiwaixianchang = updateString(shiwaixianchang);
			zhi_liang_kong_zhi.append(shiwaixianchang);
			zhi_liang_kong_zhi.append("\n上述检查内容中不合格情况如下，其它为合格。");
			no = updateString(no);
			zhi_liang_kong_zhi.append("\n3.不合格情况：\n").append(no);
			zhi_liang_kong_zhi.append("\n4.整改情况\n").append("无\n \n \n对现场检查发现的问题已通知施工单位整改。");

			tatolPage = pageNumber(zhi_liang_kong_zhi.toString(), number);
			String zhi_liang_kong_zhi_str = zhi_liang_kong_zhi.toString();
			for (int i = 1; i <= tatolPage; i++) {
				if (i > 1) {
					document.newPage();
				}
				String sub_zhi_liang_kong_zhi = "";
				if (i == tatolPage) {
					sub_zhi_liang_kong_zhi = zhi_liang_kong_zhi_noupdate_str
							.substring(getCharIndex(zhi_liang_kong_zhi_str, number * (i - 1), "\n"));
				} else if (i == 1) {
					sub_zhi_liang_kong_zhi = zhi_liang_kong_zhi_noupdate_str.substring(0,
							getCharIndex(zhi_liang_kong_zhi_str, number * i, "\n"));
				} else {
					sub_zhi_liang_kong_zhi = zhi_liang_kong_zhi_noupdate_str.substring(
							getCharIndex(zhi_liang_kong_zhi_str, number * (i - 1), "\n"),
							getCharIndex(zhi_liang_kong_zhi_str, number * i, "\n"));
				}
				createTemplatePDF(document, data, i, tatolPage, cb,
						sub_zhi_liang_kong_zhi);
			}

			// 关闭文档，不关闭文档将不能正常生成
			document.close();
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
