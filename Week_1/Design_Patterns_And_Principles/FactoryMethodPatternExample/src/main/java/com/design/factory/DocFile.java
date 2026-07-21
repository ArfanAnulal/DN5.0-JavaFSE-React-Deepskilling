package com.design.factory;

public interface DocFile {
    void load();
    void commit();
    void terminate();
    String fileType();
}
