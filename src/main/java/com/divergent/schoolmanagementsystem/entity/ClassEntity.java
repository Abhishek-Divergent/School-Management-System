package com.divergent.schoolmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "class")
public class ClassEntity {
	@Override
	public String toString() {
		return "ClassEntity [id=" + id + ", name=" + name + ", section=" + section + ", teacherid=" + teacherid + "]";
	}

	@Id
	@Column
	private int id;

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

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	@Column
	private String name;
	@Column
	private String section;
	@Column
	private int teacherid;

}
