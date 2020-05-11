package com.shop.client;

import com.shop.dao.OrdersDao;
import com.shop.model.Clients;

import com.shop.model.Good;
import com.shop.model.Orders;
import com.shop.service.OrdersService;
import com.shop.service.ClientsService;
import com.shop.service.GoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@RestController
@Controller

public class OrdersController
{
    private OrdersService ordersService;
    @Autowired
    @Qualifier(value = "ordersService")
    public void setOrdersService(OrdersService ps) 
    {
        this.ordersService = ps;
    }

    private ClientsService clientsService;
    @Autowired
    @Qualifier("clientsService")
    public void setClientsService(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    private GoodService goodService;
    @Autowired
    @Qualifier("goodService")
    public void setGoodService(GoodService goodService) {
        this.goodService = goodService;
    }

    Logger logger = Logger.getLogger(String.valueOf(OrdersDao.class));

    @RequestMapping(value = "/orders/", method = RequestMethod.GET)
    public ModelAndView listOrders()
    {
        Logger logger = Logger.getLogger (String.valueOf(OrdersDao.class));
        logger.info("+++List+++");
        ModelAndView model = new ModelAndView("orders");
        model.addObject("listOrders", this.ordersService.listOrders());
        model.addObject("listClients",this.clientsService.listClients());
        model.addObject("listGood",this.goodService.listGood());
        logger.info(model.getModel().toString());
        return model;
    }

    //добавление в БД
    @RequestMapping(value ="/orders/addOrders", method = RequestMethod.POST)
    public ModelAndView addOrders(int orderId, String dateOfOrder, int clients, @RequestParam("picture[]") List<String> pictures)
    {
        int sum = 0;
        for(Clients c : this.clientsService.listClients())
        {
            if(c.getClientId() == clients)
            {
                List<Good> goods = new ArrayList<>();
                for(String i : pictures)
                {
                    for(Good good : this.goodService.listGood())
                    {
                        if(Integer.parseInt(i) == good.getGoodId())
                        {
                            goods.add(good);
                            sum += good.getPrice();
                        }
                    }
                }
                Orders orders = new Orders(orderId,dateOfOrder,sum, c);
                orders.setGood(goods);
                if (orderId == 0) {
                    this.ordersService.addOrders(orders);
                }
                else {
                    this.ordersService.updateOrders(orders);
                }
            }
        }
        return new ModelAndView("redirect:/orders/");
    }

    //редактирование БД
    @RequestMapping(value ="/orders/edit", method = RequestMethod.POST)
    public ModelAndView editOrders(@RequestParam int orderId)
    {
        ModelAndView model = new ModelAndView("orders");
        logger.info("+++POST EDIT+++");

        for (Orders editorders: this.ordersService.listOrders())
        {
            if (editorders.getOrderId() == orderId)
            {
                model.addObject("orders", editorders);
                //model.addObject("client", orders().getClients());
            }
        }
        model.addObject("listOrders", this.ordersService.listOrders());
        model.addObject("listClients",this.clientsService.listClients());
        model.addObject("listGood",this.goodService.listGood());
        return model;
    }

    //удаление из БД
    @RequestMapping(value ="/orders/delete", method = RequestMethod.POST)
    public ModelAndView deleteOrders (@RequestParam int orderId)
    {
        this.ordersService.deleteOrders(orderId);
        logger.info("+++POST DEL+++");
        return new ModelAndView("redirect:/orders/");
    }

    @ModelAttribute("orders")
    public Orders orders()
    {
        return new Orders();
    }

    @ModelAttribute("clients")
    public Clients clients()
    {
        return new Clients();
    }
}