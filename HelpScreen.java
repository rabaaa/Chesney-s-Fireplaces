/**
 * This is the Help Screen Class
 * This Class implements the interface which
 * displays a help option for the Fireplace 
 * Cataloguer
 * 
 * @author Rabia Nazir.
 * 
 * @version 1
 */ 

import javax.swing.*;       
import java.awt.event.*;    
public class HelpScreen implements ActionListener
{
    // Define pointers to objects.  
    private JFrame frame;
    private JPanel panel;
    private JLabel helpLabel;
    private JButton proceedButton; 

    public HelpScreen() 
    {
        // Build frame object
        frame = new JFrame("Help Screen");

        // Build panel object
        panel = new JPanel();

        // Take control of positioning ourselves
        panel.setLayout (null);

        // Build label object
        helpLabel = new JLabel ("<html><h3>This is the Chesney's Fireplace catalouge system.</h3><p> From the Main Screen you can choose from 4 available options:</p> <p> Add New Supplier, Add New Item, Item Supplier Details, or Exit the system.</p></html> ");

        // Build push button
        proceedButton = new JButton ("Exit");

        //Set bounds
        helpLabel.setBounds (20,20,400,100);
        proceedButton.setBounds (40,200,100,30);

        // Set the bounds for the frame
        frame.setBounds (10,20,450,300);

        // Add above components to the panel
        panel.add (helpLabel);
        panel.add (proceedButton);

        // Register the above push button for an 
        // Action Event
        proceedButton.addActionListener (this);

        // Add the above panel to the frame
        frame.add (panel);

        // Make the frame non-resizable
        frame.setResizable (false);

        // Make the frame visible
        frame.setVisible (true);
    }

    /** 
     * Method to implement the actionPerformed() from the 
     *ActionListener Interface Class
     */
    public void actionPerformed(ActionEvent event)
    {
        // Define variables 
        String name;
        char []password;

        if (event.getSource() == proceedButton )
        {

            // Dispose of this frame
            frame.dispose ();

            MainMenuScreen go;
            go = new MainMenuScreen();
        }
    }  
}

