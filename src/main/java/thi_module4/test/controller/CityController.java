package thi_module4.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thi_module4.test.model.City;
import thi_module4.test.model.Country;
import thi_module4.test.service.ICityService;
import thi_module4.test.service.ICountryService;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountryService countryService;

    @ModelAttribute("listCountry")
    private List<Country> getAll() {
        return countryService.findAll();
    }

    @GetMapping("list")
    public ModelAndView getAllCity() {
        List<City> cities = cityService.findAll();
        return new ModelAndView("city/home", "list", cities);
    }

    @GetMapping("info/{id}")
    public ModelAndView getInfo(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("city/info");
        City city = cityService.findById(id);
        if (city != null) {
            String message = "Thành phố " + city.getName();
            modelAndView.addObject("message", message);

        }
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("city/create", "city", new City());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView create(@Validated @ModelAttribute City city, BindingResult bindingResult) {
        ModelAndView modelAndView;
        if(bindingResult.hasFieldErrors()){
            modelAndView=new ModelAndView("city/create");
            return modelAndView;
        }
        cityService.save(city);
        modelAndView = new ModelAndView("redirect:/city/list");
        modelAndView.addObject("city", new City());
        String message = " Tạo mới thành công";
        modelAndView.addObject("message",message);
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id){
        City city = cityService.findById(id);
        return new ModelAndView("city/edit","city",city);
    }
    @PostMapping("edit/{id}")
    private ModelAndView edit(@Validated @ModelAttribute City city,@PathVariable int id,BindingResult bindingResult){
        ModelAndView modelAndView;
        if(bindingResult.hasFieldErrors()){
            modelAndView=new ModelAndView("/city/edit/"+id);
            return modelAndView;
        }
        city.setId(id);
        cityService.save(city);
        modelAndView=new ModelAndView("redirect:/city/list");
        modelAndView.addObject("message"," Chỉnh sửa thành công");
        return modelAndView;
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        cityService.remote(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("search")
    public ModelAndView search(@RequestParam String name){
        String v = "%" + name + "%";
       List<City> cities = cityService.showAllCityByContainerName(v);
        return new ModelAndView("city/home","list",cities);
    }

}
