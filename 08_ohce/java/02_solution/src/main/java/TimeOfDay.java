public enum TimeOfDay {
    MORNING {
        @Override
        public String pattern() {
            return  "¡Buenos días %s!";
        }
    },
    NIGHT {
        @Override
        public String pattern() {
            return  "¡Buenas noches %s!";
        }
    },
    AFTERNOON {
        @Override
        public String pattern() {
            return  "¡Buenas tardes %s!";
        }
    };

    public String pattern() {
        return "";
    }
}
