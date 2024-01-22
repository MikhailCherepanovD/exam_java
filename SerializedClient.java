package org.example;
import java.io.*;
import java.net.Socket;

public class SerializedClient {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1";
        final int SERVER_PORT = 12345;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            // Получаем входной и выходной потоки для обмена данными с сервером
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            // Создаем объект сообщения и отправляем его серверу
            Message clientMessage = new Message("Привет, это клиент!");
            objectOutputStream.writeObject(clientMessage);

            // Ждем ответа от сервера и выводим его
            try {
                Message serverResponse = (Message) objectInputStream.readObject();
                System.out.println("Сервер: " + serverResponse.getContent());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
