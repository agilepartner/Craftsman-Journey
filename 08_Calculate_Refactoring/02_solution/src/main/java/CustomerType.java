public enum CustomerType {
    NOT_REGISTERED (1, 0.0) {
        @Override
        public double discount(int years) {
            return 0;
        }
    },
    SIMPLE (2, 0.1),
    VALUABLE (3, 0.3),
    MOST_VALUABLE (4, 0.5);

    private final int value;
    private final double ratio;

    CustomerType (int value, double ratio) {
        this.value = value;
        this.ratio = ratio;
    }

    public int value() {
        return value;
    }

    public double ratio() {
        return ratio;
    }

    public double discount(int years) {
        return (years > 5) ? (double) 5 / 100 : (double) years / 100;
    }

}
