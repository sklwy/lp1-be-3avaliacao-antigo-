package com.project.lp1.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails {

    private final String fields;
    private final String messageFields;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ValidationExceptionDetails that = (ValidationExceptionDetails) o;

        return new EqualsBuilder() //
                .append(fields, that.fields) //
                .append(messageFields, that.messageFields) //
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37) //
                .append(fields) //
                .append(messageFields) //
                .toHashCode();
    }
}
