package ua.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import ua.entity.Cafe;
import ua.entity.Cuisine;
import ua.entity.Meal;
import ua.entity.OpenClose;
import ua.entity.Type;
import ua.entity.User;
import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;
import ua.model.view.CafeView;
import ua.repository.CafeViewOfProfilRepository;
import ua.repository.ProfilRepository;

@Repository
public class CafeViewOfProfilRepositoryImpl implements CafeViewOfProfilRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<CafeView> findAllViews(String user, CafeFilter filter, Pageable pageable,Sort sort) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CafeView> cq = cb.createQuery(CafeView.class);
		Root<Cafe> root = cq.from(Cafe.class);
		Join<Cafe,OpenClose> join = root.join("open");
		Join<Cafe,OpenClose> join2 = root.join("close");
		Join<Cafe,User> join3 = root.join("user");
		//(Integer id, BigDecimal rate, String name, String photoUrl, int version, String address,String fullDescription, Type type, String phone, String email, LocalTime open, LocalTime close)
		cq.multiselect(root.get("id"), root.get("rate"), root.get("name"), root.get("photoUrl"), root.get("version"), root.get("address"), root.get("fullDescription"), root.get("type"),root.get("phone"),join3.get("email"),join.get("time"),join2.get("time"));
		///////
		PredicateBuilder builder = new PredicateBuilder(filter, cb, root,user);
		Predicate predicate = builder.toPredicate();
		if(predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<CafeView> content = em.createQuery(cq)//що за рядки нащо це
				.setFirstResult(pageable.getPageNumber()*pageable.getPageSize())//що за рядки нащо це
				.setMaxResults(pageable.getPageSize())//що за рядки нащо це
				.getResultList();//що за рядки нащо це
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Cafe> rootCount = cqCount.from(Cafe.class);
		cqCount.select(cb.count(rootCount));
		PredicateBuilder builderCount = new PredicateBuilder(filter, cb, rootCount,user);
		Predicate predicateCount = builderCount.toPredicate();
		if(predicateCount!=null) cqCount.where(predicateCount);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult());
	}
	
	private static class PredicateBuilder{
		
		final CafeFilter filter;
		
		final CriteriaBuilder cb;
		
		final Root<Cafe> root;
		
		final List<Predicate> predicates = new ArrayList<>();
		
		final String user;

		public PredicateBuilder(CafeFilter filter, CriteriaBuilder cb, Root<Cafe> root,String user) { 
			this.filter = filter;
			this.cb = cb;
			this.root = root;
			this.user=user;
		}
		void findByTitle() {
			if(!filter.getSearchName().isEmpty()) {
				predicates.add(cb.like(root.get("name"), filter.getSearchName()+"%"));
			}
		}
		void findForUser() {
			if(!user.isEmpty()) {
				Join<Cafe, User> join = root.join("user");
				predicates.add(cb.like(join.get("email"),user));
			}
		}
		void findByMinRate() {
			if(!filter.getMinRate().isEmpty()) {
				predicates.add(cb.ge(root.get("rate"), new BigDecimal(filter.getMinRate().replace(',', '.'))));
			}
		}
		
		void findByMaxRate() {
			if(!filter.getMaxRate().isEmpty()) {
				predicates.add(cb.le(root.get("rate"), new BigDecimal(filter.getMaxRate().replace(',', '.'))));
			}
		}
		
		void findByTypes() {
			if(!filter.getTypes().isEmpty()) {
				predicates.add(root.get("type").in(filter.getTypes()));
			}
		}
		
		void findByMeals() {
			if(!filter.getMealsIds().isEmpty()) {
				Join<Cafe, Meal> join = root.join("meals");
				predicates.add(join.get("id").in(filter.getMealsIds()));
			}
		}
		
		Predicate toPredicate() {
			findByMinRate();
			findByMaxRate();
			findByTypes();
			findByMeals();
			findByTitle();
			findForUser();
			return cb.and(predicates.stream().toArray(Predicate[]::new));
		}
	}

	

	
}