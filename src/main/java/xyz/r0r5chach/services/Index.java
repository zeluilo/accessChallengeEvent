package xyz.r0r5chach.services;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;

public class Index {
    public static void routes() {
        get("/", Index::dashResponse);
        get("/login", Index::loginResponse);
        get("/dashboard", Index::dashResponse);

    }

    private static String getResponse(Request req, Response res) {
        Map<String,Object> model = new HashMap<>();
        model.put("style", "styles");
        model.put("title", "Home");
        Site.renderLayout("index.ftl", model, res);
        return null;
    }

    private static String loginResponse(Request req, Response res) {
        Map<String,Object> model = new HashMap<>();
        model.put("style", "styles");
        model.put("title", "Home");
        Site.renderLayout("login.ftl", model, res);
        return null;
    }

    private static String dashResponse(Request req, Response res) {
        Map<String,Object> model = new HashMap<>();
        model.put("style", "styles");
        model.put("title", "Home");
        Site.renderLayout("dashboard.ftl", model, res);
        return null;
    }
}
