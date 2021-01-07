/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.design_pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengyi
 * @version : Department.java, v 0.1 2021年01月07日 3:01 下午 chengyi Exp $
 */
public class Department extends HumanResource {

    private List<HumanResource> subNodes = new ArrayList<>();

    public Department(long id) {
        super(id);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (HumanResource subNode : subNodes) {
            totalSalary += subNode.calculateSalary();
        }
        this.salary = totalSalary;
        return totalSalary;
    }

    public void addSubNode(HumanResource hr) {
        subNodes.add(hr);
    }
}