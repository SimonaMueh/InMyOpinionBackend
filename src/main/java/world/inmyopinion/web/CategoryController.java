package world.inmyopinion.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import world.inmyopinion.domain.Category;
import world.inmyopinion.domain.JsonViews;
import world.inmyopinion.domain.Topic;
import world.inmyopinion.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	@JsonView(JsonViews.Summary.class)
	@GetMapping
	public List<Category> retrieveAllCategories(){
	   	return categoryService.findAll();
	}
	
	@JsonView(JsonViews.Detail.class)
	@GetMapping("/{id}")
	public Category retrieveTopicById(@PathVariable Long id ) {
		return categoryService.findById(id);
	}

}
