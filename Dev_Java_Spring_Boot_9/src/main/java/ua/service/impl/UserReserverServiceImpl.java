package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.UserReserver;
import ua.repository.ReserverRepository;
import ua.service.ResrverService;
@Service
public class UserReserverServiceImpl implements ResrverService{
	private final ReserverRepository repository;
	
	@Autowired
	public UserReserverServiceImpl(ReserverRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public void save(UserReserver reserver) {
		repository.save(reserver);
		
	}

}
