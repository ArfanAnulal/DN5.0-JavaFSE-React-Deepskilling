package com.design.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DocFactoryTest {
    @Test
    public void testWordDocFactory() {
        DocFactory factory = new WordDocFactory();
        DocFile doc = factory.manufactureDocument();
        assertNotNull(doc);
        assertEquals("Word Document", doc.fileType());
    }

    @Test
    public void testPdfDocFactory() {
        DocFactory factory = new PdfDocFactory();
        DocFile doc = factory.manufactureDocument();
        assertNotNull(doc);
        assertEquals("PDF Document", doc.fileType());
    }

    @Test
    public void testExcelDocFactory() {
        DocFactory factory = new ExcelDocFactory();
        DocFile doc = factory.manufactureDocument();
        assertNotNull(doc);
        assertEquals("Excel Spreadsheet", doc.fileType());
    }
}
