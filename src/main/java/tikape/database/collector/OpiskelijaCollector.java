package tikape.database.collector;

import java.sql.ResultSet;
import java.sql.SQLException;
import tikape.database.Collector;
import tikape.pojo.Opiskelija;

public class OpiskelijaCollector implements Collector<Opiskelija> {

    @Override
    public Opiskelija collect(ResultSet rs) throws SQLException {
        return new Opiskelija(rs.getInt("id"), rs.getString("nimi"));
    }

}
