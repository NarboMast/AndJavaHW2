package enums;

public enum SharedType {
    PHONE {
        @Override
        public String share() {
            return "Ticket is shared via phone";
        }
    },
    PHONE_EMAIL {
        @Override
        public String share() {
            return "Ticket is shared via phone and email";
        }
    };

    public abstract String share();
}
