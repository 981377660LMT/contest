package on2020_02.on2020_02_27_Kotlin_Heroes__Episode_3.B__Cartoons;

import net.egork.chelper.tester.NewTester;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!NewTester.test("src/test/java/on2020_02/on2020_02_27_Kotlin_Heroes__Episode_3/B__Cartoons/B. Cartoons.json"))
			Assert.fail();
	}
}
