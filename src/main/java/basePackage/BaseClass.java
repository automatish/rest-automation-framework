package basePackage;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import helper.RequestResources;
import restOperations.PerformGet;

public class BaseClass extends RequestResources {

	private static Logger log = LogManager.getLogger(BaseClass.class.getName());

	public BaseClass() {
		BasicConfigurator.configure();
		log.info("-----Baseclass Initialized-----");
		return;
	}

	public void performGet() {
		PerformGet.performGet(this);
	}

	public void performPost() {

	}
}