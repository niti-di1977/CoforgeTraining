package com.hcl.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="course_details")
public class Course 
{
	@Id
	private int id;
	private String title;
	private int duration;
	private float fees;
}
