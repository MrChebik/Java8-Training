package ru.mrchebik.task10.math;

/**
 * Created by mrchebik on 8/3/17.
 */
public class AverageStream {
    private long count;
    private double value;

    public AverageStream() {
        this.count = 0;
        this.value = 0;
    }

    private AverageStream(long count,
                         double value) {
        this.count = count;
        this.value = value;
    }

    public AverageStream accept(double value) {
        return new AverageStream(++this.count, this.value + value);
    }

    public AverageStream combine(AverageStream averageStream) {
        return new AverageStream(this.count + averageStream.count, this.value + averageStream.value);
    }

    public double average() {
        return value / count;
    }
}
