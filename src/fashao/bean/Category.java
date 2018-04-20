package fashao.bean;

import java.util.List;

/**
 * @author ayorfree
 * @create 2018-04-20-下午7:58
 */

public class Category {
    private int id;
    private String name;
    List<Product> products;
    List<List<Product>> productsByRow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }

    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }
}
