package montero.antonio.ud2.ej1;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import montero.antonio.ud2.ej1.models.Category;
import montero.antonio.ud2.ej1.models.Product;
import montero.antonio.ud2.ej1.repositories.CategoryRepository;
import montero.antonio.ud2.ej1.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductRepository prodRepo;
    private final CategoryRepository catRepo;

    @PostConstruct
    public void run() {

        Category c1 = Category.builder()
                .name("Laptops")
                .build();
        Category c2 = Category.builder()
                .name("Smartphones")
                .build();

        Category catPadre = Category.builder()
                .name("Tech")
                .build();


        catRepo.save(catPadre);

        c1.setFatherCat(catPadre);

        catRepo.save(c1);
        catRepo.save(c2);

        Product p1 = Product.builder()
                .name("MacBook Pro M1")
                .pvp(1999.99)
                .build();
        Product p2 = Product.builder()
                .name("Iphone 14")
                .pvp(1349.99)
                .build();
        Product p3 = Product.builder()
                .name("MacBook Air 13")
                .pvp(1299.99)
                .build();

        List<Product> productList = List.of(p1, p2, p3);

        p1.addCategory(c1);
        p2.addCategory(c2);
        p3.addCategory(c1);

        prodRepo.saveAll(productList);

        catRepo.findAll()
                .forEach(category -> {
                    System.out.println("Category: " +  category.toString());
                    category.getProducts().forEach(System.out::println);
                });

    }
}
