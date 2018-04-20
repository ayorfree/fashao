package fashao.bean;

/**
 * @author ayorfree
 * @create 2018-04-20-下午8:37
 */

public class OrderItem {
    private int id;
    private int number;
    private User user;
    private Product product;
    private Order order;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Order getOrder() {
        return order;
    }

    public int getNumber() {
        return number;
    }
}
