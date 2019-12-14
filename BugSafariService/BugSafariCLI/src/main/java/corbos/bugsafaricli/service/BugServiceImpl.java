/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.bugsafaricli.service;

import corbos.bugsafaricli.data.BugDao;
import corbos.bugsafaricli.data.DataException;
import corbos.bugsafaricli.models.Bug;
import java.util.List;

/**
 *
 * @author mrmac
 */
public class BugServiceImpl implements BugServiceInterface {

    private BugDao dao;

    public BugServiceImpl(BugDao dao) {
        this.dao = dao;
    }

    @Override
    public void createBug(Bug bug) throws DataException, DuplicateLatinException, ValidationException {

        for (Bug b : dao.findAll()) {
            if (b.getLatinName().equalsIgnoreCase(bug.getLatinName())) {
                throw new DuplicateLatinException("There is already a bug with that Lating name in the collection.");
            }
        }

        validate(bug);

        dao.create(bug);
    }

    @Override
    public List<Bug> findAll() throws DataException {
        return dao.findAll();
    }

    @Override
    public boolean deleteBug(int bugId) throws DataException, LastBugDeleteException {
        if (dao.findAll().size() == 1) {
            throw new LastBugDeleteException("Cannot delete the last bug in the collection.");
        } else {
            return dao.delete(bugId);
        }

    }

    @Override
    public boolean updateBug(Bug bug) throws DataException, DuplicateLatinException, ValidationException {
        for (Bug b : dao.findAll()) {
            if (b.getLatinName().equalsIgnoreCase(bug.getLatinName())) {
                throw new DuplicateLatinException("There is already a bug with that Latin name in the collection.");
            }
        }

        validate(bug);

        return dao.update(bug);
    }

    private void validate(Bug bug) throws ValidationException {

        if (bug.getCommonName() == null
                || bug.getCommonName().isBlank()
                || bug.getLatinName() == null
                || bug.getLatinName().isBlank()) {

            throw new ValidationException("Both fields Common name and Latin name are required");
        }

    }

    @Override
    public Bug findById(int bugId) throws DataException {
        return dao.findById(bugId);
    }

}
