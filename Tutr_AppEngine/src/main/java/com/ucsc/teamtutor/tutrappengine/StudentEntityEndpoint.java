package com.ucsc.teamtutor.tutrappengine;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "studentEntityApi",
        version = "v1",
        resource = "studentEntity",
        namespace = @ApiNamespace(
                ownerDomain = "tutrappengine.teamtutor.ucsc.com",
                ownerName = "tutrappengine.teamtutor.ucsc.com",
                packagePath = ""
        )
)
public class StudentEntityEndpoint {

    private static final Logger logger = Logger.getLogger(StudentEntityEndpoint.class.getName());

    /**
     * This method gets the <code>StudentEntity</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>StudentEntity</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getStudentEntity")
    public StudentEntity getStudentEntity(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getStudentEntity method");
        return null;
    }

    /**
     * This inserts a new <code>StudentEntity</code> object.
     *
     * @param studentEntity The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertStudentEntity")
    public StudentEntity insertStudentEntity(StudentEntity studentEntity) {
        // TODO: Implement this function
        logger.info("Calling insertStudentEntity method");
        return studentEntity;
    }
}