package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.LogoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Logo;

@RestController
@RequestMapping("/api/logos")
@CrossOrigin
public class LogosController {

	private LogoService logoService;
	private EmployerService employerService;
	
	@Autowired
	public LogosController(LogoService logoService, EmployerService employerService) {
		super();
		this.logoService = logoService;
		this.employerService = employerService;
	}

	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "employerId") int employerId, @RequestParam(value = "imageFile") MultipartFile imageFile){
		Employer employer = this.employerService.findById(employerId).getData();
		Logo logo = new Logo();
		if(employer.getLogo()!=null) {
			this.delete(employerId);
		}
		logo.setEmployer(employer);
		return this.logoService.add(logo, imageFile);
	}
	
	@GetMapping("/getById")
	public DataResult<Logo> getById(@RequestParam int logoId){
		return this.logoService.getById(logoId);
	}

	@GetMapping("/getByEmployerId")
	public DataResult<Logo> getByEmployerId(@RequestParam int employerId) {
		return this.logoService.getByEmployerId(employerId);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam(value = "employerId") int employerId) {
		Logo logo = this.getByEmployerId(employerId).getData();
		return this.logoService.delete(logo);
	}

}
