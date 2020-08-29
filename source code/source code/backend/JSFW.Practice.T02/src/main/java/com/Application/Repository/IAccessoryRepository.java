package com.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Application.Entity.Accessory;
@Repository
public interface IAccessoryRepository extends JpaRepository<Accessory, Integer>{

}
