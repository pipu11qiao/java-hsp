package c9;

public class Wind extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("wind.play()" + n);

    }

}
