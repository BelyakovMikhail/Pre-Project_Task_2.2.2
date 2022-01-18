package web.controller;

import Service.CarService;
import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int countCars, ModelMap model) {
        List<Car> list = new ArrayList<>();
        list.add(new Car(1L, "BMV", "X5"));
        list.add(new Car(2L, "Vaz", "2101"));
        list.add(new Car(3L, "Mersedes", "E63"));
        list.add(new Car(4L, "UAZ", "Patriot"));
        list.add(new Car(5L, "VAZ", "2107"));
        list = CarService.carsCount(list, countCars);
        model.addAttribute("cars", list);
        return "cars";
    }
}
