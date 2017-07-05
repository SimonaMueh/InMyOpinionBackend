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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "votes")
@Data
@EqualsAndHashCode(exclude = "id")
public class Vote implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Topic topic;
	
	@Column(nullable = false)
	private Boolean selection;
	
	@Column(nullable = false)
	private String ip;
	
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