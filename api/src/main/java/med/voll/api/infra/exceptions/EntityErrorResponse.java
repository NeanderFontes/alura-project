package med.voll.api.infra.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public class EntityErrorResponse {
    private final int httpStatus;
    private final String message;
    private String stackTrace;
    private List<ValidationError> errors;

    public void addValidationError(String filed, String message) {
        if (Objects.isNull(errors)) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(new ValidationError(filed, message));
    }

}


