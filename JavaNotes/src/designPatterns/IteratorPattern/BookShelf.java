package designPatterns.IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-09
 */
public class BookShelf implements Aggregate
{
    private List<Book> books = new ArrayList<>();

    public Book getBookAt(int index)
    {
        return books.get(index);
    }

    public void appendBook(Book book)
    {
        books.add(book);
    }

    public int getSize()
    {
        return books.size();
    }

    @Override
    public Iterator iterator()
    {
        return new BookShelfIterator(this);
    }
}
