package on2021_07.on2021_07_07_Library_Checker.Matching_on_General_Graph;

import net.egork.chelper.tester.NewTester;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!NewTester.test("src/test/java/on2021_07/on2021_07_07_Library_Checker/Matching_on_General_Graph/Matching on General Graph.json"))
			Assert.fail();
	}
}
