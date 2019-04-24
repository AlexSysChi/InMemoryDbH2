import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Run {

    private static final String H2_JDBC_DRIVER = "org.h2.Driver";
    private static final String H2_DB_URL = "jdbc:h2:~/test";
    private static final String H2_DB_USER_LOGIN = "sa";
    private static final String H2_DB_USER_PASSWORD = "";

    private static String createTable = "CREATE TABLE IF NOT EXISTS TEST_TABLE " +
                                        "(id INTEGER not NULL , " +
                                        " first VARCHAR(255), " +
                                        " last VARCHAR(255), " +
                                        " age INTEGER, " +
                                        "PRIMARY KEY (id));";
    private static String dropTable = "DROP TABLE IF EXISTS TEST_TABLE;";
    private static String inputRecord = "INSERT INTO TEST_TABLE VALUES (?, ?, ?, ?); ";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection (H2_DB_URL, H2_DB_USER_LOGIN,H2_DB_USER_PASSWORD);) {
            Class.forName(H2_JDBC_DRIVER);
            try (Statement statement = connection.createStatement()) {
                statement.execute(dropTable);
                statement.executeUpdate(createTable);
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(inputRecord)) {
                preparedStatement.setString(1, "1");
                preparedStatement.setString(2, "Ivan1");
                preparedStatement.setString(3, "Ivan11");
                preparedStatement.setString(4, String.valueOf(21));
                preparedStatement.execute();

                preparedStatement.setString(1, "2");
                preparedStatement.setString(2, "Ivan2");
                preparedStatement.setString(3, "Ivan22");
                preparedStatement.setString(4, String.valueOf(22));
                preparedStatement.execute();
            }

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM TEST_TABLE");
                while (resultSet.next()) {
                    String name = resultSet.getString("FIRST");
                    System.out.println(resultSet.getString("ID")+" "+name);

                }
            }





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
