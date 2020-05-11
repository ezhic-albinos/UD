package com.shop.client;

import com.shop.dao.ClientsDao;
import com.shop.model.Clients;
import com.shop.service.ClientsService;

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
public class ClientsController
{
    private ClientsService clientsService;
    @Autowired
    @Qualifier(value = "clientsService")
    public void setClientsService(ClientsService ps)
    {
        this.clientsService = ps;
    }

    Logger logger = Logger.getLogger(String.valueOf(ClientsDao.class));

    @RequestMapping(value = "/clients/", method = RequestMethod.GET)
    public ModelAndView listClients()
    {
        Logger logger = Logger.getLogger (String.valueOf(ClientsDao.class));
        logger.info("+++List+++");
        ModelAndView model = new ModelAndView("clients");
        model.addObject("listClients", this.clientsService.listClients());
        logger.info(model.getModel().toString());
        return model;
    }

    //добавление в БД
    @RequestMapping(value ="/clients/add", method = RequestMethod.POST)
    public ModelAndView addClients(Clients s)
    {
        logger.info("+++POST ADD+++");
        for (Clients newclients: this.clientsService.listClients())
        {
            if (newclients.getClientId() == s.getClientId())
            {
                this.clientsService.updateClients(s);
                return new ModelAndView("redirect:/clients/");
            }
        }
        this.clientsService.addClients(s);
        return new ModelAndView("redirect:/clients/");
    }

    //редактирование БД
    @RequestMapping(value ="/clients/edit", method = RequestMethod.POST)
    public ModelAndView editClients(@RequestParam int clientId)
    {
        ModelAndView model = new ModelAndView("clients");
        logger.info("+++POST EDIT+++");
        for (Clients editclients: this.clientsService.listClients())
        {
            if (editclients.getClientId() == clientId)
            {
                model.addObject("clients", editclients);
            }
        }
        model.addObject("listClients", this.clientsService.listClients());
        return model;
    }

    //удаление из БД
    @RequestMapping(value ="/clients/delete", method = RequestMethod.POST)
    public ModelAndView deleteClients (@RequestParam int clientId)
    {
        this.clientsService.deleteClients(clientId);
        logger.info("+++POST DEL+++");
        return new ModelAndView("redirect:/clients/");
    }

    @ModelAttribute("clients")
    public Clients clients()
    {
        return new Clients();
    }
}
