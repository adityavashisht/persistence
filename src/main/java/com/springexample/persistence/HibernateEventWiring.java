package com.springexample.persistence;

import org.hibernate.SessionFactory;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Ady on 2/5/17.
 */
@Component
public class HibernateEventWiring {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private MySaveOrUpdateListener mySaveOrUpdateListener;

    @Autowired
    private MyFlushListener myFlushListener;


    // initialize this bean at the time of creation
    @PostConstruct
    public void registerListeners() {

        EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
                EventListenerRegistry.class);

        registry.getEventListenerGroup(EventType.SAVE_UPDATE).appendListener(mySaveOrUpdateListener);
        registry.getEventListenerGroup(EventType.FLUSH).appendListener(myFlushListener);
    }

}
