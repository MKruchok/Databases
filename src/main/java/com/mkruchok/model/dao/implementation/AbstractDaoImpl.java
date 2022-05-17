package com.mkruchok.model.dao.implementation;

import com.mkruchok.HibernateUtil;
import com.mkruchok.model.dao.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractDaoImpl<E> implements AbstractDAO<E> {

    static final Logger LOGGER = LoggerFactory.getLogger(AbstractDaoImpl.class);
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final Class<E> currentClass;

    public AbstractDaoImpl(Class<E> currentClass) {
        this.currentClass = currentClass;
    }

    @Override
    @SuppressWarnings("unchecked")
    public final Collection<E> findAll() {
        List<E> entities = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            entities = session.createQuery("from " + currentClass.getName()).getResultList();
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            LOGGER.error(String.valueOf(e));
        }
        entities.forEach(e -> LOGGER.debug(e.toString()));
        return entities;
    }


    @Override
    public final E findById(Integer id) {
        E entity = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            entity = session.get(currentClass, id);
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            LOGGER.error(String.valueOf(e));
        }
        return entity;
    }

    @Override
    public final void update(Integer id, E entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            LOGGER.error(String.valueOf(e));
        }
    }

    @Override
    public final void create(E entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            LOGGER.error(String.valueOf(e));
        }
    }

    @Override
    public final void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            E entity = session.get(currentClass, id);
            if (entity != null) {
                session.delete(entity);
            }
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            LOGGER.error(String.valueOf(e));
        }
    }
}