public class Radio
{
    private double currentFrequency;
    private int currentVolume;

    public double getCurrentFrequency() {
        return  currentFrequency;
    }

    public int getCurrentVolume() {
        return  currentVolume;
    }

    public void changeStation(double frequency) {
        if (frequency > 108.9)
            frequency = 87.0;
        currentFrequency = frequency;
    }

    public void volumeUp() {
        if (currentVolume < 10)
            currentVolume++;
    }

    public void volumeDown() {
        if (currentVolume > 0)
            currentVolume--;
    }
}
