package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	/**
	 * Default action. render the app/views/Application/index.html template
	 */
	public static void index() {
		List<Task> tasks = Task.findAll();
		render(tasks);
	}

	/**
	 * Add a new task.
	 */
	public static void add(@Required String name) {
		Task task = new Task(name);
		task.save();
		renderJSON(task);
	}
	
	/**
	 * Update a task.
	 */
	public static void done(@Required Long id, @Required boolean done) {
		Task task = Task.findById(id);
		task.done = done;
		task.save();
		renderJSON(task);
	}
	
	/**
	 * Update a task.
	 */
	public static void deleteAll() {
		int value = Task.deleteAll();
		renderJSON(value);
	}
}