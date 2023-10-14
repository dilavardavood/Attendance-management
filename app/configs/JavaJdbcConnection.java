package configs;

import play.db.Database;

import javax.inject.Inject;
import javax.xml.bind.SchemaOutputResolver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class JavaJdbcConnection {
    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public JavaJdbcConnection(Database db, DatabaseExecutionContext executionContext) {
        this.db = db;
        this.executionContext = executionContext;
    }

    public CompletionStage<Void> updateSomething() {
        return CompletableFuture.runAsync(
                () -> {
                    // get jdbc connection
                    Connection connection = db.getConnection();
                    System.out.println(connection.toString());
                    try {
                        System.out.println(" We are inside future");
                        PreparedStatement prepareStat = connection.prepareStatement("insert into  styria.user (FirstName,LastName) values (?, ?)");
                        System.out.println("Here");
                        prepareStat.setString(1, "Abhilash");
                        prepareStat.setString(2, "Manikoth");
                        prepareStat.executeUpdate();
                    }
                    catch (Exception e)
                    {
                        System.out.println("Some error is "+e.getMessage());
                    }
                    // do whatever you need with the db connection
                    return;
                },
                executionContext);
    }
}
