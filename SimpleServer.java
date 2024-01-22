package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен. Ожидание подключения...");

            // Ожидаем подключения клиента
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключен.");

            // Получаем входной и выходной потоки для обмена данными с клиентом
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Ждем сообщение от клиента и отвечаем на него
            String clientMessage = reader.readLine();
            System.out.println("Клиент: " + clientMessage);

            // Отправляем ответ клиенту
            writer.println("Привет, это сервер!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}