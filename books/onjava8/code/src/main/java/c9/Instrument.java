package c9;


abstract class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()" + n);
    }

//    public abstract void play(Node n);
}
