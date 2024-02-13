package com.sumanshekhar.java.lld;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;


// Assuming the proprietary library is available
//import com.acme.ai.DataProcessor;

public class FileProcessorSL4J {

    /*
    * Machine Coding

1. Client will dump one or more files in a shared directory
2. Each file has the following format:
    - Each line in the file should be considered as an instruction that should be read in the form of a string
    - Each line will terminate with a LF (\n)
    - Each line when processing may result in some error

3. Client has provided us with a proprietary custom library that is capable of processing each line passed in.
    - The library API has the following class that should be invoked
        -- boolean com.acme.ai.DataProcessor#parse(String)
    - Each invocation of the parse method takes around 1 second to complete


4. The client would like you to process the files at the fastest speed possible and provide the logs as output
    Logformat: fileName - true: <count>; false: <count>; failed: <count>
    * */


    private static final String SHARED_DIRECTORY = "C:\\Users\\suman\\Downloads\\code\\Java\\JDK8lessons\\src\\main\\resources\\lld\\files";
    private static final String LOG_FILE_PATH = "src/main/resources/lld/log0.txt"; // Specify log file path

    /*slf4j-api: Provides the basic API for logging.
      logback-classic: A popular SL4J implementation that supports various output destinations.*/
    private static final  Logger sl4JLogger = LoggerFactory.getLogger(FileProcessor.class);
    private static final DataProcessor dataProcessor = DataProcessor.getInstance(); // Assuming singleton


    public static void main(String[] args) {
//        try {
//            FileHandler handler = new FileHandler(LOG_FILE_PATH, true); // Append mode
//            handler.setFormatter(new SimpleFormatter()); // Set your desired formatter (optional)
//            logger.addHandler(handler);
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.exit(1); // Handle error gracefully
//        }


        File directory = new File(SHARED_DIRECTORY);//directory is a instance of File but its folder
        ExecutorService executorService = Executors.newCachedThreadPool();
        File[] files = directory.listFiles();
        System.out.println(files.length);


        if (directory.exists())
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    executorService.execute(() -> processFileParallel(file));
                }
            }

        executorService.shutdown();

        // Ensure all tasks are completed before exiting
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(File file) {
        AtomicInteger trueCount = new AtomicInteger();
        AtomicInteger falseCount = new AtomicInteger();
        AtomicInteger failedCount = new AtomicInteger();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    boolean result = dataProcessor.parse(line);
                    if (result) {
                        trueCount.incrementAndGet();
                    } else {
                        falseCount.incrementAndGet();
                    }
                } catch (Exception e) {
                    failedCount.incrementAndGet();
                    sl4JLogger.error("Error processing line: " + line + " in file " + file.getName(), e);
                }
            }
        } catch (IOException e) {
            sl4JLogger.error("Error reading file: " + file.getName(), e);
        }

        String message = file.getName() + " - true: " + trueCount + "; false: " + falseCount + "; failed: " + failedCount + "\n";
        sl4JLogger.info(message);
    }

    private static void processFileParallel(File file) {
        AtomicInteger trueCount = new AtomicInteger();
        AtomicInteger falseCount = new AtomicInteger();
        AtomicInteger failedCount = new AtomicInteger();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines() // Read lines as a stream
                    .parallel() // Process lines in parallel
                    .forEach(line -> {
                        try {
                            boolean result = dataProcessor.parse(line);
                            if (result) {
                                trueCount.incrementAndGet();
                            } else {
                                falseCount.incrementAndGet();
                            }
                        } catch (Exception e) {
                            failedCount.incrementAndGet();
                            sl4JLogger.error("Error processing line: " + line + " in file " + file.getName(), e);
                        }
                    });
        } catch (IOException e) {
            sl4JLogger.error("Error reading file: " + file.getName(), e);
        }

        String message = file.getName() + " - true: " + trueCount + "; false: " + falseCount + "; failed: " + failedCount + "\n";

        sl4JLogger.info(message);
    }


}
