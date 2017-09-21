// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model;

/**
 * @author pl041antcepa, 13 wrz 2017 CRIF IT Solutions Poland
 */
public enum MessageTypes {
    CREATE_OBJECT("1"), INFO("0"), ROOMS("2"), JOIN("3"), ROOM_INFO("4"), NEW_ROUND("5"), MOVE("6"), ROUND_SUMMARY("7"), LOGIN("8"), LEAVE_ROOM("9"), NEW_ROOM("10"),
    ;

    private String value;

    MessageTypes(String value) {
        this.value = value;
    }

    public String enumValue() {
        return value;
    }

    public static MessageTypes parse(String value) {
        for (MessageTypes type : MessageTypes.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
