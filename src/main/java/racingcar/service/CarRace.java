package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarRace {
    public static List<Car> formatCarNames(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carname : carNames) {
            Car car = new Car(carname);
            cars.add(car);
        }
        return cars;
    }

    public static void raceCar(List<Car> cars){
        for (Car car : cars) {
            if (willMoveForward()) {
                car.moveForward();
            }
        }
    }

    private static boolean willMoveForward() {
        int RandomNum = Randoms.pickNumberInRange(0, 9);
        if (RandomNum >= 4) {
            return true;
        }
        return false;
    }
}
