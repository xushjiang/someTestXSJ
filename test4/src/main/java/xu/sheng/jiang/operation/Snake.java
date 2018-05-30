package xu.sheng.jiang.operation;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Snake {

//	@Autowired
//	SnakeDao snakeDao;

	@Resource
	SnakeInterface snakeIn;

	/**
	 * 返回json
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/getSnake", method = RequestMethod.GET)
	public ModelAndView getSnake(HttpServletRequest req, HttpServletResponse res) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("date", new Date());

			// 适用于springJDBC
//			snakeDao.getUser();
			Map<String, Object> user = snakeIn.getUsers(246);
			System.out.println(user.get("loginid"));

			PrintWriter out = res.getWriter();
			JSONObject json = new JSONObject();
			json.put("errcode", 200);
			json.put("msg", new JSONObject(map));
			out.print(json);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 返回 网页路径
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getHome", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	/**
	 * 返回 网页路径和数据
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getInfo", method = RequestMethod.GET)
	public ModelAndView info(HttpServletRequest req, HttpServletResponse res) {

		res.setHeader("he", "成功");// 添加头信息
		ModelAndView model = new ModelAndView("dateTime");// 参数是页面名称
//		ModelAndView model = new ModelAndView("dateTime");// 参数是页面名称
		List<Map<String, Object>> data = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("key", new Date());
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		map.put("6", "6");
		map.put("7", "7");
		map.put("8", "8");
		map.put("11", "11");
		map.put("12", "12");
		map.put("13", "13");
		map.put("14", "14");
		data.add(map);
		data.add(map);
		model.addObject("data", data);// 要返回的数据
		model.addObject("unit", "申报单位：沈阳钢铁制造厂");
		model.addObject("time", "统计截止时间：" + new Date());
		return model;
	}

}
