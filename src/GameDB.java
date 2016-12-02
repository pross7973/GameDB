

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author patrick
 */
public class GameDB {

    public static void main(String[] args) {
   final String QUERY = "select id, gameName, gameGenre, "
                + "gameYear from game";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/game", "patrick", "mucis");
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(
                        +rs.getInt("id") + ", "
                        + rs.getString("gameName") + ", "
                        + rs.getString("gameGenre") + ", "
                        + rs.getInt("gameYear"));
            }
        } catch (SQLException ex) {
            System.out.println("Retrieve SQLException: " + ex.getMessage());

        }
    }
}
