package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RacingCarService {
    public static List<Car> convertCarNames(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = Car.createZeroProgressCar(carName);
            cars.add(car);
        }
        return cars;
    }

    public static void raceCar(List<Car> cars) {
        for (Car car : cars) {
            if (willMoveForward()) {
                car.moveForward();
            }
        }
    }

    private static boolean willMoveForward() {
        int RandomNumber = Randoms.pickNumberInRange(0, 9);
        return RandomNumber >= 4;
    }

    public static List<Car> calculatWinner(List<Car> cars) {
        int maxProgress = cars.stream()
                .mapToInt(Car::getProgress)
                .max()
                .orElse(0);

        List<Car> winners = cars.stream()
                .filter(car -> car.getProgress() == maxProgress)
                .toList();

        return winners;
    }
}
