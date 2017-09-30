package ua.controller;

import static org.mockito.Matchers.anyListOf;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;
import ua.repository.CafeViewOfProfilRepository;
import ua.repository.CafeViewRepository;
import ua.repository.ProfilRepository;
import ua.service.CafeService;
import ua.service.MealService;
import ua.service.TableService;

@Controller
public class MainController {

	private final CafeService service;
	private final TableService service2;
	private final CafeViewRepository repository;
	private final MealService service3;

	@Autowired
	
	
	@ModelAttribute("cafeFilter")
	public CafeFilter getFilter() {
		return new CafeFilter();
	}

	public MainController(CafeService service, TableService service2, CafeViewRepository repository,
			MealService service3) {
		this.service = service;
		this.service2 = service2;
		this.repository = repository;
		this.service3 = service3;
	}


	@GetMapping("/")
	public String index(Model model, Principal principal, @ModelAttribute("cafeFilter") CafeFilter filter,@PageableDefault Pageable pageable) {
		model.addAttribute("meals", service3.findAll());
		model.addAttribute("cafes", repository.findAll(filter, pageable,new Sort(Sort.Direction.DESC, "rate")));
		List<CafeIndexView> cafes =  (repository.findAll(filter, pageable,new Sort(Sort.Direction.DESC, "rate"))).getContent();
		CafeIndexView cafedefoult = new CafeIndexView(0,new BigDecimal(0), " ", " ",0," "," "," ");
		
//		if(!cafes.isEmpty()) {
//			if(cafes.size()<=4) {
//			for(int i=0;i<=cafes.size();i++) {
//				if(cafes.get(i)!=null) {
//					model.addAttribute("cafeindexview"+i,cafes.get(i));
//				}else {
//					model.addAttribute("cafeindexview"+i,cafedefoult);
//				}
//			}
//			int a = 5-cafes.size();
//			for (int i = cafes.size()-a-1; i < cafes.size(); i++) {
//				model.addAttribute("cafeindexview"+i,cafedefoult);
//			}
//			}
//			
			if(!cafes.isEmpty()) {
				if(cafes.size()>=5) {
			model.addAttribute("cafeindexview0",cafes.get(0));
			model.addAttribute("cafeindexview1",cafes.get(1));
			model.addAttribute("cafeindexview2",cafes.get(2));
			model.addAttribute("cafeindexview3",cafes.get(3));
			model.addAttribute("cafeindexview4",cafes.get(4));}
				else {for (int i = 0; i < cafes.size()-1; i++) {
					model.addAttribute("cafeindexview"+i,cafes.get(i));
					
				}
					
				}
			
		}
		
		if (principal != null) {
			model.addAttribute("message", "Hello " + principal.getName());
		} else {
			model.addAttribute("message", "Hello unregistered user");
		}
		return "index2";
	}

	@GetMapping("/cafe/{id}")
	public String showcafe(@PathVariable Integer id, Model model,Principal principal) {
		model.addAttribute("meals", service3.findAll());
		model.addAttribute("cafe", service.findCafeViewById(id));
		if(principal!=null) {
		if(service.findOne(id).getUser().getEmail().equals(principal.getName())) {
			model.addAttribute("isHISCafe",true);
		}else {
			model.addAttribute("isHISCafe",false);
		}}
		return "cafeid";
	}

	

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}