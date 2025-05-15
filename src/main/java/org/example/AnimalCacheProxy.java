package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalCacheProxy implements AnimalService {

    private final AnimalServiceImpl target;
    private List<String> allAnimals = new ArrayList<>();
    private Map<Integer, String> animals = new HashMap<>();

    public AnimalCacheProxy() {
        this.target = new AnimalServiceImpl();
    }

    @Override
    public List<String> getAll() {
        if (allAnimals.isEmpty()) {
            allAnimals = target.getAll();
        } else {
            System.out.println("Using cache");
        }
        return allAnimals;
    }

    @Override
    public String get(int id) {
        if (!animals.containsKey(id)) {
            animals.put(id, target.get(id));
        } else {
            System.out.println("Using cache");
        }
        return animals.get(id);
    }

    private void reset() {
        allAnimals = new ArrayList<>();
        animals = new HashMap<>();
    }
}
