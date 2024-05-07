package multiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MultiThreading multiThreading = new MultiThreadingIml(4);

        int factorial = multiThreading.factorial(10);
        System.out.println(factorial);
        System.out.println("————————————");

        int[] SimpleNumbers = multiThreading.getSimpleNumbers(multiThreading.getRandomArray());
        System.out.println(Arrays.toString(SimpleNumbers));
        System.out.println("————————————");

        int threadsNum = 4;
        int incrementsSteps = 1000;
        List<Thread> threads = new ArrayList<>();
        AtomicCounter atomicCounter = new AtomicCounter();


        for (int i = 0; i < threadsNum; i++) {
            var thread = new Thread(() -> {
                for (int j = 0; j < incrementsSteps / threadsNum; j++) {
                    atomicCounter.increment();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int result = atomicCounter.getResult();

        System.out.println(result);
    }
}
