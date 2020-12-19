package com.bloomberg.clustereddata.service.gen.impl;


import com.bloomberg.clustereddata.domain.xtras.AbstractEntity;
import com.bloomberg.clustereddata.exception.ModelNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Clement Nosariemen Ojo
 * @email *: clement.ojo@live.com, clement.ojo@cwlgroup.com
 * @date **: November 26, 2016  09:52 AM
 * -------------------------------------------------------------
 */
@Transactional
public abstract class AbstractServiceImpl<T extends AbstractEntity<PK>, PK extends Serializable> {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AbstractServiceImpl.class);

    @Autowired
    protected JpaRepository<T, PK> getDao;

    protected Class<T> type;
//    protected Logger log;


    /**
     * This constructor needs the real type of the generic
     * type T so it can be given to the {@link EntityManager}.
     */
    public AbstractServiceImpl(Class<T> type) {
        this.type = type;
//        this.log = Logger.getLogger(type.getName());
    }


    @Transactional(readOnly = false)
    public T saveNew(final T entity) throws ModelNotFoundException {
        log.debug("about saving entity");
        T resp = null;

        try {
            resp = getDao.save(entity);
            getDao.flush();

            //if (getDao.findOne(resp.getPk()) != null) {
            if (getDao.findById(resp.getPk()).isPresent()) {
                log.debug("finished saving entity with id - {} " + resp.getPk());
            } else {
                log.error("error occurred while saving entity");
            }
            return resp;
        } catch (ModelNotFoundException e) {
            log.error(e.getMessage(), e);
            throw e;

        }
    }


    public List<T> saveNew(final List<T> entityList) {

        log.debug("about saving entity");
        List<T> tList = null;
        try {

            //getDao.save(array);
            tList = getDao.saveAll(entityList);
            getDao.flush();
        } finally {
            log.debug("finished saving entity");
        }
        return tList;

    }

    @Transactional(readOnly = false)
    public T saveUpdate(final T entity) {

        try {
            getDao.save(entity);
            //return getDao.findOne(entity.getPk());
            return getDao.findById(entity.getPk()).get();
        } catch (PersistenceException e) {

        } catch (Exception e) {
        }
        return null;
    }

    @Transactional(readOnly = false)
    public void saveUpdate(final List<T> entityList) {
        try {

            //getDao.save(newList);
            getDao.saveAll(entityList);
        } catch (PersistenceException e) {

        } catch (Exception e) {

        }
    }


    public T delete(T entity) {
        getDao.delete(entity);
        return getDao.findById(entity.getPk()).get();
    }


//	public void delete(List<PK> list, String idProperty) {
//
//		getDao().delete(list,idProperty);
//	}

    public int deleteAll() {
//		return getDao().deleteAllInBatch();
        int size = findAll().size();

        for (T element : findAll()) {
            delete(element);
        }
        return size;
    }

    public void delete(List<T> entities) {
        getDao.deleteAll(entities);
    }

    public boolean exists(PK id) {
        //return getDao.exists(id);
        return getDao.existsById(id);
    }

    @Transactional(readOnly = true)
    public Long countLong() {
        return getDao.count();
    }

    @Transactional(readOnly = true)
    public Integer countInt() {
        return countLong().intValue();
    }


    @Transactional(readOnly = true)
    public Optional<T> findByID(PK id) throws ModelNotFoundException {
        return getDao.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<T> findByEntity(T entity) {
        return getDao.findById(entity.getPk());
    }

    public List<T> findAll() {
        return getDao.findAll();
    }


}

