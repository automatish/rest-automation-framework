package helper;

import java.util.Map;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.*;
import basePackage.BaseClass;
import io.restassured.response.Response;

/**
 * This class is used to display request specification on the console
 *
 */
public class LogRequestResponseInfo {

	private static Logger logger = LogManager.getLogger(LogRequestResponseInfo.class);
	private static String endpoint = "";

	public static void logRequestInfo(BaseClass baseClass) {

		endpoint = baseClass.getEndPoint();
		// logger.info("Request URL: " + baseClass.getBaseUri() +
		// baseClass.getBasePath() + baseClass.getEndPoint());
		try {
			if (baseClass.getPathParams() != null) {
				logger.info("-----Path Paramaters-----");
				for (Map.Entry<String, Object> pathParams : baseClass.getPathParams().entrySet()) {
					if (baseClass.getEndPoint().contains(pathParams.getKey().toString())) {
						endpoint = endpoint.replaceAll(pathParams.getKey(), pathParams.getValue().toString());
						endpoint = endpoint.replace("{", "");
						endpoint = endpoint.replace("}", "");
					}
					logger.info("\t" + pathParams.getKey() + " = " + pathParams.getValue());
				}
			}

			if (baseClass.getQueryParams() != null) {
				logger.info("-----Query Paramaters-----");
				for (Map.Entry<String, Object> queryParams : baseClass.getQueryParams().entrySet()) {
					logger.info(queryParams.getKey() + " = " + queryParams.getValue());
				}
			}
			if (baseClass.getRequestHeaders() != null) {
				logger.info("-----Headers-----");
				for (Map.Entry<String, Object> headers : baseClass.getRequestHeaders().entrySet()) {
					logger.info("\t" + headers.getKey() + " = " + headers.getValue());
				}
			}

			logger.info("Request URL: " + baseClass.getBaseUri() + baseClass.getBasePath() + endpoint);
		} catch (Exception e) {
			return;
		}
	}
	
	public static void logResponseInfo(Response response) {

		try {
			logger.info(response.getStatusLine());
			logger.info(response.getHeaders());
			logger.info("Response:\n" + new JSONObject(response.asString()).toString(4));
		} catch (Exception e) {
			return;
		}
	}
}
