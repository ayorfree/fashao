package fashao.bean;

import java.util.Date;
import java.util.List;

import fashao.dao.OrderDAO;

/**
 * @author ayorfree
 * @create 2018-04-20-下午8:19
 */

public class Order {
    private String orderCode;
    private String address;
    private String post;
    private String receiver;
    private String mobile;
    private String userMessage;
    private Date createDate;
    private Date payDate;
    private Date deliveryDate;
    private Date confirmDate;
    private User user;
    private int id;
    private List<OrderItem> orderItems;
    private float total;
    private int totalNumber;
    private String status;

    public String getStatusDesc() {
        String desc = "未知";
        switch (status) {
            case OrderDAO.waitPay:
                desc = "待付款";
                break;
            case OrderDAO.waitDelivery:
                desc = "待发货";
                break;
            case OrderDAO.waitConfirm:
                desc = "待收货";
                break;
            case OrderDAO.waitReview:
                desc = "等评价";
                break;
            case OrderDAO.finish:
                desc="完成";
                break;
            case OrderDAO.delete:
                desc="刪除";
                break;
            default:
                desc="未知";
        }
        return desc;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getPost() {
        return post;
    }

    public float getTotal() {
        return total;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public String getMobile() {
        return mobile;
    }

    public Date getPayDate() {
        return payDate;
    }

    public String getAddress() {
        return address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public String getStatus() {
        return status;
    }
}
