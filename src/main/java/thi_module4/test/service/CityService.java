package thi_module4.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thi_module4.test.model.City;
import thi_module4.test.repository.CityRepo;

import java.util.List;

@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepo cityRepo;

    @Override
    public List<City> findAll() {
        return (List<City>) cityRepo.findAll();
    }

    @Override
    public City findById(int id) {
        return cityRepo.getOne(id);
    }

    @Override
    public City save(City city) {
       return cityRepo.save(city);
    }

    @Override
    public void remote(int id) {
        cityRepo.deleteById(id);
    }

    @Override
    public List<City> showAllCityByCountry(int country_id) {
        return cityRepo.showAllCityByCountry(country_id);
    }

    @Override
    public List<City> showAllCityByContainerName(String name) {
        return cityRepo.showAllCityByContainerName(name);
    }
}
