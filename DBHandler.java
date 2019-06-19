/**
 * DataBaseHandler Class.
 * 
 * This Class contains methods which allow the user
 * to interact with the database javaassignment created in
 * MySQL.
 * 
 * @author Rabia Nazir, Ula, Bradley.
 * @version 1
 * 
 * 
 */

import java.sql.*;

public class DBHandler 
{
    // Attributes
    /**
     * Reference to a connection object.
     */
    // instance variables 
    static Connection con;
    static Statement stmt;
    static PreparedStatement stmts;
    static Statement statement;
    static String dbName = "javaassignment";
    static String url = "jdbc:mysql://localhost:3306/";

    static String userName = "root" ;
    static String password = "";
    /**
     *  Loads the MYSQL Driver.
     *  
     *  @return 0 if the driver loads successfully, otherwise
     *            -1 returned if there is a problem loading
     *            the driver.
     *  
     */
    static public int loadDriver()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");  

        }
        catch (ClassNotFoundException  e)
        {
            return -1;
        }

        return 0;

    } // end loadDriver()
    static public int makeConnectionToDB()
    {

        try
        {
            // Make connection to Database
            con = DriverManager.getConnection(
                url+dbName,userName,password);  

        }
        catch (SQLException exception)
        {  
            return (-1);    // Return back with -1 if there is a problem 
            // making a connection
        }

        return (0);   // Return back with 0 if connection is made to database

    } // end makeConnectionTojavaassignmentDB()

    /**
     * Closes the connection to the javaassignment Data base.
     * 
     * @return 0 if the connection to the data base is successfully closed, otherwise
     *           returns -1 if there is a problem closing the connection to the database.
     */
    static public int closeConnection()
    {
        try
        {
            con.close();  
        }
        catch (SQLException exception)
        {
            return  (-1);               // Return back with -1 if there is a problem closing
            // the connection.
        }

        return (0); // Return back with 0 if connection closed successfully.

    } // End closeConnection()

    /**
     * Write supplier details (supplier Id, name, houseNumber, city, postcode, email
     * and phone number)to the database table suppliers.
     * 
     * @return 0 if the record is successfully written to the suppliers table,
     *          otherwise returns -1 if there is a problems writing a record
     *          to the suppliers table.
     */
    static public int writeTosuppliersTable(int SupplierId, String Name, String HouseNumber, String city, String PostCode, 
    String Email, String PhoneNo)
    {

        // Variable to hold the SQL query
        String SQLString;

        // Build a string containing the SQL INSERT instruction to be used later
        SQLString = "INSERT INTO suppliers(supplier_id, supplier_name, house_number, city, post_code, email_address, phone_no)" 
        + " VALUES (?, ?, ?, ?, ?, ?, ? )";

        try
        {
            // The createStatement() method creates a Statement object.  Object will be

            // attached to my reference variable (statement) defined at the top of class.
            stmts = con.prepareStatement(SQLString);
            stmts.setInt (1, SupplierId);
            stmts.setString(2, Name);
            stmts.setString(3, HouseNumber);
            stmts.setString(4, city);
            stmts.setString(5, PostCode);
            stmts.setString(6, Email);
            stmts.setString(7, PhoneNo);

            stmts.execute();

            closeConnection();

        }
        catch (SQLException exception)
        {
            return (-1);     // Return -1 if problem writing record to file

        }

        return (0);   // Return with 0 if record successfully written 

    } // end writeToSuppliersTable() 

    /**
     * Search for items in the fireplace table.  The search is based
     * a item id.
     * 
     * @param itemIdIn ... a itemId
     * 
     * @return ... a reference to a ResultSet object (ResultSet)
     */
    static public ResultSet itemSearch(int itemId)
    {
        // Create a reference to a ResultSet object
        ResultSet rs = null;

        // String to hold an SQL command
        String SQLString = null;

        // Build a string containing a different version of SQL SELECT
        // instruction
        SQLString = "SELECT item_id, description, item.supplier_id, supplier.supplier_name from item inner join supplier on item.supplier_id = supplier.supplier_id where item_id= ?;";

        try
        {
            // Create scrollable statement.           
            stmt = con.prepareStatement(SQLString);
            stmts.setInt (1, itemId);

            // Note: To execute a SELECT SQL query, you need to use the method executeQuery()
            rs = stmt.executeQuery (SQLString);

        }
        catch (SQLException exception)
        {
            return rs;  // will actually return back null if there is a problem
        }

        return rs;  // Return back a reference to a ResultSet 
    } // End itemSearch()
    /**
     * Search for suppliers in the suppliers table.  The search is based
     * a supplier name.
     * 
     * @param supplierNameIn ... a supplierName
     * 
     * @return ... a reference to a ResultSet object (ResultSet)
     */
    static public ResultSet searchSupplier(String supplierName)
    {
        ResultSet rs=null;
        // Variable to hold the SQL query
        String SQLString;

        // Build a string containing the SQL INSERT instruction to be used later                                                       
        SQLString = "select * from supplier where supplier_name = ?;";                                               
        try
        {
            // connectionToDB = DriverManager.getConnection(
            //    url+dbName,userName,password);  

            // create the mysql insert preparedstatement
            // Connection myConnection2 = connectionToDB.getConnection();
            // statement = connectionToBooksDB.createprepareStatement();
            stmt = con.prepareStatement(SQLString);
            stmts.setString (1, supplierName);

            // execute the preparedstatement
            rs= stmts.executeQuery();

        }
        catch (SQLException exception)
        {
            return rs;  // will actually return back null if there is a problem

        }  
        return rs; 

    }

    /**
     * Search for allitems in the fireplace table.  The search is based on
     * a item id .
     * 
     * @param itemIdIn ... a itemId
     * 
     * @return ... a reference to a ResultSet object (ResultSet)
     */
    static public ResultSet searchCompleteItem (int itemId)
    {
        ResultSet rs=null;
        // Variable to hold the SQL query
        String SQLString;

        // Build a string containing the SQL INSERT instruction to be used later                                                       
        SQLString = "select * from item where item_id = ?;";                                               
        try
        {
            // connectionToDB = DriverManager.getConnection(
            //    url+dbName,userName,password);  

            // create the mysql insert preparedstatement
            // Connection myConnection2 = connectionToDB.getConnection();
            // statement = connectionToBooksDB.createprepareStatement();
            stmt = con.prepareStatement(SQLString);
            stmts.setInt (1, itemId);

            // execute the preparedstatement
            rs= stmts.executeQuery();

        }
        catch (SQLException exception)
        {
            return rs;  // will actually return back null if there is a problem
            //   System.out.println(exception);
        }  
        return rs; 
        //  System.out.println(statement);       
    }

    /**
     *  Method to delete record from Suppliers Table
     *  
     *  @param supplierIdIn .... The supplier Id to be deleted
     */

    static public int deleteSupplier(int supplierID)
    {
        System.out.println("1-Deleting Supplier "+supplierID);
        // Variable to hold the SQL query
        String SQLString;
        deleteSupplierItem(supplierID);
        // Build a string containing the SQL INSERT instruction to be used later                                                       
        SQLString = "Delete from suppliers where supplier_id = ?";                                               
        try
        {

            // create the mysql insert preparedstatement
            // Connection myConnection2 = connectionToDB.getConnection();

            // statement = connectionTojavaassignmentDB.createprepareStatement();
            stmts = con.prepareStatement(SQLString);
            stmts.setInt (1, supplierID);

            // execute the preparedstatement
            stmts.executeUpdate();

        }
        catch (SQLException exception)
        {
            return (-1);     // Return -1 if problem writing record to file

        }
        System.out.println("3-Deleting Supplier "+supplierID);
        return(0);   // Return with 0 if record successfully written 

    }

    /**
     *  Method to delete record from fireplace Table based on supplier id
     *  
     *  @param supplierIdIn .... The supplier Id to be deleted
     */
    static public int deleteSupplierItem(int supplierId)
    {
        System.out.println("2- Deleting Supplier "+supplierId);
        String SQLString;

        // Build a string containing the SQL INSERT instruction to be used later                                                       
        SQLString = "Delete from fireplace where supplierId = "+supplierId;                                               
        System.out.println(SQLString);
        // Delete data from fireplace table
        try
        {
            // Create a Statement object
            stmts = con.prepareStatement(SQLString);

            // executeUpdate() returns the number of records
            //stmts.setInt (1, itemId);
            stmts.executeUpdate (SQLString);

        }
        catch (SQLException exception)
        {
            return (-1);     // Return -1 if some kind of problem encountered

        }

        return (0);   // Return back with the number of records affected
        // either 0 or 1 in this case.

    } // End deleteSupplierItem()

    /**
     * Update a quantity in stock record in the fireplace Table
     * 
     */        
    static public int updatefireplace(int itemId, int quantityInStock)
    {

        // Variable to hold the SQL query
        String SQLString;

        // Build a string containing the SQL INSERT instruction to be used later                                                       
        SQLString = "update fireplace set quantityInStock = ? where itemId = ?";                                               
        try
        {

            // create the mysql insert preparedstatement
            // Connection myConnection2 = connectionToDB.getConnection();
            // statement = connectionTojavaassignmentDB.createprepareStatement();
            stmts = con.prepareStatement(SQLString);
            stmts.setInt (1, quantityInStock);
            stmts.setInt (2, itemId);

            // execute the preparedstatement
            stmts.executeUpdate();

            closeConnection();

        }
        catch (SQLException exception)
        {
            return (-1);     // Return -1 if problem writing record to file

        }

        return (0);   // Return with 0 if record successfully written 

    }

    /**
     * Update a supplier Id record in the fireplace Table
     *  
     */ 
    static public int updateSupplierItem(int supplierID, int itemId)
    {

        // Variable to hold the SQL query
        String SQLString;

        // Build a string containing the SQL INSERT instruction to be used later                                                       
        SQLString = "update fireplace set supplierId = ? where itemId = ?";                                               
        try
        {

            // create the mysql insert preparedstatement
            // Connection myConnection2 = connectionToDB.getConnection();

            // statement = connectionTojavaassignmentDB.createprepareStatement();
            stmts = con.prepareStatement(SQLString);
            stmts.setInt (1, supplierID);
            stmts.setInt (2, itemId);

            // execute the preparedstatement
            stmts.executeUpdate();

        }
        catch (SQLException exception)
        {
            return exception.getErrorCode();     // Return -1 if problem writing record to file

        }

        return(0);   // Return with 0 if record successfully written 

    }

    /**
     *  Method to delete record from fireplace Table 
     *  
     *  @param itemIdIn .... The item Id to be deleted
     */
    static public int deleteItem(int itemId)
    {
        String SQLString;

        // Build a string containing the SQL INSERT instruction to be used later                                                       
        SQLString = "Delete from fireplace where itemId = "+itemId;                                               
        System.out.println(SQLString);
        // Delete data from fireplace table
        try
        {
            // Create a Statement object
            stmts = con.prepareStatement(SQLString);

            // executeUpdate() returns the number of records
            // affected, in this case it will always be either 0 or
            // 1 since a item has a unique item id which is the fireplace Table
            // Primary Keyfield
            //stmts.setInt (1, itemId);
            stmts.executeUpdate (SQLString);

        }
        catch (SQLException exception)
        {
            return (-1);     // Return -1 if some kind of problem encountered

        }

        return (0);   // Return back with the number of records affected
        // either 0 or 1 in this case.

    } // End deleteitem()
    /**
     * Write firepace details (item Id, description, supplier Id, style, finish
     * and quantity in stock)to the database table fireplace.
     * 
     * @return 0 if the record is successfully written to the suppliers table,
     *          otherwise returns -1 if there is a problems writing a record
     *          to the suppliers table.
     */
    static public int writeTofireplaceTable(int itemId, String description, int supplierId, String style, String finish, 
    int quantityInStock)
    {

        // Variable to hold the SQL query
        String SQLString;

        // Build a string containing the SQL INSERT instruction to be used later                                                       
        SQLString = "INSERT INTO fireplace(itemId, description, supplierId, style, finish, quantityInStock)"
        + " VALUES (?, ?, ?, ?, ?, ?)";                                      
        try
        {
            // Make connection to Database

            // create the mysql insert preparedstatement
            // Connection myConnection2 = connectionToDB.getConnection();
            // statement = connectionTojavaassignmentDB.createprepareStatement();

            stmts = con.prepareStatement(SQLString);
            stmts.setInt (1, itemId);
            stmts.setString (2, description);
            stmts.setInt (3, supplierId);
            stmts.setString (4, style);
            stmts.setString (5, finish);
            stmts.setInt (6, quantityInStock);

            // execute the preparedstatement
            stmts.execute();

            closeConnection();

        }
        catch (SQLException exception)
        {
            return (-1);     // Return -1 if problem writing record to file

        }

        return (0);   // Return with 0 if record successfully written 

    }

    /**
     * Search for ALL fireplaces in the fireplace table.  This method
     * is used by the Reporting feature.
     * 
     * @return ... a reference to a ResultSet object (ResultSet)
     */
    static public ResultSet searchAllFirePlaces(int itemId)
    {
        // Create a reference to a ResultSet object
        ResultSet rs=null;
        // String to hold an SQL command
        String SQLString = null;    

        // SQL string to search all records in the fireplace Table
        SQLString = "SELECT * FROM fireplace  where itemId = "+itemId;

        try
        {

            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

            //statement.setInt (1, itemId);
            rs = statement.executeQuery(SQLString);
        }
        catch (SQLException exception)
        {
            return rs;  // will actually return back null if there is a problem
        }  
        System.out.println(rs.toString());
        return rs;       
    }

    /**
     * Search for ALL suppliers in the suppliers table.  This method
     * is used by the Reporting feature.
     * 
     * @return ... a reference to a ResultSet object (ResultSet)
     */
    static public ResultSet getAllSuppliers()
    {
        // Create a reference to a ResultSet object
        ResultSet rs=null;
        // String to hold an SQL command
        String SQLString = null;

        // SQL string to search all records in the suppliers Table
        SQLString = "SELECT * FROM suppliers;";

        try
        {
            statement = con.prepareStatement(SQLString);
            rs = statement.executeQuery(SQLString);
        }
        catch (SQLException exception)
        {
            return rs;  // will actually return back null if there is a problem
        }  
        return rs;       
    } 

    /**
     * Search for ALL items in the fireplace table.  This method
     * is used by the Reporting feature.
     * 
     * @return ... a reference to a ResultSet object (ResultSet)
     */
    static public ResultSet getAllFirePlaces()
    {
        // Create a reference to a ResultSet object
        ResultSet rs=null;
        // String to hold an SQL command
        String SQLString = null;    

        // SQL string to search all records in the fireplace Table
        SQLString = "SELECT * FROM fireplace;";

        try
        {

            statement = con.prepareStatement(SQLString);
            rs = statement.executeQuery(SQLString);
        }
        catch (SQLException exception)
        {
            return rs;  // will actually return back null if there is a problem
        }  
        return rs;       
    }
}