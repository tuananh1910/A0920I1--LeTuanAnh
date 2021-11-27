package trainee.elevators.model.entity;

import java.util.List;

public class Elevator {
    private Long id;
    private int capacity;
    private double speed;
    private int maxWeight;

    //@OneToOne
    private Door door;

    //@OneToOne
    private Status status;

    //OneToMany
    private List<Button> button;

    // OneToMany
    private List<Indicator> indicator;

    // getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    public List<Indicator> getIndicator() {
        return indicator;
    }

    public void setIndicator(List<Indicator> indicator) {
        this.indicator = indicator;
    }

    // constructor
    public Elevator(Long id, int capacity, double speed,
                    int maxWeight, Door door, Status status,
                    List<Button> button, List<Indicator> indicator) {
        this.id = id;
        this.capacity = capacity;
        this.speed = speed;
        this.maxWeight = maxWeight;
        this.door = door;
        this.status = status;
        this.button = button;
        this.indicator = indicator;
    }

    public Elevator() {
    }
}
