import static org.junit.Assert.*;

import org.example.Course;
import org.example.Student;
import org.example.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import org.example.UserChoice;
import java.util.ArrayList;
import java.util.List;

public class UserChoiceTest {
    @Test
    public void testContainsProfanity() {
        assertTrue(UserChoice.containsProfanity("This is a fucking test"));
        assertTrue(UserChoice.containsProfanity("You are an asshole"));
        assertFalse(UserChoice.containsProfanity("This is a clean test"));
        assertFalse(UserChoice.containsProfanity("Hello World!"));
    }

    @Test
    public void testContainsNumbers() {
        assertTrue(UserChoice.containsNumbers("Hello123"));
        assertTrue(UserChoice.containsNumbers("123"));
        assertFalse(UserChoice.containsNumbers("Hello"));
        assertFalse(UserChoice.containsNumbers("No numbers here"));
    }

    @Test
    public void testShowProfit() {
        UserChoice.totalStudentEnrollment = 9000.0;
        UserChoice.totalCourseCost = 3000.0;
        UserChoice.totalTeacherSalary = 2000.0;

        double expectedProfit = UserChoice.totalStudentEnrollment - (UserChoice.totalCourseCost + UserChoice.totalTeacherSalary);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserChoice.showProfit();

        String actualOutput = outContent.toString().trim();

        System.setOut(System.out);

        assertEquals(String.valueOf(expectedProfit), actualOutput);
    }

    @Before
    public void setUp() {
        UserChoice.courses = new ArrayList<>();
        UserChoice.courses.add(new Course("Math101", 0));
        UserChoice.courses.add(new Course("Science102", 0));
        UserChoice.courses.add(new Course("History103", 0));
    }

    @Test
    public void testFindCourseById_CourseExists() {
        Course course = UserChoice.findCourseById("Course1");
        assertNotNull(course);
        assertEquals("Math101", ((Course) course).getName());
    }

    @Test
    public void testFindCourseById_CourseDoesNotExist() {
        Course course = UserChoice.findCourseById("NonExistentCourse");
        assertNull(course);
    }

    @Test
    public void testLookupCourse_CourseDoesNotExist() {
        String input = "NonExistentCourse\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserChoice.lookupCourse();

        String expectedOutput = "Course with ID NonExistentCourse not found.";
        String actualOutput = outContent.toString().trim();  // Trim to remove any extra newline

        System.setIn(System.in);
        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Before
    public void setUpStudent() {
        UserChoice.students = new ArrayList<>();
        UserChoice.students.add(new Student("Alice", "123 Main St", "alice@example.com"));
        UserChoice.students.add(new Student("Bob",  "456 Maple Ave", "bob@example.com"));
        UserChoice.students.add(new Student("Charlie", "789 Oak Dr", "charlie@example.com"));

        UserChoice.teachers = new ArrayList<>();
        UserChoice.teachers.add(new Teacher("Mr. Smith", 700));
        UserChoice.teachers.add(new Teacher("Ms. Johnson", 800));
        UserChoice.teachers.add(new Teacher("Dr. Brown", 900));
    }

    @Test
    public void testFindStudentById_StudentExists() {
        Student student = UserChoice.findStudentById("1");
        assertNotNull(student);
        assertEquals("Alice", student.getName());
    }

    @Test
    public void testFindStudentById_StudentDoesNotExist() {
        Student student = UserChoice.findStudentById("NonExistentStudent");
        assertNull(student);
    }

    @Before
    public void setUpStudentLookUp() {
        UserChoice.students = new ArrayList<>();
        UserChoice.students.add(new Student("Alice", "123 Main St", "alice@example.com"));
        UserChoice.students.add(new Student("Bob", "456 Maple Ave", "bob@example.com"));
        UserChoice.students.add(new Student("Charlie","789 Oak Dr", "charlie@example.com"));
    }

    @Test
    public void testLookupStudent_StudentExists() {
        String input = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserChoice.lookupStudent();

        String expectedOutput = "Student Name: Alice";
        String actualOutput = outContent.toString().trim();
        System.setIn(System.in);
        System.setOut(System.out);

        assertTrue(actualOutput.contains(expectedOutput));
    }

    @Test
    public void testLookupStudent_StudentDoesNotExist() {
        String input = "4\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserChoice.lookupStudent();

        String expectedOutput = "Student with ID 4 not found.";
        String actualOutput = outContent.toString().trim();
        System.setIn(System.in);
        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Before
    public void setUpShowStudent() {
        UserChoice.students = new ArrayList<>();
        UserChoice.students.add(new Student("Alice",  "123 Main St", "alice@example.com"));
        UserChoice.students.add(new Student("Bob",  "456 Maple Ave", "bob@example.com"));
        UserChoice.students.add(new Student("Charlie",  "789 Oak Dr", "charlie@example.com"));
    }

    @Test
    public void testShowStudentNames() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserChoice.showStudentNames();

        String expectedOutput = "Students: \nAlice\nBob\nCharlie";
        String actualOutput = outContent.toString().trim();
        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testShowTeacherNames() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserChoice.showTeacherNames();

        String expectedOutput = "Teachers: \nMr. Smith\nMs. Johnson\nDr. Brown";
        String actualOutput = outContent.toString().trim();
        System.setOut(System.out);
        assertEquals(expectedOutput, actualOutput);
    }

}
