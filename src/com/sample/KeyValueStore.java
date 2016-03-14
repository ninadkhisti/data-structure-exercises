package com.sample;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO: Describe purpose and behavior of KeyValueStore
 */
public class KeyValueStore<K, V> {

    private Map<K, V> store;
    private int maxElements;

    public KeyValueStore() {
        this.store = new LinkedHashMap<>();
    }

    public KeyValueStore(int maxCapacity) {
        this.maxElements = maxCapacity;
        this.store = new LinkedHashMap<>(maxCapacity + 1);
    }

    public static void main(String[] args) {
        KeyValueStore<String, String> keyValueStore = new KeyValueStore<String, String>(3);
        keyValueStore.put("a", "ABC");
        keyValueStore.put("b", "ABC");
        keyValueStore.put("c", "ABC");
        keyValueStore.put("d", "ABC");
        keyValueStore.put("e", "ABC");

        try {
            boolean success = keyValueStore.get("a") != null ? true : false;
            System.out.println("Test Result => " + success);
        } catch (IllegalArgumentException ae) {
            System.out.println("Failed");
        }

        System.out.println(keyValueStore.toString());

        /*
        keyValueStore.put("abc", "ABCU");
        boolean success = keyValueStore.get("abc").equals("ABCU");
        System.out.println(success);
        System.out.println(keyValueStore.get("abc!"));
        */
    }

    public void put(K key, V value) {
        this.store.put(key, value);
    }

    public V get(K key) {
        if (this.store.containsKey(key)) {
            return this.store.get(key);
        } else { //cache miss exception
            throw new IllegalArgumentException("key not found!");
        }
    }

    public String toString() {
        return this.store.toString();
    }
}
