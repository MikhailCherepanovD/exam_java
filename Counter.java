package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.String.format;
public class Counter {
    public Double count(double a) {
        for (int i = 0; i < 1000000; i++) {
            a = a + Math.tan(a);
        }

        return a;
    }

    public static void main1(String[] args) {
        Counter counter = new Counter();

        long start = System.nanoTime();

        double value = 0;
        for (int i = 0; i < 400; i++) {
            value += counter.count(i);
        }

        System.out.printf("Executed by %d s, value : %f%n",
                (System.nanoTime() - start) / (1000_000_000),
                value);
    }













    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(8);                 // создаем пул потоков 8 штук
        Counter counter = new Counter();

        long start = System.nanoTime();

        List<Future<Double>> futures = new ArrayList<>();
    /*
    future<T> - интерфейс


    public interface Future<V> {
    boolean cancel(boolean var1);

    cancel(boolean mayInterruptIfRunning):
    Позволяет отменить выполнение задачи. mayInterruptIfRunning определяет, должен ли поток быть прерван, если задача уже выполняется.

    boolean isCancelled();

    boolean isDone();                      //Позволяет проверить, завершена ли асинхронная операция. Возвращает true, если операция завершена.

    V get() throws InterruptedException, ExecutionException;

    V get(long var1, TimeUnit var3) throws InterruptedException, ExecutionException, TimeoutException;

    Double result = futureResult.get(); - поток, вызвавший метод get из объекта реализующего интерфейс future,
    будет заблокирован до завершения операции
    }
    */
        for (int i = 0; i < 400; i++) {
            final int j = i;
            futures.add(
                    CompletableFuture.supplyAsync(
                            () -> counter.count(j),
                            threadPool
                    ));
        }

        double value = 0;
        for (Future<Double> future : futures) {
            value += future.get();
        }

        System.out.println(format("Executed by %d s, value : %f",
                (System.nanoTime() - start) / (1000_000_000),
                value));

        threadPool.shutdown();
    }


}