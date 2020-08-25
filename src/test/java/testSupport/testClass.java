package testSupport;

import basePackage.BaseClass;

public class testClass {
	
	public BaseClass baseClass;
	
	public void test()
	{
		baseClass.setBaseUri("https://bookstore.toolsqa.com");
		baseClass.setEndPoint("/BookStore/v1/Books");
		baseClass.performGet();
		baseClass.getJsonResponse();
	}

}
