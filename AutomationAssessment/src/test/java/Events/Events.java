package Events;
import locators.WebElements;
import utils.DriverFactory;

public class Events {

	public static WebElements element()
	{
		return new WebElements(DriverFactory.initDriver("chrome"));

	}

	public static void pageEvents()
	{

	}


}
