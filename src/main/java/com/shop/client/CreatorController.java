package com.shop.client;

import com.shop.dao.CreatorDao;
import com.shop.model.Creator;
import com.shop.service.CreatorService;

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

public class CreatorController
{

    private CreatorService creatorService;
    @Autowired
    @Qualifier(value = "creatorService")
    public void setCreatorService(CreatorService ps)
    {
        this.creatorService = ps;
    }

    Logger logger = Logger.getLogger(String.valueOf(CreatorDao.class));

    @RequestMapping(value = "/creator/", method = RequestMethod.GET)
    public ModelAndView listCreator()
    {
        Logger logger = Logger.getLogger (String.valueOf(CreatorDao.class));
        logger.info("+++List+++");
        ModelAndView model = new ModelAndView("creator");
        model.addObject("listCreator", this.creatorService.listCreator());
        logger.info(model.getModel().toString());
        return model;
    }

    //добавление в БД
    @RequestMapping(value ="/creator/add", method = RequestMethod.POST)
    public ModelAndView addCreator(Creator s)
    {
        logger.info("+++POST ADD+++");
        for (Creator newcreator: this.creatorService.listCreator())
        {
            if (newcreator.getArtistId() == s.getArtistId())
            {
                this.creatorService.updateCreator(s);
                return new ModelAndView("redirect:/creator/");
            }
        }
        this.creatorService.addCreator(s);
        return new ModelAndView("redirect:/creator/");
    }

    //редактирование БД
    @RequestMapping(value ="/creator/edit", method = RequestMethod.POST)
    public ModelAndView editCreator(@RequestParam int artistId)
    {
        ModelAndView model = new ModelAndView("creator");
        logger.info("+++POST EDIT+++");
        for (Creator editcreator: this.creatorService.listCreator())
        {
            if (editcreator.getArtistId() == artistId)
            {
                model.addObject("creator", editcreator);
            }
        }
        model.addObject("listCreator", this.creatorService.listCreator());
        return model;
    }

    //удаление из БД
    @RequestMapping(value ="/creator/delete", method = RequestMethod.POST)
    public ModelAndView deleteCreator (@RequestParam int artistId)
    {
        this.creatorService.deleteCreator(artistId);
        logger.info("+++POST DEL+++");
        return new ModelAndView("redirect:/creator/");
    }

    @ModelAttribute("creator")
    public Creator creator()
    {
        return new Creator();
    }
}
