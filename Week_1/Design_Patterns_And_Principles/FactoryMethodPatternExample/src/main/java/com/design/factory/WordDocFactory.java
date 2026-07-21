package com.design.factory;

public class WordDocFactory extends DocFactory {
    @Override
    public DocFile manufactureDocument() {
        return new WordFile();
    }
}
