package world.inmyopinion.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "votes")
@Data
@EqualsAndHashCode(exclude = "id")
public class Vote implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonView(JsonViews.Summary.class)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonView(JsonViews.Vote.class)
	@ManyToOne
	private Topic topic;
	
	@JsonView(JsonViews.Summary.class)
	@Column(nullable = false)
	private Boolean selection;
	
//	@Column(nullable = false)
	@JsonView(JsonViews.Vote.class)
	@Column
	private String ip;
	
	@JsonView(JsonViews.Vote.class)
	@Column(name = "date_created", updatable = false, nullable = false)
	private LocalDateTime dateCreated = LocalDateTime.now();
   
	public Vote() {
		
	}
	
	public Vote(Long id, Topic topic, Boolean selection, String ip, LocalDateTime dateCreated) {
		this.id = id;
		this.topic = topic;
		this.selection = selection;
		this.ip = ip;
		this.dateCreated = dateCreated;
	}
	
	public Vote(Long id, Topic topic, Boolean selection){
		this.id = id;
		this.topic = topic;	
		this.selection = selection;
	}
	
	public Vote( Topic topic, Boolean selection) {
	        this(null, topic, selection);
	    }

	

}