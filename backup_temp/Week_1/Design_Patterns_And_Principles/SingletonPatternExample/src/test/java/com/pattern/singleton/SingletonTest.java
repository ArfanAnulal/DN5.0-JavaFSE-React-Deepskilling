package com.pattern.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.*;

public class SingletonTest {
    @Test
    public void testSingletonInstanceEquality() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        assertSame(logger1, logger2, "Logger instances should be the same");
    }

    @Test
    public void testThreadSafety() throws InterruptedException, ExecutionException {
        int threadCount = 100;
        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        Callable<Logger>[] tasks = new Callable[threadCount];
        for (int i = 0; i < threadCount; i++) {
            tasks[i] = Logger::getInstance;
        }

        java.util.List<Future<Logger>> results = service.invokeAll(java.util.Arrays.asList(tasks));
        Logger firstInstance = results.get(0).get();
        assertNotNull(firstInstance);

        for (Future<Logger> result : results) {
            assertSame(firstInstance, result.get(), "Thread safety validation failed: multiple instances detected");
        }
        service.shutdown();
    }
}
