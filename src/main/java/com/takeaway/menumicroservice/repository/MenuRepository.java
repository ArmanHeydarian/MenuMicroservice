package com.takeaway.menumicroservice.repository;

import com.takeaway.menumicroservice.domain.model.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer>{

}
