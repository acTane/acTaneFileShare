/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.bugsafaricli.service;

/**
 *
 * @author mrmac
 */
public class LastBugDeleteException extends Exception{

    public LastBugDeleteException(String message) {
        super(message);
    }

    public LastBugDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
