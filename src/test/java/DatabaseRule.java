import org.sql2o.Connection;
import org.sql2o.Sql2o;
import  org.junit.rules.ExternalResource;
public class DatabaseRule  extends ExternalResource{

    @Override

    protected void before(){
        DB.sql2o = new Sql2o("postgresql://localhost:5432/virtual_pets_test","moringa", "Access");

    }
    @Override
    protected void after(){
        try (Connection con =DB.sql2o.open()){
            String deletePersonQuery = "DELETE FROM persons *;";
            con.createQuery(deletePersonQuery).executeUpdate();

        }
    }

}
