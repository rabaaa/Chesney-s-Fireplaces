/**
 * 
 *This class creates an Initial Log In Screen (GUI-based) object.
 *A LogInScreen object is created in the Home Screen Class.
 * 
 * @author Rabia Nazir, Ula, Bradley.
 * 
 * @version 1
 * 
 */
import javax.swing.*;       
import java.awt.event.*;    

public class LogInScreen implements ActionListener
{
    // Define pointers to objects
    private JFrame frame;
    private JPanel panel;
    private JLabel userNameLabel, passwordLabel;
    private JTextField userNameTxtField;
    private JPasswordField userPassword;   // Pointer to a password field
    private JButton proceedButton; 

    /**
     * Constructor method - called when we build an Initial Screen object
     */
    public LogInScreen() 
    {
        // Build frame object
        frame = new JFrame("Log In Screen");

        // Build panel object
        panel = new JPanel();

        // Take control of positioning ourselves
        panel.setLayout (null);

        // Build both label objects
        userNameLabel = new JLabel ("Username");
        passwordLabel = new JLabel ("Password");

        // Build the text field object
        userNameTxtField = new JTextField();

        // Build password field and set up the echo character
        userPassword = new JPasswordField ();
        userPassword.setEchoChar ('*');

        // Build push button
        proceedButton = new JButton ("Proceed");

        // Set the bounds for all the above items
        userNameLabel.setBounds (20,20,100,30);
        passwordLabel.setBounds (20,60,100,30);
        userNameTxtField.setBounds (140,20,100,30);
        userPassword.setBounds (140,60,100,30);
        proceedButton.setBounds (40,120,100,30);

        // Set the bounds for the frame
        frame.setBounds (10,20,350,200);

        // Add above components to the panel
        panel.add (userNameLabel);
        panel.add (passwordLabel);
        panel.add (userNameTxtField);
        panel.add (userPassword);
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
     * Implement the actionPerformed() method from the 
     * ActionListener Interface Class
     */
    public void actionPerformed(ActionEvent event)
    {
        // Define variables
        String name;
        char []password;

        if (event.getSource() == proceedButton )
        {

            // Check the user name and password
            name = userNameTxtField.getText();
            password = userPassword.getPassword(); 

            // Convert the password from character array to a String
            String pass = String.valueOf ( password );

            // Check both userName and password
            if ( ! ( name.equals ("user") && pass.equals("password") ) )
            {
                // Clear both fields
                userNameTxtField.setText (null);
                userPassword.setText (null);
                //Request the focus on UserNameTxtfield 
                userNameTxtField.requestFocus();
            }
            else // Username and Password must be fine
            {
                // Dispose of this frame
                frame.dispose ();

                MainMenuScreen go;
                go = new MainMenuScreen();
            }
        }

    }
}
