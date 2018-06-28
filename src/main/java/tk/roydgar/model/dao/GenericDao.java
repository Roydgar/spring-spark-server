package tk.roydgar.model.dao;


import tk.roydgar.model.entity.Client;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    Optional<T> findById(int id);
    List<T> findAll();
    void update(T entity, int id);
    void delete(int id);

}
