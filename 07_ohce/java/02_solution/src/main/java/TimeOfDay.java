public enum TimeOfDay {
    MORNING {
        @Override
        public String pattern() {
            return  "¡Buenos días %s!";
        }
    }, NIGHT {
        @Override
        public String pattern() {
            return  "¡Buenas noches %s!";
        }
    };

    public String pattern() {
        return "";
    }
}
