package io.kowsu.dp.behavioral;

public class StatePattern {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight(new RedColorState());
        light.getCurrentState();
        light.getCurrentState();
        light.setLightState(new YellowColorState());
        light.getCurrentState();
        light.getCurrentState();
        light.setLightState(new GreenColorState());
        light.getCurrentState();
        light.getCurrentState();
    }
}

class TrafficLight {

    private LightState lightState;

    public TrafficLight(LightState lightState) {
        this.lightState = lightState;
    }

    public void getCurrentState() {
        this.lightState.getState();
    }

    public void setLightState(LightState lightState) {
        this.lightState = lightState;
    }

}

interface LightState {
    void getState();
}

class RedColorState implements LightState {
    @Override
    public void getState() {
        System.out.println("Current state is red light; vehicles stopped now");
    }
}

class GreenColorState implements LightState {
    @Override
    public void getState() {
        System.out.println("Current state is red light; vehicles are running now");
    }
}

class YellowColorState implements LightState {
    @Override
    public void getState() {
        System.out.println("Current state is yellow light; vehicles started moving slowly.");
    }
}