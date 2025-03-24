package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> cars;
    private final int attempts;

    public Racing(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            raceRound();
            printPositions();
        }
    }

    private void raceRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printPositions() {
        for (Car car : cars) {
            System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
