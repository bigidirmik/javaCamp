package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemPersonelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonelDao;
import kodlamaio.hrms.entities.concretes.SystemPersonel;

@Service
public class SystemPersonelManager implements SystemPersonelService {
	
	private SystemPersonelDao systemPersonelDao;

	@Autowired
	public SystemPersonelManager(SystemPersonelDao systemPersonelDao) {
		super();
		this.systemPersonelDao = systemPersonelDao;
	}

	@Override
	public DataResult<List<SystemPersonel>> getAll() {
		return new SuccessDataResult<List<SystemPersonel>>(this.systemPersonelDao.findAll(),"Sistem personeli listelendi");
	}
	
	@Override
	public DataResult<List<SystemPersonel>> getAllAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"firstName");
		return new SuccessDataResult<List<SystemPersonel>>(this.systemPersonelDao.findAll(sort),"Sistem personeli listelendi");
	}

	@Override
	public DataResult<List<SystemPersonel>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<SystemPersonel>>(this.systemPersonelDao.findAll(pageable).getContent(),"Sistem personeli listelendi");
	}

}
