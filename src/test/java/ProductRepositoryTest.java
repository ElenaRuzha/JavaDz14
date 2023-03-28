import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product product_1 = new Product(1, "Ромашка", 100);
    Product product_2 = new Product(2, "Лилия", 200);
    Product product_3 = new Product(3, "Роза", 300);
    Product product_4 = new Product(4, "Пион", 400);

    @Test
    public void shouldGenerate_NotFoundException() {
        ShopRepository repo = new ShopRepository();
        repo.add(product_1);
        repo.add(product_2);
        repo.add(product_3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(7);
        });
    }

    @Test
    public void shouldGenerate_AlreadyExistsException() {
        ShopRepository repo = new ShopRepository();
        repo.add(product_1);
        repo.add(product_2);
        repo.add(product_3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product_3);
        });
    }

    @Test
    public void shouldRemoveById() {
        ShopRepository repo = new ShopRepository();
        repo.add(product_1);
        repo.add(product_2);
        repo.add(product_3);


        repo.removeById(3);

        Product[] expected = { product_1, product_2 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldAddProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(product_1);
        repo.add(product_2);
        repo.add(product_3);

        repo.add(product_4);

        Product[] expected = { product_1, product_2, product_3, product_4 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
}