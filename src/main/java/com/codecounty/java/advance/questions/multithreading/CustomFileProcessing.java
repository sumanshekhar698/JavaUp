package com.codecounty.java.advance.questions.multithreading;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CustomFileProcessing {

    private static int MAX_T = 2;

    public static void main(String[] args) {


        HashMap<String, File> map = gatherFiles();
        // creates a thread pool with MAX_T no. of

        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        for (Map.Entry<String, File> entry : map.entrySet()) {
            FileProcessor fileProcessor = new FileProcessor(entry.getValue());
            pool.execute(fileProcessor);
        }

        // pool shutdown (Step 4)
//        pool.shutdown();

        // ADDED Initiate graceful shutdown logic
//        pool.shutdown();

        try {
            // Wait for a reasonable time for tasks to finish
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {//Assumint in 60 seconds my file processing will be done
                // If some tasks are still running, attempt a forceful shutdown
                pool.shutdownNow(); // Interrupts running tasks
                // Wait for tasks to respond to interruption
                if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException e) {
            // Handle interruption during shutdown
            pool.shutdownNow();
            Thread.currentThread().interrupt(); // Preserve interrupt status
        }

    }

    static class FileProcessor implements Runnable {


        private File currFile;

        public FileProcessor(File currFile) {
            this.currFile = currFile;
        }

        @Override
        public void run() {
            //TextLineProcessor map.get(currFile);
        }
    }


    static HashMap<String, File> gatherFiles() {//TODO file gathering
        HashMap<String, File> map = new HashMap<>();
        return map;
    }

}
