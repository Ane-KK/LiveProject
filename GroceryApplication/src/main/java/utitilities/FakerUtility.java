package utitilities;

import com.github.javafaker.Faker;

public class FakerUtility {

	Faker faker=new Faker();
	public String createRandomUserName()
	{
		return faker.name().username();
	}
	
	public String createRandomPassword()
	{
		return faker.internet().password();
	}

	
	public String createRandomEmail()
	{
		return faker.internet().emailAddress();
	}
	
	public String createRandomFullname()
	{
		return faker.name().fullName();
	}
	
	public String createRandomAddress()
	{
		return faker.address().fullAddress();
		
	}
}



