package thi_module4.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thi_module4.test.model.Country;
import thi_module4.test.repository.CountryRepo;

import java.util.List;

@Service
public class CountryService implements ICountryService {
    @Autowired
    private CountryRepo countryRepo;
    @Override
    public List<Country> findAll() {
        return countryRepo.findAll();
    }

    @Override
    public Country findById(int id) {
        return countryRepo.getOne(id);
    }

    @Override
    public void save(Country country) {
        countryRepo.save(country);
    }

    @Override
    public void remove(int id) {
        countryRepo.deleteById(id);
    }
}
