import java.util.Random;

/**
 * RAKSHA-X threat detection simulation.
 * Uses simulated sensor readings (no real hardware) and a weighted
 * rule-based score to decide when to trigger the 3-level alert.
 * Hardware and a trained Edge AI model are planned future work.
 */
public class ThreatDetector {

    static final double THRESHOLD = 0.70;

    // Each input is a value between 0.0 (normal) and 1.0 (extreme)
    static double threatScore(double voiceStress, double movement, double darkness) {
        return 0.5 * voiceStress + 0.3 * movement + 0.2 * darkness;
    }

    static void triggerAlerts(double score) {
        System.out.println("  >> EMERGENCY MODE ON (score = " + String.format("%.2f", score) + ")");
        System.out.println("  >> Recording audio/video and locking GPS location");
        System.out.println("  >> Level 1: Alerting nearby Raksha users");
        System.out.println("  >> Level 2: Calling trusted contacts with live location");
        System.out.println("  >> Level 3: Sending location and evidence to nearest police station");
    }

    public static void main(String[] args) {
        Random random = new Random(42);

        for (int i = 1; i <= 10; i++) {
            double voice = random.nextDouble();
            double movement = random.nextDouble();
            double darkness = random.nextDouble();
            double score = threatScore(voice, movement, darkness);

            System.out.println("Reading " + i + ": voice=" + String.format("%.2f", voice)
                    + ", movement=" + String.format("%.2f", movement)
                    + ", darkness=" + String.format("%.2f", darkness)
                    + " -> score=" + String.format("%.2f", score));

            if (score >= THRESHOLD) {
                triggerAlerts(score);
            } else {
                System.out.println("  Normal. No action.");
            }
        }
    }
}
