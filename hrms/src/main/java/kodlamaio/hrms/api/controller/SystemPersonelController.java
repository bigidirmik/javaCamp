package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemPersonelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.SystemPersonel;

@RestController
@RequestMapping("/api/systempersonel")
public class SystemPersonelController {
	
	private SystemPersonelService systemPersonelService;

	@Autowired
	public SystemPersonelController(SystemPersonelService systemPersonelService) {
		super();
		this.systemPersonelService = systemPersonelService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SystemPersonel>> getAll(){
		return systemPersonelService.getAll();
	}
	
	@GetMapping("/getAllAsc")
	DataResult<List<SystemPersonel>> getAllAsc(){
		return systemPersonelService.getAllAsc();
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<SystemPersonel>> getAll(int pageNo, int pageSize){
		return systemPersonelService.getAll(pageNo, pageSize);
	}

}
