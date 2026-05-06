import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UserAccount user = new UserAccount("user123", "1234", 1000.0);
        Transaction transaction = new Transaction();

        System.out.println("===== ATM INTERFACE =====");

        System.out.print("Enter User ID: ");
        String id = sc.next();

        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if (!user.getUserId().equals(id) || !user.validatePin(pin)) {
            System.out.println("Invalid credentials!");
             sc.close();
            return;
        }

        int choice;
        do {
            System.out.println("\n1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    transaction.showHistory();
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double withdraw = sc.nextDouble();
                    if (user.withdraw(withdraw)) {
                        transaction.addTransaction("Withdrawn: " + withdraw);
                        System.out.println("Success!");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    double deposit = sc.nextDouble();
                    user.deposit(deposit);
                    transaction.addTransaction("Deposited: " + deposit);
                    System.out.println("Success!");
                    break;

                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double transfer = sc.nextDouble();
                    if (user.withdraw(transfer)) {
                        transaction.addTransaction("Transferred: " + transfer);
                        System.out.println("Transfer successful!");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}