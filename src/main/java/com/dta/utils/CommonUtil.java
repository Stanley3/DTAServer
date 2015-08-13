package com.dta.utils;

import java.math.BigDecimal;
import java.util.List;

import com.dta.bean.SchoolInfoBasedDistance;

public class CommonUtil {
	private final static double EARTH_RADIUS = 6378.137; // 单位是km

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return 根据两点的经纬度计算两点间的距离 单位是km
	 */
	public static double GetDistance(double lat1, double lng1, double lat2,
			double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		BigDecimal bigDecimal = new BigDecimal(s);
		// s = Math.round(s * 10000) / 10000;
		return bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/*public static void quickSort(List<SchoolInfoBasedDistance> list, int start,
			int end) {
		int i = start, j = end;
		double key = list.get(start).getDistance();
		SchoolInfoBasedDistance keySchool = list.get(start);

		while (i < j) {
			 按j--方向遍历目标数组，直到比key小的值为止 
			while (j > i && list.get(j).getDistance().compareTo(key) >= 0) {
				j--;
			}
			if (i < j) {
				 targetArr[i]已经保存在key中，可将后面的数填入 
				list.set(i, list.get(j));
				i++;
			}
			 按i++方向遍历目标数组，直到比key大的值为止 
			while (i < j && list.get(i).getDistance().compareTo(key) <= 0)
			
			 * 此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，
			 * 那么这个小于等于的作用就会使下面的if语句少执行一亿次。
			 
			{
				i++;
			}
			if (i < j) {
				 targetArr[j]已保存在targetArr[i]中，可将前面的值填入 
				list.set(j, list.get(i));
				j--;
			}
		}
		 此时i==j 
		list.set(i, keySchool);

		 递归调用，把key前面的完成排序 
		if (start < i - 1)
			quickSort(list, start, i - 1);

		 递归调用，把key后面的完成排序 
		if (j + 1 < end)
			quickSort(list, j + 1, end);

	}*/
}
