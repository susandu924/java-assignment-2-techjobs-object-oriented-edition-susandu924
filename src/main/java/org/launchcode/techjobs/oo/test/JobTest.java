package org.launchcode.techjobs.oo.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

//        Car test_car;
//
//    @Before
//    public void createCarObject(){
//        test_car =new Car("Toyota", "Prius", 10, 50);
//    }
    Job job1;
    Job job2;

    @Before
    public void createJobObject() {
        Job job1 = new Job();
        Job job2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

@Test
    public void testJobConstructorSetsAllFields(){
    Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

////        assertEquals is like put in the value, then getName
        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

//    Generate two Job objects that have identical field values EXCEPT for id. Test that equals returns false.
//    Can I just create 2 generic objects of the Job class to run in these tests? with before
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
//        equals returns false?
    }

//(Bonus) If a Job object ONLY contains data for the id field, the method should return, “OOPS! This job does not seem to exist.”
//
//In JobTest, add a new test named testToStringStartsAndEndsWithNewLine to check the first requirement. Be sure to use assertEquals to verify that these characters are correct, and to use the exact formatting demonstrated above.
//
//Tip
//This test should check that the first and last characters of the string both the newline character, \n. Recall that can get the character at a given position in a string using the string method charAt.
    @Test
    public  void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char lastChar = job1.toString().charAt(job1.toString().length() - 1);

        assertEquals('\n', job1.toString().charAt(0));
        assertEquals(lastChar, '\n');

//                String str = "India";
//System.out.println("last char = " + str.charAt(str.length() - 1));
//        (job1.charAt(job1.length())-1)
//        assertEquals( jobExpected.toString().charAt(0), job1.toString().charAt(0));
//        assertEquals( jobExpected.toString().charAt(jobExpected.toString().length()), job1.toString().charAt(job1.toString().length()));

//toString is the method that contains the proper print out with the \n line break string in it, but its a bunch of tiny strings
//        the toString method, returns the key:value pairs of an instance of the job class, like job1
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String job1AsAString = job1.toString();
        assertTrue(job1AsAString.contains("ID: " + job1.getId()));
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().toString());
        assertEquals("Desert", job1.getLocation().toString());
        assertEquals("Quality control", job1.getPositionType().toString());
        assertEquals("Persistence", job1.getCoreCompetency().toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testJob = "\nID: " + job1.getId() + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: "+ "Persistence" + "\n";
        assertEquals(testJob,job1.toString());
    }
}
