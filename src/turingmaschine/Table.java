package turingmaschine;
import java.util.HashMap;
import java.util.Map;

public class Table {
    private Map<Trigger, Action> map;

    Table() {
        this.map = new HashMap<>();
    }

    void add(String fromState, char read, char write, Move move, String toState) {
        this.map.put(new Trigger(fromState, read), new Action(write, move, toState));
    }

    void addTA(Trigger t, Action a) {
        this.map.put(t, a);
    }

    Action findAction(Trigger t) {
        return map.get(t);
    }

    // Method untuk menampilkan tabel
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transition Table:\n");
        sb.append("fromState | read | write | move | toState\n");
        sb.append("----------|------|-------|------|--------\n");
        
        for (Map.Entry<Trigger, Action> entry : map.entrySet()) {
            Trigger t = entry.getKey();
            Action a = entry.getValue();
            sb.append(String.format("%-9s | %-4c | %-5c | %-6s | %s\n",
                t.fromState(), t.read(), a.write(), a.move(), a.toState()));
        }
        return sb.toString();
    }
}

record Trigger(String fromState, char read) {
    public String toString() {
        return "(" + fromState + ", '" + read + "')";
    }
}

record Action(char write, Move move, String toState) {
    public String toString() {
        return "('" + write + "', " + move + ", " + toState + ")";
    }
}
