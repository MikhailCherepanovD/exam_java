package org.example;
import java.util.concurrent.Semaphore;

class ReaderWriterProblem {
    Semaphore mutex = new Semaphore(1);
    Semaphore writeBlock = new Semaphore(1);
    int readCount = 0;

    void startReading() throws InterruptedException {
        mutex.acquire();
        readCount++;
        if (readCount == 1) {
            writeBlock.acquire();      // блокируем запись
        }
        mutex.release(); // разрешаем другим читателям читать

        // Reading...

        System.out.println("Reader is reading. Readers count: " + readCount);

        mutex.acquire();
        readCount--;
        if (readCount == 0) {
            writeBlock.release();// разрешаем запись
        }
        mutex.release();
    }

    void startWriting() throws InterruptedException {
        writeBlock.acquire();

        // Writing...

        System.out.println("Writer is writing.");

        writeBlock.release();
    }
}

class Reader implements Runnable {
    ReaderWriterProblem problem;

    Reader(ReaderWriterProblem problem) {
        this.problem = problem;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000); // Simulating reading time
                problem.startReading();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Writer implements Runnable {
    ReaderWriterProblem problem;

    Writer(ReaderWriterProblem problem) {
        this.problem = problem;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000); // Simulating writing time
                problem.startWriting();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


