package com.design.factory;

public class PdfDocFactory extends DocFactory {
    @Override
    public DocFile manufactureDocument() {
        return new PdfFile();
    }
}
