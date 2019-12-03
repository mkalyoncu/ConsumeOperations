package com.prisync;

import com.prisync.consumer.Worker;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {

    public Main() throws IOException, TimeoutException {
        Worker firstWorker = new Worker();
        Worker secondWorker = new Worker();
        Thread firstThread = new Thread(firstWorker);
        Thread secondThread = new Thread(secondWorker);
        firstThread.start();
        secondThread.start();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
