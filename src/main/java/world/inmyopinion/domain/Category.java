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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "categories")
@Data
@EqualsAndHashCode(exclude = "id")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 75)
	private String text;
	
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Topic> topic = new ArrayList<>();
	
   
	public Category() {
		
	}
	
	public Category(Long id, String text){
		this.id = id;
		this.text = text;	
	}
	
	public Category( String text) {
	        this( null, text);
	    }

}