package stage1.TasksPack3.Task2;

import java.util.Random;

public class Computer {
    public boolean isOn = false;
    private final Hdd hdd;
    private final Processor processor;
    private final Ram ram;

    public Computer(Hdd hdd, Processor processor, Ram ram) {
        this.hdd = hdd;
        this.processor = processor;
        this.ram = ram;
    }

    public void power() {
        isOn = !isOn;
    }

    public boolean checkPower(){
        return isOn;
    }


    public boolean virusCheck() {
        Random rnd = new Random();
        return rnd.nextBoolean();
    }

    public String getMemory() {
        return "Размер винчестера: " + hdd.getCapacity()
                + "\nРазмер оперативной памяти: " + ram.getCapacity();
    }

}
