package com.finalproject.Entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", nullable = false, unique = true)
	public Integer id;
    
    @Column(name = "name", nullable = false, length = 100)
	public String name;

    @Column(name = "email", nullable = false, unique = true, length = 150)
	public String email;

    @ManyToMany(mappedBy = "members")
	public Set<Group> groups = new HashSet<>();
   public User(Integer i, String string, String string2) {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Group> getGroups() {
		return groups;
	}
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	} 
}
