package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAll();
	
	DataResult<List<City>> getAllAsc();
	
	DataResult<List<City>> getAll(int pageNo, int pageSize);
	
}
