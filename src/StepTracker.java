import java.util.Scanner;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    int[][] mothData; // Двумерный массив месяц-день
    int targetSteps; // Целевое значение

    public StepTracker() {
        mothData = new int[12][30];
        targetSteps = 10000;
    }

    public void saveStep() {
        System.out.println("За какой месяц вводится значение?");
        printMonth();
        int numberMonth = checkCorrectMonth(scanner.nextInt()); // Проверка корректности введного месяца
        System.out.println("Введите день (от 1 до 30):");
        int numberDay = checkCorrectDay(scanner.nextInt() - 1); // Проверка корректности введенного дня
        checkCorrectDay(numberDay);
        System.out.println("Введите количество шагов:");
        int numberOfStep = Math.abs(scanner.nextInt()); // Преобразование отрицательного значения в положительное
        mothData[numberMonth][numberDay] = numberOfStep;
        System.out.println();
    }


    public void getStat() { // Метод по получению статистики
        System.out.println("Статистика за какой месяц Вам нужна?");
        printMonth();
        int num = checkCorrectMonth(scanner.nextInt());
        showStatMonth(num);
        System.out.println("Общее количество шагов за месяц: " + countSum(num));
        System.out.println("Максимальное пройденное количество шагов за месяц: " + findMaxStep(num));
        findAverageSteps(num);
        Converter converter = new Converter(countSum(num));
        System.out.println("Пройденная дистанция: " + converter.defineDistance() + " км.");
        System.out.println("Сожжено " + converter.defineCalories() + " килокалорий");
        defineSeriesSteps(num);
        System.out.println();
    }

    public void showStatMonth(int num) { // Метод, в котором выводятся шаги по днями в нужном формате
        System.out.println("Количество пройденных шагов: ");
        for (int i = 0; i < mothData[num].length; i++) {
            if (i == mothData[num].length - 1) {
                System.out.print((i + 1) + " день: " + mothData[num][i] + ". ");
            } else {
                System.out.print((i + 1) + " день: " + mothData[num][i] + ", ");
            }

        }
        System.out.println();
    }

    public double countSum(int num) { // Метод по подсчету суммарного значения шагов за месяц
        int sum = 0;
        for (int i = 0; i < mothData[num].length; i++) {
            sum += mothData[num][i];
        }
        return sum;
    }

    public double findMaxStep(int num) { // Метод по поиску максимального значения шагов в массиве
        int maxValue = 0;
        for (int i = 0; i < mothData[num].length; i++) {
            if (maxValue < mothData[num][i]) {
                maxValue = mothData[num][i];
            }
        }
        return maxValue;
    }

    public void findAverageSteps(int num) { // Метод по подсчету среднего значения шагов за месяц
        double average = countSum(num) / mothData[num].length;
        System.out.printf("Среднее число шагов за месяц: " + "%.1f", average);
        System.out.println();
    }

    public void defineSeriesSteps(int num) { // Поиск максимальной серии дней, когда значение шагов больше нормы.
        int[] seriesMass = new int[mothData[num].length]; // Новый массив, в котором хранятся значения серий
        int seriesValue = 0;
        for (int i = 0; i < mothData[num].length; i++) {
            if (mothData[num][i] >= targetSteps) {
                seriesMass[seriesValue] += 1;
            } else {
                seriesValue += 1;
            }
        }
        System.out.println("Ваша максимальная серия, превосходящая норму: " + findMaxValueMass(seriesMass) + " д.");
    }

    public int findMaxValueMass(int[] array) { // Поиск max значения в массиве, где хранятся наибольшие значения серий
        int maxSeries = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxSeries < array[i]) {
                maxSeries = array[i];
            }
        }
        return maxSeries;
    }

    public void changeTargetSteps() { // Изменение целевого значения
        System.out.println("Введите значение Вашей новой цели: ");
        targetSteps = Math.abs(scanner.nextInt());
        System.out.println("Ваша новая цель: " + targetSteps + " шагов");
        System.out.println();
    }

    public int checkCorrectMonth(int month) { // Проверка корректности значения месяца
        while (month < 0 || month > 11) {
            System.out.println("Введите корректное значение месяца.");
            printMonth();
            month = scanner.nextInt();
        }
        return month;
    }

    public int checkCorrectDay(int day) { // Провека корректности значения дня
        while (day < 0 || day > 29) {
            System.out.println("Введите корректное значение дня (от 1 до 30):");
            day = scanner.nextInt() - 1;
        }
        return day;
    }


    public static void printMonth() { // Вывод списка месяцев
        System.out.println("0 - Январь");
        System.out.println("1 - Февраль");
        System.out.println("2 - Март");
        System.out.println("3 - Апрель");
        System.out.println("4 - Май");
        System.out.println("5 - Июнь");
        System.out.println("6 - Июль");
        System.out.println("7 - Август");
        System.out.println("8 - Сентябрь");
        System.out.println("9 - Октябрь");
        System.out.println("10 - Ноябрь");
        System.out.println("11 - Декабрь");
    }
}

