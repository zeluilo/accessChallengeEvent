package xyz.r0r5chach.services;

import static spark.Spark.notFound;
import static spark.Spark.staticFiles;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;

public class Site {
    public static Configuration templateEngine;

    public static void initSite(Configuration cfg) {
        templateEngine = cfg;
        notFound(Site::notFoundPage);
        staticFiles.location("/public");
        initPaths();
    }

    private static String renderTemplate(String view, Map<String, Object> model, Response res) {
        try {
            Writer out = new OutputStreamWriter(res.raw().getOutputStream());
            templateEngine.getTemplate(view).process(model, out);
        } 
        catch (TemplateException | IOException e) {
            return "Error Loading Page";
        }
        return null;
    }

    public static String renderLayout(String view, Map<String, Object> model, Response res) {
        model.put("content", view);
        model.put("date", Integer.toString(LocalDate.now().getYear())   );
        renderTemplate("layout.ftl", model, res);
        return null;
    }

    private static String notFoundPage(Request req, Response res) { //TODO: Check to see whether page is marked as under construction
        Map<String, Object> model = new HashMap<>();
        renderLayout("notFound.ftl", model, res);
        return null;
    }

    private static void initPaths() {
        Index.routes();
    }
}
