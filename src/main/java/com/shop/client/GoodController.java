package com.shop.client;

import com.shop.dao.GoodDao;
import com.shop.model.Creator;
import com.shop.model.Good;
import com.shop.service.CreatorService;
import com.shop.service.GoodService;

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

public class GoodController {
    private GoodService goodService;

    @Qualifier("creatorService")
    @Autowired
    private CreatorService creatorService;

    @Autowired
    @Qualifier(value = "goodService")
    public void setGoodService(GoodService ps)
    {
        this.goodService = ps;
    }

    Logger logger = Logger.getLogger(String.valueOf(GoodDao.class));

    @RequestMapping(value = "/good/", method = RequestMethod.GET)
    public ModelAndView listGood()
    {
        Logger logger = Logger.getLogger (String.valueOf(GoodDao.class));
        logger.info("+++List+++");
        ModelAndView model = new ModelAndView("good");
        model.addObject("listGood", this.goodService.listGood());
        model.addObject("listCreator",this.creatorService.listCreator());
        logger.info(model.getModel().toString());
        return model;
    }

    //добавление в БД
    @RequestMapping(value ="/good/add", method = RequestMethod.POST)
    public ModelAndView addGood(int goodId, String name, int year, int price, String city, String museum_gallery, int creator)
    {
        for(Good g : this.goodService.listGood())
        {
            for(Creator c : this.creatorService.listCreator())
            {
                if(c.getArtistId() == creator)
                {
                    Good good = new Good(goodId, name, year, price, city, museum_gallery, c);
                    if (g.getGoodId() == goodId)
                    {
                        this.goodService.updateGood(good);
                        return new ModelAndView("redirect:/good/");
                    } else if (goodId == 0)
                    {
                        this.goodService.addGood(good);
                        return new ModelAndView("redirect:/good/");
                    }
                }
            }
        }
        return new ModelAndView("redirect:/good/");
    }

    //редактирование БД
    @RequestMapping(value ="/good/edit", method = RequestMethod.POST)
    public ModelAndView updateGood(@RequestParam int goodId)
    {
        ModelAndView model = new ModelAndView("good");
        logger.info("+++POST EDIT+++");
        for (Good editgood: this.goodService.listGood())
        {
            if (editgood.getGoodId() == goodId)
            {
                model.addObject("good", editgood);
            }
        }
        model.addObject("listGood", this.goodService.listGood());
        model.addObject("listCreator",this.creatorService.listCreator());
        return model;
    }

    //удаление из БД
    @RequestMapping(value ="/good/delete", method = RequestMethod.POST)
    public ModelAndView deleteGood (@RequestParam int goodId)
    {
        this.goodService.deleteGood(goodId);
        logger.info("+++POST DEL+++");
        return new ModelAndView("redirect:/good/");
    }

    @ModelAttribute("good")
    public Good good()
    {
        return new Good();
    }

    public void setCreatorService(CreatorService creatorService)
    {
        this.creatorService = creatorService;
    }

    @ModelAttribute("creator")
    public Creator creator()
    {
        return new Creator();
    }
}
