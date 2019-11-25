package com.pritam.authorization.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <pre>
 * <b>Description : </b>
 * UserNotFoundException.
 * 
 * @version $Revision: 1 $ $Date: Dec 13, 2017 12:19:56 PM $
 * @author $Author: pritam.ghosh $ 
 * </pre>
 */
public class BadCredentialException extends ApplicationCustomException {

    /**
     * serialVersionUID. 
     */
    private static final long serialVersionUID = 1108553482984732948L;

}
