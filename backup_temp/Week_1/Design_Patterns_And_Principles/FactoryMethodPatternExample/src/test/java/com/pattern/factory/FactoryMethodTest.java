package com.pattern.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryMethodTest {
    @Test
    public void testWordDocumentFactory() {
        DocumentFactory factory = new WordDocumentFactory();
        Document doc = factory.createDocument();
        assertNotNull(doc);
        assertEquals("Word", doc.getType());
    }

    @Test
    public void testPdfDocumentFactory() {
        DocumentFactory factory = new PdfDocumentFactory();
        Document doc = factory.createDocument();
        assertNotNull(doc);
        assertEquals("PDF", doc.getType());
    }

    @Test
    public void testExcelDocumentFactory() {
        DocumentFactory factory = new ExcelDocumentFactory();
        Document doc = factory.createDocument();
        assertNotNull(doc);
        assertEquals("Excel", doc.getType());
    }
}
