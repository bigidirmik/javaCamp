package kodlamaio.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.LogoService;
import kodlamaio.hrms.core.utilities.imageUpload.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LogoDao;
import kodlamaio.hrms.entities.concretes.Logo;

@Service
public class LogoManager implements LogoService {

	private LogoDao logoDao;
	private CloudinaryService cloudinaryService;

	@Autowired
	public LogoManager(LogoDao logoDao,CloudinaryService cloudinaryService) {
		super();
		this.logoDao = logoDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(Logo logo,MultipartFile imageFile) {
		@SuppressWarnings("unchecked")
		Map<String,String> uploadLogo = this.cloudinaryService.upload(imageFile).getData();
		logo.setUrl(uploadLogo.get("url"));
		this.logoDao.save(logo);
		return new SuccessResult("Logo eklendi!");
	}

	@Override
	public DataResult<Logo> getById(int logoId) {
		return new SuccessDataResult<Logo>(this.logoDao.getById(logoId),"Logo bulundu");		
	}

	@Override
	public DataResult<Logo>getByEmployerId(int employerId) {
		return new SuccessDataResult<Logo>(this.logoDao.getByEmployer_Id(employerId),"Logo bulundu");
	}

	@Override
	public Result delete(Logo logo) {
		this.logoDao.delete(logo);
		return new SuccessResult("Logo silindi!");
	}
	
}
