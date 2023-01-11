public class CreditCalculator {


    public double calculateOverpayment(CreditData creditData) {
        String clientType = creditData.clientType;


        double overpayment = 0;
        double paymentPerYear;

        switch (creditData.clientType) {
            case "human":
                overpayment += (creditData.credit * creditData.percent) / 100;
                creditData.credit += (creditData.credit * creditData.percent) / 100;
                break;
            case "business":
                break;
            default:
                System.out.println("Неверный параметр");
        }

        creditData.credit = creditData.credit < creditData.payment * 12 ? 0 : creditData.credit;

        while (creditData.credit > 0) {
            creditData.credit = creditData.credit - creditData.payment * 12;
            paymentPerYear = (creditData.credit * creditData.percent) / 100;
            creditData.credit += paymentPerYear;
            overpayment += paymentPerYear;
            creditData.credit = creditData.credit < creditData.payment * 12 ? 0 : creditData.credit;

            if (creditData.payment * 12 < paymentPerYear) {

                break;
            }
        }
        return overpayment;
    }
}
