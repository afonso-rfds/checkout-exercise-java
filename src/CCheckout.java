import java.util.ArrayList;
import java.util.List;

public class CCheckout 
{
    private final List<CItem>     m_items = new ArrayList<>();
    private final List<CDiscount> m_promotions;

    public CCheckout(List<CDiscount> f_promotions) 
    {
        this.m_promotions = f_promotions;
    }

    public void scanItem(CItem f_item) 
    {
        m_items.add(f_item);
    }

    public float calculatePriceWithoutDiscount() 
    {
        float priceWithoutDiscount = 0;

        for (CItem item : m_items) 
        {
            priceWithoutDiscount += item.getPrice();
        }

        return priceWithoutDiscount;
    }

    public float calculateDiscount() 
    {
        float discount = 0;

        for (CDiscount promotion : m_promotions) 
        {
            discount += promotion.getDiscount(m_items);
        }

        return discount;
    }
}
