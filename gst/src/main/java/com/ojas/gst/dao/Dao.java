package com.ojas.gst.dao;

import java.util.List;

import com.ojas.gst.entity.Entity;



public interface Dao<T extends Entity, I>
{
    List<T> findAll();
  
    T find(I id);

    T save(T entity);

    void delete(I id);

    void delete(T entity);
    
    Long calculateMaxId(Entity entity);


    
}
