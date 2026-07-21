package com.design.factory;

public class PdfFile implements DocFile {
    @Override
    public void load() {
        System.out.println("[PDF] Parsing binary structures and fonts...");
    }

    @Override
    public void commit() {
        System.out.println("[PDF] Flushing stream and saving updates...");
    }

    @Override
    public void terminate() {
        System.out.println("[PDF] Releasing handles and wrapping up file...");
    }

    @Override
    public String fileType() {
        return "PDF Document";
    }
}
