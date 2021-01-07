/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.design_pattern.composite;

/**
 * @author chengyi
 * @version : HumanResource.java, v 0.1 2021年01月07日 2:58 下午 chengyi Exp $
 */
public abstract class HumanResource {

    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public abstract double calculateSalary();
}