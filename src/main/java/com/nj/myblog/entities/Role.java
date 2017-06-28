/**
 * 
 */
package com.nj.myblog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author Siva
 *
 */
@Entity
public class Role 
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="r_id", nullable=false)
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
