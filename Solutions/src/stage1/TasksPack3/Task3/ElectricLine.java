package stage1.TasksPack3.Task3;

import java.util.ArrayList;
import java.util.Scanner;

public class ElectricLine {
    private final ArrayList<ElectricalAppliance> appliances = new ArrayList<>();

    public void setPowerToAppliances() {
        Scanner in = new Scanner(System.in);
        askUserForValue("Холодильник");
        appliances.add(new Fridge(in.nextInt()));
        askUserForValue("Миксер");
        appliances.add(new Mixer(in.nextInt()));
        askUserForValue("Пылесос");
        appliances.add(new Vacuum(in.nextInt()));
        askUserForValue("Телевизор");
        appliances.add(new Television(in.nextInt()));
        askUserForValue("Кондиционер");
        appliances.add(new AirConditioner(in.nextInt()));
        askUserForValue("Чайник");
        appliances.add(new Kettle(in.nextInt()));
    }

    public int getListLength() {
        return appliances.size();
    }

    public void switchPowerByIndex(int index) {
        appliances.get(index).switchPower();
        appliances.get(index).setCurrentLoad(0);
    }

    public void askUserForValue(String name) {
        System.out.printf("Введите значения мощности для: %s\n", name);
    }

    public void printList() {
        int count = 0;
        for (ElectricalAppliance appliance : appliances) {
            String isPowered = appliance.isOn() ? "Вкл." : "Выкл.";
            System.out.printf("%d. %s - %s\n", count++, appliance.getName(), isPowered);
        }

    }

    public void checkForLoadExceeding(int limitAmperage) {

        int sumPower = 0;
        System.out.println("В сети включены:");
        for (ElectricalAppliance appliance : appliances) {
            if (appliance.isOn()) {
                appliance.setCurrentLoad((double) appliance.getPower() / ElectricalAppliance.VOLTAGE);
                System.out.printf("%s, нагрузка на сеть - %.2fA\n", appliance.getName(), appliance.getCurrentLoad());
            }
            sumPower = sumPower + appliance.getPower();
        }
        int resAmperage = sumPower / ElectricalAppliance.VOLTAGE;
        System.out.printf("\nРезультирущая нагрузка - %d A", resAmperage);
        System.out.printf("\nЛимит - %d A \n", limitAmperage);
        if (resAmperage > limitAmperage) {
            double min = 0;
            ElectricalAppliance closestByLoad = appliances.get(0);
            for (ElectricalAppliance electronic : appliances) {
                double load = electronic.getCurrentLoad();
                if (load > min && load < resAmperage - limitAmperage) {
                    min = load;
                    closestByLoad = electronic;
                }
            }
            System.out.printf("\nЛучше выключить - %s\n", closestByLoad.getName());
            System.out.printf("Его нагрузка на сеть - %.2fA\n", closestByLoad.getCurrentLoad());
        } else {
            System.out.println("Ничего выключать не нужно! Вычисленная сила тока не превышает допустимую!");
        }
    }
}
