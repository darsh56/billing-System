
package com.Bean;

/**
 *
 * @author navkar
 */
public class PurchaseDetails_Bean {
    private String PO_No;    
    private String Date;
    private String Client_id;
    
    public String getPO_No()
    {
        return PO_No;
    }
    public void setPO_No(String PO_No)
    {
        this.PO_No=PO_No;
    }
    public String getClient_id()
    {
        return Client_id;
    }
    public void setClient_id(String Client_id)
    {
        this.Client_id=Client_id;
    }
    public String getDate()
    {
        return Date;
    }
    public void setDate(String Date)
    {
        this.Date=Date;
    }
}
