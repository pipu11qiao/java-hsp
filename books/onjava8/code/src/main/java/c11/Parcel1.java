package c11;

public class Parcel1 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        Contents c = new Contents();
        private String label;

        Destination(String whereTo) {
            Contents c = new Contents();
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    Contents c = new Contents();

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
//        Parcel1.Contents c = new Parcel1.Contents();
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }
}
