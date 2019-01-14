package com.example.springboot.web.springBootDemo.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Size;

@Entity
public class TaskToDo {
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	@Size(min=10, message="Enter atleast 10 characters")
	private String description;
	private Date targetDate;
	private boolean isCompleted;
	
	public TaskToDo() {
		super();
	}
	public TaskToDo(int id, String user, String desc, Date targetDate, boolean isCompleted) {
		super();
		this.id = id;
		this.userName = user;
		this.description = desc;
		this.targetDate = targetDate;
		this.isCompleted = isCompleted;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String user) {
		this.userName = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(description, id, isCompleted, targetDate, userName);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskToDo other = (TaskToDo) obj;
		return id == other.id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task [id=" + id + ", user=" + userName + ", desc=" + description + ", targetDate=" + targetDate + ", isCompleted="
				+ isCompleted + "]";
	}
	
}
