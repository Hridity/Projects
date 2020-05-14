package api;

import model.Categories;
import model.Meals;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodApi {

    @GET("random.php")
    Call<Meals> getMeal();

    @GET("categories.php")
    Call<Categories> getCategories();

}