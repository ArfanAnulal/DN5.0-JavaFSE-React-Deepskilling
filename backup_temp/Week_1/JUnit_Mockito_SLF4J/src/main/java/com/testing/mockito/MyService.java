package com.testing.mockito;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public void saveData(String key, String value) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }
        externalApi.updateData(key, value);
    }

    public String getValue(String key) {
        return externalApi.getValueFor(key);
    }
}
