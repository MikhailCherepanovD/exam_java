package org.example;

import java.util.concurrent.Callable;

public class Lambda17 {
    public static void main(String[] args)throws Exception   {

        Thread t = new Thread(() -> System.out.println("Hello world!"));
        t.start();
        Callable<Integer> c = () -> 42;
        Integer result = c.call();

        // Выводим результат
        System.out.println("Результат: " + result);
    }
}
