package corbos.bugsafaricli.service;

import corbos.bugsafaricli.data.DataException;
import corbos.bugsafaricli.models.Bug;
import java.util.List;

/**
 *
 * @author mrmac
 */
public interface BugServiceInterface {

    void createBug(Bug bug) throws
            DataException,
            DuplicateLatinException,
            ValidationException;

    List<Bug> findAll() throws DataException;

    boolean deleteBug(int bugId) throws
            DataException,
            LastBugDeleteException;

    Bug findById(int bugId) throws DataException;

    boolean updateBug(Bug bug) throws
            DataException,
            DuplicateLatinException,
            ValidationException; //will need validation

}
