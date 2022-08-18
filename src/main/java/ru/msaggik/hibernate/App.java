package ru.msaggik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.msaggik.hibernate.model.Person;

import java.util.List;

public class App {
    public static void main( String[] args ) {
        // подключение файла конфигурации hibernate.properties и класса Person
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        // создание сессии из configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // сессия
        Session session = sessionFactory.getCurrentSession();

        try {
            // начало транзакции
            session.beginTransaction();

//            // возврат всех значений из таблицы Person (обращается к классу Person)
//            List<Person> people = session.createQuery("FROM Person").getResultList();

//            // возврат всех значений из таблицы Person с возрастом более 30
//            List<Person> people = session.createQuery("FROM Person WHERE age > 30").getResultList();

//            // возврат всех значений из таблицы Person с именем начинающимся на букву "T"
//            List<Person> people = session.createQuery("FROM Person WHERE name LIKE 'T%'").getResultList();

//            // обновление имён в таблице Person всех пользователей с возрастом меньше 30 на имя Hero
//            session.createQuery("update Person set name = 'Hero' where age < 30").executeUpdate();

            // удаление имён из таблицы Person всех пользователей с возрастом больше 90
            session.createQuery("delete from Person where age > 90").executeUpdate();

//            // вывод на экран каждого пользователя
//            for(Person person: people)
//                System.out.println(person);

            // закрытие транзакции
            session.getTransaction().commit();
        } finally {
            // закрытие сессии
            sessionFactory.close();
        }
    }
}