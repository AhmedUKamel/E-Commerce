package org.ahmedukamel.ecommerce.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {
    private final String identifier;
    private final Class theClass;

    public EntityNotFoundException(String identifier, Class theClass) {
        super(theClass.getName() + " " + identifier + " not found!");
        this.identifier = identifier;
        this.theClass = theClass;
    }

    public String getTheClassName() {
        return this.theClass.getSimpleName();
    }
}
