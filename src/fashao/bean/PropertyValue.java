package fashao.bean;

/**
 * @author ayorfree
 * @create 2018-04-20-下午8:15
 */

public class PropertyValue {
    private int id;
    private String value;
    private Product product;
    private Property property;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public Property getProperty() {
        return property;
    }
}
