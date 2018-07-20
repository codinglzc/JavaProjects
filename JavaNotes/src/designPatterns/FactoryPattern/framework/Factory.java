package designPatterns.FactoryPattern.framework;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-15
 */
public abstract class Factory
{
    public final Product create(int id, String owner)
    {
        Product p = createProduct(id, owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(int id, String owner);

    protected abstract void registerProduct(Product product);
}
