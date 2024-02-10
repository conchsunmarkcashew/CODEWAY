import java.util.ArrayList;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void incrementEnrolledStudents() {
        enrolledStudents++;
    }

    public void decrementEnrolledStudents() {
        enrolledStudents--;
    }
}

class Student {
    private int studentID;
    private String name;
    private ArrayList<String> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

public class Register {
    public static void main(String[] args) {
        
        Course course1 = new Course("CSE101", "Introduction to Computer Science", "Introduction to programming and computer science concepts.", 50, "MWF 10:00 AM - 11:30 AM");
        Course course2 = new Course("MAT201", "Calculus I", "Introduction to differential and integral calculus.", 40, "TTH 8:00 AM - 9:30 AM");
        
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Student student3 = new Student(3, "Jack");
        

        
        student1.registerCourse(course1.getCourseCode());
        student3.registerCourse(course1.getCourseCode());
        student2.registerCourse(course2.getCourseCode());

        
        System.out.println("Available Courses:");
        displayCourseDetails(course1);
        displayCourseDetails(course2);
        
        displayStudentCourses(student1);
        displayStudentCourses(student2);
        displayStudentCourses(student3);

    }

    public static void displayCourseDetails(Course course) {
        System.out.println("Course Code: " + course.getCourseCode());
        System.out.println("Title: " + course.getTitle());
        System.out.println("Description: " + course.getDescription());
        System.out.println("Capacity: " + course.getCapacity());
        System.out.println("Schedule: " + course.getSchedule());
        System.out.println("Enrolled Students: " + course.getEnrolledStudents());
        System.out.println();
    }

    public static void displayStudentCourses(Student student) {
        System.out.println("Registered Courses for " + student.getName() + ":");
        for (String courseCode : student.getRegisteredCourses()) {
            System.out.println(courseCode);
        }
        System.out.println();
    }
}
