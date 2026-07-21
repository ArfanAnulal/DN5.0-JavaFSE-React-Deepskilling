package com.design.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.*;

public class GlobalLoggerTest {
    @Test
    public void testInstanceEquality() {
        GlobalLogger inst1 = GlobalLogger.getInstance();
        GlobalLogger inst2 = GlobalLogger.getInstance();
        assertSame(inst1, inst2, "Instances must be reference-equal");
    }

    @Test
    public void testMultiThreadedAccess() throws InterruptedException, ExecutionException {
        int threads = 50;
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        java.util.List<Callable<GlobalLogger>> tasks = new java.util.ArrayList<>(threads);
        
        for (int i = 0; i < threads; i++) {
            tasks.add(GlobalLogger::getInstance);
        }

        java.util.List<Future<GlobalLogger>> futures = executor.invokeAll(tasks);
        GlobalLogger pivot = futures.get(0).get();
        assertNotNull(pivot);

        for (Future<GlobalLogger> f : futures) {
            assertSame(pivot, f.get(), "Thread safety failed: multiple logger instances returned");
        }
        executor.shutdown();
    }
}
