package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import ua.model.filter.CafeFilter;
import ua.model.view.CafeView;

public interface CafeViewOfProfilService {
	Page<CafeView> findAllViews(String user, CafeFilter filter, Pageable pageable,Sort sort);
}
