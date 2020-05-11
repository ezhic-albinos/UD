package com.shop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "ordered_good")

public class Ordered_good
{
    @Id
    @Column(name = "goodid")
    @GeneratedValue
    private int GoodId;
    @Column(name = "orderid")
    private int OrderId;

    public Ordered_good()
    {
    }

    public int getGoodId()
    {
        return GoodId;
    }

    public void setGoodId(int goodId)
    {
        this.GoodId = goodId;
    }

    public int getOrderId()
    {
        return OrderId;
    }

    public void setOrderId(int orderId)
    {
        this.OrderId = orderId;
    }

    @Override
    public String toString()
    {
        return "Ordered_good{" + "GoodId=" + GoodId + ", OrderId=" + OrderId + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordered_good ordered_good = (Ordered_good) o;
        return GoodId == ordered_good.GoodId &&
                OrderId == ordered_good.OrderId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(GoodId, OrderId);
    }
}
