package com.traveler.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.traveler.entities.Backpack;
import com.traveler.repository.Repository;

@ExtendWith(MockitoExtension.class)
public class ReservationControllerTest {

	@Mock
	private Repository repository;

	private TravelerController travelerController;

	@BeforeEach
	void init() {
		travelerController = new TravelerController();
		travelerController.setRepository(repository);
	}
	
	@Test
	void test_showForm_succes() {

		// act
		ModelAndView modelAndView = travelerController.showForm();

		// verify
		assertNotEquals(null, modelAndView);
		assertEquals(modelAndView.getViewName(), "calculationHome");
		assertEquals(modelAndView.getModelMap().containsKey("backpack"), true);
	}

	@Test
	void test_generateBackpack_succes() {

		// prepare
		ModelMap modelMap = new ModelMap();
		Backpack backpack = new Backpack();

		backpack.setDistance("distance");
		backpack.setBodyWeight("bodyWeight");
		backpack.setDate("date");

		// act
		String result = travelerController.generateBackpack(backpack, null, modelMap);

		// verify
		assertEquals("generateBackpack", result);
		assertEquals(modelMap.get("distance"), "distance");
		assertEquals(modelMap.get("bodyWeight"), "bodyWeight");
		assertEquals(modelMap.get("date"), "date");
	}

	@Test
	void test_cancel_succes() {

		// prepare
		ModelMap modelMap = new ModelMap();
		Backpack reservation = new Backpack();

		// act
		String result = travelerController.cancel(reservation, null, modelMap);

		// verify
		assertEquals("calculationHome", result);
		assertEquals(modelMap.get("message"), "You clicked cancel, please re-enter details:");
	}

	@Test
	void test_submit_succes() {

		// prepare
		ModelMap modelMap = new ModelMap();
		Backpack backpack = new Backpack();
		when(repository.generateBackpack(any(Backpack.class))).thenReturn(backpack);

		// act
		String result = travelerController.submit(backpack, null, modelMap);

		// verify
		assertEquals("showBackpack", result);
		verify(repository).generateBackpack(any(Backpack.class));
	}
	
	@Test
	void test_submit_error() {

		// prepare
		ModelMap modelMap = new ModelMap();
		Backpack backpack = new Backpack();

		// act
		String result = travelerController.submit(backpack, null, modelMap);

		// verify
		assertEquals("error", result);
		verify(repository).generateBackpack(any(Backpack.class));
	}
}
