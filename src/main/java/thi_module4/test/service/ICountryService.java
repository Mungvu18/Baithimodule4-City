package thi_module4.test.service;

import thi_module4.test.model.Country;

import java.util.List;

public interface ICountryService{
    List<Country> findAll();

    Country findById(int id);

    void save(Country country);

    void remove(int id);
}
