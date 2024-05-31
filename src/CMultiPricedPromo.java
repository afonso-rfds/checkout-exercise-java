import java.util.List;

public class CMultiPricedPromo implements CDiscount {
    private final char  m_sku;
    private final int   m_requiredAmountForReward;
    private final float m_promoPrice;

    // Constructor
    public CMultiPricedPromo(char f_sku, int f_requiredAmountForReward, float f_promoPrice) {
        this.m_sku = f_sku;
        this.m_requiredAmountForReward = f_requiredAmountForReward;
        this.m_promoPrice = f_promoPrice;
    }

    @Override
    public float getDiscount(List<CItem> items) {
        int numEligibleItems = 0;
        float priceEligibleItems = 0;
        int numPacks;
        float discount;
        float discountPerPack;

        for (CItem item : items) {
            if (item.getSKU() == m_sku) {
                numEligibleItems++;
                priceEligibleItems = item.getPrice();
            }
        }

        discountPerPack = (m_requiredAmountForReward * priceEligibleItems) - m_promoPrice;
        numPacks = numEligibleItems / m_requiredAmountForReward;
        discount = numPacks * discountPerPack;

        return discount;
    }
}
