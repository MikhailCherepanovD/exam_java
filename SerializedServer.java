package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

public class SerializedServer {
    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен. Ожидание подключения...");

            // Ожидаем подключения клиента
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключен.");

            // Получаем входной и выходной потоки для обмена данными с клиентом
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

            // Ждем объект сообщения от клиента и отвечаем на него
            try {
                Message clientMessage = (Message) objectInputStream.readObject();
                System.out.println("Клиент: " + clientMessage.getContent());

                // Отправляем ответ клиенту
                Message serverResponse = new Message("Привет, это сервер!");
                objectOutputStream.writeObject(serverResponse);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
