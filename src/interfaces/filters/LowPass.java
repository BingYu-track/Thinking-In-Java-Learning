package interfaces.filters;

//低通滤波器
public class LowPass extends Filter{

    double cutoff;
    public LowPass(double cutoff) { this.cutoff = cutoff; }
    public Waveform process(Waveform input) {
        return input; // Dummy processing
    }
}
