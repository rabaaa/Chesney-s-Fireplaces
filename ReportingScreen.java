/**
 * 
 * Reporting Class.
 * 
 * This Class displays a Report of all the items
 * and suppliers in the Catalogue.  
 *
 * @author Rabia Nazir.
 * 
 * 
 */

import javax.swing.*;           // JFrame, JLabel, etc..
import java.sql.*;              // ResultSet Class
import javax.swing.border.*;    // Border, BorderFactory Classes
import java.awt.*;              // Font Class
import java.awt.event.*;        // ActionListener, ActionEvent

public class ReportingScreen implements ActionListener
{
    // Attributes
    private JFrame frame;
    private Border border1, border2;
    private JPanel mainPanel, headerPanel, headerPanel1, reportPanel, reportPanel1,
    pushButtonPanel, pushButtonPanel1, dataEntryPanel;
    private Font   myFont;
    private Font myFont1;
    private JLabel screenHeaderLabel, screenHeaderLabel1, itemIdLabel;
    private JTextArea textArea, textArea1;
    private JScrollPane scrollPanel, scrollPanel1;  
    private JButton backButton, submitButton;
    private JTextField ItemIdTxtField;
    private String ItemOrSupplierString="";  

    /**
     *  Constructor method
     * 
     *  This method effectively sets everything up - although
     *  it calls a series of methods which carries out the tasks
     *  in the required order.
     */  
    public ReportingScreen()
    {
        // Call method to set up the frame
        setUpFrame();

        // Set up borders for later use with panels
        setUpBorders();

        // Call method to set up the panels and apply
        // relevant layout managers
        createPanels();

        // Set up Screen Header
        setUpScreenHeader();           

        setUpScreenHeader1();
        setUpForm();
        // Set up the Reporting Area
        setUpReportArea();
        setUpReportArea1();
        // Set up push button panel
        setUpButtonPanel();

        // Display all the fireplaces
        displayAllFireplaces();
        // Display all the suppliers
        displayAllSuppliers();

        // Register push button for an Action Event
        backButton.addActionListener (this);
        submitButton.addActionListener (this);

        // Finalise the screen panel which will hold
        // everything and place it on the Frame
        finaliseScreen();       

    } // End ReportingScreen()

    /**
     *  Method to set up Frame
     */
    private void setUpFrame()
    {
        // Set up frame
        frame = new JFrame();
        frame.setTitle("Reporting");
        frame.setBounds(100,100,1200,600);

        // Do not allow this frame to be closed when the Exit
        // button is pressed in the top right corner of frame
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Make frame non-resizable
        frame.setResizable (true);

    } // End setUpFrame()

    /**
     * Method to set up borders for later use with panels
     */
    private void setUpBorders()
    {         
        // Create border objects
        border1 = BorderFactory.createRaisedBevelBorder();
        border2 = BorderFactory.createLoweredBevelBorder();

    } // End setUpBorders()

    /**
     *  Method to create all the panels and put a border
     *  around each panel
     */
    private void createPanels()
    {
        // Create Panels 
        mainPanel = new JPanel();
        headerPanel = new JPanel();
        headerPanel1 = new JPanel();
        dataEntryPanel = new JPanel();
        reportPanel = new JPanel();
        reportPanel1 = new JPanel();
        pushButtonPanel = new JPanel();
        pushButtonPanel1 = new JPanel();

        // Specify that we want to use Absolute Positioning
        // on all the panels
        mainPanel.setLayout (null);
        headerPanel.setLayout (null);
        headerPanel1.setLayout(null);
        dataEntryPanel.setLayout (null);
        reportPanel.setLayout (null);
        reportPanel1.setLayout (null);
        pushButtonPanel.setLayout (null);
        pushButtonPanel1.setLayout (null);

        // Associate borders with the relevant panels       
        headerPanel.setBorder (border1);
        headerPanel1.setBorder(border1);
        dataEntryPanel.setBorder (border1);  
        reportPanel.setBorder (border2); 
        reportPanel1.setBorder (border2); 
        pushButtonPanel.setBorder (border1);
        pushButtonPanel1.setBorder (border1);

    } // End createPanels()

    /**
     *  Method to set up the Screen Header
     */
    private void setUpScreenHeader()
    {
        // Create a font object for the header
        myFont = new Font("TimesRoman", Font.BOLD, 28);

        // Create screen header label and put on header panel
        screenHeaderLabel = new JLabel ("List All Items");        

        // Apply font to above screen header label
        screenHeaderLabel.setFont (myFont);

        // Size and position label and then place on headerPanel
        screenHeaderLabel.setBounds (10,10,400,40);

        // Add this label to the headerPanel
        headerPanel.add (screenHeaderLabel);

    } // End setUpScreenHeader()
    /**
     *  Method to set up the Screen Header
     */
    private void setUpScreenHeader1()
    {
        // Create a font object for the header
        myFont1 = new Font("TimesRoman", Font.BOLD, 28);

        // Create screen header label and put on header panel

        screenHeaderLabel1 = new JLabel ("List All Suppliers");
        // Apply font to above screen header label
        screenHeaderLabel1.setFont (myFont1);

        // Size and position label and then place on headerPanel

        screenHeaderLabel1.setBounds (10,10,400,40);
        // Add this label to the headerPanel

        headerPanel1.add(screenHeaderLabel1);
    } // End setUpScreenHeader()
    private void setUpForm()
    {

        // Create supplier id label object, position
        // and size it and place it on its panel.
        itemIdLabel = new JLabel ("Enter Supplier ID");
        itemIdLabel.setBounds (10,10,200,40);
        // Add above label to dataEntryPanel
        dataEntryPanel.add (itemIdLabel);

        ItemIdTxtField = new JTextField(20);
        ItemIdTxtField.setBounds (10,60,200,40);
        // Add above text field to data entry panel
        dataEntryPanel.add (ItemIdTxtField);

        submitButton = new JButton("Delete");
        submitButton.setBounds (40,25,140,30);
        // Add Submit button to push button panel
        pushButtonPanel1.add (submitButton);

    }

    /**
     *  Method to set up the data-entry form itself
     */
    private void setUpReportArea1()
    {
        // Create a TextArea object.  No need to size as this
        // will be done later using setBounds() method.
        textArea1 = new JTextArea();

        // The text area is only to be used to display supplier
        // details.  No editing allowed.
        textArea1.setEditable (false);

        // Create a scrollable panel object.  Put the text area
        // on the scrollable panel.  Only display vertical and
        // horizontal scroll bars as an when appropriate to do so.
        scrollPanel1 = new JScrollPane(textArea1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    } // End setUpReportArea()

    /**
     *  Method to set up the data-entry form itself
     */
    private void setUpReportArea()
    {
        // Create a TextArea object.  No need to size as this
        // will be done later using setBounds() method.
        textArea = new JTextArea();

        // The text area is only to be used to display items
        // details.  No editing allowed.
        textArea.setEditable (false);

        // Create a scrollable panel object.  Put the text area
        // on the scrollable panel.  Only display vertical and
        // horizontal scroll bars as an when appropriate to do so.
        scrollPanel = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    } // End setUpReportArea()

    /**
     * Method to set up the push button panel.  This panel
     * only contains a single button to allow the user to
     * return back to the Main Menu.
     */
    private void setUpButtonPanel()
    {

        // Create Back to Menu push button object, position
        // and size it and place it on its panel
        backButton = new JButton ("Back To Main Menu");

        backButton.setBounds (120,25,160,30);

        // Add back button to push button panel
        pushButtonPanel.add (backButton);

    }  // End setUpButtonPanel()

    /**
     *  Finalise the screen
     */  
    private void finaliseScreen()
    {
        // Specify where we want to place the header
        // panel on the main panel and also size the
        // main panel
        headerPanel.setBounds (100,30,250,80);
        // And add to mainPanel
        mainPanel.add (headerPanel);

        headerPanel1.setBounds (400,30,250,80);
        // And add to mainPanel
        mainPanel.add (headerPanel1);

        dataEntryPanel.setBounds (700,150,300,120);
        // And add to mainPanel
        mainPanel.add (dataEntryPanel);

        // Specify where we want to place the push
        // buttons panel and give it a size
        pushButtonPanel1.setBounds (700,300,200,80);
        // And add to mainPanel
        mainPanel.add (pushButtonPanel1);

        // Specify where we want to place the data
        // entry panel and also give it a size
        scrollPanel.setBounds (100,140,250,300);
        // And add to mainPanel
        mainPanel.add (scrollPanel);

        scrollPanel1.setBounds (400,140,250,300);
        // And add to mainPanel
        mainPanel.add (scrollPanel1);

        // Specify where we want to place the push
        // buttons panel and give it a size
        pushButtonPanel.setBounds (100,460,400,80);
        // And add to mainPanel
        mainPanel.add (pushButtonPanel);

        // Now, add main panel to the frame
        frame.add (mainPanel);

        // Make the frame visible
        frame.setVisible (true);

    } // End finaliseScreen()

    /**
     * Implement the actionPerformed() method
     * in the ActionListener Interface Class
     * 
     * @param event ... An ActionEvent
     */ 
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == submitButton)
        {

            readItemOrSupplierID();

            if (ItemOrSupplierString == "" || ItemOrSupplierString == null)  
            { 
                JOptionPane.showMessageDialog(frame, 
                    "Error - you need to enter a supplier id");
            }
            else{

                int supplierId = Integer.valueOf(ItemOrSupplierString);

                deleteSupplier(supplierId); 
            }
        }{
            { if (event.getSource() == backButton)
                {
                    // Close down / dispose of this frame
                    frame.dispose();

                    // Call the MainMenuScreen Class
                    // constructor
                    new MainMenuScreen();
                }   

            } // End actionPerformed()
        }
    }

    /**
     * Delete the supplier
     */
    private void deleteSupplier(int supplierID)
    {
        if ( DBHandler.loadDriver() == -1 )
        {
            JOptionPane.showMessageDialog (frame, "Problem loading the JDBC/ODBC driver.");
        }
        else if ( DBHandler.makeConnectionToDB() == -1 )
        {
            JOptionPane.showMessageDialog (frame, "Unable to connect to database table (suppliers)");
        }else{
            System.out.println("3- get Supplier "+supplierID);
            int Results = DBHandler.deleteSupplier(supplierID);

            // code above will contain the total number of records 
            // deleted, which will be either 0 (none) or 1 
            if (Results == -1)  // If 0, means nothing deleted
            {
                // Display error message
                JOptionPane.showMessageDialog(frame, 
                    "No record found for deletion.");
            }
            else  // Otherwise, there must have been a deletion
            {
                // Display message
                JOptionPane.showMessageDialog(frame,
                    " Record(s) deleted from Supplier Table");
                // Display all the books
                displayAllFireplaces();
                displayAllSuppliers();
                ItemIdTxtField.setText(null);

            }
        }

    }

    /**
     * Display all the fireplaces
     */
    private void displayAllFireplaces()
    {
        // Define items only used inside this method
        ResultSet rs;
        String    description, style, finish, quantityInStock;
        int supplierId = 0;
        int       itemId = 0;

        // Check to see if we can load the JDBC/ODBC driver
        if ( DBHandler.loadDriver() == -1 )
        {
            JOptionPane.showMessageDialog (frame, "Problem loading the JDBC/ODBC driver.");
        }
        else 
        // Check to see if we can connect to the database table
        if ( DBHandler.makeConnectionToDB() == -1 )
        {
            JOptionPane.showMessageDialog (frame, "Unable to connect to database table (fireplace)");
        }
        else  // Search for all the items
        {
            // Call the getAllFirePlaces method in DataBaseHandler
            // Store the data in my result set.
            rs = DBHandler.getAllFirePlaces();
            textArea.setText(null);

            // Go through all the records in the ResultSet and 
            // display in the text area
            try
            {

                while ( rs.next()  )
                {

                    // Add 1 to itemidCount
                    itemId++;

                    // Retreive the contents of each attribute in the 
                    // result set.
                    itemId  = Integer.valueOf(rs.getString("itemId"));
                    System.out.println ("itemId is " + itemId);

                    description = rs.getString ("description");

                    style = rs.getString ("style");

                    finish = rs.getString ("finish");

                    quantityInStock = rs.getString ("quantityInStock");

                    supplierId =rs.getInt("supplierId");

                    // Put the data into the text area.  append() method
                    // adds data to the end of what was in the text area
                    // previously.
                    textArea.append ("itemId: " + itemId + "\n\n" +
                        "description: " + description + "\n" +
                        "supplierId: " + supplierId + "\n" +
                        "style: " + style + "\n" +
                        "finish: " + finish + "\n" +
                        "quantityInStock: " + quantityInStock + "\n\n");

                }
            }
            catch (SQLException e)
            {
                // Report an error message is there is a problem with the result set
                JOptionPane.showMessageDialog (frame, "Problem displaying item data");
            }

            // If itemCount is 0 when this point is reached, this must mean there
            // were no records in the fireplace Table.  Display an appropriate message
            // in rhe textArea.
            if (itemId == 0)
            {
                textArea.append ("\n\n----- NO ITEMS RECORDS FOUND -----");
            }

            // Close connection to Database.  Display a message if there is a 
            // problem closing the connection.
            if ( DBHandler.closeConnection() == -1 )
            {
                // Report an error message is there is a problem 
                JOptionPane.showMessageDialog (frame, "Problem closing database connection.");
            }

        } 
    }

    /**
     * Display all the suppliers
     */
    private void displayAllSuppliers()
    {
        // Define items only used inside this method
        ResultSet rs;
        String    Name, HouseNo, City, PostCode,Email, Phone ;
        int supplierId = 0;

        // Check to see if we can load the JDBC/ODBC driver
        if ( DBHandler.loadDriver() == -1 )
        {
            JOptionPane.showMessageDialog (frame, "Problem loading the JDBC/ODBC driver.");
        }
        else 
        // Check to see if we can connect to the database table
        if ( DBHandler.makeConnectionToDB() == -1 )
        {
            JOptionPane.showMessageDialog (frame, "Unable to connect to database table (Suppliers)");
        }
        else  // Search for all the suppliers
        {
            // Call the getAllSuppliers method in DataBaseHandler
            // Store the data in my result set.
            rs = DBHandler.getAllSuppliers();
            textArea1.setText(null);

            // Go through all the records in the ResultSet and 
            // display in the text area
            try
            {

                while ( rs.next()  )
                {

                    // Add 1 to supplieridCount
                    supplierId++;

                    // Retreive the contents of each attribute in the 
                    // result set.
                    supplierId  = Integer.valueOf(rs.getString("supplier_id"));
                    System.out.println ("supplier_id is " + supplierId);

                    Name = rs.getString ("supplier_name");

                    HouseNo = rs.getString ("house_number");

                    City = rs.getString ("city");

                    PostCode = rs.getString ("post_code");

                    Email =rs.getString("email_address");

                    Phone =rs.getString("phone_no");

                    // Put the data into the text area.  append() method
                    // adds data to the end of what was in the text area
                    // previously.
                    textArea1.append ("supplier_id: " + supplierId + "\n\n" +
                        "supplier_name: " + Name + "\n" +
                        "house_number: " + HouseNo + "\n" +
                        "city: " + City + "\n" +
                        "post_code: " + PostCode + "\n" +
                        "email_address: " + Email + "\n" +
                        "phone_no: " + Phone + "\n\n");

                }
            }
            catch (SQLException e)
            {
                // Report an error message is there is a problem with the result set
                JOptionPane.showMessageDialog (frame, "Problem displaying supplier data");
            }

            // If supplieridCount is 0 when this point is reached, this must mean there
            // were no records in the supplier Table.  Display an appropriate message
            // in the textArea.
            if (supplierId == 0)
            {
                textArea1.append ("\n\n----- NO SUPPLIER RECORDS FOUND -----");
            }

            // Close connection to Database.  Display a message if there is a 
            // problem closing the connection.
            if ( DBHandler.closeConnection() == -1 )
            {
                // Report an error message is there is a problem 
                JOptionPane.showMessageDialog (frame, "Problem closing database connection.");
            }

        }        

    }

    /**
     * Method to read itemid or supplierid from text field
     */
    private void readItemOrSupplierID()
    {
        ItemOrSupplierString = ItemIdTxtField.getText();
    }
} // End Class

