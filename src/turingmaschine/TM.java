package turingmaschine;
public class TM {
    Tape tape;
    Table table = new Table();
    String state;
    int stepCount = 0;
    static final String HALT_STATE = "HALT";

    TM(char pre, int head, String init, String state) {
        this.tape = new Tape(pre, head, init);
        this.state = state;
    }

    
    boolean step() {
        
        if (state.equals(HALT_STATE)) {
            System.out.println("Already in HALT state.");
            return false;
        }

        
        Trigger trigger = new Trigger(state, tape.read());
        Action action = table.findAction(trigger);

        
        if (action == null) {
            System.out.println("No transition for: " + trigger);
            return false;
        }

        
        tape.write(action.write());  
        tape.move(action.move());    
        state = action.toState();    
        System.out.println("Step " + stepCount + ": " + tape + " -- " + state);
        stepCount++;
        
        return true;
    }

    
    void run() {
        System.out.println("Starting TM execution...");
        System.out.println("Initial: " + tape + " -- " + state);
        
        while (!state.equals(HALT_STATE) && step()) {
        }
        
        System.out.println("Execution completed.");
    }

    
    static void beispiel() {
        System.out.println("\n=== Example 7.1: Binary Decrement ===");
        
       
        TM tm = new TM('#', 6, "#11000#", "S");
        
        tm.table.add("S", '#', '#', Move.LEFT, "S");
        tm.table.add("S", '1', '0', Move.RIGHT, "R");
        tm.table.add("S", '0', '1', Move.LEFT, "L");
        tm.table.add("R", '0', '0', Move.RIGHT, "R");
        tm.table.add("R", '1', '1', Move.RIGHT, "R");
        tm.table.add("R", '#', '#', Move.LEFT, "W");
        tm.table.add("W", '1', '1', Move.RIGHT, "HALT");
        tm.table.add("W", '0', '0', Move.RIGHT, "HALT");
        tm.table.add("W", '#', '#', Move.RIGHT, "HALT");
        tm.table.add("L", '0', '1', Move.LEFT, "L");
        tm.table.add("L", '1', '0', Move.RIGHT, "R");
        tm.table.add("L", '#', '#', Move.RIGHT, "R");
        
        // Tampilkan tabel transisi
        System.out.println(tm.table);
        
        // Eksekusi 3 langkah pertama
        System.out.println("\nFirst 3 steps:");
        for (int i = 0; i < 3; i++) {
            tm.step();
        }
        
        // Reset dan eksekusi lengkap
        System.out.println("\nFull execution:");
        tm = new TM('#', 6, "#11000#", "S");
        // Tambahkan transisi lagi
        tm.table.add("S", '#', '#', Move.LEFT, "S");
        tm.table.add("S", '1', '0', Move.RIGHT, "R");
        tm.table.add("S", '0', '1', Move.LEFT, "L");
        tm.table.add("R", '0', '0', Move.RIGHT, "R");
        tm.table.add("R", '1', '1', Move.RIGHT, "R");
        tm.table.add("R", '#', '#', Move.LEFT, "W");
        tm.table.add("W", '1', '1', Move.RIGHT, "HALT");
        tm.table.add("W", '0', '0', Move.RIGHT, "HALT");
        tm.table.add("W", '#', '#', Move.RIGHT, "HALT");
        tm.table.add("L", '0', '1', Move.LEFT, "L");
        tm.table.add("L", '1', '0', Move.RIGHT, "R");
        tm.table.add("L", '#', '#', Move.RIGHT, "R");
        
        tm.run();
    }

    public static void main(String[] args) {
        Trigger t = new Trigger("S", '1');
        Action a = new Action('0', Move.RIGHT, "R");
        System.out.println("Trigger: " + t);
        System.out.println("Action: " + a);
        
        
        beispiel();
    }
}