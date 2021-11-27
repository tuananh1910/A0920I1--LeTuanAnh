package trainee.elevators.model.entity;

public class Door {
    private int id;
    private boolean state;

    // OneToOne
    private Elevator elevator;

    //getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    // constructor
    public Door(int id, boolean state, Elevator elevator) {
        this.id = id;
        this.state = state;
        this.elevator = elevator;
    }

    public Door() {
    }


}
