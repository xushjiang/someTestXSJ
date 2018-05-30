package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 初始化日志
 * 
 * @author xushjiang
 *
 */
public class LogInit extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(LogInit.class);

	public LogInit() {
    }

	public void init(ServletConfig config) throws ServletException {

		String contextPath = config.getServletContext().getRealPath("/");
		String log4jProperties = config.getInitParameter("log4jInit");
		String propertiesPath = contextPath + log4jProperties;
		Properties properties = new Properties();
		try {
			InputStream propertiesInStream = new FileInputStream(new File(propertiesPath));
			properties.load(propertiesInStream);
			propertiesInStream.close();
			if (logger.isDebugEnabled()) {
				String debugFile = contextPath + properties.getProperty("log4j.appender.D.File");// 设置debug路径
				properties.setProperty("log4j.appender.D.File", debugFile);
			}

			if (logger.isInfoEnabled()) {
				String infoFile = contextPath + properties.getProperty("log4j.appender.I.File");// 设置info路径
				properties.setProperty("log4j.appender.I.File", infoFile);
				System.err.println("============================================================================");
				System.err.println(infoFile);
			}

			if (logger.isWarnEnabled()) {
				String warnFile = contextPath + properties.getProperty("log4j.appender.W.File");// 设置warn路径
				properties.setProperty("log4j.appender.W.File", warnFile);
			}

			if (logger.isErrorEnabled()) {
				String errorFile = contextPath + properties.getProperty("log4j.appender.E.File");// 设置error路径
				properties.setProperty("log4j.appender.E.File", errorFile);
			}

			PropertyConfigurator.configure(properties);// 装入log4j配置信息
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
