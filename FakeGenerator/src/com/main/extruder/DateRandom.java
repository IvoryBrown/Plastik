package com.main.extruder;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateRandom {

	public static String date() {

		GregorianCalendar gc = new GregorianCalendar();

		int year = randBetween(2017, 2020);

		gc.set(Calendar.YEAR, year);

		int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

		return gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH);

	}

	private static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
}
