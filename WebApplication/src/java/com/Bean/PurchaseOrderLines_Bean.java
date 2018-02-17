
package com.Bean;

/**
 *
 * @author navkar
 */
public class PurchaseOrderLines_Bean {
    private int Polineno;
    private String PO_No;
    private int Serial_No;
    private String Part_Name;
    private String Description;
    private int Line_No;
    private String DueDate;
    private int Quantity;
    private int Rate;
    private int Amount;
    
    public int getPolineno()
    {
        return Polineno;
    }
    public void setPolineno(int Polineno)
    {
        this.Polineno=Polineno;
    }
    public String getPO_No()
    {
        return PO_No;
    }
    public void setPO_No(String PO_No)
    {
        this.PO_No=PO_No;
    }

    public int getSerial_No()
    {
        return Serial_No;
    }
    public void setSerial_No(int Serial_No)
    {
        this.Serial_No=Serial_No;
    }
    public String getPart_Name()
    {
        return Part_Name;
    }
    public void setPart_Name(String Part_Name)
    {
        this.Part_Name=Part_Name;
    }
     public String getDescription()
    {
        return Description;
    }
    public void setDescription(String Description)
    {
        this.Description=Description;
    }

    public int getLine_No()
    {
        return Line_No;
    }
    public void setLine_No(int Line_No)
    {
        this.Line_No=Line_No;
    }
    public String getDueDate()
    {
        return DueDate;
    }
    public void setDueDate(String DueDate)
    {
        this.DueDate=DueDate;
    }
    public int getQuantity()
    {
        return Quantity;
    }
    public void setQuantity(int Quantity)
    {
        this.Quantity=Quantity;
    }
    public int getRate()
    {
        return Rate;
    }
    public void setRate(int Rate)
    {
        this.Rate=Rate;
    }
    public int getAmount()
    {
        return Amount;
    }
    public void setAmount(int Amount)
    {
        this.Amount=Amount;
    }
}
