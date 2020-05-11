package com.shop.service;

import com.shop.dao.GoodDao;
import com.shop.model.Good;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GoodService
{
    @Autowired
    private GoodDao goodDao;

    public void setGoodDao(GoodDao goodDao)
    {
        this.goodDao = goodDao;
    }

    @Transactional
    public List<Good> listGood()
    {
        return this.goodDao.listGood();
    }

    public List<Good> ExpensiveListGood()
    {
        return this.goodDao.ExpensiveListGood();
    }

    public List<Good> ListGoodPrice(){return this.goodDao.ListGoodPrice();}

    //обновление БД
    public void updateGood(Good s)
    {
        this.goodDao.UpdateGood(s);
    }

    //добавление в БД
    public void addGood(Good s)
    {
        this.goodDao.AddGood(s);
    }

    //удаление из БД
    public void deleteGood(int goodId)
    {
        for (Good delgood: listGood())
        {
            if (delgood.getGoodId() == goodId)
            {
                this.goodDao.DeleteGood(delgood);
                return;
            }
        }
    }
}
