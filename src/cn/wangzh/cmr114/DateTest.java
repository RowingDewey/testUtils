package cn.wangzh.cmr114;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DateTest {

	public static enum CompareDateFormate {
		/**
		 * 时间格式
		 */
		year, month, day, hour, minute, second,

		/**
		 * 时间格式
		 */
		yyyyMMddhhmmss, yyyyMMddhhmm, yyyyMMddhh, yyyyMMdd, yyyyMM,

		/**
		 * 时间格式
		 */
		MMddhhmmss, MMddhhmm, MMddhh, MMdd, ddhhmmss, ddhhmm, ddhh, hhmmss, hhmm, mmss
	}
	private static final HashMap<CompareDateFormate, int[]> map = new HashMap<CompareDateFormate, int[]>();
	static {
		map.put(CompareDateFormate.year, new int[]{Calendar.YEAR});
		map.put(CompareDateFormate.month, new int[]{Calendar.MONTH});
		map.put(CompareDateFormate.day, new int[]{Calendar.DATE});
		map.put(CompareDateFormate.hour, new int[]{Calendar.HOUR_OF_DAY});
		map.put(CompareDateFormate.minute, new int[]{Calendar.MINUTE});
		map.put(CompareDateFormate.second, new int[]{Calendar.SECOND});

		map.put(CompareDateFormate.yyyyMMddhhmmss, new int[]{Calendar.YEAR,
				Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY,
				Calendar.MINUTE, Calendar.SECOND});
		map.put(CompareDateFormate.yyyyMMddhhmm, new int[]{Calendar.YEAR,
				Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY,
				Calendar.MINUTE});
		map.put(CompareDateFormate.yyyyMMddhh, new int[]{Calendar.YEAR,
				Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY});
		map.put(CompareDateFormate.yyyyMMdd, new int[]{Calendar.YEAR,
				Calendar.MONTH, Calendar.DATE});
		map.put(CompareDateFormate.yyyyMM, new int[]{Calendar.YEAR,
				Calendar.MONTH});

		map.put(CompareDateFormate.MMddhhmmss, new int[]{Calendar.MONTH,
				Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE,
				Calendar.SECOND});
		map.put(CompareDateFormate.MMddhhmm, new int[]{Calendar.MONTH,
				Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE});
		map.put(CompareDateFormate.MMddhh, new int[]{Calendar.MONTH,
				Calendar.DATE, Calendar.HOUR_OF_DAY});
		map.put(CompareDateFormate.MMdd, new int[]{Calendar.MONTH,
				Calendar.DATE});

		map.put(CompareDateFormate.ddhhmmss, new int[]{Calendar.DATE,
				Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND});
		map.put(CompareDateFormate.ddhhmm, new int[]{Calendar.DATE,
				Calendar.HOUR_OF_DAY, Calendar.MINUTE});
		map.put(CompareDateFormate.ddhh, new int[]{Calendar.DATE,
				Calendar.HOUR_OF_DAY});

		map.put(CompareDateFormate.hhmmss, new int[]{Calendar.HOUR_OF_DAY,
				Calendar.MINUTE, Calendar.SECOND});
		map.put(CompareDateFormate.hhmm, new int[]{Calendar.HOUR_OF_DAY,
				Calendar.MINUTE});
		map.put(CompareDateFormate.mmss, new int[]{Calendar.MINUTE,
				Calendar.SECOND});
	}

	public static int compare(Date date1, Date date2, CompareDateFormate cdf) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);

		int[] form = map.get(cdf);
		for (int field : form) {
			int t1 = c1.get(field);
			int t2 = c2.get(field);
			if (t1 > t2) {
				return 1;
			} else if (t1 < t2) {
				return -1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		DateBean date = new DateBean("2016/7/9 15:31:52");
		@SuppressWarnings("deprecation")
		int result = compare(new Date(), new Date(date.getTime()),
				CompareDateFormate.yyyyMM);

		System.out.println("result =" + result);

	}
}
