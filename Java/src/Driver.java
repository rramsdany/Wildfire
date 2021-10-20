import java.sql.*;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Hey");

        try{
            // 1. Get connection to DB
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Wildfire", "root", "easypinkslips");

            // 2. Create a statement
            Statement myStmt = myConn.createStatement();

            // 3. Execute SQL query
            ResultSet myRs = myStmt.executeQuery("select * from ildfire");

            // 4. Process the result set
            while(myRs.next()){
                System.out.println("Wildfire Name: " + myRs.getString("Name"));
                System.out.println("Country: " + myRs.getString("County"));
                try{
                    System.out.println("Acres Burned: " + myRs.getInt("AcresBurned"));
                }catch(NumberFormatException nfe) {System.out.println("Acres Burned: null"); }

                try{
                    System.out.println("Percent Contained: " + myRs.getInt("PercentContained"));
                }catch(NumberFormatException nfe) {System.out.println("Percent Contained: null"); }

                System.out.println("Is Active: " + myRs.getBoolean("IsActive"));
                System.out.println("\n\n");
            }

        }catch (Exception exc){
            exc.printStackTrace();
        }

    }

}
