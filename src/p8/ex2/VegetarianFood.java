package p8.ex2;

abstract public class VegetarianFood extends Food {
    private String name;

    VegetarianFood(String name, double proteins, double calories, double weight) {
        super(proteins, calories, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
