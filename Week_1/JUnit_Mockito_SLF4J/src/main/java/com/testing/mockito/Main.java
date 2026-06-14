package com.testing.mockito;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Mockito Mocking Component Output (Exercise 2) ===");
        ExternalApi mockApi = new ExternalApi() {
            @Override
            public String getData() {
                return "Stubbed Data Response";
            }
            @Override
            public void updateData(String key, String value) {
                System.out.println("Stubbed Update: " + key + " = " + value);
            }
            @Override
            public String getValueFor(String key) {
                if (key.equals("user_1")) {
                    return "Alice";
                }
                return null;
            }
        };
        
        MyService service = new MyService(mockApi);
        
        System.out.println("Calling service.fetchData():");
        String data = service.fetchData();
        System.out.println("Result: " + data);
        
        System.out.println("\nCalling service.saveData('config', 'active'):");
        service.saveData("config", "active");
        
        System.out.println("\nCalling service.getValue('user_1'):");
        String val = service.getValue("user_1");
        System.out.println("Result: " + val);
    }
}
