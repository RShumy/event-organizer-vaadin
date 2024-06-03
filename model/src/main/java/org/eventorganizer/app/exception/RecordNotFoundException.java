package org.eventorganizer.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,
                reason = "Resource does not exist")
public class RecordNotFoundException extends RuntimeException{
                private static final long UID = 1L;
}
