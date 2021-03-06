package article;

import java.math.BigDecimal;

public class Article {

    private Long id;
    private String name;
    private BigDecimal price;

    public Article(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
