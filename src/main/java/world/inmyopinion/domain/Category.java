package world.inmyopinion.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "categories")
@Data
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "topics")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonView(JsonViews.Summary.class)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonView(JsonViews.Summary.class)
	@Column(nullable = false, length = 75)
	private String text;
	
	@JsonView(JsonViews.Category.class)
//	@JsonBackReference
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Topic> topics = new ArrayList<>();
	
	
	public Category() {
	}
	
	public Category(Long id, String text, List<Topic> topics) {
		this.id = id;
		this.text = text;
		this.topics = topics;
	}
	
//	public Category(Long id, String text){
//		this.id = id;
//		this.text = text;	
//	}
//	
	public Category( String text) {
	        this( null, text, null);
	    }
	

	public void addTopic(Topic topic) {
		topic.setCategory(this);
		getTopics().add(topic);
	}
	
}