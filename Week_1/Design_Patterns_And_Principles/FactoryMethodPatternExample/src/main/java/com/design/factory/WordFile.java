package com.design.factory;

public class WordFile implements DocFile {
    @Override
    public void load() {
        System.out.println("[Word] Loading document text and styles...");
    }

    @Override
    public void commit() {
        System.out.println("[Word] Compiling modifications to disk...");
    }

    @Override
    public void terminate() {
        System.out.println("[Word] Unlinking resources and closing session...");
    }

    @Override
    public String fileType() {
        return "Word Document";
    }
}
