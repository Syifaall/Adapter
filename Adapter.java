public class Adapter {
    public interface Duck {
        void quack();
        void fly();
    }
    public interface Turkey {
        void gobble();
        void fly();
    }
    public static class WildTurkey implements Turkey {
        @Override
        public void gobble() {
            System.out.println("Gobble gobble");
        }

        @Override
        public void fly() {
            System.out.println("I'm flying a short distance");
        }
    }
    public static class TurkeyAdapter implements Duck {
        private Turkey turkey;

        public TurkeyAdapter(Turkey turkey) {
            this.turkey = turkey;
        }

        @Override
        public void quack() {
            turkey.gobble();
        }

        @Override
        public void fly() {
            for (int i = 0; i < 5; i++) {
                turkey.fly();
            }
        }
    }
    public static void main(String[] args) {
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe TurkeyAdapter says...");
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
