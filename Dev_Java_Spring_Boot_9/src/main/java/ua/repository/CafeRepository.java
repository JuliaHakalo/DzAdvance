package ua.repository;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.entity.Type;
import ua.model.view.CafeIndexView;
import ua.model.view.CafeView;
import ua.model.view.MealView;

public interface CafeRepository extends JpaRepository<Cafe, Integer>{

	@Query("SELECT c FROM Cafe c WHERE c.id=?1")
	Cafe findById(Integer id);
	@Query("SELECT new ua.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl,c.version,c.address,c.fullDescription,c.type,c.phone,u.email,o.time,cl.time) FROM Cafe c LEFT JOIN  c.open o LEFT JOIN  c.close cl LEFT JOIN c.user u")
	List<CafeView> findAllViews();
	@Query("SELECT new ua.model.view.CafeIndexView(c.id,c.rate,c.name,c.photoUrl,c.version,c.address,c.shortDescription,c.type) FROM Cafe c ")
	List<CafeIndexView> findAllIndexViews();
	@Query("SELECT o.time FROM OpenClose o")
	List<LocalTime> findAllTimes();
	@Query("SELECT new ua.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl,c.version,c.address,c.fullDescription,c.type,c.phone,u.email,o.time,cl.time) FROM Cafe c LEFT JOIN  c.open o LEFT JOIN  c.close cl LEFT JOIN c.user u WHERE c.id=?1")
	CafeView findCafeViewById(Integer id);
	@Query("SELECT new ua.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl,c.version,c.address,c.fullDescription,c.type,c.phone,u.email,o.time,cl.time) FROM Cafe c LEFT JOIN  c.open o LEFT JOIN  c.close cl LEFT JOIN c.user u")
	List<CafeIndexView> findAllViewsByDesc(Sort sort);
	@Query("SELECT new ua.model.view.CafeIndexView(c.id,c.rate,c.name,c.photoUrl,c.version,c.address,c.shortDescription,c.type) FROM Cafe c ")
	List<CafeIndexView> findAllIndexViewsByDesc(Sort sort);
	
}