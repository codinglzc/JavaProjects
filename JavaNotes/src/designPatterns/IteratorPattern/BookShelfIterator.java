package designPatterns.IteratorPattern;

import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-09
 */
public class BookShelfIterator implements Iterator
{
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf)
    {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext()
    {
        return index < bookShelf.getSize();
    }

    @Override
    public Object next()
    {
        return bookShelf.getBookAt(index++);
    }
}
