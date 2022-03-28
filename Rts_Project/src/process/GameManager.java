package process;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import entities.GameObject;
import entities.Player;

public class GameManager {
	
	public List<GameObject> object = new ArrayList<>();

	
	public void update() {
		for(GameObject tmpObject : object) {
			tmpObject.update();
			
		}
	}
	
	public void render(Graphics2D g2d) {
		
		for(GameObject tmpObject : object) {
			tmpObject.render(g2d);
		}
	}
	
	public void addObject(GameObject tmpObject) {
		object.add(tmpObject);
	
	}
	
	public void removeObject(GameObject tmpObject) {
		object.remove(tmpObject);
	}
	

	public List<GameObject> getObject() {
		return object;
	}

	
	
}