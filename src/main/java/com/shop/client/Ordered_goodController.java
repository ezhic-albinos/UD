package com.shop.client;

import com.shop.dao.Ordered_goodDao;
import com.shop.service.Ordered_goodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@RestController
@Controller

public class Ordered_goodController
{

    private Ordered_goodService ordered_goodService;
    @Autowired
    @Qualifier(value = "ordered_goodService")
    public void setOrdered_goodService(Ordered_goodService ps)
    {
        this.ordered_goodService = ps;
    }

    Logger logger = Logger.getLogger(String.valueOf(Ordered_goodDao.class));

    @RequestMapping(value = "/ordered_good/", method = RequestMethod.GET)
    public ModelAndView listOrdered_good()
    {
        Logger logger = Logger.getLogger (String.valueOf(Ordered_goodDao.class));
        logger.info("+++List+++");
        ModelAndView model = new ModelAndView("ordered_good");
        model.addObject("listOrdered_good", this.ordered_goodService.listOrdered_good());
        logger.info(model.getModel().toString());
        return model;
    }


}
