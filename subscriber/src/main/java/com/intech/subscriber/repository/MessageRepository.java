package com.intech.subscriber.repository;

import com.intech.subscriber.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
    private SessionFactory sessionFactory;

    public MessageRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addMessage(Message message) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(message);
        session.getTransaction().commit();
        session.close();
    }

    public int getLastId(Class<? extends Message> messageClass) {
        Session session = sessionFactory.getCurrentSession();
        String queryString = String.format("from %s order by id DESC", messageClass.getSimpleName());
        Query<? extends Message> query = session.createQuery(queryString, messageClass);
        query.setMaxResults(1);
        return query.uniqueResultOptional()
                .map(Message::getId)
                .orElse(0);
    }
}
