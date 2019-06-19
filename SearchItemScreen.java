/**
 * 
 * SearchitemScreen Class.
 *
 * This Class provides a Graphical User Interface Screen which
 * allows the user to search for a item based on it's item id.
 * 
 * 
 * Features are also provided to allow the user to update and delete
 * item records.
 * 
 * @author Rabia Nazir, Ula, Bradley.
 *
 * 
 */

import javax.swing.*; 

import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 

public class SearchItemScreen extends JPanel implements ActionListener
{
    // Attributes
    private JFrame frame;
    private Border border1, border2;
    private JPanel mainPanel, headerPanel, bookStuffPanel,
    scrollButtonsPanel, pushButtonsPanel, gerneralInfoPanel;
    private Font myFont;
    private JLabel screenHeaderLabel, descriptionLabel, supplierIdLabel,
    itemIdLabel, styleLabel, finishLabel, quantityInStockLabel ;
    private JTextField descriptionTxtField, supplierIdTxtField, 
    itemIdTxtField, styleTxtField, finishTxtField, 
    quantityInStockTxtField;
    private JButton searchButton, clearButton, updateButton,
    backButton, nextButton,
    previousButton, deleteButton;
    private String itemId, description, supplierId, style, finish, quantityInStock;
    private ResultSet rs;

    private String itemIdString;

    private boolean nextButtonPressed, previousButtonPressed, recordsFound;
    private int recordCount;

    /**
     * Constructor method
     */
    public SearchItemScreen()
    {
        // Load JDBC/ODBC Criver
        loadDriver();

        // Make connection to javaassignment database
        makeConnection();

        // Set up the frame
        setUpFrame();

        // Set up borders for later use with panels
        setUpBorders();

        // Set up the panels and apply
        // relevant layout managers
        createPanels();

        // Set up Screen Header
        setUpScreenHeader();           

        // Set up fireplace details stuff
        setUpFireplacedetails();

        // Register push buttons for Action Events           
        searchButton.addActionListener (this);
        clearButton.addActionListener (this);
        deleteButton.addActionListener (this);
        updateButton.addActionListener (this);
        nextButton.addActionListener (this);
        previousButton.addActionListener (this);
        backButton.addActionListener (this);

        // Finalise the screen panel which will hold
        // everything and place it on the Frame
        finaliseScreen();       

    } // End SearchItemScreen()

    /**
     * Method to set up Frame
     */
    private void setUpFrame()
    {
        createPanels();
        // Set up frame
        frame = new JFrame();
        frame.setTitle("Search Item Catalogue");
        frame.setBounds(100,100,720,600);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable (true);

        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

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
     * Method to create all the panels and put a border
     * around each panel
     */
    private void createPanels()
    {
        // Create Panels 
        mainPanel = new JPanel();
        headerPanel = new JPanel();
        bookStuffPanel = new JPanel();
        scrollButtonsPanel = new JPanel();
        pushButtonsPanel = new JPanel();
        gerneralInfoPanel = new JPanel();
        // use absolute positioning for all 
        // the panels except scrollButtonPanel.  Therefore set layout to null
        // for all the panels.
        mainPanel.setLayout (null);
        headerPanel.setLayout (null);
        bookStuffPanel.setLayout (null);
        pushButtonsPanel.setLayout (null);  
        gerneralInfoPanel.setLayout(null);
        // Use GridLayout for scrollButtonPanel
        // 2 rows, 1 column
        scrollButtonsPanel.setLayout (new GridLayout(2,1));

        // Associate borders with the relevant panels
        headerPanel.setBorder (border1);
        bookStuffPanel.setBorder (border2);  
        scrollButtonsPanel.setBorder (border2);
        pushButtonsPanel.setBorder (border2);
        gerneralInfoPanel.setBorder(border2);            

    } // End createPanels()
    /**
     * Method to set up the Screen Header
     */
    private void setUpScreenHeader()
    {
        // Create a font object for the header
        myFont = new Font("TimesRoman", Font.BOLD, 30);

        // Create screen header label, specify size and location
        // and add to its panel.              
        screenHeaderLabel = new JLabel ("Search Item Catalogue");

        // Apply font to above screen header label
        screenHeaderLabel.setFont (myFont);

        // Size and position label and then place on headerPanel
        screenHeaderLabel.setLocation (40,20); 
        screenHeaderLabel.setSize (400,40);
        headerPanel.add (screenHeaderLabel);

    } // End setUpScreenHeader()

    /**
     *  Method to set up the item details stuff
     */
    private void setUpFireplacedetails()
    {

        // Create item id label object, position
        // and size it and place it on its panel.
        itemIdLabel = new JLabel ("Item Id");
        itemIdLabel.setLocation (20,20);
        itemIdLabel.setSize (60,20);
        // Add label to item stuff panel
        bookStuffPanel.add (itemIdLabel);

        // Create decription label object, position
        // and size it and place it on its panel.
        descriptionLabel = new JLabel("Description");
        descriptionLabel.setLocation (20,60);
        descriptionLabel.setSize (60,20);
        // Add label to item stuff panel
        bookStuffPanel.add (descriptionLabel);

        // Create supplier id label object, position
        // and size it and place it on its panel.
        supplierIdLabel = new JLabel ("Supplier Id");
        supplierIdLabel.setLocation (20, 100);
        supplierIdLabel.setSize (60,20);
        // Add label to item stuff panel
        bookStuffPanel.add (supplierIdLabel);

        // Create style label object, position
        // and size it and place it on its panel.
        styleLabel = new JLabel ("Style");
        styleLabel.setLocation (20, 140);
        styleLabel.setSize (60,20);
        // Add label to item stuff panel
        bookStuffPanel.add (styleLabel);

        // Create finish label object, position
        // and size it and place it on its panel.
        finishLabel = new JLabel ("Finish");
        finishLabel.setLocation (20, 180);
        finishLabel.setSize (60,20);
        // Add label to item stuff panel
        bookStuffPanel.add (finishLabel);

        // Create quantity in stock label object, position
        // and size it and place it on its panel.
        quantityInStockLabel = new JLabel ("Quantity In Stock");
        quantityInStockLabel.setLocation (20, 220);
        quantityInStockLabel.setSize (60,20);
        // Add label to item stuff panel
        bookStuffPanel.add (quantityInStockLabel);

        // Create item id title text field object, position
        // and size it and place it on its panel
        itemIdTxtField = new JTextField(20);
        itemIdTxtField.setLocation(100,20);
        itemIdTxtField.setSize (200,20);
        // Add text field to item stuff panel
        bookStuffPanel.add (itemIdTxtField);

        // Create description text field object, position
        // and size it and place it on its panel.
        descriptionTxtField = new JTextField(20);
        descriptionTxtField.setLocation (100,60);
        descriptionTxtField.setSize (200,20);
        // Add text field to item stuff panel
        bookStuffPanel.add (descriptionTxtField);

        // Create supplier id text field object, position
        // and size it and place it on its panel
        supplierIdTxtField = new JTextField(20);
        supplierIdTxtField.setLocation(100,100);
        supplierIdTxtField.setSize (200,20);
        // Add text field to item stuff panel
        bookStuffPanel.add (supplierIdTxtField);

        // Create style text field object, position
        // and size it and place it on its panel
        styleTxtField = new JTextField(20);
        styleTxtField.setLocation(100,140);
        styleTxtField.setSize (200,20);
        // Add text field to item stuff panel
        bookStuffPanel.add (styleTxtField);

        // Create finish text field object, position
        // and size it and place it on its panel
        finishTxtField = new JTextField(20);
        finishTxtField.setLocation(100,180);
        finishTxtField.setSize (200,20);
        // Add text field to item stuff panel
        bookStuffPanel.add (finishTxtField);

        // Create quantity in stock text field object, position
        // and size it and place it on its panel
        quantityInStockTxtField = new JTextField(20);
        quantityInStockTxtField.setLocation(100,220);
        quantityInStockTxtField.setSize (200,20);
        // Add text field to item stuff panel
        bookStuffPanel.add (quantityInStockTxtField);

        descriptionTxtField.setEnabled (false);
        supplierIdTxtField.setEnabled (false);
        styleTxtField.setEnabled (false);
        finishTxtField.setEnabled (false);
        quantityInStockTxtField.setEnabled (false);

        // Create search push button object, position
        // and size it and place it on its panel
        searchButton = new JButton("Search");
        searchButton.setLocation (10,25);
        searchButton.setSize (140,30);
        // Add search button to push button panel
        pushButtonsPanel.add (searchButton);

        // Create clear push button object, position
        // and size it and place it on its panel
        clearButton = new JButton("Clear Form");
        clearButton.setLocation (200,25);
        clearButton.setSize (140,30);
        // Add clear button to push button panel
        pushButtonsPanel.add (clearButton);

        // Creeate update push button, position
        // and size it and place it on its panel
        updateButton = new JButton("Update Record");
        updateButton.setLocation (390,25);
        updateButton.setSize (140,30);
        // Add update button to push button panel
        pushButtonsPanel.add (updateButton);

        // Create delete push button, position
        // and size it and place it on its panel
        deleteButton = new JButton("Delete Record");
        deleteButton.setLocation (10,70);
        deleteButton.setSize (140,30);
        //Add delete button to push button panel
        pushButtonsPanel.add (deleteButton);

        // Create 'back to main menu' push button, position 
        // and size it and place it on its panel
        backButton = new JButton("Back to Main Menu");
        backButton.setLocation (310,70);
        backButton.setSize (220,30);
        // Add button to push button panel
        pushButtonsPanel.add (backButton);

        // Create two push button to allow the user to
        // scroll forwards and backwards through items records.
        nextButton = new JButton(">>> Next Record >>>");                
        previousButton = new JButton ("<<< Previous Record <<<");

        // Add the two button above to the scrollButton
        // Panel
        scrollButtonsPanel.add (nextButton);
        scrollButtonsPanel.add (previousButton);

        // Disable the next and back buttons when they 
        // appear for the very first time.
        nextButton.setEnabled (false);
        previousButton.setEnabled (false);

        // And also disable the update and delete
        // buttons when they appear for the first time
        updateButton.setEnabled (false);
        deleteButton.setEnabled (false);

    } // End setUpForm()
    /**
     * Finalise the screen
     */
    private void finaliseScreen()
    {
        // Specify where we want to place the header
        // panel on the main panel and also size the
        // main panel
        headerPanel.setLocation(130,30);
        headerPanel.setSize (400,80);

        // Specify where we want to place the book
        // stuff panel and also give it a size
        bookStuffPanel.setLocation (40,140);
        bookStuffPanel.setSize (400,250);

        // Specify where we want to place the push
        // buttons panel and give it a size
        pushButtonsPanel.setLocation (30, 400);
        pushButtonsPanel.setSize (600, 120);

        // Specify where we want to place the 
        // scrollButtonsPanel, and size.
        scrollButtonsPanel.setLocation (475,175);
        scrollButtonsPanel.setSize (190,100);

        // Add all the above panels to the main panel
        mainPanel.add (headerPanel);
        mainPanel.add (bookStuffPanel);
        mainPanel.add (scrollButtonsPanel);
        mainPanel.add (pushButtonsPanel);

        // Add main panel to the frame
        frame.add (mainPanel);

        // Make the frame visible
        frame.setVisible (true);

    } // End finaliseScreen()

    /**
     *  Implement the actionPerformed() method
     *  in the ActionListener Interface Class
     *  
     *  @param An ActionEvent
     */
    public void actionPerformed(ActionEvent event)
    {
        // Check to see if Search button pressed
        if (event.getSource() == searchButton)
        { 
            // Read the contents of the item id text field
            readitemId();

            // Display an error message if there is no data in
            // item id text field
            if (itemId.equals(""))  
            {
                JOptionPane.showMessageDialog(frame, 
                    "Error - you need to enter a Item Id");
            }
            else // OK to carry out search
            { 
                // Search for items based on the
                // item id entered above 

                searchAllFirePlaces();

                // Display items
                displayFireplaceDetails();
            }
        }
        else // Check if Delete button pressed
        if ( event.getSource() == deleteButton )

        {
            readitemId(); // Read the item id from textfield
            // Delete will be based on item id 
            // which is unique for every item.

            // Call deleteItem() method in DataBaseHandler Class

            int Results = DBHandler.deleteItem(Integer.valueOf(itemId));

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
                    " Record(s) deleted from FirePlace Table");

                // Disable Update and Delete buttons
                updateButton.setEnabled (false);
                deleteButton.setEnabled (false);
            }

            // Clear the form
            clearForm();

        }
        else // Check if Update button pressed
        if (event.getSource() == updateButton )
        {

            // Read data from form
            readDataFromForm();

            // Update fireplace Table with new data

            updatefireplace();

            updatefireplacequantity();
        }
        
        
    
        else  // Check if Next button pressed
        if ( event.getSource() == nextButton )
        {
            // Set nextButtonPressed to true
            nextButtonPressed = true;

            // Make sure Delete and Update buttons
            // are enabled
            deleteButton.setEnabled (true);
            updateButton.setEnabled (true);

            // Display item details
            displayFireplaceDetails();  
        }

        else  // Check if Previous button pressed
        if ( event.getSource() == previousButton )
        {
            // Set previousButtonPressed to true
            previousButtonPressed = true;

            // Make sure Delete and Update buttons
            // are enabled
            deleteButton.setEnabled (true);
            updateButton.setEnabled (true);

            // Display item details
            displayFireplaceDetails();
        } 
        else // Check to see if Clear button was pressed
        if (event.getSource() == clearButton)
        {   
            // Clear the form
            clearForm();

            // Depending upon what happened previously, the
            // Next and Previous buttons may be enabled.
            // Shall always make sure they are disabled after we 
            // clear the form
            nextButton.setEnabled (false);
            previousButton.setEnabled (false);
        }
        else // Check if Back To Menu button pressed
        if (event.getSource() == backButton)
        {

            // Dispose of this frame
            frame.dispose();

            // Close the database connection
            //closeConnection();

            // Go back to MainMenu, by calling the 
            // Constructor method in the MainMenuScreen
            // Class

            new MainMenuScreen();

        }

    } // End actionPerformed()
    /**
     * Method to load JDBC/ODBC driver
     * 
     */
    private void loadDriver()
    {
        // Load driver. Report an error message if there
        // is a problem and exit system
        if ( DBHandler.loadDriver() == -1 )
        {
            // Display an error message
            JOptionPane.showMessageDialog (frame,
                "Unable to load JDBC/ODBC driver");

            // Exit system
            System.exit (0);
        }
    }

    /**
     * Method to make connection to javaassignment
     * database table.
     *
     */ 
    private void makeConnection()
    {

        // Make connection to javaassignment database. Report an
        // error message if there is a problem and exit 
        // system
        if ( DBHandler.makeConnectionToDB() == -1 )  
        {
            // Display an error message
            JOptionPane.showMessageDialog (frame,
                "Unable to connect to javaassignment database");

            // Exit system
            System.exit (0);
        }
    }   

    /**
     * Method to close connection to javaassignment
     * database table.
     * 
     */
    private void closeConnection()
    {
        // Close connection to javaassignment database. Report 
        // an error message if there is a problem
        // and exit the system.
        //if ( DataBaseHandler.closeConnection() == -1 )
        { 
            // Display an error message
            //JOptionPane.showMessageDialog (frame,
            //     "Unable to close connection to javaassignment database");

            // Exit system
            System.exit (0);
        }
    }        

    /**
     * Search for items.  Search for items based
     * upon item id.
     */
    private void searchAllFirePlaces()
    {

        // Call the searchAllFirePlaces() method in DataBaseHandler Class
        // This method returns a reference to a ResultSet object.
        rs = DBHandler.searchAllFirePlaces(Integer.valueOf(itemId));

        // Set recordCount to 0
        recordCount = 0;

    }  // End searchForBooks()  

    /**
     * Display the item details in the result set on the form.
     */
    private void displayFireplaceDetails()
    {
        // Clear whatever might be on the form when this method
        // might have been previously called
        clearForm();

        // Lots of methods which follow which require exception-
        // handling code, e.g. next(), previous(), getString(), etc..
        try
        {
            // The ResultSet many have 0, 1 or more records
            // These need to be displayed on the form

            // When recordCount is 0 ...                      
            if ( recordCount == 0 ) 
            {
                // Try to advance the ResultSet pointer
                if ( rs.next()== true )   
                {
                    // There must be at least one record in ResultSet if
                    // we are in here, so set recordsFound to true
                    recordsFound = true;
                    System.out.println(rs.getString("itemId"));
                    // Read the contents of each item in the ResultSet 
                    itemId =  rs.getString("itemId");
                    //int itemIdInt =  Integer.valueOf(itemId);
                    description = rs.getString("description"); 
                    //int supplierIdInt =  Integer.valueOf(supplierId);
                    supplierId = rs.getString("supplierId");
                    style = rs.getString("style"); 
                    finish = rs.getString("finish");
                    quantityInStock = rs.getString("quantityInStock"); 
                    //int quantityInStockInt =  Integer.valueOf(quantityInStock);

                    System.out.println(itemId +";"+description+":"+supplierId+";"+style+":"+finish+":"+quantityInStock);
                    // Add 1 to recordCount
                    recordCount++;

                    // Enable the Update and Delete buttons
                    updateButton.setEnabled (true);
                    deleteButton.setEnabled (true);

                    // Enable the Next and Previous Buttons 
                    nextButton.setEnabled (true);
                    previousButton.setEnabled (true);                                    

                }
                else  // If we reach this point, there must have been
                // no records which satisfied the search criteria
                {
                    // Display an error message
                    JOptionPane.showMessageDialog (frame, 
                        "No record(s) which satisfy search criteria.");

                    // Disable the Update and Delete buttons
                    updateButton.setEnabled (false);
                    deleteButton.setEnabled (false);

                    // Disable the Next and Previous Buttons 
                    nextButton.setEnabled (false);
                    previousButton.setEnabled (false);      

                    // Set recordsFound to false
                    recordsFound = false;

                }

            }
            //else  // Check if nextButtonPressed contains is true
            else if ( nextButtonPressed )
            {
                // If we are in here, we can now reset nextButtonPressed back
                // to false
                nextButtonPressed = false;

                // Advance ResultSet pointer and see if there is a record
                if ( rs.next()  == true )   
                {
                    // Read the contents of each item in the result set 
                    itemId =  rs.getString("itemId");
                    description = rs.getString("description");
                    supplierId = rs.getString("supplierId");
                    style = rs.getString("style");
                    finish = rs.getString("finish");
                    quantityInStock = rs.getString("quantityInStock");

                    // Add 1 to recordCount
                    recordCount ++;

                }
                else // If / When there are no more records, then....
                {
                    // Set record count back to 0
                    recordCount = 0;                       
                }

            }
            //else  // Check if previousButtonPressed is  true
            else if ( previousButtonPressed )
            {
                // If we are in here, we can now reset previousButtonPressed
                // back to false
                previousButtonPressed = false;

                // Move the ResultSet pointer back and see if there is a 
                // record
                if ( rs.previous() == true)
                {

                    // Subtract 1 from record count
                    recordCount --;

                    // Read the contents of each item in the result set 
                    itemId =  rs.getString("itemId");
                    description = rs.getString("description");
                    supplierId = rs.getString("supplierId");
                    style = rs.getString("style");
                    finish = rs.getString("finish");
                    quantityInStock = rs.getString("quantityInStock");
                }
                else // If / When there are no more records, then...
                {
                    // Set recordCount to 0
                    recordCount = 0;

                }

            }   
            // Display the data on the form only if recordsFound
            // contains true
            if ( recordsFound ) 
            {
                // Put data (Item id, description, etc) on the form                       
                itemIdTxtField.setText (itemId);
                descriptionTxtField.setText (description);
                supplierIdTxtField.setText (supplierId);
                finishTxtField.setText (finish);
                styleTxtField.setText (style);
                quantityInStockTxtField.setText (quantityInStock);
            }

            // Enable the following textfields only if 
            // record count is greater than or equal to 1
            if (recordCount >= 1)
            {

                itemIdTxtField.setEnabled (true);
                descriptionTxtField.setEnabled (true);
                supplierIdTxtField.setEnabled (true);
                finishTxtField.setEnabled (true);
                styleTxtField.setEnabled (true);
                quantityInStockTxtField.setEnabled (true);
            }

        }

        catch (SQLException e)  // Problem ....
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog (frame, 
                "Problem reading record(s)...");
        } 

        // If there are no records in the result set, record count will be zero,
        // so display an error message.  
        if ( (recordCount == 0) && (recordsFound == true) )
        {
            // Display an error message just over the scrollButtonsPanel
            JOptionPane.showMessageDialog (scrollButtonsPanel, "No more records");

            // Probably a good idea to disable next and previous buttons
            nextButton.setEnabled (false);
            previousButton.setEnabled (false);

            // And disable the delete and update buttons
            deleteButton.setEnabled (false);
            updateButton.setEnabled (false);

            // Clear the form
            clearForm();

            // Disable all textfields except item id

            descriptionTxtField.setEnabled (false);
            supplierIdTxtField.setEnabled (false);
            finishTxtField.setEnabled (false);
            styleTxtField.setEnabled (false);
            quantityInStockTxtField.setEnabled (false);

        }

    }  // End displayFireplaceDetails

    /**
     * Method to clear the text fields on the form
     * 
     */
    private void clearForm()
    {
        // Clear all the text fields
        itemIdTxtField.setText(null);
        descriptionTxtField.setText(null);
        supplierIdTxtField.setText(null);                
        finishTxtField.setText(null);
        styleTxtField.setText(null);                
        quantityInStockTxtField.setText(null);

    } // End clearForm()

    /**
     * Method to read data off form
     */
    private void readDataFromForm()
    {

        itemId = itemIdTxtField.getText();
        description = descriptionTxtField.getText();
        supplierId = supplierIdTxtField.getText();
        finish = finishTxtField.getText();
        style = styleTxtField.getText();
        quantityInStock = quantityInStockTxtField.getText();

    } // End readDataFromForm
    /**
     * Method to read item id from text field
     */
    private void readitemId()
    {
        itemId = itemIdTxtField.getText();
    }

    /**
     * Method to read description from text field
     */
    private void readDescription()
    {
        description = descriptionTxtField.getText();
    }

    /**
     * Method to update the fireplace Table
     */
    private void updatefireplace()
    {
        // Define a local variable - code
        int code;

        // updatefireplace() wll return -1 if there is a problem performing
        // the update.
        code = DBHandler.updateSupplierItem(Integer.valueOf(supplierId), Integer.valueOf(itemId));

        // Check to see what code contains
        if (code == -1)   // Problem, report an error
        {
            JOptionPane.showMessageDialog (frame, "Problem updating record");
        }  
        // Otherwise, if the update is successful, the updatefireplace() method
        // will return 1 (the total number of records updated)
        // which in my case will always be 1 since I only update 1 record
        // at a time
        else if (code == 1)
        {
            JOptionPane.showMessageDialog (frame, "Record successfully updated");

        }

    }// End updateFireplace()
    private void updatefireplacequantity()
    {
        // Define a local variable - code
        int code;

        // updatefireplacequantity() wll return -1 if there is a problem performing
        // the update.
        code = DBHandler.updatefireplace(Integer.valueOf(itemId), Integer.valueOf(quantityInStock));

        // Check to see what code contains
        if (code == -1)   // Problem, report an error
        {
            JOptionPane.showMessageDialog (frame, "Record successfully updated");
        }  
        // Otherwise, if the update is successful, the upDateBook method
        // will return 1 (the total number of records updated)
        // which in my case will always be 1 since I only update 1 record
        // at a time
        else if (code == 1)
        {
            JOptionPane.showMessageDialog (frame, "Record successfully updated");

        }

    } // End updatefireplacequantity()

} // End SearchItemScreen