package com.shop.service;

import com.shop.dao.OrdersDao;
import com.shop.model.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    public void setOrdersDao(OrdersDao ordersDao)
    {
        this.ordersDao = ordersDao;
    }

    @Transactional
    public List<Orders> listOrders()
    {
        return this.ordersDao.listOrders();
    }

    //обновление БД
    public void updateOrders(Orders s)
    {
        this.ordersDao.UpdateOrders(s);
    }

    //добавление в БД
    public void addOrders(Orders s)
    {
        this.ordersDao.AddOrders(s);
    }

    //удаление из БД
    public void deleteOrders(int orderId)
    {
        for (Orders delorders: listOrders())
        {
            if (delorders.getOrderId() == orderId)
            {
                this.ordersDao.DeleteOrders(delorders);
                return;
            }
        }
    }
}
