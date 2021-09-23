package org.core.base;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Java8Date {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println("Today's date = " + today);

		System.out
				.println("Year :" + today.getYear() + " Month: " + today.getMonth() + " Day: " + today.getDayOfMonth());

		LocalDate date = LocalDate.of(2016, 2, 22);
		System.out.println("Converted date = " + date);

		LocalDate date1 = LocalDate.of(2016, 2, 22);
		if (date.equals(date1)) {
			System.out.println("Both the dates are equal: " + date + " - " + date1);
		}

		LocalTime time = LocalTime.now();
		System.out.println("Current time is: " + time + " \nAfter adding 2 hours: " + time.plusHours(2));

		LocalDate dateAfterWeek = today.plus(2, ChronoUnit.WEEKS);
		System.out.println("Week after 2 week: " + dateAfterWeek);

		LocalDate prevYear = today.minus(1, ChronoUnit.YEARS);
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Prev and next year: " + prevYear + " and " + nextYear);

		LocalDate tomorrow = LocalDate.now().plusDays(1);
		if (tomorrow.isAfter(today)) {
			System.out.println(tomorrow + " is after " + today);
		}

		ZoneId america = ZoneId.of("America/New_York");
		LocalDateTime todayTime = LocalDateTime.now();
		ZonedDateTime todayZonedTime = ZonedDateTime.of(todayTime, america);
		System.out.println("Zoned time America is: " + todayZonedTime);
		System.out.println("Zoned time here is: " + ZonedDateTime.now());

		System.out.println("Number of days between " + today + " and " + tomorrow + " is: "
				+ Period.between(today, tomorrow).getDays());

		Instant timeStamp = Instant.now();
		System.out.println("Today time stamp is: " + timeStamp);

		System.out.println("Today date time is: " + LocalDateTime.now());

		String todayString = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("Today in String: " + todayString);
		LocalDate todayDate = LocalDate.parse(todayString, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("Today in date: " + todayDate);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh:MM a");
		String dateFirmatString = LocalDateTime.now().format(formatter);
		System.out.println("Date in string format: " + dateFirmatString);
	}
}
