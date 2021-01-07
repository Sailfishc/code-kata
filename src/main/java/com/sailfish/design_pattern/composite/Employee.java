/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.design_pattern.composite;

/**
 * @author chengyi
 * @version : Employee.java, v 0.1 2021年01月07日 2:59 下午 chengyi Exp $
 */
public class Employee extends HumanResource {

    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}