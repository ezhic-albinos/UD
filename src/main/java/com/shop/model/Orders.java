package com.shop.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "orders")

public class Orders
{
    @Id
    @Column(name = "orderid")
    @GeneratedValue
    private int OrderId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name="ordered_good",
            joinColumns=@JoinColumn (name="orderid"),
            inverseJoinColumns=@JoinColumn(name="goodid"))
    private List<Good> good;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientid", referencedColumnName = "clientid")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Clients clients;

    @Column(name = "dateoforder")
    private String DateOfOrder;

    @Column(name = "allprice")
    private int Allprice;

    public Orders()
    {
    }

    public int getAllPrice() {
        return Allprice;
    }
    public void setAllPrice(int allprice) {
        Allprice = allprice;
    }

    public Orders(int orderId, String dateoforder,int allprice, Clients clients)
    {
        this.OrderId = orderId;
        this.clients = clients;
        this.DateOfOrder = dateoforder;
        this.Allprice = allprice;
    }

    public int getOrderId()
    {
        return OrderId;
    }

    public void setOrderId(int orderId)
    {
        this.OrderId = orderId;
    }

    public Clients getClients()
    {
        return clients;
    }

    public void setClients(Clients clients)
    {
        this.clients = clients;
    }

    public String getDateOfOrder()
    {
        return DateOfOrder;
    }

    public void setDateOfOrder(String dateoforder) {
        this.DateOfOrder = dateoforder;
    }

    @Override
    public String toString()
    {
        return "Orders{" +
                "OrderId=" + OrderId +
                ", ClientId=" + clients.getFamilia() +
                ", DateOfOrder='" + DateOfOrder + '\'' +
                ", allprice='" + Allprice + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return OrderId == orders.OrderId &&
                clients == orders.clients &&
                DateOfOrder.equals(orders.DateOfOrder) &&
                Allprice == orders.Allprice;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(OrderId, clients, DateOfOrder, Allprice);
    }

    public List<Good> getGood() {
        return good;
    }

    public void setGood(List<Good> good) {
        this.good = good;
    }
}
