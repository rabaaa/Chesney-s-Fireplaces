/**
 * This is the Suppliers class which extends Catalogue
 *
 * @author Rabia Nazir, Ula, Bradley.
 * 
 * @version 1
 */
public class Suppliers extends Catalogue
{
    // Attributes
    private String Name;
    private String HouseNumber;
    private String city;
    private String PostCode;

    private String Email;
    private String PhoneNo;

    /** 
     * Constructor method for Suppliers
     */
    public Suppliers()
    {
        // initialise instance variables

        Name = null;
        HouseNumber = null;
        city = null;
        PostCode = null;
        Email = null;
        PhoneNo = null;
    }

    /** 
     * Method to set a supplier name
     * 
     * @param nameIn ... The supplier of Fireplace
     */
    public void setName(String nameIn)
    {
        this.Name = nameIn;
    }

    /**
     * Method to get a supplier name
     * 
     * @return the supplier name (as a String)
     * 
     */
    public String getName()
    {
        return(this.Name);
    }

    /** 
     * Method to set a HouseNumber
     * 
     * @param HouseNumberIn... The HouseNumber
     */
    public void setHouseNumber(String HouseNumberIn)
    {
        this.HouseNumber = HouseNumberIn;
    }

    /**
     * Method to get a HouseNumber
     * 
     * @return the HouseNumber (as a String)
     * 
     */
    public String getHouseNumber()
    {
        return(this.HouseNumber);
    }

    /** 
     * Method to set a city
     * 
     * @param cityIn... The city
     */  
    public void setcity(String cityIn)
    {
        this.city = cityIn;
    }

    /**
     * Method to get a city
     * 
     * @return the city (as a String)
     * 
     */
    public String getcity()
    {
        return(this.city);
    }

    /** 
     * Method to set a PostCode
     * 
     * @param postCodeIn... The PostCode
     */
    public void setPostCode(String postCodeIn)
    {
        this.PostCode = postCodeIn;
    }

    /**
     * Method to get a PostCode
     * 
     * @return the PostCode (as a String)
     * 
     */
    public String getPostCode()
    {
        return(this.PostCode);
    }

    /** 
     * Method to set a Email
     * 
     * @param emailIn... The Email
     */
    public void setEmail(String emailIn)
    {
        this.Email = emailIn;
    }

    /**
     * Method to get a Email
     * 
     * @return the Email (as a String)
     * 
     */
    public String getEmail()
    {
        return(this.Email);
    }

    /** 
     * Method to set a PhoneNo
     * 
     * @param PhoneNoIn... The PhoneNo
     */  
    public void setphoneNo(String phoneNoIn)
    {
        this.PhoneNo = phoneNoIn;
    }

    /**
     * Method to get a PhoneNo
     * 
     * @return the PhoneNo (as a String)
     * 
     */
    public String getphoneNo()
    {
        return(this.PhoneNo);
    }

}// end of class
