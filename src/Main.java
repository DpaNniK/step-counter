import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker test = new StepTracker(); // Создание объекта по шаблону класса StepTracker
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            if (userInput == 1) {
                test.saveStep(); // Вызов метода по сохранению стаистики
            } else if (userInput == 2) {
                test.getStat(); // Вызов метода по получению статистики
            } else if (userInput == 3) {
                test.changeTargetSteps(); // Вызов метода по изменению целевого значения
            } else {
                System.out.println("Такой операци нет. Пожалуйста, выберите операцию из списка:");
            }
            printMenu();
            userInput = scanner.nextInt();
        }

    }

    public static void printMenu() {
        System.out.println("Какую операцию Вы хотите выполнить? ");
        System.out.println(" 1. Ввести количество шагов за определенный день;");
        System.out.println(" 2. Напечатать статистику за определенный месяц;");
        System.out.println(" 3. Изменить цель по количеству шагов в день;");
        System.out.println(" 0. Выйти из приложения;");
    }
}
