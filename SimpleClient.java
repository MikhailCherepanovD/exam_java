package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1";
        final int SERVER_PORT = 12345;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            // Получаем входной и выходной потоки для обмена данными с сервером
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Отправляем сообщение серверу
            writer.println("Привет, это клиент!");

            // Ждем ответа от сервера и выводим его
            String serverResponse = reader.readLine();
            System.out.println("Сервер: " + serverResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}