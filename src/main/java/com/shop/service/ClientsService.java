package com.shop.service;

import com.shop.dao.ClientsDao;
import com.shop.model.Clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientsService
{
    @Autowired
    private ClientsDao clientsDao;

    public void setClientsDao(ClientsDao clientsDao)
    {
        this.clientsDao = clientsDao;
    }

    @Transactional
    public List<Clients> listClients()
    {
        return this.clientsDao.listClients();
    }

    //обновление БД
    public void updateClients(Clients s)
    {
        this.clientsDao.UpdateClients(s);
    }

    //добавление в БД
    public void addClients(Clients s)
    {
        this.clientsDao.AddClients(s);
    }

    //удаление из БД
    public void deleteClients(int clientId)
    {
        for (Clients delclients: listClients())
        {
            if (delclients.getClientId() == clientId)
            {
                this.clientsDao.DeleteClients(delclients);
                return;
            }
        }
    }
}
