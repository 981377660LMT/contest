package on2021_07.on2021_07_12_Library_Checker.General_Weighted_Matching;

import net.egork.chelper.tester.NewTester;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!NewTester.test("src/test/java/on2021_07/on2021_07_12_Library_Checker/General_Weighted_Matching/General Weighted Matching.json"))
			Assert.fail();
	}
}