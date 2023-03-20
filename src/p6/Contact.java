package p6;

import java.util.Objects;

public class Contact {
    private static int idCounter = 1;
    private final int id;
    private final Person person;
    private int phone = -1;
    private String email;

    public Contact(Person person, int phone, String email) {
        this.id = idCounter++;
        this.person = person;

        try {
            this.setPhone(phone);
        } catch (IllegalArgumentException e) {
            try {
                this.setEmail(email);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Contact must have at least a phone number or an e-mail");
            }
        }
    }

    public int getPhone() {
        return this.phone;
    }

    public boolean willBeEmpty(int phone, String email) {
        // TODO: Check if phone number and e-mail won't be empty after setting null.
        return phone != 0 || email != null;
    }

    public void setPhone(int phone) {
        if (phone == 0 || phone == -1) {
            if (willBeEmpty(phone, this.email)) {
                throw new IllegalArgumentException("Contact must have at least a phone number or an e-mail");
            } else {
                this.phone = -1;
            }
        } else if (Integer.toString(phone).matches("^9[0-9]{8}$")) {
            // About the if:
            // - The regex checks if the phone number is 9 digits long and starts with the digit 9
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number");
        }

        // Check if phone number is 9 digits long and starts with the digit 9
        if (Integer.toString(phone).equals("^9[0-9]{8}$")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number");
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
            throw new IllegalArgumentException("Invalid e-mail");
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
}
