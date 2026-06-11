package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	String methodname = result.getMethod().getMethodName();
	System.out.println(methodname+"----started");	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"----success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"----failed");
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		String screenshotname = methodname+" "+jutil.toGenerateSystemDateAndTimeInformat();
		try {
			wutil.toTakeScreeshot(BaseClass.sDriver, screenshotname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"----skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("-----Suite Execution started ");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("--------Suite execution finished ");	
	}
	
	
	
	

}
