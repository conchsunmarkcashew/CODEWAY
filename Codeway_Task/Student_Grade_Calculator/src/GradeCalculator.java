import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter marks obtained in each subject (out of 100):");
        
        System.out.print("Enter Total Subject :");
        
        int sub = scanner.nextInt();
        double averagePercentage = 0;
        
        int totalMarks=0;
        
        
        
        for(int i=1;i<=sub;i++) {
        System.out.print("Subject " + i +":");
        int subject = scanner.nextInt();
        
        totalMarks += subject;
        averagePercentage = totalMarks / sub;
        
        }

        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
