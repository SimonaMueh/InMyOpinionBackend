package world.inmyopinion.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import world.inmyopinion.domain.JsonViews;
import world.inmyopinion.domain.Topic;
import world.inmyopinion.service.TopicService;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

	private final TopicService topicService;
	
	
	@Autowired
	public TopicController(TopicService topicService){
		System.out.println("Du ficker");
		this.topicService = topicService;
	}
	
	@JsonView(JsonViews.Summary.class)
	@GetMapping
	public List<Topic> retrieveAllTopics(){
		System.out.println("At home");
	   	return topicService.findAll();
	}
	
	@JsonView(JsonViews.Detail.class)
	@GetMapping("/{id}")
	public Topic retrieveTopicById(@PathVariable Long id ) {
		return topicService.findById(id);
	}
	
	@GetMapping(value="/search", params="query")
	@ResponseBody
	public List <Topic> searchTopic(@RequestParam("query") String query){
		return topicService.findByTextIgnoreCaseContaining(query);
	}

}
