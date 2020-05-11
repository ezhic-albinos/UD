package com.shop.client;

import com.shop.model.Good;
import com.shop.service.GoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@RestController
@Controller
public class RequestController
{
    private GoodService goodService;
    @Autowired
    @Qualifier("goodService")
    public void setGoodService(GoodService goodService) {
        this.goodService = goodService;
    }

    @RequestMapping(value = "/request/", method = RequestMethod.GET)
    public ModelAndView request()
    {
        int sum = 0;
        ModelAndView model = new ModelAndView("request");
        model.addObject("listGoods", this.goodService.ExpensiveListGood());
        model.addObject("listPicture", this.goodService.ListGoodPrice());

        for (Good good : goodService.ExpensiveListGood())
        {
            sum += good.getPrice();
        }
        model.addObject("sum", sum);
        return model;
    }
}
