package xu.sheng.jiang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilAction {

	public static String timeNow() throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}

	public static String long2String() throws Exception {

		long date = new Date().getTime();
		return Long.toString(date);
	}

}
