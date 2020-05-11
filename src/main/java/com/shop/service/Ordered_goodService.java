package com.shop.service;

import com.shop.dao.Ordered_goodDao;
import com.shop.model.Ordered_good;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Ordered_goodService
{
    @Autowired
    private Ordered_goodDao ordered_goodDao;

    public void setOrdered_goodDao(Ordered_goodDao ordered_goodDao)
    {
        this.ordered_goodDao = ordered_goodDao;
    }

    @Transactional
    public List<Ordered_good> listOrdered_good()
    {
        return this.ordered_goodDao.listOrdered_good();
    }
}
