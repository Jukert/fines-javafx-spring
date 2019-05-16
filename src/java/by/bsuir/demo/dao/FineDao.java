package by.bsuir.demo.dao;

import by.bsuir.demo.common.Fine;
import by.bsuir.demo.filter.FineFilter;

import java.util.List;

public interface FineDao {

     void save(Fine fine);

     List<Fine> findAll(FineFilter filter);

}
