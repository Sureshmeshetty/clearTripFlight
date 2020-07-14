package steps;

import org.apache.log4j.Logger;

import com.clearTrip.utils.BaseClasss;
import cucumber.api.java.Before;

public class BeforeActions  {
	static Logger logger = Logger.getLogger(AfterActions.class);

	@Before
    public static void setUp() {
		logger.info("Before");
		BaseClasss.setUpDriver();
    }
}
