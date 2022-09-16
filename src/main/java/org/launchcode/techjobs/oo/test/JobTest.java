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


//    Before writing your first test, consider how we want the method to behave:
//
//When passed a Job object, it should return a string that contains a blank line before and after the job information.
//
//The string should contain a label for each field, followed by the data stored in that field. Each field should be on its own line.
//
//ID:  _______
//Name: _______
//Employer: _______
//Location: _______
//Position Type: _______
//Core Competency: _______
//If a field is empty, the method should add, “Data not available” af
//
//
//
//
// ter the label.
//
//(Bonus) If a Job object ONLY contains data for the id field, the method should return, “OOPS! This job does not seem to exist.”
//
//In JobTest, add a new test named testToStringStartsAndEndsWithNewLine to check the first requirement. Be sure to use assertEquals to verify that these characters are correct, and to use the exact formatting demonstrated above.
//
//Tip
//This test should check that the first and last characters of the string both the newline character, \n. Recall that can get the character at a given position in a string using the string method charAt.
    @Test
    public  void testToStringStartsAndEndsWithNewLine(){
        Job jobExpected = new Job();
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals('\n', job1.toString().charAt(0));
//        char lastChar = job1.toString().length()-1
        char lastChar = job1.toString().charAt(job1.toString().length() - 1);
//                String str = "India";
//System.out.println("last char = " + str.charAt(str.length() - 1));
//        (job1.charAt(job1.length())-1)
//
        assertEquals('\n', lastChar);

//        assertEquals( jobExpected.toString().charAt(0), job1.toString().charAt(0));
//        assertEquals( jobExpected.toString().charAt(jobExpected.toString().length()), job1.toString().charAt(job1.toString().length()));

//toString is the method that contains the proper print out with the \n line break string in it, but its a bunch of tiny strings
//        the toString method, returns the key:value pairs of an instance of the job class, like job1
//


//        assertEquals("\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPositionType: Quality control\nCoreCompetency: Persistence\n"), (job1.toString();
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

//    @Test
//    public void testToStringHandlesEmptyField(){
//        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        assertEquals(job1.toString(),"", " ");
//    }

}
