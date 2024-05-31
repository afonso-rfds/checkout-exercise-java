import java.util.List;

public class CBuyNGetOnePromo implements CDiscount {
    private final char m_sku;
    private final int  m_requiredAmountForReward;

    // Constructor
    public CBuyNGetOnePromo(char f_sku, int f_requiredAmountForReward) {
        this.m_sku = f_sku;
        this.m_requiredAmountForReward = f_requiredAmountForReward;
    }

    @Override
    public float getDiscount(List<CItem> items) {
        int   numEligibleItems   = 0;
        int   freeItems          = 0;
        float priceEligibleItems = 0;
        float discount;

        for (CItem item : items) {
            if (item.getSKU() == m_sku) {
                numEligibleItems++;
                priceEligibleItems = item.getPrice();
            }
        }

        for (int counter = 0; counter + m_requiredAmountForReward < numEligibleItems;) {
            counter += m_requiredAmountForReward + 1;
            freeItems++;
        }

        discount = freeItems * priceEligibleItems;
        
        return discount;
    }
}