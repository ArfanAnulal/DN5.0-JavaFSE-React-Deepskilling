package com.ecommerce.search;

public class Item implements Comparable<Item> {
    private String id;
    private String name;
    private String category;

    public Item(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }

    @Override
    public int compareTo(Item other) {
        return this.id.compareTo(other.id);
    }
}
