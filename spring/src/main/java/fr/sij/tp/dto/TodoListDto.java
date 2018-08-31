package fr.sij.tp.dto;

import java.util.*;

public class TodoListDto {

	public int id;
	public String color;
	public String title;
	public String owner;
	public Date dueDate;

	public List<TaskDto> tasks = new ArrayList<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoListDto other = (TodoListDto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String str = "";
		String tasks = "{";
		for (TaskDto t : this.tasks) {
			tasks = tasks + t.toString();
		}
		str = "{" + this.id + ", " + this.title + ", " + this.owner + ", " + this.dueDate + " " + tasks + "}";
		return str;
	}

	public TaskDto getTask(int idTask) {
		for (TaskDto task : tasks) {
			if (task.id == idTask) {
				return task;
			}
		}
		return null;
	}

}
