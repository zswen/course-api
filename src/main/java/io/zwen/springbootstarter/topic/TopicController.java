package io.zwen.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired // This will let springBoot auto inject that singleton. This actually wired a controller to a service
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		
		return topicService.getAppTopics();
	}
	
	@RequestMapping("/topics/{id}") // Default is GET
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics") // POST
	public void addTopic(@RequestBody Topic topic) { // This annotation is saying that the request payload (payload is sent from client who sent POST api call) needs to contain a json reprenstation of Topic object. Spring will convert it into a Topic object instance
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}") // PUT
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) { // This annotation is saying that the request payload needs to contain a json reprenstation of Topic object. Spring will convert it into a Topic object instance
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}") // Default is GET
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
