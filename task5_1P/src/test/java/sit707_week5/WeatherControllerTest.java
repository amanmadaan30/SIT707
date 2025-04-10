package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

	private static WeatherController wController;//setup wController as a class object so that it can be used by each method of the class
	// and does not require re-initialization
	private static double[] hourlyTemperatures;// add hourlyTemperatures and global variable to save time

	@Test
	public void testStudentIdentity() {
		String studentId = "224141207";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Aman Madaan";
		Assert.assertNotNull("Student name is null", studentName);
	}

	// using junit tag beforeClass so that initializing is done before any test runs and variables and
	// objects can be re-used
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("+++ Setting up WeatherController and retrieving hourly temperatures +++");
		// get instance is now called only once
		wController = WeatherController.getInstance();
		//nHours sets up total hours only once which can be reused by every method
		int nHours = wController.getTotalHours();
		hourlyTemperatures = new double[nHours];
		// since getTemperatureForHour has artificial delay, avoided calling it across every test
		// and setup hourlyTemperature array just once...
		for (int i = 0; i < nHours; i++) {
			hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("+++ Closing WeatherController +++");
		// avoided calling close function again and again and closing only after each test is run
		if (wController != null) {
			wController.close();
		}
	}
	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");

		// setup min temperature
		double minTemperature = 1000;
		//for each loop saves time and requires minimal initialization
		for (double temp : hourlyTemperatures) {
			if (minTemperature > temp) {
				minTemperature = temp;
			}
		}

		Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);

	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");

		double maxTemperature = -1;
		for (double temp : hourlyTemperatures) {
			if (maxTemperature < temp) {
				maxTemperature = temp;
			}
		}

		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");

		double sumTemp = 0;
		for (double temp : hourlyTemperatures) {
			sumTemp += temp;
		}
		double averageTemp = sumTemp / hourlyTemperatures.length;

		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
	}
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
