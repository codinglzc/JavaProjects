package designPatterns.IteratorPattern;

import java.util.Iterator;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-09
 */
public class Main
{
    public static void main(String[] args)
    {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        Iterator it = bookShelf.iterator();
        while (it.hasNext())
        {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
