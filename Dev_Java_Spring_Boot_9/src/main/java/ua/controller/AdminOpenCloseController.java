//package ua.controller;
//
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import ua.entity.OpenClose;
//import ua.service.impl.OpenCloseServiceImpl;
//
//@Controller
//@RequestMapping("/admin/openclose")
//@SessionAttributes("opencloses")
//public class AdminOpenCloseController {
//	
//	private final OpenCloseServiceImpl service;
//
//	@Autowired
//	public AdminOpenCloseController(OpenCloseServiceImpl service) {
//		this.service = service;
//	}
//	@GetMapping
//	public String show(Model model) {
//		model.addAttribute("opencloses", service.findAll());
//		return "openclose";
//	}
//	
//	@GetMapping("/delete/{id}")
//	public String delete(@PathVariable Integer id) {
//		service.delete(id);
//		return "redirect:/admin/openclose";
//	}
//	
//	@PostMapping
//	public String save(@RequestParam String time) {
//		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//		//String[] times = time.split(" ");
//		 LocalTime dt = LocalTime.parse(time, dtf);
//		
//		//service.save(new OpenClose(LocalTime.of(Integer.valueOf(times[0]),Integer.valueOf(times[1]))));
//		 service.save(new OpenClose(dt));
//		return "redirect:/admin/openclose";
//	}
//
//}






//package ua.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import ua.entity.OpenClose;
//import ua.model.filter.SimpleFilter;
//import ua.model.request.OpenCloseRequest;
//import ua.service.OpenCloseService;
//import ua.service.impl.OpenCloseServiceImpl;
//
//@Controller
//@RequestMapping("/admin/openclose")
//@SessionAttributes("openclose")
//public class AdminOpenCloseController {
//
//	private final OpenCloseService service;
//	
//	@Autowired
//	public AdminOpenCloseController(OpenCloseService service) {
//		this.service = service;
//	}
//	@ModelAttribute("openclose")
//	public OpenCloseRequest getForm() {
//		return new OpenCloseRequest();
//	}
//	@ModelAttribute("filter")
//	public SimpleFilter getFilter() {
//		return new SimpleFilter();
//	}
//	@GetMapping
//	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
//		model.addAttribute("opencloses", service.findAll());
//		return "openclose";
//	}
//	@GetMapping("/delete/{id}")
//	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
//		service.delete(id);
//		return "redirect:/admin/openclose";
//	}
//	@GetMapping("/update/{id}")
//	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
//		model.addAttribute("openclose", service.findOne(id));
//		return show(model,pageable);
//	}
//	
//	@PostMapping
//	public String save(@ModelAttribute("openclose") OpenCloseRequest request,SessionStatus status,Pageable pageable) {
//		service.save(request);
//		return cancel(status);
//	}
//	@GetMapping("/cancel")
//	public String cancel(SessionStatus status) {
//		status.setComplete();
//		return "redirect:/admin/openclose";
//	}
//}
//package ua.controller;
//


package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import ua.entity.Ingredient;
import ua.model.filter.SimpleFilter;
import ua.model.request.OpenCloseRequest;
import ua.service.IngredientService;
import ua.service.OpenCloseService;
import ua.validation.flag.CuisineFlag;
import ua.validation.flag.IngredientFlag;
import ua.validation.flag.OpenCloseFlag;

@Controller
@RequestMapping("/admin/openclose")
@SessionAttributes("openclose")
public class AdminOpenCloseController {

	private final OpenCloseService service;
	
	@Autowired
	public AdminOpenCloseController(OpenCloseService service) {
		this.service = service;
	}
	
	@ModelAttribute("openclose")
	public OpenCloseRequest getForm() {
		return new OpenCloseRequest();
	}
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("opencloses", service.findAll(pageable,filter));
		return "openclose";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		service.delete(id);
		return "redirect:/admin/openclose"+buildParams(pageable, filter);
	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("openclose", service.findOne(id));
		return show(model, pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("openclose") @Validated(OpenCloseFlag.class) OpenCloseRequest openclose, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors()) return show(model, pageable, filter);
		service.save(openclose);
		return cancel(status,pageable,filter);
		//return "redirect:/admin/ingredient";
	}
	@GetMapping("/cancel")
	public String cancel(SessionStatus status,@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		status.setComplete();
		return "redirect:/admin/openclose"+buildParams(pageable, filter);
	}
	private String buildParams(Pageable pageable, SimpleFilter filter) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		buffer.append("&search=");
		buffer.append(filter.getSearch());
		return buffer.toString();
	}
}
