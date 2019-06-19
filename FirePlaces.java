
/**
 * This is the FirePlaces class which extends Catalogue.
 *
 * @author Rabia Nazir, Ula, Bradley.
 * 
 * @version 1
 */
public class FirePlaces extends Catalogue
{
    // Attributes
    private int itemId;
    private String description;
    private double unitPrice;
    private String style;
    private String finish;
    private int quantityInStock;

    /** 
     * Constructor method for FirePlaces
     */
    public FirePlaces()
    {
        // initialise instance variables
        itemId = 0;
        description = null;
        unitPrice = 0.0;
        style = null;
        finish = null;
        quantityInStock = 0;
    }

    /** 
     * Method to set a item id
     * 
     * @param itemIdIn ... The id of item
     */
    public void setitemId(int itemIdIn)
    {
        this.itemId = itemIdIn;
    }

    /**
     * Method to get a item id
     * 
     * @return the id of item (as a int)
     * 
     */
    public int getitemId()
    {
        return(this.itemId);
    }

    /** 
     * Method to set a description
     * 
     * @param descriptionIn ... The description of item
     */    
    public void setdescription(String descriptionIn)
    {
        this.description = descriptionIn;
    }

    /**
     * 
     * Get {@see #Description}. @return {@link #Description}.  
     */    
    public String getdescription()
    {
        return(this.description);
    }

    /** 
     * Method to set a unit price
     * 
     * @param unitPriceIn ... The price of item
     */  
    public void setunitPrice(double unitPriceIn)
    {
        this.unitPrice = unitPriceIn;
    }

    /**
     * 
     * Get {@see #UnitPrice}. @return {@link #UnitPrice}.  
     */    
    public Double getunitPrice()
    {
        return(this.unitPrice);
    }

    /** 
     * Method to set a quantity in stock
     * 
     * @param quantityInStockIn ... The qunatity of items in stock
     */  
    public void setquantityInStock(int quantityInStockIn)
    {
        this.quantityInStock = quantityInStockIn;
    }

    /**
     * 
     * Get {@see #QuantityInStock}. @return {@link #QuantityInStock}.  
     */    
    public int getquantityInStock()
    {
        return(this.quantityInStock);
    }

    /** 
     * Method to set a style of an item
     * 
     * @param styleIn ... The style of an item
     */   
    public void setstyle(String styleIn)
    {
        this.style = styleIn;
    }

    /**
     * 
     * Get {@see #Style}. @return {@link #Style}.  
     */    
    public String getstyle()
    {
        return(this.style);
    }

    /** 
     * Method to set a finish
     * 
     * @param finishIn ... The finish of item
     */   
    public void setfinish(String finishIn)
    {
        this.finish = finishIn;
    }

    /**
     * 
     * Get {@see #Finish}. @return {@link #Finish}.  
     */    
    public String getfinish()
    {
        return(this.finish);
    }      
}
