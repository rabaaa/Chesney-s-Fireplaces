
/**
 * This is an abstract Catalogue class which implements CatalogueInterface.
 *
 * @author Rabia Nazir, Ula, Bradley.
 * 
 * @version 1
 */
abstract public class Catalogue implements CatalogueInterface
{
    // instance variables 
    private int SupplierId;

    /**
     * Constructor for objects of class Catalogue
     */
    public Catalogue()
    {
        SupplierId = 0;
    }

    /**
     * Method to set SupplierId
     * 
     * @param SupplierIdIn ... The SupplierId
     */
    public void setSupplierId(int SupplierIdIn)
    {
        this.SupplierId = SupplierIdIn;
    }

    /**
     * Method to get a SupplierId
     * 
     * @return The SupplierId (as a int)
     */
    public int getSupplierId()
    {
        return(this.SupplierId);
    }
}
