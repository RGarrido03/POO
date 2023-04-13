package p8.ex2;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VegetarianFood that = (VegetarianFood) o;
        return Objects.equals(name, that.name) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
