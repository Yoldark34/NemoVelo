/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Timestamp;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class Helper {

	/**
	 * get the actual time
	 *
	 * @return Timestamp
	 */
	public static Timestamp getSqlDateNow() {
		Timestamp timestamp = new java.sql.Timestamp(java.util.Calendar.getInstance().getTime().getTime());

		return timestamp;
	}

	/**
	 * calculate difference between duration to calc overtime and min time for a
	 * location
	 *
	 * @param t1 start date
	 * @param t2 end date
	 * @param unit hour, day ... for DataBaseElements.PriceDurationUnit
	 * @return int
	 */
	public static int getDifference(Timestamp t1, Timestamp t2, String unit) {
		int result;
		double unitDivision = -1;
		switch (unit) {
			case DataBaseElements.PriceDurationUnit.HOUR:
				unitDivision = 3600;
				break;
			case DataBaseElements.PriceDurationUnit.MINUTE:
				unitDivision = 60;
				break;
			case DataBaseElements.PriceDurationUnit.DAY:
				unitDivision = 86400;
				break;
			case DataBaseElements.PriceDurationUnit.MONTH:
				unitDivision = 2629743.83;
				break;
			case DataBaseElements.PriceDurationUnit.WEEK:
				unitDivision = 604800;
				break;
		}
		long nano1 = t1.getTime();
		long nano2 = t2.getTime();
		long difference = (nano2 - nano1);
		long differenceInSec = difference / 1000;
		float restInDivision = (float) (differenceInSec % unitDivision);
		result = (int) ((differenceInSec - restInDivision) / unitDivision);
		if (restInDivision > 0) {
			result++;
		}
		return result;
	}
}
