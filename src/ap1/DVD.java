package ap1;

public class DVD extends LibraryItem {
    private final int duration; // Minutes

    public DVD(int id, String title, int duration) {
        super(id, title);

        if (duration > 0) {
            this.duration = duration;
        } else {
            throw new IllegalArgumentException("Duration must be positive.");
        }
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "DVD " + super.toString() + " Duration: " + this.getDuration();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof DVD)) {
            return false;
        }

        DVD comparingObj = (DVD) o;
        return super.equals(comparingObj);
    }
}
