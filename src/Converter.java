public class Converter {
    double step;
    double lengthStep;
    double kilocalories;
    double caloriesPerStep;
    public Converter(double numStep) {
        step = numStep;
        lengthStep = 0.00075; // Длина шага, переведенная в нужную единиицу измерения
        caloriesPerStep = 50; // Число калорий, которые сжигаются за 1 шаг
        kilocalories = 0.001; // Величина, необходимая для перевода калории в килокалории
    }

    public double defineDistance() { // Подсчет суммарной дистанции в километрах
        return step * lengthStep;
    }

    public double defineCalories(){ // Подсчет соженых калорий в килокалориях
        return step * caloriesPerStep * kilocalories;
    }

}
