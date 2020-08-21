package com.me.myapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.myapp.Entity.Accessory;

@Repository
public interface IAccessoryRepository extends JpaRepository<Accessory, Integer> {

}
