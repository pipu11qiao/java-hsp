package c8;

class Cleanser {
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append("dilute()");
    }

    public void apply() {
        append("apply()");
    }

    public void scrub() {
        append("scrub()");
    }

    @Override

    public String toString() {
        return s;
    }

    public static void main(String[] args) {

        Cleanser x = new Cleanser();

        x.dilute();
        x.apply();
        x.scrub();

        System.out.println(x);

    }
}


public class Detergent extends Cleanser {

    //Changeamethod:

    @Override

    public void scrub() {

        append("Detergent.scrub()");

        super.scrub(); //Callbase-classversion

    }

    //Addmethodstotheinterface:

    public void foam() {
        append("foam()");
    }

    //Testthenewclass:

    public static void main(String[] args) {

        Detergent x = new Detergent();

        x.dilute();

        x.apply();

        x.scrub();

        x.foam();

        System.out.println(x);

        System.out.println("Testingbaseclass:");

        Cleanser.main(args);

    }

}
