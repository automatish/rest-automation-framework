package Test;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestNgTest {
	RestAssured assured;
	Response response;
	ExtentTest test;
	ExtentReports extentReports;
	TestNgTest localObject;
	String userDir;
	
	@BeforeSuite
	public void init(ITestContext context)
	{
		localObject=new TestNgTest();
		userDir=System.getProperty("user.dir")+"\\src\\test\\resources\\Report"+new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		
		extentReports=new ExtentReports(userDir+".html");
	}
  @Test
  public void s() throws IOException {
	  test=extentReports.startTest("TC01");
	  //Calling the GET API
	  response=RestAssured.get("http://jsonplaceholder.typicode.com/users");
	  
	  //Log the response in report file
	  test.log(LogStatus.INFO,"RESPONSE");
	  test.log(LogStatus.INFO,"<pre>"+ response.asString()+"</pre>");
	  
	  extentReports.endTest(test);

	  //logging the response in console
	  System.out.println("JSON response "+response.prettyPrint());  
	  
	  // Writing response in text file with timestamp
	  localObject.textFile(response);
  }
  @AfterSuite
  public void end()
  {
	  extentReports.flush();
	  extentReports.close();
  }
  public void textFile(Response response) throws IOException {
	  String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	  File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Response_"+timeStamp+".txt");
	  file.createNewFile();
	  FileWriter fileWriter=new FileWriter(file);
	  fileWriter.write(response.asString());
	  fileWriter.flush();
	  fileWriter.close();
  }
}
 