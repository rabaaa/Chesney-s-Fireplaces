/**
 * This class represents Add Item Screen, and implements ActionListener.
 * The Class handles the screen which allows the
 * user to entry fireplace details for Chensey Fireplaces.
 * 
 * @author Rabia Nazir, Ula, Bradley.
 * 
 * @version 1
 * 
 */

import javax.swing.*;           
import javax.swing.border.*;    
import java.awt.*;              
import java.awt.event.*; 
public class addItemScreen implements ActionListener
{
    // Attributes
    private JFrame frame;
    private Border border1, border2;
    private JPanel mainPanel, headerPanel, dataEntryPanel,
    pushButtonsPanel;
    private Font myFont;
    private JLabel screenHeaderLabel, styleLabel, supplierIdLabel,
    itemIdLabel, descriptionLabel, finishLabel, quantityInStockLabel;
    private JTextField ItemIdTxtField, DescriptionTxtField,
    supplierIdTxtField, styleTxtField, finishTxtField, quantityInStockTxtField ;
    private JButton submitButton, backButton;

    /**
     *  Constructor method
     * 
     *  This method effectively sets everything up
     */  
    public addItemScreen()
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

    } // End addItemScreen()

    /**
     *  Method to set up Frame
     */
    private void setUpFrame()
    {
        // Set up frame
        frame = new JFrame();
        frame.setTitle("Enter New Item Details");
        frame.setBounds(100,100,700,600);
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

        // Create item id label object, position
        // and size it and place it on its panel.
        itemIdLabel = new JLabel ("Item ID");
        itemIdLabel.setBounds (20,20,60,20);
        // Add above label to dataEntryPanel
        dataEntryPanel.add (itemIdLabel);

        // Create description label object, position
        // and size it and place it on its panel.
        descriptionLabel = new JLabel("Description");
        descriptionLabel.setBounds (20,60,60,20);
        // Add above label to dataEntryPanel
        dataEntryPanel.add (descriptionLabel);

        // Create supplier id label object, position
        // and size it and place it on its panel.
        supplierIdLabel = new JLabel ("Supplier Id");
        supplierIdLabel.setBounds (20,100,60,20);
        // Add above label to data entry panel
        dataEntryPanel.add (supplierIdLabel);

        // Create style label object, position
        // and size it and place it on its panel.
        styleLabel = new JLabel ("Style");
        styleLabel.setBounds (20,140,60,20);
        // Add above label to data entry panel
        dataEntryPanel.add (styleLabel);

        //Create finish label object and place it on its panel.
        finishLabel = new JLabel ("Finish");
        finishLabel.setBounds (20,180,60,20);
        // Add above label to data entry panel
        dataEntryPanel.add (finishLabel);

        // Create quantity in stock label object, position
        // and size it and place it on its panel.
        quantityInStockLabel = new JLabel ("Quantity In Stock");
        quantityInStockLabel.setBounds (20,220,60,20);
        // Add above label to data entry panel
        dataEntryPanel.add (quantityInStockLabel);

        // Create item id text field object, position
        // and size it and place it on its panel
        ItemIdTxtField = new JTextField(20);
        ItemIdTxtField.setBounds (100,20,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (ItemIdTxtField);

        // Create description text field object, position
        // and size it and place it on its panel
        DescriptionTxtField = new JTextField(20);
        DescriptionTxtField.setBounds (100,60,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (DescriptionTxtField);

        // Create supplier id text field object, position
        // and size it and place it on its panel
        supplierIdTxtField = new JTextField(20);
        supplierIdTxtField.setBounds (100,100,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (supplierIdTxtField);

        // Create style text field object, position
        // and size it and place it on its panel
        styleTxtField = new JTextField(20);
        styleTxtField.setBounds (100,140,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (styleTxtField);

        // Create finish text field object, position
        // and size it and place it on its panel
        finishTxtField = new JTextField(20);
        finishTxtField.setBounds (100,180,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (finishTxtField);

        // Create qunatity in stock text field object, position
        // and size it and place it on its panel
        quantityInStockTxtField = new JTextField(20);
        quantityInStockTxtField.setBounds (100,220,150,20);
        // Add above text field to data entry panel
        dataEntryPanel.add (quantityInStockTxtField);

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
     *  Finalise the screen
     */  
    private void finaliseScreen()
    {
        // Specify where we want to place the header
        // panel on the main panel and also size the
        // main panel
        headerPanel.setBounds (100,30,400,80);
        // And add to mainPanel
        mainPanel.add (headerPanel);

        // Specify where we want to place the data
        // entry panel and also give it a size
        dataEntryPanel.setBounds (100,140,400,245);
        // And add to mainPanel
        mainPanel.add (dataEntryPanel);

        // Specify where we want to place the push
        // buttons panel and give it a size
        pushButtonsPanel.setBounds (100,400,400,80);
        // And add to mainPanel
        mainPanel.add (pushButtonsPanel);

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
            JOptionPane.showMessageDialog (frame, "Unable to connect to database table (fireplace)");
        }
        else  // Ok, so first read data from the text fields
        {
            // Read data from form and store data                      
            String itemId = ItemIdTxtField.getText();
            String description = DescriptionTxtField.getText();
            String supplierId = supplierIdTxtField.getText();
            String style = styleTxtField.getText();
            String finish = finishTxtField.getText();
            String quantityInStock = quantityInStockTxtField.getText();

            // Convert supplierId to an int
            int supplierIdInt = Integer.valueOf( supplierId );

            int itemIdInt = 0;
            try {

                itemIdInt = Integer.valueOf( itemId );

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog (frame, "Item ID is not a number");
            }

            int quantityInStockInt = Integer.valueOf( quantityInStock );

            // Create a fireplace object
            FirePlaces fireplace = new FirePlaces();                      

            // Set the attributes for the fireplace object  
            fireplace.setitemId (itemIdInt);
            fireplace.setdescription (description);
            fireplace.setSupplierId (supplierIdInt);
            fireplace.setstyle (style);
            fireplace.setfinish (finish);
            fireplace.setquantityInStock (quantityInStockInt);

               
            // Write fireplace record.  Method writeTofireplaceTable() returns
            // 0 of OK writing record, -1 if there is a problem.  I store
            // the returned value in a variable called error.
            int error = DBHandler.writeTofireplaceTable(fireplace.getitemId(),
                    fireplace.getdescription(),
                    fireplace.getSupplierId(),
                    fireplace.getstyle(),
                    fireplace.getfinish(),
                    fireplace.getquantityInStock());

            // Check if there is a problem writing the record, in 
            // which case error will contain -1                                         
            if (error == -1)
            {
                JOptionPane.showMessageDialog (frame, "Problem writing record to fireplace Table");
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
        ItemIdTxtField.setText(null);
        DescriptionTxtField.setText(null);
        supplierIdTxtField.setText(null);                   
        styleTxtField.setText(null);
        finishTxtField.setText(null);                   
        quantityInStockTxtField.setText(null);

    } // End clearForm()

} // End Class
