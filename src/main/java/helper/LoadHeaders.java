package helper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import basePackage.BaseClass;


/**
 * This class loads headers from config file in src/test/resources folder
 *
 */
public class LoadHeaders {

	private static final String configFilePath = "src/test/resources/config/requestData.conf";
	private static final String headerKey = "Content-Type";
	private Map<String, Object> headerMap = new HashMap<>();

	public Map<String, Object> loadHeadersFromConfig(BaseClass baseClass) {
		Config config = ConfigFactory.parseFile(new File(configFilePath));
		headerMap.put(headerKey, config.getConfig("headers").getString(headerKey));
		return headerMap;
	}
}
