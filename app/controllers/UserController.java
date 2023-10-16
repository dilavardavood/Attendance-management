package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.users.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.UserService;

import javax.inject.Inject;

public class UserController extends Controller {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public Result registerUser(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return badRequest("Expecting JSON data");
        }

        try {
            User user = Json.fromJson(json, User.class);
            userService.registerUser(user);
            return ok("User registered successfully");
        } catch (Exception e) {
            return internalServerError("Error registering user: " + e.getMessage());
        }
    }
    public Result authenticateUser(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return badRequest("Expecting JSON data");
        }

        String username = json.get("username").asText();
        String password = json.get("password").asText();

        User user = userService.authenticateUser(username, password);

        if (user != null) {
            return ok(Json.toJson(user));
        } else {
            return unauthorized("Invalid username or password");
        }
    }
}
