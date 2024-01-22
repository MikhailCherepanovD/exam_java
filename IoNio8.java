package org.example;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class IoNio8 {
    public static void main(String[] args) {
        try {
            RandomAccessFile aFile = new RandomAccessFile("text.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(100);
            int bytesRead = inChannel.read(buf);

            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        }
        catch (Exception e){

        }
    }


}
