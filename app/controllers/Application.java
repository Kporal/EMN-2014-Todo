package controllers;

import play.*;
import play.cache.Cache;
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
	public static void add(String name) {
		Task task = new Task(name);
		task.save();
		renderJSON(task);
	}
	
	/**
	 * Remove a task.
	 */
	public static void delete(Long id) {
		Task task = Task.findById(id);
		task.done = true;
		task.save();
		renderJSON(task);
	}
}