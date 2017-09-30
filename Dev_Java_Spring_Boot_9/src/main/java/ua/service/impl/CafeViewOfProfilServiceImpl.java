package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.model.filter.CafeFilter;

import ua.model.view.CafeView;
import ua.repository.CafeViewOfProfilRepository;

import ua.service.CafeViewOfProfilService;

@Service
public class CafeViewOfProfilServiceImpl implements CafeViewOfProfilService {

	private final CafeViewOfProfilRepository repository;

	@Autowired
	public CafeViewOfProfilServiceImpl(CafeViewOfProfilRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Page<CafeView> findAllViews(String user, CafeFilter filter, Pageable pageable, Sort sort) {
		return repository.findAllViews(user, filter, pageable, sort);
	}

}
