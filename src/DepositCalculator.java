import java.util.Scanner;


public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double finalAmount = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundFinalAmount(finalAmount, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double finalAmount = amount + amount * yearRate * depositPeriod;
        return roundFinalAmount(finalAmount, 2);
    }

    double roundFinalAmount(double value, int power) {
        double scale = Math.pow(10, power);
        return Math.round(value * scale) / scale;
    }

    void calculateUserDeposit() {
        int depositPeriod;
        int action;
        int amount;
        double finalAmount = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            finalAmount = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (action == 2) {
            finalAmount = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + finalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateUserDeposit();
    }
}
