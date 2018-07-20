package designPatterns.FactoryPattern.idcard;

import designPatterns.FactoryPattern.framework.Factory;
import designPatterns.FactoryPattern.framework.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-15
 */
public class IDCardFactory extends Factory
{
    List<IDCard> cards = new ArrayList<>();

    @Override
    protected Product createProduct(int id, String owner)
    {
        return new IDCard(id, owner);
    }

    @Override
    protected void registerProduct(Product product)
    {
        cards.add((IDCard) product);
    }

    public List<IDCard> getCards()
    {
        return cards;
    }
}
