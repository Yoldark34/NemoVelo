/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.math.BigDecimal;
import java.sql.Timestamp;
import model.database.DataBaseElements;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class Helper {

	public static Timestamp getSqlDateNow() {
		Timestamp timestamp = new java.sql.Timestamp(java.util.Calendar.getInstance().getTime().getTime());
		//java.sql.Date sqlToday = new Date();

		return timestamp;
	}

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

	public static float divide(float p_numerator, float p_denominator) {
		BigDecimal numerator = new BigDecimal(p_numerator);
		BigDecimal denominator = new BigDecimal(p_denominator);
		BigDecimal quotient = numerator.divide(denominator);
		return quotient.floatValue();
	}
}
