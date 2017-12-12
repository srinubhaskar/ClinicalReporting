package com.vijayadurga.clinic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6352768217218406699L;

	@Column(unique = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Integer age;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = true)
	private String referedBy;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReferedBy() {
		return referedBy;
	}

	public void setReferedBy(String referedBy) {
		this.referedBy = referedBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
