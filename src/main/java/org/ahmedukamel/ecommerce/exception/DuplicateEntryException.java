package org.ahmedukamel.ecommerce.exception;

import lombok.Getter;

@Getter
public class DuplicateEntryException extends RuntimeException {
    private final String identifier;
    private final Class theClass;

    public DuplicateEntryException(String identifier, Class theClass) {
        super(theClass.getName() + " " + identifier + " already exist!");
        this.identifier = identifier;
        this.theClass = theClass;
    }

    public String getTheClassName() {
        return this.theClass.getSimpleName();
    }
}
