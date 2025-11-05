package main;

import java.util.List;

public class Metrics {
    private final double avgWait;
    private final double avgPassage;
    private final double throughput;
    private final int completedCount;
    private final List<Double> waits;
    private final List<Double> passages;
    private final double[] utilizations;

    public Metrics(double avgWait,
            double avgPassage,
            double throughput,
            int completedCount,
            List<Double> waits,
            List<Double> passages,
            double[] utilizations) {
        this.avgWait = avgWait;
        this.avgPassage = avgPassage;
        this.throughput = throughput;
        this.completedCount = completedCount;
        this.waits = waits;
        this.passages = passages;
        this.utilizations = utilizations;
    }

    // --- Getters ---
    public double getAvgWait() {
        return avgWait;
    }

    public double getAvgPassage() {
        return avgPassage;
    }

    public double getThroughput() {
        return throughput;
    }

    public int getCompletedCount() {
        return completedCount;
    }

    public List<Double> getWaits() {
        return waits;
    }

    public List<Double> getPassages() {
        return passages;
    }

    public double[] getUtilizations() {
        return utilizations;
    }

    public double getMedianWait() {
        return median(waits);
    }

    public double getMedianPassage() {
        return median(passages);
    }

    public double getPercentileWait(double p) {
        return percentile(waits, p);
    }

    public double getPercentilePassage(double p) {
        return percentile(passages, p);
    }

    private double median(List<Double> values) {
        if (values == null || values.isEmpty())
            return 0.0;
        List<Double> sorted = values.stream().sorted().toList();
        int n = sorted.size();
        if (n % 2 == 1)
            return sorted.get(n / 2);
        return (sorted.get(n / 2 - 1) + sorted.get(n / 2)) / 2.0;
    }

    private double percentile(List<Double> values, double p) {
        if (values == null || values.isEmpty())
            return 0.0;
        List<Double> sorted = values.stream().sorted().toList();
        int index = (int) Math.ceil(p / 100.0 * sorted.size()) - 1;
        index = Math.max(0, Math.min(index, sorted.size() - 1));
        return sorted.get(index);
    }

    @Override
    public String toString() {
        return String.format("Metrics[avgWait=%.2f, avgPassage=%.2f, throughput=%.3f, completed=%d]",
                avgWait, avgPassage, throughput, completedCount);
    }
}
