package p5;

import java.util.ArrayList;
import java.util.List;

public class RealEstate {
    private int id = 1000;
    private final List<Property> propertiesArray = new ArrayList<>();

    public void newProperty(String location, int bedrooms, int price) {
        this.propertiesArray.add(new Property(location, bedrooms, price));
        id++;
    }

    public void sell(int id) {
        try {
            Property temp = this.propertiesArray.get(id - 1000);

            if (temp.isAvailable()) {
                temp.setAvailable(false);
                System.out.printf("Imóvel %d vendido.\n", id);
            } else {
                System.out.printf("Imóvel %d não está disponível.\n", id);
            }
        } catch (Exception e) { // This exception catching handles when index is out of the bound.
            System.out.printf("Imóvel %d não existe.\n", id);
        }
    }

    public void setAuction(int id, DateYMD auctionStart, int days) {
        if (id < this.id && this.propertiesArray.get(id - 1000).isAvailable())
            this.propertiesArray.get(id - 1000).setAuction(auctionStart, days);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("Propriedades:\n");
        for (int i = 1000; i < id; i++) {
            Property temp = propertiesArray.get(i - 1000);
            str.append(String.format("Imóvel: %d; quartos %d; localidade: %s; preço: %d; disponível: %s",
                i,
                temp.getBedrooms(),
                temp.getLocation(),
                temp.getPrice(),
                temp.isAvailable() ? "sim" : "não"
            ));

            if (temp.getAuctionStart() != null) {
                str.append(String.format("; leilão %s : %s",
                    temp.getAuctionStart().toString(),
                    temp.getAuctionEnd().toString()
                ));
            }
            str.append("\n");
        }

        return str.toString();
    }
}
