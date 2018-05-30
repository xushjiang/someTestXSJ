package test.test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class SomeTest {

	public static void test() throws Exception {

		List<String> l1 = new ArrayList<>();
		l1.add("1");
		l1.add("12");
		l1.add("13");
		List<String> l2 = new ArrayList<>();
		l1.add("1");
		l1.add("14");
		l1.add("15");
		l1.addAll(l2);
		System.err.println(new HashSet<>(l1));
	}

	private static String doubleTrans1(double num) {

		String s_num = Double.toString(num);
		String last_num = s_num.substring(s_num.indexOf(".") + 1);
		DecimalFormat df = new DecimalFormat("0.00000");

		if (num % 1 == 0 && last_num.startsWith("0")) {
			return String.valueOf((long) num);
		}
		return df.format(num);
	}
	

	public static void dateFormate() throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("yyyy 年 M 月 d 日");
		System.out.println(df.format(1522827511000L));
	}

	/**
	 * 把一个数组按照完全二叉树进行堆排序 理解完全二叉树：对于完全二叉树k层的节点，他的左子节点所在地址为2*currentNodeIndex+1
	 * 他的右子节点的所在地址为2*currentNodeIndex+2。在比较时，值大小顺序为父节点<左子节点<右子节点
	 * 
	 * @throws Exception
	 */
	public static void binaryTreeSort(int[] array, int currentNodeIndex, int size) throws Exception {

		// 默认当前节点的值最大
		int max = currentNodeIndex;

		// 比较当前节点和他的左子节点的大小。当左子节点小于当前节点，互换值
		if (2 * currentNodeIndex + 1 < size) {
			int left = array[2 * currentNodeIndex + 1];
			if (left < array[max]) {
				array[2 * currentNodeIndex + 1] = array[max];// 将比较大的值放入左子节点
				array[currentNodeIndex] = left;// 将比较小的值放入当前节点
				max = 2 * currentNodeIndex + 1;// 将比较大的值得地址记录
			}
		}

		// 比较左节点和右子节点。当右子节点小于左子节点时，互换值
		if (2 * currentNodeIndex + 2 < size) {
			int right = array[2 * currentNodeIndex + 2];
			if (right < array[max]) {
				array[2 * currentNodeIndex + 2] = array[max];// 将比较大的值放入左子节点
				array[2 * currentNodeIndex + 1] = right;// 将比较小的值放入当前节点
				max = 2 * currentNodeIndex + 2;// 将比较大的值得地址记录
			}
		}

	}

	/**
	 * 格式化时间戳为指定日期格式
	 * 
	 * @param time
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	private static String formateDate(long time, String pattern) throws Exception {

		SimpleDateFormat df = new SimpleDateFormat(pattern);

		return df.format(time * 1000L);
	}

	private static String formateNum(int num, int lenth) throws Exception {

		String num_str = Integer.toString(num);
		int num_lenth = num_str.length();

		if (num_lenth >= lenth) {
			System.err.println(num_str);
			return num_str;
		}

		for (int i = num_lenth; i < lenth; i++) {
			num_str = "0" + num_str;
		}
		System.err.println(num_str);
		return num_str;
	}

	/**
	 * 获取某月的天数
	 * 
	 * @throws Exception
	 */
	public static void getMonthDay(int year, int month) throws Exception {

		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.set(year, month, 0);
		System.err.println(year + "/" + month);
		System.err.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));

	}

	public static void main(String[] args) {

		int[] array = { 1, 3, 2, 4, 9, 5, 6, 8, 7 };// 无序数组
		try {
//			dateFormate();
//			test();
			getMonthDay(2018, 5);
//			formateNum(2345, 5);
		} catch (Exception e) {
//			e.printStackTrace();
			if (e instanceof NumberFormatException) {
				System.out.println("对了");
			} else {
				System.out.println("错了：" + e.getClass());
				System.out.println("错了：" + NumberFormatException.class);
			}
		}

	}

}
