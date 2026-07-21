package com.junit.test.stubbing;

public interface DataService {
    String pullPayload();
    void pushPayload(String name, String value);
    String retrievePayload(String name);
}
