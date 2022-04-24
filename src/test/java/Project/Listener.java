package Project;

import org.apache.logging.log4j.core.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	// Creating an Object of baseTest Class to Access Log
	baseTest b = new baseTest();
	Logger log = (Logger) b.log;

	//ADDING THE LOGGER INFO,ERROR MESSAGES TO INDICATE LOGGER MESSAGES
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("The Method " + result.getName() + " has been Succesfull");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.error("The Method " + result.getName() + " has Failed");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

		log.info("The Method " + context.getName() + " has been Started");

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("The Method " + context.getName() + " has been Completed");

	}

}
