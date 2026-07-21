package com.design.factory;

public class ExcelDocFactory extends DocFactory {
    @Override
    public DocFile manufactureDocument() {
        return new ExcelFile();
    }
}
