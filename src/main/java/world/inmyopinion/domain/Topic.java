package world.inmyopinion.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "topics")
@Data
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "votes")
public class Topic implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonView(JsonViews.Summary.class)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonView(JsonViews.Summary.class)
	@Column(nullable = false, length = 254)
	private String text;
	
//	@JsonView(JsonViews.Summary.class)
	@ManyToOne
	private Category category;
	
	@JsonView(JsonViews.Summary.class)
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private List<Vote> votes = new ArrayList<>();
	
	@JsonView(JsonViews.Detail.class)
	//Token length? and Type?
	@Column(nullable = false)
	private String token;
	
	@JsonView(JsonViews.Summary.class)
    @Column(name = "date_created", updatable = false, nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();
	
	
	public Topic() {
		
	}
	

	public Topic(Long id, String text, Category category, List<Vote> votes, String token, LocalDateTime dateCreated) {
		this.id = id;
		this.text = text;
		this.category = category;
		this.votes = votes;
		this.token = token;
		this.dateCreated = dateCreated;
	}
	
	
	public Topic(Long id, String text, Category category, String token){
		this.id = id;
		this.text = text;
		this.category = category;
		this.token = token;
		
	}
	
	
	public Topic( String text, Category category, String token) {
	        this( null, text, category, token);
	    }

	public void addVote(Vote vote) {
		vote.setTopic(this);
		getVotes().add(vote);
	}
	
	@PrePersist
    protected void prePersist() {
        this.dateCreated = LocalDateTime.now();
    }

}
