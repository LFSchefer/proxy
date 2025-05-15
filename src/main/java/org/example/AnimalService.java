package org.example;

import java.util.List;

public interface AnimalService {

    List<String> getAll();

    String get(int id);
}
