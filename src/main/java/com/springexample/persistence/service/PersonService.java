package com.springexample.persistence.service;

import com.springexample.persistence.domain.Person;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ady on 2/3/17.
 */
@Component // Spring component
@Transactional // Annotation driven transaction
public class PersonService {


    @Autowired
    private SessionFactory sessionFactory;

    public void save(Person person) {


        // From the factory get a "current" session

        Session session = sessionFactory.getCurrentSession();

        session.setHibernateFlushMode(FlushMode.MANUAL);

        session.saveOrUpdate(person);

        session.flush();


    }


    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Person p = session.load(Person.class, id);
        session.delete(p);
    }


    /**
     * @param city
     * @return
     */
    public List<Person> getAllByCity(String city) {
        Session session = sessionFactory.getCurrentSession();


        Query query = session.createQuery("from Person as p inner join p.addressSet a where a.city=:city").setParameter("city", city);
        List<Object> objectList = query.list();

        List<Person> personList = null;
        if (!CollectionUtils.isEmpty(objectList)) {

            personList = new ArrayList<Person>(objectList.size());

            for (Object object : objectList) {

                Object array[] = (Object[]) object;

                Person p = (Person) (array[0]);// The zero-th element is the Person type as a result of this inner join

                personList.add(p);

            }
        }


        return personList;


    }

    public List<Person> getUsingAddressTable(String city) {

        Session session = sessionFactory.getCurrentSession();


        Query query = session.createQuery("select address.person from Address address where address.city=:city").setParameter("city", city);
        List<Person> personList = query.list();
        return personList;

    }


}
