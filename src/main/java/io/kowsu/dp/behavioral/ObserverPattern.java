package io.kowsu.dp.behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Blog();
        Observer user1 = new User();
        user1.setSubject(subject);
        Observer user2 = new User();
        user2.setSubject(subject);

        subject.registerObserver(user1);
        subject.registerObserver(user2);

        subject.notifyObserver();
        subject.unregisterObserver(user1);
        subject.notifyObserver();

    }
}


interface Subject {
    void registerObserver(Observer observer);
    void notifyObserver();
    Object getUpdate();
    void unregisterObserver(Observer observer);
}

interface Observer {
    void setSubject(Subject subject);
    void update();
}


class Blog implements Subject {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        System.out.println("Registering observer");
        this.observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        System.out.println("De-registering observer");
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        this.observers.forEach(Observer::update);
    }

    @Override
    public String getUpdate() {
        return "latest change";
    }
}

class User implements Observer {

    private Subject subject;
    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.printf("Received update from subject ---> %s  \n",
                subject.getUpdate().toString().concat(String.format(" %s", UUID.randomUUID().toString())));
    }
}

