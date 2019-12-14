/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.bugsafaricli.data;

import corbos.bugsafaricli.models.Bug;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mrmac
 */
public class BugDaoTest {

    public BugDaoTest() {
    }

    public static BugDao dao = new BugDao();

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {

    }

    @BeforeEach
    public void setUp() throws DataException {
        for (Bug bug : dao.findAll()) {
            dao.delete(bug.getBugId());
        }
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of create method, of class BugDao.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        Bug bug = new Bug();
        bug.setBugId(001);
        bug.setCommonName("abc");
        bug.setLatinName("ABC");
        dao.create(bug);

        assertEquals("abc", dao.findById(001).getCommonName(), "common fail");
        assertEquals("ABC", dao.findById(001).getLatinName(), "latin fail");

        assertEquals(bug, dao.findById(001), "Did not point to the same bug");
        assertEquals(1, dao.findAll().size(), "did not get added to the file");

    }

    /**
     * Test of update method, of class BugDao.
     */
    @Test
    public void testUpdate() throws Exception {
        Bug bug = new Bug();
        bug.setBugId(001);
        bug.setCommonName("abc");
        bug.setLatinName("ABC");
        dao.create(bug);

        Bug bugUpdated = new Bug();
        bugUpdated.setBugId(001);
        bugUpdated.setCommonName("abcd");
        bugUpdated.setLatinName("ABCD");
        dao.update(bugUpdated);

        assertEquals("abcd", dao.findById(001).getCommonName(), "common fail");
        assertEquals("ABCD", dao.findById(001).getLatinName(), "latin fail");

        assertEquals(bugUpdated, dao.findById(001), "Did not update the same bug");

    }

    /**
     * Test of delete method, of class BugDao.
     */
    @Test
    public void testDelete() throws Exception {
        Bug bug = new Bug();
        bug.setBugId(001);
        bug.setCommonName("abc");
        bug.setLatinName("ABC");
        dao.create(bug);
        dao.delete(001);
        assertNull(dao.findById(001));
        assertEquals(0, dao.findAll().size(), "did not get removed from the file");
    }

    /**
     * Test of findById method, of class BugDao.
     */
    @Test
    public void testFindById() throws Exception {
        Bug bug = new Bug();
        bug.setBugId(001);
        bug.setCommonName("abc");
        bug.setLatinName("ABC");
        dao.create(bug);
        assertEquals(bug, dao.findById(001), "Did not point to the same bug");
    }

    /**
     * Test of findAll method, of class BugDao.
     */
    @Test
    public void testFindAll() throws Exception {
        Bug bug = new Bug();
        bug.setBugId(001);
        bug.setCommonName("abc");
        bug.setLatinName("ABC");
        dao.create(bug);
        assertEquals(1, dao.findAll().size(), "did not get added to the file");
    }

}
