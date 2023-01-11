public class CreditData {
    double credit;
    double payment;
    double percent;
    String clientType;


    public CreditData(double credit, double payment, double percent, String clientType) {
        this.credit = credit;
        this.payment = payment;
        this.percent = percent;
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "CreditData{" +
                "credit=" + credit +
                ", payment=" + payment +
                ", percent=" + percent +
                ", clientType='" + clientType + '\'' +
                '}';
    }
}
