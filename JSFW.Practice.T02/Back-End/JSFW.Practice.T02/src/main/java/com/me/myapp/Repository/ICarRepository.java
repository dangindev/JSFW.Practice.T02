package com.me.myapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.myapp.Entity.Car;
import com.me.myapp.Entity.CarPK;

@Repository
public interface ICarRepository extends JpaRepository<Car, CarPK> {

}
