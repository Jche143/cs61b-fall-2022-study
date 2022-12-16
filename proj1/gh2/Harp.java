package gh2;

public class Harp extends GuitarString{
    private static final double DECAY = .996;

    public Harp(double frequency) {
        super(frequency * 2);
    }

    public void tic() {
        double frontSample = buffer.removeFirst();
        double newlast = ((frontSample + buffer.get(0)) / 2) * DECAY;
        buffer.addLast(-newlast);
    }
}
