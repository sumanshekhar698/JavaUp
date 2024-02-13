package com.sumanshekhar.java.lld;



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
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Assuming the proprietary library is available
//import com.acme.ai.DataProcessor;

public class FileProcessor {

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
    private static final org.slf4j.Logger sl4JLogger = LoggerFactory.getLogger(FileProcessor.class);
    private static final DataProcessor dataProcessor = DataProcessor.getInstance(); // Assuming singleton
    private static final Logger logger = Logger.getLogger(FileProcessor.class.getName()); // Get logger for this class


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
                    logger.log(Level.SEVERE, "Error processing line: " + line + " in file " + file.getName(), e);
                    sl4JLogger.error("Error processing line: " + line + " in file " + file.getName(), e);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading file: " + file.getName(), e);
            sl4JLogger.error("Error reading file: " + file.getName(), e);
        }

        String message = file.getName() + " - true: " + trueCount + "; false: " + falseCount + "; failed: " + failedCount + "\n";
        logger.log(Level.INFO, message); // Log overall results with INFO level
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
                            logger.log(Level.SEVERE, "Error processing line: " + line + " in file " + file.getName(), e);
                            sl4JLogger.error("Error processing line: " + line + " in file " + file.getName(), e);
                        }
                    });
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading file: " + file.getName(), e);
            sl4JLogger.error("Error reading file: " + file.getName(), e);
        }

        String message = file.getName() + " - true: " + trueCount + "; false: " + falseCount + "; failed: " + failedCount + "\n";
        logger.log(Level.INFO, message); // Log overall results with INFO level

        sl4JLogger.info(message);
    }


}

class DataProcessor {

    private static volatile DataProcessor instance;

    private DataProcessor() {
    } // Private constructor to enforce singleton

    public static DataProcessor getInstance() {
        // Double-checked locking for efficiency
        if (instance == null) {
            synchronized (DataProcessor.class) {//synchronized (DataProcessor.class): This part acquires a lock on the DataProcessor.class object. This lock ensures that only one thread can enter this section at a time, preventing multiple threads from creating the instance simultaneously.
                if (instance == null) {
                    instance = new DataProcessor();
                }
            }
        }
        return instance;
    }

    public boolean parseRandom(String line) {
        Random random = new Random();  // Create a Random object for generating randomness
        return random.nextBoolean();  // Return a random boolean value (true or false)
    }

    public boolean parse(String line) {
        return line.length() % 2 == 0;
    }



/*Removes the unnecessary synchronized block within getInstance, relying on the volatile field for thread safety and visibility.
Uses double-checked locking to improve efficiency in subsequent calls to getInstance after the instance is created. This ensures proper synchronization only when necessary.
Maintains the same functionality for the parse method.
Explanation:

The volatile keyword guarantees visibility and ordering of reads and writes of the instance variable across different threads.
Double-checked locking ensures that the creation of the instance happens only once in a thread-safe manner while avoiding unnecessary synchronization overhead in subsequent calls.
This approach is generally considered more performant and efficient for singleton implementations in modern Java compared to the double synchronized version. Remember to choose the most suitable approach based on your specific performance requirements and coding preferences.*/

/*
The volatile keyword is crucial in this particular scenario for the following reasons:

Thread Safety:

In a multithreaded environment, multiple threads could potentially call DataProcessor.getInstance(). Without volatile, it's possible that one thread reads a partially initialized instance (before the constructor finishes) leading to unexpected behavior.
Adding volatile to the instance variable ensures that reads and writes of its reference are performed atomically. This means that all threads will see the latest consistent value of the instance variable, preventing potential inconsistency issues.
Visibility Guarantee:

In Java, memory operations are not always immediately visible to other threads. Changes made by one thread might not be reflected in the memory shared by other threads until a synchronization mechanism like synchronized is used.
By declaring instance as volatile, you inform the compiler and the JVM that any changes to this variable must be made visible to all threads immediately. This avoids situations where different threads might see stale values of the instance reference.
Benefits of Using volatile:

Using volatile in this specific case ensures thread safety and proper visibility of the instance variable across multiple threads.
It provides a simple and lightweight way to achieve thread safety compared to using synchronized blocks or more complex mechanisms.
Potential Considerations:

It's important to be mindful that volatile only guarantees visibility and ordering of reads and writes, not atomicity of operations. If your getInstance method involves multiple steps, you might need additional synchronization mechanisms for thread safety within the method itself.
Overall, using volatile for the instance variable in this singleton implementation is a good practice for ensuring thread safety and visibility in a multithreaded environment. Remember, the specific need for volatile depends on the context and desired behavior of your program.*/


/*Public synchronized static DataProcessor getInstance() {
    if (instance == null) {
        synchronized (DataProcessor.class) {
            if (instance == null) {
                instance = new DataProcessor();
            }
        }
    }
    return instance;
}

Is this double synchronized?
Yes, the code does involve double synchronization:

Synchronized method: The getInstance method itself is declared as synchronized. This means that only one thread can enter the method at a time, acquiring a lock on the DataProcessor class object.
Synchronized block within the method: An additional synchronized block is used within the method, also acquiring a lock on the DataProcessor.class object.
Purpose of Double Synchronization:

Ensuring thread safety: The primary goal is to guarantee thread safety during the singleton instance creation. Only one thread should be able to create the instance, even if multiple threads call getInstance simultaneously.
Efficiency consideration (not fully achieved): The intention might have been to optimize performance by avoiding unnecessary synchronization in subsequent calls to getInstance after the instance is created. However, this implementation doesn't fully achieve this goal.
Issues with Double Synchronization:

Redundant locking: The two locks are acquired on the same object (DataProcessor.class), making the inner synchronized block redundant. It doesn't provide additional thread safety benefits in this case.
Performance overhead: The extra synchronization adds unnecessary overhead, as threads need to acquire and release locks even after the instance is created.
Better Approaches for Thread Safety:

Volatile field approach: As discussed earlier, using a volatile field for instance and removing the synchronized block within getInstance is generally preferred in modern Java for thread safety and performance.
Initialization-on-demand holder idiom: This pattern also provides thread safety and lazy initialization without explicit synchronization, offering better performance in most cases.
Recommendations:

If thread safety is crucial, use either the volatile field approach or the initialization-on-demand holder idiom for a more efficient and cleaner implementation.
Avoid double synchronization unless there's a specific reason for it, as it can lead to performance degradation without providing substantial benefits.*/
}