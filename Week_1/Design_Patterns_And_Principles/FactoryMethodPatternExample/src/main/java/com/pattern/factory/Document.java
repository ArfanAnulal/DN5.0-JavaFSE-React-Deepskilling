package com.pattern.factory;

public interface Document {
    void open();
    void save();
    void close();
    String getType();
}
