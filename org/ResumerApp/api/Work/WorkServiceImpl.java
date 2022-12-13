package org.ResumerApp.api.Work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService{

	@Autowired
	private WorkRepo workRepo;
	
	@Override
	public boolean SaveWork(WorkEntity work) {
		WorkEntity workEntity = new WorkEntity();
		if(work!=null)
		{
			workEntity.setCompany(work.getCompany());
			workEntity.setExperience(work.getExperience());
			workEntity.setProject(work.getProject());
			workEntity.setRole(work.getRole());
			return true;
		}
		return false;
	}
}
