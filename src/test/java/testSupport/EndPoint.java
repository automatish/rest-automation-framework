package testSupport;

//We use this class to save our endpoints at a common place
public interface EndPoint {

	public static final String booksEndpoint = "/BookStore/v1/Books";
	
	public static final String purchaseOrder = "/store/order/{orderId}";
	
//	http://bookstore.toolsqa.com
//	https://petstore.swagger.io/v2

}
