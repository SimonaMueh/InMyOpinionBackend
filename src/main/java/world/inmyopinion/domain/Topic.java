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
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "topics")
@Data
@EqualsAndHashCode(exclude = "id")
public class Topic implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 254)
	private String text;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private List<Vote> votes = new ArrayList<>();
	
	//Token length? and Type?
	@Column(nullable = false)
	private String token;
	
    @Column(name = "date_created", updatable = false, nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();
    
   
	
	public Topic() {
		
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

}
