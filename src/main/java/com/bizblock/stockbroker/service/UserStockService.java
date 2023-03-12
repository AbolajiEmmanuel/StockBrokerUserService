/*
 * Copyright (c) 2018, Xyneex Technologies. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * You are not meant to edit or modify this source code unless you are
 * authorized to do so.
 *
 * Please contact Xyneex Technologies, #1 Orok Orok Street, Calabar, Nigeria.
 * or visit www.xyneex.com if you need additional information or have any
 * questions.
 */
package com.bizblock.stockbroker.service;

import com.bizblock.stockbroker.dto.TransactionDTO;
import com.bizblock.stockbroker.dto.UserStockRequest;
import com.bizblock.stockbroker.model.UserStock;
import com.bizblock.stockbroker.repository.UserStockRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author BLAZE
 */
@Service
public class UserStockService
{
    private final UserStockRepository userStockRepository;

    public UserStockService(UserStockRepository userStockRepository)
    {
        this.userStockRepository = userStockRepository;
    }

    public void createNewUserStock(UserStockRequest userStockRequest)
    {
        UserStock userStock = new UserStock();
        userStock.setCompanyName(userStockRequest.getCompanyName());
        userStock.setCompanySharesOwned(userStockRequest.getCompanySharesOwned());
        userStock.setUser(userStockRequest.getUser());

        userStockRepository.save(userStock);
    }

    public void updateCompanySharesOwned(UserStock userStock)
    {
        userStockRepository.updateUserShares(userStock.getCompanySharesOwned(), userStock.getUser(), userStock.getCompanyName());
    }

    public UserStock getUserByCompanyNameAndUsername(String companyName, String username)
    {
        UserStock userStock = userStockRepository.findByCompanyNameAndUserUsername(companyName, username);
        if(userStock != null)
            return userStock;
        else
            // handle case where user is not found
            return null;
    }

    public void buyTransactionStuff(TransactionDTO td, UserStockRequest userStockRequest)
    {
        UserStock userStock = getUserByCompanyNameAndUsername(td.getCompanyName(), td.getUsername());
        if(userStock != null)
        {
            double newUserStockBalance = userStock.getCompanySharesOwned() + td.getAmount();
            userStock.setCompanySharesOwned(newUserStockBalance);
            updateCompanySharesOwned(userStock);
        }
        else
            createNewUserStock(userStockRequest);
    }

    public void sellTransactionStuff(TransactionDTO td)
    {
        UserStock userStock = getUserByCompanyNameAndUsername(td.getCompanyName(), td.getUsername());
        double newUserStockBalance = userStock.getCompanySharesOwned() - td.getAmount();
        userStock.setCompanySharesOwned(newUserStockBalance);
        updateCompanySharesOwned(userStock);
    }
}
