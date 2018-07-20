package designPatterns.FactoryPattern.idcard;

import designPatterns.FactoryPattern.framework.Product;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-15
 */
public class IDCard extends Product
{
    private int id;
    private String owner;

    IDCard(int id, String owner)
    {
        this.id = id;
        this.owner = owner;
    }

    @Override
    public void use()
    {
        System.out.println("使用" + owner + "的ID卡，其编号为" + id);
    }

    public int getId()
    {
        return id;
    }

    public String getOwner()
    {
        return owner;
    }
}
