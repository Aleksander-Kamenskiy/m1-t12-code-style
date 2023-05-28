import java.util.Scanner;

public class DepositCalculator {
    double calculateComplex(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate/ 12), 12 * depositPeriod);
        return quantity(pay,2);
    }
    double calculateSimple(double amount, double yearRate, int depositPeriod) {
        return quantity(amount + amount * yearRate * depositPeriod,2);
    }
    double quantity(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void EnterMoney() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();
        System.out.println(
                "Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:"
        );
        action = scanner.nextInt();
        double out = 0;
        if (action == 1) {
            out = calculateSimple(amount, 0.06, period);
        }
        else if (action == 2) {
            out = calculateComplex(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }
    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.EnterMoney();
    }
}
