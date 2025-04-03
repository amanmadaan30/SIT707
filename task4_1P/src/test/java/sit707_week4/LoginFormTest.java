package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

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
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	

	@Test
	public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login(null, "wrongPass");
		Assert.assertFalse("Login should fail due to empty username", status.isLoginSuccess());
	}

	@Test
	public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login(null, "testPass");
		Assert.assertFalse("Login should fail due to empty username", status.isLoginSuccess());
	}

	@Test
	public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("wrongUser", null);
		Assert.assertFalse("Login should fail due to wrong username", status.isLoginSuccess());
	}

	@Test
	public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("wrongUser", "wrongPass");
		Assert.assertFalse("Login should fail due to wrong username", status.isLoginSuccess());
	}

	@Test
	public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("wrongUser", "testPass");
		Assert.assertFalse("Login should fail due to wrong username", status.isLoginSuccess());
	}

	@Test
	public void testFailCorrectUsernameAndEmptyPasswordAndEmptyValCode() {
		LoginStatus status = LoginForm.login("testUser", null);
		Assert.assertFalse("Login should fail due to empty password", status.isLoginSuccess());
	}

	@Test
	public void testFailCorrectUsernameAndWrongPasswordAndEmptyValCode() {
		LoginStatus status = LoginForm.login("testUser", "wrongPass");
		Assert.assertFalse("Login should fail due to wrong password", status.isLoginSuccess());
	}

	@Test
	public void testFailCorrectUsernameAndCorrectPasswordAndWrongValCode() {
		LoginStatus status = LoginForm.login("testUser", "testPass");
		boolean isValidCode = LoginForm.validateCode("000000");
		//status.setValidationCode("wrongCode"); // Assuming validation code is checked elsewhere
		Assert.assertFalse(isValidCode);
	}

	@Test
	public void testSuccessCorrectUsernameAndCorrectPasswordAndCorrectValCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");

		//status.Vali("correctCode"); // Assuming validation code is checked elsewhere
		Assert.assertTrue("Login should be successful", status.isLoginSuccess());
		boolean isValidCode = LoginForm.validateCode("123456");
		Assert.assertTrue(isValidCode);
	}
}
