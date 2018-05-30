package test.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {

	/**
	 * 导入模板数据
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	public ModelAndView importTemplateData(HttpServletRequest req, HttpServletResponse res) {

		try {
			System.err.println("导入文件");
			File file = new File("E://creatFile//files//XXX.xls");
			Workbook workBook = Workbook.getWorkbook(file);
			Sheet sheet = workBook.getSheet(0);

			List<Map<String, Object>> list = new ArrayList<>();
			for (int i = 1; i < sheet.getRows(); i++) {
				// 序号
				String sequence = sheet.getCell(0, i).getContents();
				if (sequence == null || sequence.trim().isEmpty()) {
					continue;
				}

				// 检查项
				String examine = sheet.getCell(1, i).getContents();
				if (examine == null || examine.trim().isEmpty()) {
					examine = null;
				}

				// 采集以及内容
				String result = sheet.getCell(2, i).getContents();
				if (result == null || result.trim().isEmpty()) {
					result = null;
				}

				// 选择的内容
				String checked = sheet.getCell(3, i).getContents();
				if (checked == null || checked.trim().isEmpty()) {
					checked = null;
				}

//				// 选择信息描述（1系统默认，2人工录入，3下拉选择，4选择是否合格，5自定义）
//				String check_desc = sheet.getCell(4, i).getContents();
//				if (StringUtil.isEmpty(check_desc)) {
//					check_desc = null;
//				}
//
//				// 严重程度
//				String degree = sheet.getCell(5, i).getContents();
//				if (StringUtil.isEmpty(degree)) {
//					degree = null;
//				}
//
//				// 对应规范
//				String standard = sheet.getCell(6, i).getContents();
//				if (StringUtil.isEmpty(standard)) {
//					standard = null;
//				}
//
//				// 自动累计（模板3有值）
//				String auto_increase = sheet.getCell(7, i).getContents();
//				if (StringUtil.isEmpty(auto_increase)) {
//					auto_increase = null;
//				}
//
//				// 人工累计(模板3有值)
//				String person_increase = sheet.getCell(8, i).getContents();
//				if (StringUtil.isEmpty(person_increase)) {
//					person_increase = null;
//				}

				Map<String, Object> map = new HashMap<>();
				map.put("sequence", sequence);
				map.put("examine", examine);
				map.put("result", result);
				map.put("checked", checked);
//				map.put("check_desc", check_desc);
//				map.put("degree", degree);
//				map.put("standard", standard);
//				map.put("auto_increase", auto_increase);
//				map.put("person_increase", person_increase);
				list.add(map);
			}
			System.err.println(list);
			// 导入数据
//			int result = sceneManageService.importTemplateData(list);
//			if (result > 0) {
//				PortReturn.success_print(res);
//			} else {
//				PortReturn.fail_print(ErrCode.FAIL, Msg.FAIL, res);
//			}
		} catch (Exception e) {
//			PortReturn.fail_print(ErrCode.SERVER_ERR, Msg.SERVER_ERR, res);
//			logger.error("出错:\n" + RequestUtil.getReqInfo(req), e);
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
