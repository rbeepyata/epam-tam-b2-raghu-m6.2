package com.ryanair.tests;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ryanair.pages.AbstractBasePage;
import com.ryanair.pages.HomePage;
import com.ryanair.pages.SearchResultPage;
import com.tam.builder.flights.businessobject.FlightSchedule;
import com.tam.singleton.webdriver.Driver;

public class FlightsTests {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = Driver.getInstance();
		AbstractBasePage.initBasePage(driver);
		driver.manage().window().maximize();
	}

	@Test
	public void testFlights() throws InterruptedException {

		HomePage homePage = new HomePage();
		
		homePage.open();
		Assert.assertEquals(driver.getTitle(),
				"Official Ryanair website | Book direct for the lowest fares | Ryanair.com");

		
		FlightSchedule schedule = new FlightSchedule.Builder()
				.fromCountry(" Belgium")
				.fromAirport("Brussels Charleroi")
				.toCountry(" United Kingdom")
				.toAirport("Manchester")
				.build();
		
		System.out.println(schedule.getFromCountry());
		System.out.println(schedule.getFromAirport());		
		System.out.println(schedule.getToCountry());
		System.out.println(schedule.getToAirport());
		
		homePage.selectFromCountry(schedule.getFromCountry())
				.selectFromAirport(schedule.getFromAirport());
		Assert.assertEquals(homePage.getSelectedFromValue(), "Brussels Charleroi");

		homePage.selectToCountry(schedule.getToCountry())
				.selectToAirport(schedule.getToAirport());
		Assert.assertEquals(homePage.getSelectedToValue(), "Manchester");

		// Mechanism to choose random dates
		LocalDate startingDate = LocalDate.of(java.time.LocalDateTime.now().getYear(),
				java.time.LocalDateTime.now().getMonthValue(), java.time.LocalDateTime.now().getDayOfMonth());
		long start = startingDate.toEpochDay();
		LocalDate endingDate = LocalDate.of(java.time.LocalDateTime.now().getYear(),
				java.time.LocalDateTime.now().getMonthValue() + 7, java.time.LocalDateTime.now().getDayOfMonth()); 
		long end = endingDate.toEpochDay();
		long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
		long randomEpochDay2 = ThreadLocalRandom.current().longs(randomEpochDay, end).findAny().getAsLong();
		String startDate = LocalDate.ofEpochDay(randomEpochDay).getDayOfMonth() + "";
		String toDate = LocalDate.ofEpochDay(randomEpochDay2).getDayOfMonth() + "";
		String startMonth = LocalDate.ofEpochDay(randomEpochDay).getMonth().name();
		String toMonth = LocalDate.ofEpochDay(randomEpochDay2).getMonth().name();

		homePage.selectFromCalendar(startDate, startMonth)
				.selectFromCalendar(toDate, toMonth)
				.addTeen();
		SearchResultPage searchResultPage = homePage.search();
		Assert.assertTrue(searchResultPage.isFlightDisplayed());
		
		String startResultDate = searchResultPage.startResultDateText().toLowerCase();
		Assert.assertTrue(
				startResultDate.toLowerCase().contains((startDate + " " + startMonth.substring(0, 3)).toLowerCase()));

		String endResultDate = searchResultPage.endResultDateText().toLowerCase();
		Assert.assertTrue(endResultDate.toLowerCase().contains((toDate + " " + toMonth.substring(0, 3)).toLowerCase()));
		searchResultPage.printFlightDetails();

		System.out.println("Test Completed...");
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
