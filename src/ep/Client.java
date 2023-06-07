package ep;

public class Client {
    private int nif;
    private String name;
    private ClientType clientType;

    public Client(int nif, String name, ClientType clientType) {
        this.nif = nif;
        this.name = name;
        this.clientType = clientType;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public int getNif() {
        return nif;
    }

    @Override
    public String toString() {
        return name + " [" + clientType + ": " + nif + "]";
    }
}
