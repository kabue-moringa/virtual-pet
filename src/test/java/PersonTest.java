import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PersonTest {

    @Rule
    public DatabaseRule database =  new DatabaseRule();
    @Test
    public void person_instantiatesCorrectly_true() {
        Person testPerson = new Person("Henry", "[email protected]");
        assertEquals(true, testPerson instanceof Person);
    }


    @Test
    public void getEmail_personInstantiatesWithEmail_String(){
        Person testPerson = new Person("Henry", "[email protected]");
        assertEquals("[email protected]", testPerson.getEmail());
    }

    @Test
    public void getName_personInstantiatesWithName_Henry(){
        Person testPerson =new Person ("Henry","[email protected]");
        assertEquals("Henry", testPerson.getName());
    }

//   Override
    @Test
    public void equals_returnsTrueIfNameAndEmailAreSame_true(){
      Person firstPerson = new Person("Henry","[email protected]");
      Person anotherPerson = new Person("Henry", "[email protected]");
      assertTrue(firstPerson.equals(anotherPerson));

    }



    @Test

    public void save_insertsObjectIntoDataBase_Person(){
        Person testPerson = new Person ("Henry","[email protected]");
        testPerson.save();
        assertTrue(Person.all().get(0).equals(testPerson));

    }
@Test


    public void all_returnAllInstancesOfPerson_true(){
        Person firstPerson = new Person ("Henry", "henry@henry.com");
        firstPerson.save();
        Person secondPerson = new Person("Harriet", "harriet@harriet.com");
        secondPerson.save();
        assertEquals(true, Person.all().get(0).equals(firstPerson));
        assertEquals(true, Person.all().get(1).equals(secondPerson));
}

@Test

//    assigniing id

    public void save_assignsIdToObject(){
        Person testPerson = new Person("Henry", "henry@henry.com");
        testPerson.save();
        Person savedPerson = Person.all().get(0);
        assertEquals(testPerson.getId(), savedPerson.getId());
}

@Test

public void find_returnPersonWithSameId_secondPerson(){
        Person firstPerson = new Person("Henry", "henry@Henry.com");
        firstPerson.save();
        Person secondPerson = new Person("Harriet", "harriet@harriet.com");
        secondPerson.save();
        assertEquals(Person.find(secondPerson.getId()), secondPerson);

}

}


