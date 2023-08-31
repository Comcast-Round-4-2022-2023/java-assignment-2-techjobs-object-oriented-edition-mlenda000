package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.PositionType;

import org.launchcode.techjobs.oo.Location;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {


    @Test
    public void testSettingJobId(){
        Job a = new Job();
        Job b = new Job();
        assertNotEquals(a.getId() == b.getId());
    }

    private void assertNotEquals(boolean b) {
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job c =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(c.getName() instanceof String);
        assertTrue(c.getEmployer() instanceof Employer);
        assertTrue(c.getLocation() instanceof Location);
        assertTrue(c.getPositionType() instanceof PositionType);
        assertTrue( c.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester",c.getName());
        assertEquals("ACME",c.getEmployer().getValue());
        assertEquals("Desert",c.getLocation().getValue());
        assertEquals("Quality control",c.getPositionType().getValue());
        assertEquals("Persistence",c.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job a =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job b =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(a.getId() == b.getId());
        assertFalse(a == b);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job b =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals( "\nID: " + b.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n",b.toString());

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job b =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals( '\n',b.toString().charAt(0));
        assertEquals( '\n',b.toString().charAt(b.toString().length()-1));

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job b =new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals( "\nID: " + b.getId() + "\nName: Product tester\nEmployer: Data not available\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Data not available\n",b.toString());
    }


}
