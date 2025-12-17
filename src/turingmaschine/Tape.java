package turingmaschine;
import java.util.ArrayList;
import java.util.List;


public class Tape {
    private List<Character> band = new ArrayList<>();
    private char pre; //Symbol = #
    private int head; //Which state right now the TM do

    Tape(char pre, int head, String init) {
        this.pre = pre;
        this.head = head;
        
        char[] charArray = init.toCharArray();
        for (char c : charArray) {
            this.band.add(c);
        }
    }

    char read() {
        return band.get(head);
    }

    void write(char c) {
        band.set(head, c);
    }

    void move(Move m) {
        switch (m) {
            case LEFT:
                this.head--;
                if (this.head < 0) {
                    this.band.add(0, Character.valueOf(pre));
                    this.head = 0;
                }
                break;

            case RIGHT:
                this.head++;
                if (this.head >= this.band.size()) {
                    this.band.add(Character.valueOf(pre));
                }
                break;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < band.size(); i++) {
            if (i == head) {
                sb.append("{").append(band.get(i)).append("}");
            } else {
                sb.append(band.get(i));
            }
            if (i < band.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
