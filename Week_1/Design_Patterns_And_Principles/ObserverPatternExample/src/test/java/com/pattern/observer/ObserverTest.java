package com.pattern.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {
    @Test
    public void testObserverNotification() {
        StockMarket googleStock = new StockMarket("GOOGL", 150.0);
        MobileApp pixelApp = new MobileApp("PixelApp");
        WebApp chromeApp = new WebApp("ChromeApp");

        googleStock.registerObserver(pixelApp);
        googleStock.registerObserver(chromeApp);

        googleStock.setPrice(155.5);
        assertEquals(155.5, pixelApp.getLatestPrice());
        assertEquals(155.5, chromeApp.getLatestPrice());

        // Deregister one
        googleStock.deregisterObserver(chromeApp);
        googleStock.setPrice(160.0);

        assertEquals(160.0, pixelApp.getLatestPrice());
        assertEquals(155.5, chromeApp.getLatestPrice()); // remains unchanged
    }
}
