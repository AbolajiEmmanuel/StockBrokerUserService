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
 * @since Mar 12, 2023 7:47:33 PM
 */
public class TransactionDTO
{
    private String username;
    private String companyName;
    private double amount;

    public TransactionDTO()
    {
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amountBought)
    {
        this.amount = amountBought;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
}
