package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = createCars();
        int attempts = getAttempts();
        Racing racing = new Racing(cars, attempts);
        racing.start();
        printWinners(racing.getWinners()); // try-catch 제거
    }

    private static List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
        }
    }

    private static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
