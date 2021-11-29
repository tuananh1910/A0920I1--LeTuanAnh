package elevators.model.entity;

public class Indicator {
    private Long id;
    private boolean isLight;

    // ManyToOne
    private Elevator elevators;

    // constructor
    public Indicator() {
    }

    public Indicator(Long id, boolean isLight, Elevator elevators) {
        this.id = id;
        this.isLight = isLight;
        this.elevators = elevators;
    }

    // getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLight() {
        return isLight;
    }

    public void setLight(boolean light) {
        isLight = light;
    }

    public Elevator getElevators() {
        return elevators;
    }

    public void setElevators(Elevator elevators) {
        this.elevators = elevators;
    }
}
