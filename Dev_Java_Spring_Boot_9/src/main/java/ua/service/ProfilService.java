package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import ua.entity.User;
import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;
import ua.model.view.CafeView;

public interface ProfilService {
	
	Page<CafeIndexView> findAllViews(String user,CafeFilter filter, Pageable pageable,Sort sort);
}
