
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnnualReviewTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreateAnnualReview() {
        assertEquals(true,AnnualReview.createAnnualReview("abc100", "Surname: David" ));
    }

    @Test
    public void testCreateAnnualReviewWrong() {
        assertEquals(true,AnnualReview.createAnnualReview("a100", "Surname: David" ));
    }

    @Test
    public void testModifyAnnualReview() {
        assertEquals(true,AnnualReview.modifyAnnualReview("abc100"));
    }

    @Test
    public void testModifyWithWrongDetails() {
        assertEquals(false,AnnualReview.modifyAnnualReview("John"));

    }

    @Test
    public void readCorrect() {
        assertEquals(true,AnnualReview.read("abc100"));
    }

    @Test
    public void readIncorrect() {
        assertEquals(true,AnnualReview.read("Steve"));
    }
}
