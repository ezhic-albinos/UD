package com.shop.service;

import com.shop.dao.CreatorDao;
import com.shop.model.Creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CreatorService
{
    @Autowired
    private CreatorDao creatorDao;

    public void setCreatorDao(CreatorDao creatorDao)
    {
        this.creatorDao = creatorDao;
    }

    @Transactional
    public List<Creator> listCreator()
    {
        return this.creatorDao.listCreator();
    }

    //обновление БД
    public void updateCreator(Creator s)
    {
        this.creatorDao.UpdateCreator(s);
    }

    //добавление в БД
    public void addCreator(Creator s)
    {
        this.creatorDao.AddCreator(s);
    }

    //удаление из БД
    public void deleteCreator(int artistId)
    {
        for (Creator delcreator: listCreator())
        {
            if (delcreator.getArtistId() == artistId)
            {
                this.creatorDao.DeleteCreator(delcreator);
                return;
            }
        }
    }
}

