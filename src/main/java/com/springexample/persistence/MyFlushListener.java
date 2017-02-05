package com.springexample.persistence;

import org.hibernate.HibernateException;
import org.hibernate.event.internal.DefaultFlushEventListener;
import org.hibernate.event.spi.FlushEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Ady on 2/5/17.
 */
@Component
public class MyFlushListener extends DefaultFlushEventListener {

    public void onFlush(FlushEvent event) throws HibernateException {
        super.onFlush(event);
    }
}
