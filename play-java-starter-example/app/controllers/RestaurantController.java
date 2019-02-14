package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dao.RestaurantDao;
import models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Collection;

public class RestaurantController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(RestaurantController .class);

    @Autowired
    final RestaurantDao restaurantDao;

    @Inject
    public RestaurantController(RestaurantDao restaurantDao) { this.restaurantDao = restaurantDao; }
    //public UserController(UserDao userDao) { this.userDao = userDao; }

    @Transactional
    public Result createRestaurant() {

        final JsonNode json = request().body().asJson();

        final Restaurant restaurant = Json.fromJson(json, Restaurant.class);

        LOGGER.debug("Restaurant name = " + restaurant.getName());
        LOGGER.error("This is an error");

        if (null == restaurant.getName()) {
            return badRequest("Name must be provided");
        }

       // final Restaurant newrestaurant = restaurantDao.create(restaurant);

       // final JsonNode result = Json.toJson(newrestaurant);
        restaurantDao.create(restaurant);
        final JsonNode result = Json.toJson(restaurant);
        return ok(result);
    }


    @Transactional
    public Result getAllRestaurants() {

        Collection<Restaurant> restaurant = restaurantDao.all();

        final JsonNode result = Json.toJson(restaurant);

        return ok(result);
    }

}

