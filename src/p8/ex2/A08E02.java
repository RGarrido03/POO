package p8.ex2;

public class A08E02 {

	public static void main(String[] args) {
		Menu ementa = new Menu("Especial Primavera", "Snack da UA");
		Dish[] pratos = new Dish[DaysOfTheWeek.values().length];
		for (int i = 0; i < pratos.length; i++) {
			pratos[i] = randPrato(i + 1);
			System.out.println("A sair .. " + pratos[i]);

			// Adiciona 2 ingredientes a cada Dish
			int ingred = 1;
			do {
				Food aux = randAlimento();
				if (pratos[i].addIngredient(aux)) {
					System.out.println("\tIngrediente " + ingred + " adicionado: " + aux);
					ingred++;
				} else
					System.out.println("\tERRO: não é possível adicionar Ingrediente " + ingred + ": " + aux);
			} while (ingred < 3);

			ementa.addDish(pratos[i], DaysOfTheWeek.values()[i]);
		}
		System.out.println("\nEmenta final\n--------------------");
		System.out.println(ementa);
	}

	public static Food randAlimento() {
		return switch ((int) (Math.random() * 4)) {
			case 0 -> new Meat(MeatProtein.CHICKEN, 22.3, 345.3, 300);
			case 1 -> new Fish(FishType.FROZEN, 31.3, 25.3, 200);
			case 2 -> new Vegetable("Couve Flor", 21.3, 22.4, 150);
			case 3 -> new Cereal("Milho", 19.3, 32.4, 110);
			default -> null;
		};
	}

	public static Dish randPrato(int i) {
		return switch ((int) (Math.random() * 3)) {
			case 0 -> new Dish("combinado n." + i);
			case 1 -> new VegetarianDish("combinado n." + i);
			case 2 -> new DietDish("combinado n." + i, 90.8);
			default -> null;
		};
	}

}
