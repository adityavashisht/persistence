package com.springexample.persistence;

import com.springexample.persistence.domain.Person;
import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Ady on 2/5/17.
 */
@Component
public class MySaveOrUpdateListener extends DefaultSaveOrUpdateEventListener {

    public void onSaveOrUpdate(SaveOrUpdateEvent event) {

        Object entity = event.getEntity();
        if (entity != null && entity instanceof Person) {
            Person p = (Person) event.getEntity();
            if (p.getFirstName().length() < 2) {
                throw new IllegalArgumentException("Whoa thats not allowed");
            }
        }
        super.onSaveOrUpdate(event);


    }
}
