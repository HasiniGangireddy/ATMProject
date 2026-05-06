import java.util.ArrayList;

public class Transaction {
    private ArrayList<String> history = new ArrayList<>();

    public void addTransaction(String record) {
        history.add(record);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : history) {
                System.out.println(t);
            }
        }
    }
}