package stage1.TasksPack3.Task3;

public abstract class ElectricalAppliance {
    private final int power;
    private double currentLoad;
    public static final int VOLTAGE = 220;
    private boolean isOn = true;
    private String name;

    public ElectricalAppliance(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public boolean isOn() {
        return isOn;
    }

    public void switchPower() {
        isOn = !isOn;
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(double load) {
        currentLoad = load;
    }
}
