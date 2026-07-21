package com.design.factory;

public class ExcelFile implements DocFile {
    @Override
    public void load() {
        System.out.println("[Excel] Scanning worksheets and parsing cells...");
    }

    @Override
    public void commit() {
        System.out.println("[Excel] Saving calculations and spreadsheets...");
    }

    @Override
    public void terminate() {
        System.out.println("[Excel] Purging memory buffers and closing workbook...");
    }

    @Override
    public String fileType() {
        return "Excel Spreadsheet";
    }
}
