package world.inmyopinion.web;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.annotation.JsonView;

import world.inmyopinion.domain.Category;
import world.inmyopinion.domain.JsonViews;
import world.inmyopinion.domain.Topic;
import world.inmyopinion.domain.Vote;
import world.inmyopinion.service.CategoryService;
import world.inmyopinion.service.TopicService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryService categoryService;
	private final TopicService topicService;
	
	@Autowired
	public CategoryController(CategoryService categoryService, TopicService topicService){
		this.categoryService = categoryService;
		this.topicService = topicService;
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
	
	@JsonView(JsonViews.Detail.class)
	@PostMapping(value = "/{id}/topic")
	 public void createNew(@RequestBody Map<String, String> json, @PathVariable Long id){
		System.out.println(json);	
		//improve for random Number later...for now we leave it like this
//		int randomNum = ThreadLocalRandom.current().nextInt(0, 10 + 1);
//		String token = ""+randomNum;
		String token = UUID.randomUUID().toString();
		System.out.println("this is the token: " + token);
		Category category = this.categoryService.findById(id);
		System.out.println("this is the category: " + category);
		Topic userTopic = new Topic((json.get("text")), category, token);
		System.out.println("this is the userTopic: " + userTopic);
		category.addTopic(userTopic);
		this.topicService.createNew(userTopic);
		
//		public Topic( String text, Category category, String token);
	}
	


}
