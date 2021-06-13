package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<City>> getAllAsc(){
		return this.cityService.getAllAsc();
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<City>> getAll(int pageNo, int pageSize){
		return this.cityService.getAll(pageNo, pageSize);
	}
	
	
	@GetMapping("/findById")
	public DataResult<City> findById(@RequestParam int cityId){
		return this.cityService.findById(cityId);
	}
	
	@GetMapping("/findByCityName")
	public DataResult<City> findByCityName(@RequestParam String cityName){
		return this.cityService.findByCityName(cityName);
	}

}
