package thi_module4.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import thi_module4.test.model.City;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<City,Integer> {
    @Query(nativeQuery = true,value = "select * from city where country_id = ?")
    List<City> showAllCityByCountry(int country_id);
    @Query(nativeQuery = true,value = "select * from city where name like ?")
    List<City> showAllCityByContainerName(String name);
}
