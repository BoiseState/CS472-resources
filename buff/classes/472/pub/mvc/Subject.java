// Singleton(127).Singleton
// Observer(293).Subject

import java.util.*;

public abstract class Subject {

    private Vector<Observer> observers=new Vector<>();

    public void attach(Observer observer) {
	observers.add(observer);
	observer.update();	// first time
    }

    public void detach(Observer observer) {
	observers.remove(observer);
    }

    // Object.notify() is final
    public void update() {
	for (Observer observer: observers)
	    observer.update();
    }

}
