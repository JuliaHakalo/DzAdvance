package ua.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;
import java.math.BigDecimal;
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
import ua.entity.Ingredient;
import ua.entity.Meal;
import ua.entity.User;
import ua.model.filter.MealFilter;
import ua.model.view.MealView;
import ua.repository.MealViewRepository;

@Repository
public class MealViewRepositoryImpl implements MealViewRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<MealView> findAll(MealFilter filter, Pageable pageable, Sort sort) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MealView> cq = cb.createQuery(MealView.class);
		Root<Meal> root = cq.from(Meal.class);
		Join<Meal, Cuisine> join = root.join("cuisine");
		// Integer id, String title, String description, BigDecimal price, String
		// photoUrl, int version,String cuisine, int weight
		cq.multiselect(root.get("id"), root.get("title"), root.get("description"), root.get("price"),
				root.get("photoUrl"), root.get("version"), join.get("name"), root.get("weight"));
		///////
		PredicateBuilder builder = new PredicateBuilder(filter, cb, root);
		Predicate predicate = builder.toPredicate();
		if (predicate != null)
			cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<MealView> content = em.createQuery(cq).setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
				.setMaxResults(pageable.getPageSize()).getResultList();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Meal> rootCount = cqCount.from(Meal.class);
		cqCount.select(cb.count(rootCount));
		PredicateBuilder builderCount = new PredicateBuilder(filter, cb, rootCount);
		Predicate predicateCount = builderCount.toPredicate();
		if (predicateCount != null)
			cqCount.where(predicateCount);
		return PageableExecutionUtils.getPage(content, pageable, () -> em.createQuery(cqCount).getSingleResult());
	}

	@Override
	public Page<MealView> findAllByIdCafe(MealFilter filter, Pageable pageable, Sort sort, Integer id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MealView> cq = cb.createQuery(MealView.class);
		Root<Meal> root = cq.from(Meal.class);
		Join<Meal, Cuisine> join = root.join("cuisine");
		// Integer id, String title, String description, BigDecimal price, String
		// photoUrl, int version,String cuisine, int weight
		cq.multiselect(root.get("id"), root.get("title"), root.get("description"), root.get("price"),
				root.get("photoUrl"), root.get("version"), join.get("name"), root.get("weight"));
		///////
		PredicateBuilderCafeId builder = new PredicateBuilderCafeId(filter, cb, root,id);
		Predicate predicate = builder.toPredicate();
		if (predicate != null)
			cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<MealView> content = em.createQuery(cq).setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
				.setMaxResults(pageable.getPageSize()).getResultList();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Meal> rootCount = cqCount.from(Meal.class);
		cqCount.select(cb.count(rootCount));
		PredicateBuilderCafeId builderCount = new PredicateBuilderCafeId(filter, cb, rootCount,id);
		Predicate predicateCount = builderCount.toPredicate();
		if (predicateCount != null)
			cqCount.where(predicateCount);
		return PageableExecutionUtils.getPage(content, pageable, () -> em.createQuery(cqCount).getSingleResult());
	}

	private static class PredicateBuilder {

		final MealFilter filter;

		final CriteriaBuilder cb;

		final Root<Meal> root;

		final List<Predicate> predicates = new ArrayList<>();

		public PredicateBuilder(MealFilter filter, CriteriaBuilder cb, Root<Meal> root) {
			this.filter = filter;
			this.cb = cb;
			this.root = root;
		}

		void findByTitle() {
			if (!filter.getSerchTitle().isEmpty()) {
				predicates.add(cb.like(root.get("title"), filter.getSerchTitle() + "%"));
			}
		}

		void findByMinPrice() {
			if (!filter.getMinPrice().isEmpty()) {
				predicates.add(cb.ge(root.get("price"), new BigDecimal(filter.getMinPrice().replace(',', '.'))));
			}
		}

		void findByMaxPrice() {
			if (!filter.getMaxPrice().isEmpty()) {
				predicates.add(cb.le(root.get("price"), new BigDecimal(filter.getMaxPrice().replace(',', '.'))));
			}
		}

		void findByMinWeight() {
			if (!filter.getMinWeight().isEmpty()) {
				predicates.add(cb.ge(root.get("weight"), Integer.valueOf(filter.getMinWeight())));
			}
		}

		void findByMaxWeight() {
			if (!filter.getMaxWeight().isEmpty()) {
				predicates.add(cb.le(root.get("weight"), Integer.valueOf(filter.getMaxWeight())));
			}
		}

		void findByIngredients() {
			if (!filter.getIngredientIds().isEmpty()) {
				Join<Meal, Ingredient> join = root.join("ingredients");
				predicates.add(join.get("id").in(filter.getIngredientIds()));
			}
		}

		void findByCuisines() {
			if (!filter.getCuisinesIds().isEmpty()) {

				Join<Meal, Cuisine> join = root.join("cuisine");
				predicates.add(join.get("id").in(filter.getCuisinesIds()));
			} else {
				System.out.println("LOX");
			}
		}

		Predicate toPredicate() {
			findByMinPrice();
			findByMaxPrice();
			findByMinWeight();
			findByMaxWeight();
			findByIngredients();
			findByCuisines();
			findByTitle();
			return cb.and(predicates.stream().toArray(Predicate[]::new));
		}
	}

	private static class PredicateBuilderCafeId {

		final MealFilter filter;

		final CriteriaBuilder cb;

		final Root<Meal> root;

		final List<Predicate> predicates = new ArrayList<>();
		final Integer id;

		public PredicateBuilderCafeId(MealFilter filter, CriteriaBuilder cb, Root<Meal> root, Integer id) {
			this.filter = filter;
			this.cb = cb;
			this.root = root;
			this.id = id;
		}

		void findByTitle() {
			if (!filter.getSerchTitle().isEmpty()) {
				predicates.add(cb.like(root.get("title"), filter.getSerchTitle() + "%"));
			}
		}

		void findByMinPrice() {
			if (!filter.getMinPrice().isEmpty()) {
				predicates.add(cb.ge(root.get("price"), new BigDecimal(filter.getMinPrice().replace(',', '.'))));
			}
		}

		void findForCafeId() {
				Join<Meal, Cafe> join = root.join("cafe");
				predicates.add(cb.equal(join.get("id"), id));
			
		}

		void findByMaxPrice() {
			if (!filter.getMaxPrice().isEmpty()) {
				predicates.add(cb.le(root.get("price"), new BigDecimal(filter.getMaxPrice().replace(',', '.'))));
			}
		}

		void findByMinWeight() {
			if (!filter.getMinWeight().isEmpty()) {
				predicates.add(cb.ge(root.get("weight"), Integer.valueOf(filter.getMinWeight())));
			}
		}

		void findByMaxWeight() {
			if (!filter.getMaxWeight().isEmpty()) {
				predicates.add(cb.le(root.get("weight"), Integer.valueOf(filter.getMaxWeight())));
			}
		}

		void findByIngredients() {
			if (!filter.getIngredientIds().isEmpty()) {
				Join<Meal, Ingredient> join = root.join("ingredients");
				predicates.add(join.get("id").in(filter.getIngredientIds()));
			}
		}

		void findByCuisines() {
			if (!filter.getCuisinesIds().isEmpty()) {

				Join<Meal, Cuisine> join = root.join("cuisine");
				predicates.add(join.get("id").in(filter.getCuisinesIds()));
			} else {
				System.out.println("LOX");
			}
		}

		Predicate toPredicate() {
			findByMinPrice();
			findByMaxPrice();
			findByMinWeight();
			findByMaxWeight();
			findByIngredients();
			findByCuisines();
			findByTitle();
			findForCafeId();
			return cb.and(predicates.stream().toArray(Predicate[]::new));
		}
	}

}