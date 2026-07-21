package com.junit.test.stubbing;

public class MockitoDemo {
    public static void main(String[] args) {
        System.out.println("=== Mockito Component Integration Demo ===");
        
        // Creating a manual stub to avoid importing test-scoped Mockito in src/main
        DataService stubApi = new DataService() {
            @Override
            public String pullPayload() {
                return "Stubbed Data Response";
            }

            @Override
            public void pushPayload(String key, String value) {
                System.out.println("Stubbed Update: " + key + " = " + value);
            }

            @Override
            public String retrievePayload(String key) {
                if ("user_1".equals(key)) {
                    return "Alice";
                }
                return null;
            }
        };

        CoreProcessor service = new CoreProcessor(stubApi);

        System.out.println("Calling service.load():");
        System.out.println("Result: " + service.load());

        System.out.println("\nCalling service.persist('config', 'active'):");
        service.persist("config", "active");

        System.out.println("\nCalling service.lookup('user_1'):");
        System.out.println("Result: " + service.lookup("user_1"));
    }
}
