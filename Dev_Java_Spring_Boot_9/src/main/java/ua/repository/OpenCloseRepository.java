package ua.repository;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Ingredient;
import ua.entity.Meal;
import ua.entity.OpenClose;

public interface OpenCloseRepository extends JpaRepository<OpenClose,Integer>,JpaSpecificationExecutor<OpenClose>{
	@Query("SELECT o FROM OpenClose o WHERE o.time=?")
	OpenClose findByTime(LocalTime time);
	@Query("SELECT o.time FROM OpenClose o ")
	List<LocalTime> findAllTimes();
	@Query("SELECT o FROM OpenClose o")
	List<OpenClose> findAll();
	@Query("SELECT DISTINCT m FROM OpenClose m WHERE m.id=?1")
	OpenClose findOne(Integer id);
}