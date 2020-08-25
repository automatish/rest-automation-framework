
package restOperations;

import basePackage.BaseClass;
import helper.LogRequestResponseInfo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class is to perform "GET" operation
 *
 */
public class PerformGet {

	private static Response response;

	public static void performGet(final BaseClass baseClass) {
		RequestSpecification request = RestAssured.given().baseUri(baseClass.getBaseUri());
		LogRequestResponseInfo.logRequestInfo(baseClass);
		if(baseClass.getPathParams() != null)
		{
			response = request.headers(baseClass.getRequestHeaders()).pathParams(baseClass.getPathParams()).get(baseClass.getEndPoint());
		}
		else
		{
			response = request.headers(baseClass.getRequestHeaders()).get(baseClass.getEndPoint());
		}
		baseClass.setResponseCode(response.getStatusCode());
		baseClass.setJsonResponse(response.asString());
		LogRequestResponseInfo.logResponseInfo(response);
	}
}
