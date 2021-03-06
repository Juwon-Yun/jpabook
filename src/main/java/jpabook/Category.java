package jpabook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// LAZY에 alt + enter => static import
import static javax.persistence.FetchType.LAZY;

@Entity
public class Category extends BaseEntity{
	@Id @GeneratedValue
	private long id;

	private String name;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "PARENT_ID")
	private Category parent;

	// self로 양방향 잡힘
	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<>();
	
	// 다대다 단방향
	@ManyToMany
	@JoinTable(name = "CATEGORY_ITEM"
		, joinColumns = @JoinColumn(name = "CATEGORY_ID")
		, inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
	)
	private List<Item> items = new ArrayList<>();
}
