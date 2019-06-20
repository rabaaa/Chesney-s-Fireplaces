/**
 * 
 * This is the Add Supplier Screen class, which implements ActionListener.
 * The Class handles the screen which allows the
 * user to enter supplier details for Chesney Fireplaces.
 * 
 * @author Rabia Nazir.
 * 
 * @version 1
 * 
 */

import javax.swing.*;           
import javax.swing.border.*;    
import java.awt.*;             
import java.awt.event.*;        

public class AddSupplierScreen implements ActionListener
{
    // Attributes
    private JFrame frame;
    private Border border1, border2;
    private JPanel mainPanel, headerPanel, dataEntryPanel,
    pushButtonsPanel;
    private Font myFont;
    private JLabel screenHeaderLabel, supplierNameLabel, supplierIdLabel,
    houseNoLabel, cityLabel, postCodeLabel, emailLabel, phoneNoLabel;
    private JTextField supplierIdTxtField, supplierNameTxtField,
    houseNoTxtField, cityTxtField, postCodeTxtField, emailTxtField, phoneNoTxtField ;
    private JButton submitButton, backButton;

    /**
     *  Constructor method
     * 
     *  This method sets the frame, borders, screenHeader, form,
     *  create panels, register push buttons and finalise the screen panel.
     */  
    public AddSupplierScreen()
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

        // Set up the Form
        setUpForm();

        // Register push buttons for Action Events
        submitButton.addActionListener (this);
        backButton.addActionListener (this);

        // Finalise the screen panel which will hold
        // everything and place it on the Frame
        finaliseScreen();       

    } // End AddSupplierScreen()

    /**
     *  Method to set up Frame
     */
    private void setUpFrame()
    {
        // Set up frame
        frame = new JFrame();
        frame.setTitle("Enter New Item Details");
        frame.setBounds(100,100,700,600);

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
        dataEntryPanel = new JPanel();
        pushButtonsPanel = new JPanel();

        // Specify that we want to use Absolute Positioning
        // on all the panels
        mainPanel.setLayout (null);
        headerPanel.setLayout (null);
        dataEntryPanel.setLayout (null);
        pushButtonsPanel.setLayout (null);

        // Associate borders with the relevant panels       
        headerPanel.setBorder (border1);
        dataEntryPanel.setBorder (border2);   
        pushButtonsPanel.setBorder (border1);

    } // End createPanels()

    /**
     *  Method to set up the Screen Header
     */
    private void setUpScreenHeader()
    {
        // Create a font object for the header
        myFont = new Font("TimesRoman", Font.BOLD, 30);

        // Create screen header label and put on header panel
        screenHeaderLabel = new JLabel ("Enter New Item Details");        

        // Apply font to above screen header label
        screenHeaderLabel.setFont (myFont);

        // Size and position label and then place on headerPanel
        screenHeaderLabel.setBounds (10,10,400,40);
        // Add this label to the headerPanel
        headerPanel.add (screenHeaderLabel);

    } // End setUpScreenHeader()

    /**
     *  Method to set up the data-entry form itself
     */
    private void setUpForm()
    {

        // Create supplier id label object, position
        // and size it and place it on its panel.
        supplierIdLabel = new JLabel ("Supplier Id");
        supplierIdLabel.setBounds (20,20,60,20);
        // Add above label to dataEntryPanel
        dataEntryPanel.add (supplierIdLabel);

        // Create supplier name label object, position
        // and size it and place it on its panel.
        supplierNameLabel = new JLabel("Name");
        supplierNameLabel.setBounds (20,60,60,20);
        // Add above label to dataEntryPanel
        dataEntryPanel.add (supplierNameLabel);

        // Create house number label object, position
        // and size it and place it on its panel.
        houseNoLabel = new JLabel ("House No");
        houseNoLabel.setBounds (20,100,60,20);
        // Add above label to dataEntryPanel
        dataEntryPanel.add (houseNoLabel);

        // Create city label object, position
        // and size it and place it on its panel.
        cityLabel = new JLabel ("City");
        cityLabel.setBounds (20,140,60,20);
        // Add above label to dataEntryPanel
        dataEntryPanel.add (cityLabel);

        // Create post code label object, position
        // and size it and place it on its panel.
        postCodeLabel = new JLabel ("Post Code");
        postCodeLabel.setBounds (20,180,60,20);
        // Add above label to dataEntryPanel
        dataEntryPanel.add (postCodeLabel);

        // Create email label object, position
        // and size it and place it on its panel.
        emailLabel = new JLabel ("Email");
        emailLabel.setBounds (20,220,60,20);
        // Add above label to dataEntryPanel
        dataEntryPanel.add (emailLabel);

        // Create phone number label object, position
        // and size it and place it on its panel.
        phoneNoLabel = new JLabel ("Phone No");
        phoneNoLabel.setBounds (20,260,60,20);
        // Add above label to dataEntryPanel
        dataEntryPanel.add (phoneNoLabel);

        // Create supplier id text field object, position
        // and size it and place it on its panel
        supplierIdTxtField = new JTextField(20);
        supplierIdTxtField.setBounds (100,20,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (supplierIdTxtField);

        // Create supplier name text field object, position
        // and size it and place it on its panel
        supplierNameTxtField = new JTextField(20);
        supplierNameTxtField.setBounds (100,60,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (supplierNameTxtField);

        // Create house number text field object, position
        // and size it and place it on its panel
        houseNoTxtField = new JTextField(20);
        houseNoTxtField.setBounds (100,100,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (houseNoTxtField);

        // Create city text field object, position
        // and size it and place it on its panel
        cityTxtField = new JTextField(20);
        cityTxtField.setBounds (100,140,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (cityTxtField);

        // Create post code text field object, position
        // and size it and place it on its panel
        postCodeTxtField = new JTextField(20);
        postCodeTxtField.setBounds (100,180,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (postCodeTxtField);

        // Create email text field object, position
        // and size it and place it on its panel
        emailTxtField = new JTextField(20);
        emailTxtField.setBounds (100,220,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (emailTxtField);

        // Create phone number text field object, position
        // and size it and place it on its panel
        phoneNoTxtField = new JTextField(20);
        phoneNoTxtField.setBounds (100,260,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (phoneNoTxtField);

        // Create Submit push button object, position
        // and size it and place it on its panel
        submitButton = new JButton("Submit and Save");
        submitButton.setBounds (40,25,140,30);
        // Add Submit button to push button panel
        pushButtonsPanel.add (submitButton);

        // Create Back push button object, position
        // and size it and place it on its panel
        backButton = new JButton ("Back To Main Menu");
        backButton.setBounds (220,25,160,30);
        // Add back button to push button panel
        pushButtonsPanel.add (backButton);

    } // End setUpForm()
    /**
     *  Method to finalise the screen
     */  
    private void finaliseScreen()
    {
        // Specify location of the header
        // panel on the main panel and also size the
        // main panel
        headerPanel.setBounds (100,30,400,80);
        // And add to mainPanel
        mainPanel.add (headerPanel);

        // Specify where we want to place the data
        // entry panel and the size
        dataEntryPanel.setBounds (100,140,400,285);
        // And add to mainPanel
        mainPanel.add (dataEntryPanel);

        // Specify where we want to place the push
        // buttons panel and the size
        pushButtonsPanel.setBounds (100,430,400,80);
        // And add to mainPanel
        mainPanel.add (pushButtonsPanel);

        // add main panel to the frame
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
        // Check to see it the submit button was pressed
        if (event.getSource() == submitButton)
        {
            // Check to see if there is a problem loading driver
            if( DBHandler.loadDriver() == -1 )
            {
                JOptionPane.showMessageDialog (frame, "Unable to load driver...");
            }
            else  // Ok to write record to database table
            {
                writeTofireplaceTable();  // Call method which is coded below.
            }

        }
        else // back to main menu button pressed
        if (event.getSource() == backButton)
        {
            // Close down this frame
            frame.dispose();

            // Call the MainMenuScreen Class
            // constructor
            new MainMenuScreen();
        }   

    } // End actionPerformed()

    /**
     *  Method to write a fireplace record
     */
    private void writeTofireplaceTable()
    {   
        // Check to see if we can connect to database table
        if (DBHandler. makeConnectionToDB() == -1)
        {
            JOptionPane.showMessageDialog (frame, "Unable to connect to database table (Fireplace)");
        }
        else  //read data from the text fields
        {
            // Read data from form and store data                      
            String supplierId = supplierIdTxtField.getText();
            String supplierName = supplierNameTxtField.getText();
            String houseNo = houseNoTxtField.getText();
            String city = cityTxtField.getText();
            String postCode = postCodeTxtField.getText();
            String email = emailTxtField.getText();
            String phoneNo = phoneNoTxtField.getText();

            // Convert supplierId to an int
            int supplierIdInt = Integer.valueOf( supplierId );

            // Create a suppliers object
            Suppliers suppliers = new Suppliers();                      

            // Set the attributes for the suppliers object  
            suppliers.setSupplierId (supplierIdInt);
            suppliers.setName (supplierName);
            suppliers.setHouseNumber (houseNo);
            suppliers.setcity (city);
            suppliers.setPostCode (postCode);
            suppliers.setEmail (email);
            suppliers.setphoneNo (phoneNo);

            // Write suppliers record. Method writeTosuppliersTable() returns
            // 0 of OK writing record, -1 if there is a problem.  I store
            // the returned value in a variable called error.
            int error = DBHandler.writeTosuppliersTable(suppliers.getSupplierId(),
                    suppliers.getName(),
                    suppliers.getHouseNumber(),
                    suppliers.getcity(),
                    suppliers.getPostCode(),
                    suppliers.getEmail(),
                    suppliers.getphoneNo());

            // Check if there is a problem writing the record, in 
            // which case error will contain -1                                         
            if (error == -1)
            {
                JOptionPane.showMessageDialog (frame, "Problem writing record to suppliers Table");
            }

            // Clear the form - actual method is coded below
            clearForm();

            // Close database connection.  Report an error message
            // if there is a problem.
            if ( DBHandler.closeConnection() == -1 )
            {
                JOptionPane.showMessageDialog (frame, "Problem closing data base conection");
            }

        }
    }  // End writeTofireplaceTable()
    /**
     * Method to clear the text fields on the form
     */
    private void clearForm()
    {
        // Simply put an empty string into each textfield    
        supplierIdTxtField.setText(null);
        supplierNameTxtField.setText(null);
        houseNoTxtField.setText(null);                   
        cityTxtField.setText(null);
        postCodeTxtField.setText(null);                   
        emailTxtField.setText(null);
        phoneNoTxtField.setText(null);

    } // End clearForm()
} // End Class
