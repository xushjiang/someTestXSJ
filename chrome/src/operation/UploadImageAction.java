package operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadImageAction {

	private Logger logger = LoggerFactory.getLogger(UploadImageAction.class);

	@RequestMapping(value = "/getIndex", method = RequestMethod.GET)
	public ModelAndView getIndex(HttpServletRequest req, HttpServletResponse res) {

		logger.info("CHROME.{}", req.getContextPath());
		return null;
	}

}
