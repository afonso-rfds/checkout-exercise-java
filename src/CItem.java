public class CItem 
{
    private final char  m_sku;
    private final float m_price;

    public CItem(char f_sku, float f_price) 
    {
        this.m_sku   = f_sku;
        this.m_price = f_price;
    }

    public char getSKU() 
    {
        return m_sku;
    }

    public float getPrice() 
    {
        return m_price;
    }
}