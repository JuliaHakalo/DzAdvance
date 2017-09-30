package ua.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;


public interface ProfilRepository{
	
	
	
	Page<CafeIndexView> findAllViews(String user,CafeFilter filter, Pageable pageable,Sort sort);
	
}
