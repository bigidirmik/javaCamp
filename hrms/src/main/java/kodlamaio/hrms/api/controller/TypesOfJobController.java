package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TypeOfJobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.TypeOfJob;

@RestController
@RequestMapping("/api/types-of-job")
@CrossOrigin
public class TypesOfJobController {
	
	private TypeOfJobService typeOfJobService;

	@Autowired
	public TypesOfJobController(TypeOfJobService typeOfJobService) {
		super();
		this.typeOfJobService = typeOfJobService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<TypeOfJob>> getAll(){
		return this.typeOfJobService.getAll();
	}

}
