package com.avenau.MenuService.controller;

import com.avenau.MenuService.dto.FoodResponse;
import com.avenau.MenuService.models.Food;
import com.avenau.MenuService.service.FoodService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/menu")
@RequiredArgsConstructor

public class FoodController {

    private final FoodService foodService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addFood(@RequestBody FoodResponse food){
        Food result = Food.builder()
                .food_id(food.getFood_id())
                .name(food.getName())
                .price(food.getPrice())
                .build();
        foodService.save(result);
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFood(@RequestBody FoodResponse food){
        Food result = Food.builder()
                .food_id(food.getFood_id())
                .name(food.getName())
                .price(food.getPrice())
                .build();
        foodService.remove(result);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<FoodResponse> getAllFoods() {
        return foodService.findAll();
    }


}
