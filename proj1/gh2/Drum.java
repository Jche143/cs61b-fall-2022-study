package gh2;

import edu.princeton.cs.algs4.StdRandom;

public class Drum extends GuitarString{
    private static final double DECAY = 1.0;

    public Drum(double frequency) {
        super(frequency);
    }

    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       **Do not call StdAudio.play().**
        double frontSample = buffer.removeFirst();
        double second = this.buffer.get(0);
        double newlast = 0.5 * DECAY * (frontSample + second);
        double r = StdRandom.uniform();
        if(r < 0.5){
            buffer.addLast(newlast);
        } else {
            buffer.addLast(-newlast);
        }
    }
}
