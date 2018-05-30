package xu.sheng.jiang.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;

import redis.clients.jedis.Jedis;

public class SomeTest extends AbstractClass {

	public static void main(String[] args) {

		try {
//			switchDemo();
//			pattern();
//			tryTest();
//			httpRequestGet();
//			string();
//			moveByte();
//			StringBuffer str_sb = new StringBuffer("a,b,a,d,e,f,a,h,i,a,k,l,m,n");
//			String str = "a,b,\n,d,\n,f,a,h,i,a,k,l,m,n";
//			System.out.println(getCharIndex(str, 2, "\n"));
//			testEquas();
//			Calendar ca = calculatDate(201712);
//			System.err.println(ca.getActualMaximum(Calendar.DAY_OF_MONTH));
//			Map<String, Object> yea = spliteYearMonthDay(20171212);
//			System.err.println(yea);
//			copyList();
//			newDate();
//			doubleTrans1(0.03);
//			getMax();
//			getIndex();
//			createNewWord();
//			createListsLists();
			charString();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void charString() throws Exception {

		Jedis redis = new Jedis("127.0.0.1");

		System.err.println(redis.get("name"));
	}

	public static void createListsLists() throws Exception {

		List<Map<String, Object>> lists = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			List<Map<String, Object>> fileLists = new ArrayList<>();
			Map<String, Object> fileMap = new HashMap<>();
			fileMap.put("type", 2);
			fileMap.put("name", "文件名称.doc");
			fileMap.put("mime", "http://192.168.1.236:8080/dhyt");
			fileLists.add(fileMap);

			Map<String, Object> map = new HashMap<>();
			map.put("taskName", "监理审批-钢结构检查合格");
			map.put("mime", fileLists);

			lists.add(map);
		}
		Map<String, Object> jMap = new HashMap<>();
		jMap.put("files", lists);

		System.err.println(org.json.simple.JSONObject.toJSONString(jMap));
	}

	public static void newDate() throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("yyyy 年 M 月 d 日");
		System.err.println(df.format(new Date(1543593600 * 1000L)));
//		int date = Integer.parseInt(df.format(new Date().getTime()));

//		System.out.println(new Date(1529683200 * 1000L));

	}

	public static void copyList() throws Exception {

		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		List<Integer> list2 = new ArrayList<>();
		list2.addAll(list1);
		System.err.println(list1 + "---" + list2);
		list2.set(0, 3);
		System.err.println(list1 + "---" + list2);
	}

	/**
	 * 将时间分为年，月，日
	 * 
	 * @param period:20170503、201705
	 * @return
	 * @throws Exception
	 */
	private static Map<String, Object> spliteYearMonthDay(int period) throws Exception {

		Map<String, Object> map = new HashMap<>();
		int year = Integer.parseInt(Integer.toString(period).substring(0, 4));
		int month = 1;
		int day = 1;
		int lenth = Integer.toString(period).length();
		if (lenth == 8) {
			String s_month = Integer.toString(period).substring(4, 6);
			if (s_month.startsWith("0")) {
				s_month = s_month.substring(1, 2);
				month = Integer.parseInt(s_month);
			} else {
				month = Integer.parseInt(s_month);
			}
			String s_day = Integer.toString(period).substring(6, 8);
			if (s_day.startsWith("0")) {
				s_day = s_day.substring(1, 2);
				day = Integer.parseInt(s_day);
			} else {
				day = Integer.parseInt(s_day);
			}
		} else if (lenth == 6) {
			String s_month = Integer.toString(period).substring(4, 6);
			if (s_month.startsWith("0")) {
				s_month = s_month.substring(1, 2);
				month = Integer.parseInt(s_month);
			} else {
				month = Integer.parseInt(s_month);
			}
		}
		map.put("year", year);
		map.put("month", month);
		map.put("day", day);
		return map;
	}

	private static Calendar calculatDate(int period) throws Exception {

		int year = Integer.parseInt(Integer.toString(period).substring(0, 4));
		int month = 0;
		String s_month = Integer.toString(period).substring(4, 6);
		if (s_month.startsWith("0")) {
			s_month = s_month.substring(1, 2);
			month = Integer.parseInt(s_month) - 1;
		}

		Calendar c = Calendar.getInstance();
		c.set(year, month, 1);
		return c;
	}

	public static void testEquas() throws Exception {

		String str = "a";
		String str1 = "a";
		System.out.println("a".equals(str));
		System.out.println("﻿[".equals("["));
		System.out.println("[".equals("["));

	}

	public static int getCharIndex(String str,int times,String ch) throws Exception {
		
		if(str.trim().isEmpty()){
			return 0;
		}
		char[] char_array = str.toCharArray();
		System.err.println(char_array);
		int index = 0;
		for (int i = 0; i < char_array.length; i++) {
			String s = String.valueOf(char_array[i]);
			if(ch.equals(s)){
				index++;
				if (index == times) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * 测试switch能不能使用string做参数
	 * 
	 * @throws Exception
	 */
	private static void switchDemo() throws Exception {

		String str = "a";
		switch (str) {
		case "a":
			System.err.println("is 'a'");
			break;
		case "b":
			System.err.println("is 'b'");
			break;
		default:
			break;
		}

	}

//	@Override
//	public void getString() throws Exception {
//
//	};

	/**
	 * 正则表达式
	 * 
	 * @throws Exception
	 */
	public static void pattern() throws Exception {

		String str_1 = "${e}weiruan2@owqeutlook.comWE";
		String regex = "\\$\\{.*\\}[a-zA_Z]*\\d*\\@{1}\\w*\\.com[A-Z]*";
		boolean flag = Pattern.matches(regex, str_1);

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str_1);

//		pattern.

		System.out.println(flag);
		System.out.println(matcher.matches());
	}

	/**
	 * 测试try catch finally
	 * 
	 * @throws Exception
	 */
	private static int tryTest() throws Exception {

		int sum = 0;
		try {
			int i_1 = 3;
			int i_2 = 4;
			sum = i_1 + i_2;
//			int i_3 = Integer.parseInt("a");
			return sum;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sum = sum + 3;
			System.out.println(sum + ":" + System.currentTimeMillis());
			System.err.println("erro" + ":" + System.currentTimeMillis());
		}
		System.err.println(sum + ":" + System.currentTimeMillis());
		return sum;
	}

	public static void string() throws Exception{
		StringBuffer sql = new StringBuffer();
		List<Object> objs = new ArrayList<>();
		String[] st = { "1", "2", "3", "4" };
		for (int i = 0; i < st.length; i++) {
			int type = Integer.parseInt(st[i]);
			switch (type) {
			case 1:
				sql.append("a");
				break;
			case 2:
				sql.append("b");
				break;
			case 3:
				sql.append("c");
				break;
			case 4:
				sql.append("d");
				break;
			default:
				break;
			}
		}
		System.out.println(sql.toString());
	}

	public static void moveByte() throws Exception {

		int i = 2;
		System.out.println(Integer.toBinaryString(i << 2));
	}

	public static String list(List<String> list) throws Exception {

		System.err.println(list);
		if (list.size() == 1) {
			System.err.println("w");
			return list.get(0);
		}

		List<String> new_list = new ArrayList<>();
		for (String l : list) {
			if ((list.indexOf(l) + 1) % 3 > 0) {
				new_list.add(l);
			}
			if (list.indexOf(l) == list.size() - 1) {
				list(new_list);
			}
		}

		return list.get(0);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public static void httpRequestGet() throws Exception {

		String result = "";
		BufferedReader in = null;
		try {
			String url = "http://192.168.1.236:8081/rqjlzs/api/getStProjectIsFinish?project_id=158";
			URLConnection connection = (new URL(url)).openConnection();
			HttpURLConnection hc = (HttpURLConnection) connection;

			// 设置通用的请求属性
			hc.setRequestProperty("accept", "*/*");
			hc.setRequestProperty("connection", "Keep-Alive");
			hc.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			hc.setRequestMethod("GET");

			// 建立实际的连接
			hc.connect();

			// 获取所有响应头字段
			Map<String, List<String>> map = hc.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.err.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(hc.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println(result);
	}

//	private 

	private static String doubleTrans1(double num) {

		String s_num = Double.toString(num);
		System.err.println(s_num.indexOf("."));
		String last_num = s_num.substring(s_num.indexOf(".") + 1);
		System.err.println(last_num);
		DecimalFormat df = new DecimalFormat("0.00");

		if (num % 1 == 0 && last_num.startsWith("0")) {
			System.err.println(String.valueOf((long) num));
			return String.valueOf((long) num);
		}
		System.out.println(df.format(num));
		return df.format(num);

	}

	public static void getIndex() throws Exception {

		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(2);
		System.out.println(list.indexOf(2));
	}

	/**
	 * 问题描述：求出数组中某个数之后大于这个数的数个数
	 * 
	 * @param args
	 * @return
	 */
	private static int getMax() {

//		Scanner sc = new Scanner(System.in);
//		System.out.println("ScannerTest, Please Enter Name:");
//		String name = sc.nextLine(); // 读取字符串型输入
//		System.out.println("ScannerTest, Please Enter Age:");
//		int age = sc.nextInt(); // 读取整型输入
//		System.out.println("ScannerTest, Please Enter Salary:");
//		float salary = sc.nextFloat(); // 读取float型输入
//		System.out.println("Your Information is as below:");
//		System.out.println("Name:" + name + "\n" + "Age:" + age + "\n" + "Salary:" + salary);
		Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		while (in.next().isEmpty()) {
			int i = in.nextInt();
			list.add(i);
		}

		List<String> l = new ArrayList<>();
		for(Integer n :list){
			int n_index = list.indexOf(n);
			int o = 0;
			for (int nu = n_index; n_index < list.size() - 1; n_index++) {
				if (n < nu) {
					o++;
				}
			}
			l.add(Integer.toString(o) + "index:" + Integer.toString(n_index));
		}
		System.out.println(l);
		return 0;
	}

	/**
	 * 创建新的word文档
	 * 
	 * @throws Exception
	 */
	public static void createNewWord() throws Exception {

		// 设置新的文档
		XWPFDocument doc = new XWPFDocument();

		// 设置一个段落
		XWPFParagraph pa1 = doc.createParagraph();
		pa1.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun run = pa1.createRun();
		run.setText("我想设置一个表头");
		run.setFontSize(21);
		run.setBold(true);

		// 创建表格并设置表格内容
		XWPFTable table = doc.createTable(3, 3);
		CTTblPr newCtt = table.getCTTbl().addNewTblPr();
		newCtt.addNewTblW().setW(BigInteger.valueOf(8000));

		table.getRow(0).getCell(0).setText("首次创建Word表格");
		table.getRow(0).getCell(1).setText("首次创建Word表格");
		table.getRow(0).getCell(2).setText("首次创建Word表格");
		mergeCellsVertically(table, 0, 1, 2);
		table.getRow(1).getCell(0).setText("首次创建Word表格");
		table.getRow(1).getCell(1).setText("首次创建Word表格");
		table.getRow(1).getCell(2).setText("首次创建Word表格");
		mergeCellsHorizontal(table, 2, 1, 2);
		table.getRow(2).getCell(1).setText("首次创建Word表格");

		System.err.println(table.getCellMarginBottom());

		// 加入一张图片
		XWPFParagraph p = doc.createParagraph();
		p.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r = p.createRun();
		List<String> args = new ArrayList<>();
		args.add("E://文件//picture//61434d637f691276d6660daad38ceca3.png");
//		args.add("http://192.168.1.236:8080/dhyt/file/jintai/check/55/24/a6f5abd9-a6e3-4c40-9e6a-60eb88081a3a.jpg");
		for (String imgFile : args) {
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

//			r.setText(imgFile);
			r.addBreak();
			r.addPicture(new FileInputStream(imgFile), format, imgFile, Units.toEMU(200), Units.toEMU(200)); // 200x200
//			r.addBreak(BreakType.PAGE);
		}

		// 插入超链接
		XWPFParagraph p2 = doc.createParagraph();
		appendExternalHyperlink(
				"http://192.168.1.236:8080/dhyt/file/jintai/check/55/24/a6f5abd9-a6e3-4c40-9e6a-60eb88081a3a.jpg",
				"通知文件", p2);

		// 输出文档
		OutputStream out = new FileOutputStream("E://simpleTable.docx");
		doc.write(out);
		out.close();
		doc.close();
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
//		paragraph.setVerticalAlignment(TextAlignment.CENTER);
	}

}

