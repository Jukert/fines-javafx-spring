package by.bsuir.demo.dao;

import by.bsuir.demo.common.Car;

import java.util.List;

public interface CarDao {

    void save(Car car);

    List<Car> findAll();

}
