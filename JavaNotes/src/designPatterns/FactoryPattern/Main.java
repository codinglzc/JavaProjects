package designPatterns.FactoryPattern;

import designPatterns.FactoryPattern.framework.Factory;
import designPatterns.FactoryPattern.framework.Product;
import designPatterns.FactoryPattern.idcard.IDCardFactory;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-15
 */
public class Main
{
    public static void main(String[] args)
    {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create(1, "小明");
        Product card2 = factory.create(2, "小红");
        Product card3 = factory.create(3, "小刚");
        card1.use();
        card2.use();
        card3.use();
    }
}
