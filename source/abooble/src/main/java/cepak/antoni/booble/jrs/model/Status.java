// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model;

/**
 * @author pl041antcepa, 18 wrz 2017
 * CRIF IT Solutions Poland
 */
public enum Status {
    OK("1"), ERROR("0"),
    ;

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String enumValue() {
        return value;
    }

    public static Status parse(String value) {
        for (Status type : Status.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
