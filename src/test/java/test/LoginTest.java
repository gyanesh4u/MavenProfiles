package test;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test
	public void loginTest() {

		  System.out.println("Executing testSuccessfulLogin on " + browser + " in " + env + " environment.");
			String title = driver.getTitle();
		  System.out.println(title);
	}
}
