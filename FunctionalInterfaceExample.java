package org.example;

@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod();
}
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Используем лямбда-выражение для создания объекта MyFunctionalInterface
        MyFunctionalInterface myFunctionalInterface = () -> {
            System.out.println("Выполняется myMethod");
        };

        // Вызываем метод из функционального интерфейса
        myFunctionalInterface.myMethod();
    }
}