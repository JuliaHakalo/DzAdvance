package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Table;
import ua.model.view.CafeView;

public interface TableRepository extends JpaRepository<Table, Integer>{
	List<Table> findAll();
	@Query("SELECT new ua.model.view.CafeView(c.id,c.rate,c.name,c.photoUrl,c.version,c.address,c.fullDescription,c.type,c.phone,u.email,o.time, cl.time) From Cafe c LEFT JOIN c.open o LEFT JOIN c.close cl LEFT JOIN c.user u")
	List<CafeView> findAllViewsCafe();
	
	@Query("SELECT  m FROM Table m JOIN FETCH m.cafe c WHERE m.id=?1")
	Table findOneRequest(Integer id);
	
	@Query("SELECT  m FROM Table m LEFT JOIN  m.users WHERE m.id=?1")
	Table findOneTable(Integer id);
	@Query("SELECT  m FROM Table m JOIN FETCH m.cafe c WHERE c.id=?1")
	List<Table> findAllTablesbyIdCafe(Integer id);
	@Query("SELECT  m FROM Table m JOIN  m.cafe c WHERE c.id=?1 AND m.isFree=?2")
	List<Table> findAllTablesbyIdCafeReserved(Integer id,boolean isFree);
	@Query("SELECT  m.id FROM Table m JOIN  m.cafe c WHERE c.id=?1 AND m.isFree=?2")
	List<Integer> findAllTablesbyIdCafeReservedIDS(Integer id,boolean isFree);	
}