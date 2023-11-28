package xyz.r0r5chach;

import java.util.TimeZone;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import xyz.r0r5chach.services.Site;

public class App {
    public static void main( String[] args )
    {
        Site.initSite(initTemplateEngine());   
    }

    private static Configuration initTemplateEngine() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        
        cfg.setClassForTemplateLoading(App.class, "/templates/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());

        return cfg;
    }
}
