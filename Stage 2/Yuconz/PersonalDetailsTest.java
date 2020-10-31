import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonalDetailsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreatePersonalDetails() {
        assertEquals(true,PersonalDetails.createPersonalDetails("abc100", "Surname: David" ));
    }

    @Test
    public void testCreatePersonalDetailsWrong() {
        assertEquals(true,PersonalDetails.createPersonalDetails("a100", "Surname: David" ));
    }

    @Test
    public void testModifyPersonalDetails() {
        assertEquals(true,PersonalDetails.modifyPersonalDetails("abc100"));
    }

    @Test
    public void testModifyWithWrongDetails() {
        assertEquals(false,PersonalDetails.modifyPersonalDetails("John"));

    }

    @Test
    public void readCorrect() {
        assertEquals(true,PersonalDetails.read("abc100"));
    }

    @Test
    public void readIncorrect() {
        assertEquals(true,PersonalDetails.read("Steve"));
    }
}

