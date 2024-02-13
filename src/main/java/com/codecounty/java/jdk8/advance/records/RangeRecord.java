package com.codecounty.java.jdk8.advance.records;

import java.io.Serializable;

/*Notice that there is no need to add any additional boilerplate to RangeRecord in order to make it serializable. Specifically, there is no need to add a serialVersionUID field, since the serialVersionUID of a record class is 0L unless explicitly declared, and the requirement for matching the serialVersionUID value is waived for record classes. Rarely, for migration compatibility between normal classes and record classes, a serialVersionUID may be declared,
 see Section 5.6.2 Compatible Changes of the Java Object Serialization Specification for more details.*/
public record RangeRecord(int lo, int hi) implements Serializable {
    public RangeRecord {
        if (lo > hi)
            throw new IllegalArgumentException(String.format("%d, %d", lo, hi));
    }

}