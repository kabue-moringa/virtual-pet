import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MonsterTest {
    @Rule
    public DatabaseRule database =new DatabaseRule();


    @Test

    public  void monster_instantiateCorrectly_true(){
        Monster testMonster = new Monster ("Bubbles", 1);

        assertEquals(true, testMonster instanceof Monster);
    }

    @Test

    public  void monster_instantiateWithName_true(){
        Monster testMonster =  new Monster ( "Bubbles", 1);
        assertEquals("Bubbles", testMonster.getName());
    }

    @Test

    public  void Monster_instantiatesWithPersonId_int(){
        Monster testMonster = new Monster("Bubbles", 1);
        assertEquals(1, testMonster.getPersonId());
    }
}
