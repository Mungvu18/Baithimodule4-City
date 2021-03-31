package thi_module4.test.service;
import thi_module4.test.model.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();
    City findById(int id);
    City save(City city);
    void remote(int id);
    List<City> showAllCityByCountry(int country_id);
    List<City> showAllCityByContainerName(String name);
}
