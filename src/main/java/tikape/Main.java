package tikape;

import java.util.HashMap;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import tikape.database.Database;
import tikape.database.OpiskelijaDao;

public class Main {

    public static void main(String[] args) throws Exception {
        Database database = new Database("org.sqlite.JDBC", "jdbc:sqlite:opiskelijat.db");
        database.setDebugMode(true);

        OpiskelijaDao opiskelijaDao = new OpiskelijaDao(database);

        get("/opiskelijat", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("opiskelijat", opiskelijaDao.findAll());

            return new ModelAndView(map, "index");
        }, new ThymeleafTemplateEngine());

    }
}
