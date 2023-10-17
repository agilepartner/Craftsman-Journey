public class Birds {
    public interface Bird {
        void walk();
        void fly();
        void talk();
    }

    public class Eagle implements Bird {

        @Override
        public void walk() {
            /* ... */
        }

        @Override
        public void fly() {
            /* ... */
        }

        @Override
        public void talk() {
            throw new RuntimeException("Can't talk");
        }
    }

    public class Ostrich implements Bird {

        @Override
        public void walk() {
            /* ... */
        }

        @Override
        public void fly() {
            throw new RuntimeException("Can't fly");
        }

        @Override
        public void talk() {
            throw new RuntimeException("Can't talk");
        }
    }

    public class Parrot implements Bird {

        @Override
        public void walk() {
            /* ... */
        }

        @Override
        public void fly() {
            /* ... */
        }

        @Override
        public void talk() {
            /* ... */
        }
    }
}
