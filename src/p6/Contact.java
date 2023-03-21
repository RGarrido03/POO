package p6;

public class Contact {
    private static int idCounter = 1;
    private final int id;
    private final Person person;
    private int phone = -1;
    private String email;

    public Contact(Person person, int phone, String email) {
        this.person = person;

        try {
            this.setPhone(phone);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            this.setEmail(email);
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals("Invalid e-mail. It must have the form \"name@domain\".")) {
                System.out.println(e.getMessage());
            } else {
                throw e;
            }
        }
        this.id = idCounter++;
    }

    public int getPhone() {
        return this.phone;
    }

    public boolean willBeEmpty(int phone, String email) {
        // TODO: Check if phone number and e-mail won't be empty after setting null.
        return phone == -1 && (email == null || email.equals(""));
    }

    public void setPhone(int phone) {
        if (phone == 0 || phone == -1) {
            // callingMethod is used to check if the method is being called from the constructor.
            // If it is, the exception won't be thrown, because email isn't set yet.
            String callingMethod = new Throwable().getStackTrace()[1].getMethodName();
            if (willBeEmpty(-1, this.email) && !callingMethod.equals("<init>")) {
                throw new IllegalArgumentException("Contact must have at least a phone number or an e-mail");
            } else {
                this.phone = -1;
            }
        } else if (Integer.toString(phone).matches("^9[0-9]{8}$")) {
            // About the if:
            // - The regex checks if the phone number is 9 digits long and starts with the digit 9
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number. It must be 9 digits long and start with the digit 9.");
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (email == null || email.equals("")) {
            if (willBeEmpty(this.phone, email)) {
                throw new IllegalArgumentException("Contact must have at least a phone number or an e-mail");
            } else {
                this.email = null;
            }
        } else if (email.matches("^([\\w\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$")) {
            // About the if:
            // - The regex checks if the e-mail is valid (i.e., has the form "name@domain")
            // - Object.equals() circunvents the null check
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid e-mail. It must have the form \"name@domain\".");
        }
    }

    public Person getPerson() {
        return person;
    }

    public String getName() {
        return this.person.getName();
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.person.toString() + "; Phone: " + this.phone + "; E-mail: " + this.email;
    }

    public boolean equals(Contact contact) {
        return this.person.equals(contact.getPerson());
    }

    public boolean equals(Person person) {
        return this.person.equals(person);
    }
}
