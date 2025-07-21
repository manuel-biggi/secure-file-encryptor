package com.securefileapp.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private final ExecutorService executor;

    public ThreadPool(int threads) {
        this.executor = Executors.newFixedThreadPool(threads);
    }

    public void submit(Runnable task) {
        executor.submit(task);
    }

    public void shutdown() {
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait
        }
    }
}
