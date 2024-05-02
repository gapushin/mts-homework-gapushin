package multiThreading;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MultiThreading multiThreading = new MultiThreadingIml(4);

        int factorial = multiThreading.factorial(10);
        System.out.println(factorial);
        System.out.println("————————————");

        int[] SimpleNumbers = multiThreading.getSimpleNumbers(multiThreading.getRandomArray());
        System.out.println(Arrays.toString(SimpleNumbers));
        System.out.println("————————————");


        AtomicCounter atomicCounter = new AtomicCounter(4);
        int count = atomicCounter.incrementWith(1000);
        System.out.println(count);
    }
}
