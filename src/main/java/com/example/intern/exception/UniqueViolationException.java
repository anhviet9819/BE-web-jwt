package com.example.intern.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UniqueViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    private String resourceName;
    private Long idValue;
    
    public UniqueViolationException( String resourceName, Long idValue) {
        super(String.format(" Duplicate entry id '%s' for key '%s'  " , idValue, resourceName ));
        this.resourceName = resourceName;
        this.idValue = idValue;
    }

    public String getResourceName() {
        return resourceName;
    }
    public Object getIdValue() {
        return idValue;
    }
}
