package world.inmyopinion.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonView;

import world.inmyopinion.domain.JsonViews;
import world.inmyopinion.domain.Topic;
import world.inmyopinion.domain.Vote;
import world.inmyopinion.service.TopicService;
import world.inmyopinion.service.VoteService;

@RestController
@RequestMapping("/topics")
public class TopicController {

	private final TopicService topicService;
	private final VoteService voteService;
	
	
	@Autowired
	public TopicController(TopicService topicService, VoteService voteService){
		this.topicService = topicService;
		this.voteService = voteService;
	}
	
	@JsonView(JsonViews.Summary.class)
	@GetMapping
	public List<Topic> retrieveAllTopics(){
	   	return topicService.findAll();
	}
	
	@JsonView(JsonViews.Detail.class)
	@GetMapping("/{id}")
	public Topic retrieveTopicById(@PathVariable Long id ) {
		System.out.println(topicService.findById(id));
		return topicService.findById(id);
	}
	
	@JsonView(JsonViews.Summary.class)
	@GetMapping(value="/search", params="query")
	@ResponseBody
	public List <Topic> searchTopic(@RequestParam("query") String query){
		return topicService.findByTextIgnoreCaseContaining(query);
	}
	
	@JsonView(JsonViews.Detail.class)
	@PostMapping(value = "/{id}/vote")
	 public void createNew(@RequestBody Map<String, String> json, @PathVariable Long id, HttpServletRequest request){
		//get IP address
		System.out.println(request.getRemoteAddr());
		System.out.println(json);
		Topic topic = this.topicService.findById(id);
		System.out.println(topic);
		Vote userVote = new Vote(topic, Boolean.parseBoolean(json.get("selection")));
		System.out.println(userVote);
		topic.addVote(userVote);
		this.voteService.createNew(userVote);
	}
	
	
}
