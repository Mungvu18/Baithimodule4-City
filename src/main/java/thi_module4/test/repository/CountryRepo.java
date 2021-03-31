package thi_module4.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thi_module4.test.model.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country,Integer> {
}
