package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Ingredient;
import ua.entity.OpenClose;
import ua.model.filter.SimpleFilter;
import ua.model.request.OpenCloseRequest;

public interface OpenCloseService {
	List<String> findAllTimes();

	void delete(Integer id);

	void save(OpenCloseRequest request);

	OpenCloseRequest findOne(Integer id);
	
	Page<OpenClose> findAll(Pageable pageable, SimpleFilter filter);
	
	List<OpenClose> findAll();
}
