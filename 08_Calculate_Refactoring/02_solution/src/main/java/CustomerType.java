public enum CustomerType {
    NOT_REGISTERED (1) {
        @Override
        public double discount(int years) {
            return 0;
        }

    },
    SIMPLE (2) {
        @Override
        public double ratio() {
            return 0.1;
        }
    },
    VALUABLE (3) {
        @Override
        public double ratio() {
            return 0.3;
        }
    },
    MOST_VALUABLE (4) {
        @Override
        public double ratio() {
            return 0.5;
        }
    };

    private final int value;

    CustomerType (int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public double discount(int years) {
        return (years > 5) ? (double) 5 / 100 : (double) years / 100;
    }

    public double ratio() {
        return 0.0;
    }
}
