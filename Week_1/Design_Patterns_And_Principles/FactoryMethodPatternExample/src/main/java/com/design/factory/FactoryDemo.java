package com.design.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("--- Factory Method Pattern Demo ---");

        DocFactory wordCreator = new WordDocFactory();
        DocFile word = wordCreator.manufactureDocument();
        System.out.println("Document Type: " + word.fileType());
        word.load();
        word.commit();
        word.terminate();

        System.out.println();

        DocFactory pdfCreator = new PdfDocFactory();
        DocFile pdf = pdfCreator.manufactureDocument();
        System.out.println("Document Type: " + pdf.fileType());
        pdf.load();
        pdf.commit();
        pdf.terminate();

        System.out.println();

        DocFactory excelCreator = new ExcelDocFactory();
        DocFile excel = excelCreator.manufactureDocument();
        System.out.println("Document Type: " + excel.fileType());
        excel.load();
        excel.commit();
        excel.terminate();
    }
}
