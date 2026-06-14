package com.testing.mockito;

public interface ExternalApi {
    String getData();
    void updateData(String key, String value);
    String getValueFor(String key);
}
