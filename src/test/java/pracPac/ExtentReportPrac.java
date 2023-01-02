package pracPac;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportPrac {
	ExtentTest test1 ;
	
	
	@Test
	public void extentTest()
	{		
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/report.html");
		spark.config().setDocumentTitle("Document title");
		spark.config().setReportName("reporter name");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser name", "chrome");
		
		test1 = report.createTest("create client");
		test1.info("this info is coming from client");
		test1.pass("pass");
		
		
		report.flush();
		
	}
	
	

}
