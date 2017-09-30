package ua.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.entity.User;
import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;
import ua.repository.ProfilRepository;
import ua.service.ProfilService;

@Service
public class ProfilServiceImpl implements ProfilService {

	private final ProfilRepository repository;

	@Autowired
	public ProfilServiceImpl(ProfilRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Page<CafeIndexView> findAllViews(String user, CafeFilter filter, Pageable pageable, Sort sort) {
		return repository.findAllViews(user, filter, pageable, sort);
	}

}
