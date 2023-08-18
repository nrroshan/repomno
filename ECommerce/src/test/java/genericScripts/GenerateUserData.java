package genericScripts;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class GenerateUserData {
	/*
	first_name
	last_name
	email
	mobile
	password
	company
	address1
	address2
	state
	city
	zipcode
	*/
	@Test
	public static void data()
	{
		Faker faker = new Faker();
		LinkedHashMap<String, String> details = new LinkedHashMap<String, String>();
		details.put("first_name", faker.name().firstName());
		details.put("last_name", faker.name().lastName());
		details.put("email", faker.internet().emailAddress());
		details.put("mobile", faker.number().digits(10));
		details.put("password", faker.internet().password(10, 15));
		details.put("company", faker.company().name());
		details.put("address1", faker.address().buildingNumber());
		details.put("address2", faker.address().streetAddress());
		details.put("country", "India");
		details.put("state", "Karnataka");
		details.put("city", "Bangalore");
		details.put("dd", String.valueOf(faker.number().numberBetween(1,28)));
		details.put("mm", "March");
		details.put("yyyy", String.valueOf(faker.number().numberBetween(1900, 2021)));
		details.put("zipcode", faker.number().digits(6));
		
//		System.out.println(details);
		
		HandlingDataFromPropertyFile.setData("./resources/register.properties", details);
	}
}
