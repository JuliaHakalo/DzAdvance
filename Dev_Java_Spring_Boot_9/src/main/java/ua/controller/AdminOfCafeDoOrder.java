package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.OrderRequest;
import ua.service.MealService;
import ua.service.OrderService;
import ua.service.TableService;

@Controller
@RequestMapping("/cafe/{id}/order")
@SessionAttributes("order")
public class AdminOfCafeDoOrder {
	private final OrderService orderService;
	private final MealService mealService;
	private final TableService tableService;

	@Autowired
	public AdminOfCafeDoOrder(OrderService orderService, MealService mealService, TableService tableService) {
		this.orderService = orderService;
		this.mealService = mealService;
		this.tableService = tableService;
	}

	@ModelAttribute("order")
	public OrderRequest getForm() {
		return new OrderRequest();
	}

	@GetMapping
	public String show(Model model, @PathVariable Integer id) {
		model.addAttribute("tables", tableService.findAllTablesbyIdCafeReserved(id, false));
		model.addAttribute("meals", mealService.findAllViewsMealsByCafe(id));
		if (tableService.findAllTablesbyIdCafeReservedIDS(id, false).isEmpty()) {
			return "orders";
		}
		model.addAttribute("orders",
				orderService.findAllOrderForAllsTablesINCAFE(tableService.findAllTablesbyIdCafeReservedIDS(id, false)));
		return "orders";

	}

	@PostMapping
	public String save(@ModelAttribute("order") OrderRequest request, SessionStatus status,@PathVariable Integer id) {
		orderService.save(request);
		return cancel(status,id);
	}

	@GetMapping("/update/{id2}")
	public String update(@PathVariable Integer id2,@PathVariable Integer id, Model model) {
		model.addAttribute("order", orderService.findOne(id2));
		System.out.println(orderService.findOne(id2).getMeals());
		return show(model, id);
	}

	@GetMapping("/delete/{id2}")
	public String delete(@PathVariable Integer id,@PathVariable Integer id2) {
		orderService.delete(id2);
		return "redirect:/cafe/"+id+"/order";
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status,@PathVariable Integer id) {
		status.setComplete();
		return "redirect:/cafe/"+id+"/order";
	}
}
