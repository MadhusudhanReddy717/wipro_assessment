package com.example.springassessmentproject.q6;

import java.util.List;

public interface PersonDAO {
    void save(Person person);
    void update(Person person);
    void delete(int id);
    Person getById(int id);
    List<Person> getAll();
}
