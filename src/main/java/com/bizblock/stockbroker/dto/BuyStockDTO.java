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
package com.bizblock.stockbroker.dto;

/**
 *
 * @author BLAZE
 * @since Mar 12, 2023 7:45:35 PM
 */
public class BuyStockDTO
{
    private TransactionDTO transactionDto;
    private UserStockRequest userStockRequest;

    // getters and setters
    public TransactionDTO getTransactionDto()
    {
        return transactionDto;
    }

    public void setTransactionDto(TransactionDTO transactionDto)
    {
        this.transactionDto = transactionDto;
    }

    public UserStockRequest getUserStockRequest()
    {
        return userStockRequest;
    }

    public void setUserStockRequest(UserStockRequest userStockRequest)
    {
        this.userStockRequest = userStockRequest;
    }
}
