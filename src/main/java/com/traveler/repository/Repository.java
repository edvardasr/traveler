package com.traveler.repository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.traveler.entities.Backpack;
import com.traveler.utils.MonthOfYearValidator;

@Component
public class Repository {

	private static final String FOOD_ITEMS = "FoodItems";

	private static final String ITEMS_SUMMER = "ItemsSummer";

	private static final String ITEMS_SPRING = "ItemsSpring";

	private static final String ITEMS_WINTER = "ItemsWinter";

	private static final String ITEMS_AUTUMN = "ItemsAutumn";

	private static final String VASARA = "Vasara";

	private static final String PAVASARIS = "Pavasaris";

	private static final String �IEMA = "�iema";

	private static final String RUDUO = "Ruduo";

	private static final Logger logger = LoggerFactory.getLogger(Repository.class);

	private static final String AUTUMN = "09, 10, 11";
	private static final String WINTER = "12, 01, 02";
	private static final String SPRING = "03, 04, 05";
	private static final String SUMMER = "06, 07, 08";

	@Autowired
	private MonthOfYearValidator validator;

	public Repository() {

	}

	public Backpack generateBackpack(Backpack backpack) {

		int month = validator.getMonthOfTheYear(backpack);
		if (backpack.getDate() == null || backpack.getDistance() == null || backpack.getBodyWeight() == null
				|| month == 0) {
			return null;
		}

		Double distance = null;
		Double bodyWeight = null;
		try {
			distance = Double.valueOf(backpack.getDistance());
			bodyWeight = Double.valueOf(backpack.getBodyWeight());
		} catch (Exception e) {
			return null;
		}

		File file = null;
		if (AUTUMN.contains(String.valueOf(month))) {
			file = FileUtils.toFile(getClass().getClassLoader().getResource(ITEMS_AUTUMN));
			backpack.setTimeOfYear(RUDUO);
		} else if (WINTER.contains(String.valueOf(month))) {
			file = FileUtils.toFile(getClass().getClassLoader().getResource(ITEMS_WINTER));
			backpack.setTimeOfYear(�IEMA);

		} else if (SPRING.contains(String.valueOf(month))) {
			file = FileUtils.toFile(getClass().getClassLoader().getResource(ITEMS_SPRING));
			backpack.setTimeOfYear(PAVASARIS);

		} else if (SUMMER.contains(String.valueOf(month))) {
			file = FileUtils.toFile(getClass().getClassLoader().getResource(ITEMS_SUMMER));
			backpack.setTimeOfYear(VASARA);

		}

		try {
			backpack.setPersonalBelongings(FileUtils.readLines(file, StandardCharsets.UTF_8));
			file = FileUtils.toFile(getClass().getClassLoader().getResource(FOOD_ITEMS));
			backpack.setFoodItems(FileUtils.readLines(file, StandardCharsets.UTF_8));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		Double requiredWater = distance * 0.06;
		Double requiredCalories = 0.048 * (bodyWeight * 2.2) * (distance / 7) * 60;

		requiredCalories = Math.round(requiredCalories * 100.0) / 100.0;
		requiredWater = Math.round(requiredWater * 100.0) / 100.0;
		backpack.setRequiredCalories(requiredCalories);
		backpack.setRequiredWater(requiredWater);

		return backpack;
	}
}