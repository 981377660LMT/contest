package on2021_01.on2021_01_22_Luogu.P6243__USACO06OPEN_The_Milk_Queue_G;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import chelper.ExternalExecutor;
import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import template.rand.RandomWrapper;

public class P6243USACO06OPENTheMilkQueueGTestCase {
    @TestCase
    public Collection<Test> createTests() {
        RandomWrapper.INSTANCE.getRandom().setSeed(0);
        List<Test> tests = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("build  testcase " + i);
            tests.add(create(i));
        }
        return tests;
    }

    private void printLine(StringBuilder builder, int... vals) {
        for (int val : vals) {
            builder.append(val).append(' ');
        }
        builder.append('\n');
    }

    private void printLine(StringBuilder builder, long... vals) {
        for (long val : vals) {
            builder.append(val).append(' ');
        }
        builder.append('\n');
    }

    private <T> void printLineObj(StringBuilder builder, T... vals) {
        for (T val : vals) {
            builder.append(val).append(' ');
        }
        builder.append('\n');
    }

    RandomWrapper random = new RandomWrapper(0);

    public Test create(int testNum) {
        int n = random.nextInt(1, 5);
        StringBuilder in = new StringBuilder();
        printLine(in, n);
        for (int i = 0; i < n; i++) {
            printLine(in, random.nextInt(1, 10), random.nextInt(1, 10));
        }
        String ans = new ExternalExecutor("F:\\geany\\main.exe").invoke(in.toString());
        return new Test(in.toString(), ans);
    }
}
