package on2019_10.on2019_10_27_abc144.TaskC;

import net.egork.chelper.tester.NewTester;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!NewTester.test("src/test/java/on2019_10/on2019_10_27_abc144/TaskC/TaskC.json"))
			Assert.fail();
	}
}