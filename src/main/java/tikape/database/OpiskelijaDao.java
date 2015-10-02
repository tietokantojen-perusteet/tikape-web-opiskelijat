package tikape.database;

import java.sql.SQLException;
import java.util.List;
import tikape.database.collector.OpiskelijaCollector;
import tikape.pojo.Opiskelija;

public class OpiskelijaDao implements Dao<Opiskelija, Integer> {

    private Database database;

    public OpiskelijaDao(Database database) {
        this.database = database;
    }

    @Override
    public Opiskelija findOne(Integer key) throws SQLException {
        List<Opiskelija> asiakkaat = this.database.queryAndCollect("SELECT * FROM Asiakas WHERE id = '?'", new OpiskelijaCollector(), key);
        if (asiakkaat.isEmpty()) {
            return null;
        }

        return asiakkaat.get(0);
    }

    @Override
    public void save(Opiskelija opiskelija) throws SQLException {
        this.database.update("INSERT INTO Asiakas (nimi) VALUES (?)", opiskelija.getNimi());
    }

    @Override
    public List<Opiskelija> findAll() throws SQLException {
        return this.database.queryAndCollect("SELECT * FROM Asiakas", new OpiskelijaCollector());
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
