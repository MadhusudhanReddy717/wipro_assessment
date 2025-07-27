package assessment;

class Tank {
    private boolean isReleased = false;

    public void fillTank() {
        System.out.println("Tank filled.");
    }

    public void emptyTank() {
        System.out.println("Tank emptied.");
    }

    public void releaseTank() {
        isReleased = true;
        System.out.println("Tank resources released properly.");
    }

    @Override
    protected void finalize() throws Throwable {
        if (!isReleased) {
            System.out.println("Warning: Tank not released properly!");
        } else {
            System.out.println("Tank finalized safely.");
        }
        super.finalize();
    }
}

public class Q36 {
    public static void main(String[] args) {
        Tank t1 = new Tank();
        t1.fillTank();
        t1.emptyTank();
        t1.releaseTank();

        Tank t2 = new Tank();
        t2.fillTank();
        t2.emptyTank();
        // Forgot to release t2

        t1 = null;
        t2 = null;

        System.gc(); // Suggest GC to run and call finalize
        try {
            Thread.sleep(1000); // Give GC some time to act
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
