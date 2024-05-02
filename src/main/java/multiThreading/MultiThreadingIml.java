package multiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class MultiThreadingIml implements MultiThreading {

    ArrayList<Integer> randomArray = new ArrayList<>();
    int threadsNum;
    int chunkSize;
    ExecutorService exec;

    public MultiThreadingIml (int threadsNum) {
        this.threadsNum = threadsNum;
        randomArray.addAll(createRandomIntArray(100));
        System.out.println(randomArray);
        chunkSize = randomArray.size()/threadsNum;
        exec = Executors.newFixedThreadPool(threadsNum);
    }
    @Override
    public ArrayList<Integer> getRandomArray() {
        return randomArray;
    }

    private ArrayList<Integer> createRandomIntArray (int length) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array.add(random.nextInt());
        }

        return array;
    }

    private int[][] divideIntoSubArrays(int N, int[] array) {
        // Each bucket has the size (which is not a whole number)
        float bucketSize = array.length / (float) N;
        System.out.println("Bucket size is "+ bucketSize);

        int[][] result = new int[N][];

        for (int currentBucket = 0; currentBucket < N; currentBucket++) {
            // In this bucket are all the values from currentBucket * bucketSize up to currentBucket * bucketSize + bucketSize
            result[currentBucket] = Arrays.copyOfRange(array, (int) Math.ceil(currentBucket * bucketSize), (int) Math.ceil(currentBucket * bucketSize + bucketSize));
        }

        return result;
    }

    @Override
    public int factorial(int n) {
        Future<Integer>[] futures = new Future[threadsNum];

        int[] arr = IntStream.rangeClosed(1, n).toArray();
        final int[][] splitArr = divideIntoSubArrays(threadsNum, arr);

        for (int i = 0; i < threadsNum; i++) {
            int finalI = i;
            futures[i] = exec.submit(() -> {
                int [] subArr = splitArr[finalI];
                int result = 1;

                for (int k : subArr) {
                    result *= k;
                }

                return result;
            });
        }
        int result = 1;

        for (Future<Integer> future: futures) {
            try {
                result *= future.get();
            } catch ( InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int[] getSimpleNumbers(ArrayList<Integer> intArray) {
        Future<int[]>[] futures = new Future[threadsNum];
        int[] array = new int[intArray.size()];

        for (int i = 0; i < intArray.size(); i++) {
            array[i] = intArray.get(i);
        }

        final int[][] splitArr = divideIntoSubArrays(threadsNum, array);

        for (int i = 0; i < threadsNum; i++) {
            int finalI = i;

            futures[i] = exec.submit(() -> Arrays.stream(splitArr[finalI]).filter(this::isPrime).toArray());
        }

        int[] resultArray = new int[0];

        for (Future<int[]> future: futures) {
            try {
                int[] mergedArray = new int[resultArray.length + future.get().length];

                System.arraycopy(resultArray, 0, mergedArray, 0, resultArray.length);
                System.arraycopy(future.get(), 0, mergedArray, resultArray.length, future.get().length);

                resultArray = mergedArray;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return resultArray;
    }
}
