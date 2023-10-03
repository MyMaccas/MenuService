package com.avenau.MenuService.service;

import com.avenau.MenuService.dto.FoodResponse;
import com.avenau.MenuService.models.Food;
import com.avenau.MenuService.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private FoodRepository foodRepo;

    @Autowired
    public FoodService(FoodRepository foodRepo) {
        super();
        this.foodRepo = foodRepo;
    }

    public Food save(Food food) {
        return foodRepo.save(food);
    }

    public void remove(Food food) {

        foodRepo.delete(food);
    }

    public void deleteAll() {
        foodRepo.deleteAll();
    }

    public List<FoodResponse> findAll(){
        List<Food> foods = foodRepo.findAll();
        return foods.stream().map(this::mapToFoodResponse).toList();
    }


    public Food find(int id) {
        Optional<Food> requestedFood = foodRepo.findById(id);
        if (requestedFood.get() == null) {
            return null;
        }
        return requestedFood.get();
    }

    private FoodResponse mapToFoodResponse(Food food) {
        return FoodResponse.builder()
                .food_id(food.getFood_id())
                .name(food.getName())
                .price(food.getPrice())
                .build();
    }
}

