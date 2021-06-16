package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Image;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {

	private ImageService imageService;
	private CandidateService candidateService;
	
	@Autowired
	public ImagesController(ImageService imageService, CandidateService candidateService) {
		super();
		this.imageService = imageService;
		this.candidateService = candidateService;
	}

	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "candidateId") int candidateId, @RequestParam(value = "imageFile") MultipartFile imageFile){
		Candidate candidate = this.candidateService.findById(candidateId).getData();
		Image image = new Image();
		image.setCandidate(candidate);
		return this.imageService.add(image, imageFile);
	}
	
	@GetMapping("/getById")
	public DataResult<Image> getById(@RequestParam int imageId){
		return this.imageService.getById(imageId);
	}

	@GetMapping("/getByCandidateId")
	public DataResult<Image> getByCandidateId(@RequestParam int candidateId) {
		return this.imageService.getByCandidateId(candidateId);
	}

}
