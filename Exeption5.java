package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exeption5 {
    void exeption1() throws FileNotFoundException, IOException  {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Username\\Desktop\\test.txt"));

            String firstString = reader.readLine();
            System.out.println(firstString);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Файл не найден!");
            e.printStackTrace();
        } finally {
            System.out.println("А вот и блок finally!");
        }

    }
    void colled(){
        try {
            // exeption();
            int i=1;
            if (i==1)
                throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    void printFirstString(String filePath) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String firstString = reader.readLine();
        System.out.println(firstString);
    }
}
