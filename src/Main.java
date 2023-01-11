import java.util.*;

public class Main {

    private static void checkException(double credit, double payment) throws ArithmeticException {
        if (credit <= 0) {
            throw new ArithmeticException("Нельзя выплатить кредит с такими параметрами");
        }
        if (payment <= 0) {
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
        CreditData creditData = new CreditData(credit, payment, percent, clientType);

        checkException(credit, payment);
        CreditCalculator calc = new CreditCalculator();
        double credit1 = calc.calculateOverpayment(creditData);
       // CreditData calc = new CreditData();
        //double credit1 = calc.CreditCalculator(credit, payment, percent, clientType);
//        checkException(credit, payment);
        System.out.println("результат переплаты " + credit1);
    }
}
/*
class CreditDatad {

    static void checkException(double paymentPerYear, double payment) throws ArithmeticException {
        if (payment * 12 < paymentPerYear) {
            throw new ArithmeticException("Процент больше чем оплата за год");
        }
    }

    public double CreditCalculator(double credit, double payment, double percent, String clientType) {

        //double numberOfYears = Math.ceil((credit / payment) / 12);
        double overpayment = 0;
        double paymentPerYear;

        switch (clientType) {
            case "human":
                overpayment += (credit * percent) / 100;
                credit += (credit * percent) / 100;
                break;
            case "business":
                break;
            default:
                System.out.println("Неверный параметр");
        }

        credit = credit < payment * 12 ? 0 : credit;

        while (credit > 0) {
            credit = credit - payment * 12;
            paymentPerYear = (credit * percent) / 100;
            credit += paymentPerYear;
            overpayment += paymentPerYear;
            credit = credit < payment * 12 ? 0 : credit;
            checkException(paymentPerYear, payment);
        }
        return overpayment;
    }
}*/