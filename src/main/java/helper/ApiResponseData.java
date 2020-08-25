package helper;

import io.restassured.path.json.JsonPath;

public abstract class ApiResponseData {

	private int responseCode;
	private String jsonResponse = "";

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public void setJsonResponse(String jsonResponse) {
		this.jsonResponse = jsonResponse;
	}

	public JsonPath getJsonResponse() {
		return JsonPath.from(this.jsonResponse);
	}
}
