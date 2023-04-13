package p8.ex2;

import java.util.HashMap;

public class Menu {
    private final String name, location;
    private final HashMap<DaysOfTheWeek, Dish> dishHashMap = new HashMap<>();

    Menu(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addDish(Dish dish, DaysOfTheWeek dayOfTheWeek) {
        this.dishHashMap.put(dayOfTheWeek, dish);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DaysOfTheWeek dayOfTheWeek;

        for (int i = 0; i < dishHashMap.size(); i++) {
            dayOfTheWeek = DaysOfTheWeek.values()[i];
            sb.append(dishHashMap.get(dayOfTheWeek)).append(", on ").append(dayOfTheWeek).append("\n");
        }

        return sb.toString();
    }
}
