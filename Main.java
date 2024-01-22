package org.example;


class Parent {
    int parentField = 1;

    public Parent() {
        describe();
    }

    void describe() {
        System.out.print("Parent field = " + parentField);
    }
}

class Child extends Parent {
    int childField = 1;

    void describe() {
        super.describe();
        System.out.print(" | Child field = " + childField);
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
    }
}