package RestTesting;

import org.junit.Before;
import org.testng.Assert;

public class diffjnuint {
	@Before
	public void BT() {
		String Name = "Malkeet";
		String SName = "Singh";
		Assert.assertEquals(SName, Name);
	}

}
