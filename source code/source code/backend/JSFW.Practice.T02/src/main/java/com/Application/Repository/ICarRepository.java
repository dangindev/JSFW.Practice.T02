package com.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Application.Entity.Car;
import com.Application.Entity.CarPK;
@Repository
public interface ICarRepository extends JpaRepository<Car, CarPK> {

}
