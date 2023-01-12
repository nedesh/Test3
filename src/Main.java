import java.util.*;

public class Main {

    private static void checkException(double credit, double payment, double percent) throws ArithmeticException {
        if (credit <= 0) {
            throw new ArithmeticException("Нельзя выплатить кредит с такими параметрами");
        }
        if (payment <= 0) {
            throw new ArithmeticException("Нельзя выплатить кредит с такими параметрами");
        }
        if (payment * 12 < (credit * percent) / 100) {
            throw new ArithmeticException("Нельзя выплатить кредит с такими параметрами");
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String str = scanner.nextLine();
        String[] array = str.split(" ");

        Double credit = Double.valueOf(array[0]);
        Double payment = Double.valueOf(array[1]);
        Double percent = Double.valueOf(array[2]);
        String clientType = String.valueOf(array[3]);
        checkException(credit, payment, percent);
        CreditData creditData = new CreditData(credit, payment, percent, clientType);
        CreditCalculator calc = new CreditCalculator();
        double credit1 = calc.calculateOverpayment(creditData);
        System.out.println("результат переплаты " + credit1);
    }
}