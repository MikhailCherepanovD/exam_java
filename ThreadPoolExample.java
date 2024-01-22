package org.example;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Создаем пул потоков с фиксированным количеством потоков (например, 5)
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Передаем задачи на выполнение
        for (int i = 0; i < 10; i++) {
            // Создаем объект Runnable (задача для выполнения в отдельном потоке)
            Runnable task = new MyTask(i);

            // Передаем задачу в пул потоков
            executor.execute(task);
        }

        // Завершаем работу пула потоков после выполнения всех задач
        executor.shutdown();
    }
}

// Пример задачи, реализующей интерфейс Runnable
class MyTask implements Runnable {
    private int taskId;

    public MyTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task ID : " + taskId + " выполнена потоком : " + Thread.currentThread().getName());
    }
}