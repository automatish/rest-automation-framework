package helper;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.typesafe.config.Config;

import basePackage.BaseClass;

public abstract class RequestResources extends ApiResponseData {

	private static Logger log = Logger.getLogger(RequestResources.class.getName());

	private JSONObject requestBody;
	private String basePath = "";
	private String baseUri = "";
	private String endPoint = "";
	private Map<String, Object> pathParams = new HashMap<>();
	private Map<String, Object> queryParams = new HashMap<>();
	private Map<String, Object> requestHeaders;

	public Map<String, Object> getPathParams() {
		return pathParams;
	}

	public void setPathParams(String key, Object value) {
		this.pathParams.put(key, value);
	}

	public Map<String, Object> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Map<String, Object> queryParams) {
		this.queryParams = queryParams;
	}

	public Map<String, Object> getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(final BaseClass baseClass) {
		this.requestHeaders = new LoadHeaders().loadHeadersFromConfig(baseClass);
	}

	public void setEndPoint(String endpoint) {
		this.endPoint = endpoint;
		log.info("Endpoint set");
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
		log.info("BaseURI set");
	}

	public String getEndPoint() {
		return this.endPoint;
	}

	public String getBasePath() {
		return this.basePath;
	}

	public String getBaseUri() {
		return this.baseUri;
	}

	public JSONObject getRequestBody() {
		return requestBody;
	}

	public void loadRequestPayload(String fileName) {
		String payloadFolderPath = "src/test/resources/payload/";
		try {
			FileReader inputStream = new FileReader(payloadFolderPath + fileName);

			JSONObject object = (JSONObject) new JSONParser().parse(inputStream);

			this.requestBody = object;

			// System.out.println("Request payload is: \n"
			// + new
			// org.json.JSONObject(requestResources.getRequestBody().toString()).toString(4));

			inputStream.close();
		} catch (Exception e) {

			log.error(e.getMessage());
		}
	}
	
	
}
