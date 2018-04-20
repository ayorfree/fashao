package fashao.bean;

/**
 * @author ayorfree
 * @create 2018-04-20-下午8:13
 */

public class ProductImage {
    private int id;
    private Product product;
    private String type;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
