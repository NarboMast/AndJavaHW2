package sharedVia;

import enums.SharedType;

public class ValidateSharedType {
    public static String validateSharedType(SharedType sharedType, String ticketId) {
        if (sharedType == null) {
            return ticketId + " is not shared";
        }

        SharedVia sharedVia;

        switch (sharedType) {
            case PHONE -> sharedVia = new SharedViaPhone();
            case PHONE_EMAIL -> sharedVia = new SharedViaPhoneEmail();
            default -> {
                return ticketId + " is not shared";
            }
        }

        return sharedVia.sharedVia(ticketId);
    }
}
