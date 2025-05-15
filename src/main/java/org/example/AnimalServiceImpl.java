package org.example;

import java.util.HashMap;
import java.util.List;

public class AnimalServiceImpl implements AnimalService {

    private final HashMap<Integer, String> db;

    public AnimalServiceImpl() {
        this.db = new HashMap<>();
        db.put(1,"chicken");
        db.put(2,"cow");
        db.put(3,"lion");
        db.put(4,"dog");
        db.put(5,"cat");
        db.put(6,"rabbit");
        db.put(7,"bear");
    }

    @Override
    public List<String> getAll() {
        simulateLatency(300);
        return db.keySet().stream().map( k -> db.get(k)).toList();
    }

    @Override
    public String get(int id) {
        simulateLatency(150);
        return db.get(id);
    }

    private void simulateLatency(Integer responseTime) {
        try {
            System.out.println("Waiting: " + responseTime + "ms for response.");
            Thread.sleep(responseTime);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
