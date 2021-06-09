package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;

@RestController
@RequestMapping("/api/activation-codes")
public class ActivationCodesController {
	
	private ActivationCodeService activationCodeService;

	@Autowired
	public ActivationCodesController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ActivationCode activationCode){
		return this.activationCodeService.add(activationCode);
	}
	
	@GetMapping("/getById")
	DataResult<ActivationCode> getById(int id){
		return this.activationCodeService.getById(id);
	}
	
	@GetMapping("/getByUserId")
	DataResult<ActivationCode> geteByUserId(int userId){
		return this.activationCodeService.getByUserId(userId);
	}
	
}
