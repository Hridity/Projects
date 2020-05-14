package view_home;

import java.util.List;

import model.Categories;
import model.Meals;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeals(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);

}