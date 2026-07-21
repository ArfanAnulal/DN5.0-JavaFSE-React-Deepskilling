package com.junit.test.stubbing;

public class CoreProcessor {
    private final DataService dataService;

    public CoreProcessor(DataService dataService) {
        this.dataService = dataService;
    }

    public String load() {
        return dataService.pullPayload();
    }

    public void persist(String key, String value) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty.");
        }
        dataService.pushPayload(key, value);
    }

    public String lookup(String key) {
        return dataService.retrievePayload(key);
    }
}
