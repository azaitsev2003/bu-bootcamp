import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");

        // Step 2: calculate statistics
        double average = calculateAverage(scores);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        if (!scores.isEmpty()) {
            for (int i = 0; i < scores.size(); i++) {
                if (scores.get(i) > highest) {
                    highest = scores.get(i);
                }
                if (scores.get(i) < lowest) {
                    lowest = scores.get(i);
                }
            }
        }
        else {
            highest = 0;
            lowest = 0;
        }

        // Step 3: write and print report
        writeReport(scores, average, highest, lowest, "report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scoreList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    try {
                        int n = Integer.parseInt(line);
                        scoreList.add(n);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Warning: Line Skipped: " + line);
                    }
                }
            }
        } 
        catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return scoreList;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (int i = 0; i < scores.size(); i++) {
            total += scores.get(i);
        }
        return total / scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, String outputFile) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) >= 90) {
                countA++;
            }
            else if (scores.get(i) >= 80) {
                countB++;
            }
            else if (scores.get(i) >= 70) {
                countC++;
            }
            else if (scores.get(i) >= 60) {
                countD++;
            }
            else {
                countF++;
            }
        }

        String report = String.format(
        "=== Grade Analysis Report ===%n" +
        "Total scores processed:  %d%n" +
        "%n" +
        "Average score:   %.2f%n" +
        "Highest score:   %d%n" +
        "Lowest score:    %d%n" +
        "%n" +
        "Grade distribution:%n" +
        "  A (90-100):   %d%n" +
        "  B (80-89):    %d%n" +
        "  C (70-79):    %d%n" +
        "  D (60-69):    %d%n" +
        "  F (below 60): %d%n",
        scores.size(), avg, high, low, countA, countB, countC, countD, countF);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(report);
        }
        catch (IOException e) {
            System.out.println("Could not write report: " + e.getMessage());
        }

        System.out.println(report);
    }
} 