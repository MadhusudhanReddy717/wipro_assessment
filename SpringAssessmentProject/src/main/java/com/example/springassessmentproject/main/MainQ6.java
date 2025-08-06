package com.example.springassessmentproject.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.springassessmentproject.q6.Person;
import com.example.springassessmentproject.q6.PersonDAO;
import java.util.List;

public class MainQ6 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("q6-config.xml");
        PersonDAO dao = (PersonDAO) context.getBean("personDAO");

        List<Person> list = dao.getAll();
        for (Person p : list) System.out.println(p);

        Person p = dao.getById(2);
        System.out.println("Get person with ID 2\n" + p);

        dao.save(new Person(4, 36, "Sergey", "Emets"));
        list = dao.getAll();
        System.out.println("After inserting:");
        for (Person per : list) System.out.println(per);

        dao.delete(2);
        dao.update(new Person(4, 36, "Sergey", "CHANGED"));

        list = dao.getAll();
        System.out.println("Final list:");
        for (Person per : list) System.out.println(per);
    }
}
/*
Person{id=1, age=21, firstName='Vlad', lastName='Boyarskiy'}
Person{id=2, age=30, firstName='Oksi', lastName='Bahatskaya'}
Person{id=3, age=32, firstName='Vadim', lastName='Vadimich'}
Get person with ID 2
Person{id=2, age=30, firstName='Oksi', lastName='Bahatskaya'}
After inserting:
Person{id=1, age=21, firstName='Vlad', lastName='Boyarskiy'}
Person{id=2, age=30, firstName='Oksi', lastName='Bahatskaya'}
Person{id=3, age=32, firstName='Vadim', lastName='Vadimich'}
Person{id=4, age=36, firstName='Sergey', lastName='Emets'}
Final list:
Person{id=1, age=21, firstName='Vlad', lastName='Boyarskiy'}
Person{id=3, age=32, firstName='Vadim', lastName='Vadimich'}
Person{id=4, age=36, firstName='Sergey', lastName='CHANGED'}
*/