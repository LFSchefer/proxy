package org.example;

import java.util.List;

public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    public List<String> getAll() {
        return service.getAll();
    }

    public String get(int id) {
        return service.get(id);
    }
}
