package com.traveler.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.traveler.entities.Backpack;

@Component
public class MonthOfYearValidator {

	private static final Logger logger = LoggerFactory.getLogger(MonthOfYearValidator.class);

	public MonthOfYearValidator() {

	}

	public int getMonthOfTheYear(Backpack backpack) {

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(backpack.getDate());
		} catch (ParseException e) {
			logger.debug("Incorrect date format", e);
			return 0;
		}
		Calendar targetCalendar = Calendar.getInstance();
		targetCalendar.setTime(date);
		int targetMonth = targetCalendar.get(Calendar.MONTH);
		targetMonth++;
		return targetMonth;
	}
}
