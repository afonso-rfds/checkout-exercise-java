import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CMealDealPromo implements CDiscount 
{
    private final List<Character> m_skuCombination;
    private final float           m_promoPrice;

    public CMealDealPromo(List<Character> f_skuCombination, float f_promoPrice) 
    {
        this.m_skuCombination = f_skuCombination;
        this.m_promoPrice     = f_promoPrice;
    }

    @Override
    public float getDiscount(List<CItem> f_items) 
    {
        int                     leastOccurrences     = Integer.MAX_VALUE;
        float                   priceWithoutDiscount = 0;
        Map<Character, Integer> itemsMap             = new HashMap<>();

        // Calculate price without discount for the combination
        for (char sku : m_skuCombination) 
        {
            for (CItem item : f_items) 
            {
                if (sku == item.getSKU()) 
                {
                    priceWithoutDiscount += item.getPrice();
                    break;
                }
            }
        }

        // Count number of occurrences for each item in the checkout list
        for (CItem item : f_items) 
        {
            itemsMap.put(item.getSKU(), itemsMap.getOrDefault(item.getSKU(), 0) + 1);
        }

        // Determine the least occurrences among the items in the combination
        for (char sku : m_skuCombination) 
        {
            if (itemsMap.getOrDefault(sku, 0) < leastOccurrences) 
            {
                leastOccurrences = itemsMap.get(sku);
            }
        }

        float discount = (priceWithoutDiscount - m_promoPrice) * leastOccurrences;
        
        return discount;
    }
}
