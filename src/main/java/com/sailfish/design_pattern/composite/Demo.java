/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.design_pattern.composite;

import java.util.List;

/**
 * Department:
 *      - 01
 *          - 010
 *          - 011
 *          - 012
 *              - 0120
 *                  Employee
 *                  - E-0120
 *                  - E-0121
 *              - 0121
 *                  - 01210
 *                  - xxx
 *  部门-》子部门
 *  部门-》员工
 *  员工无上下级关系
 * @author chengyi
 * @version : Demo.java, v 0.1 2021年01月07日 3:04 下午 chengyi Exp $
 */
public class Demo {

    private static final long ORGANIZATION_ROOT_ID = 1001;
    private DepartmentRepo departmentRepo; // 依赖注入
    private EmployeeRepo employeeRepo; // 依赖注入

    public void buildOrganization() {
        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(rootDepartment);
    }

    private void buildOrganization(Department department) {
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment = new Department(subDepartmentId);
            department.addSubNode(subDepartment);
            buildOrganization(subDepartment);
        }
        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
        for (Long employeeId : employeeIds) {
            double salary = employeeRepo.getEmployeeSalary(employeeId);
            department.addSubNode(new Employee(employeeId, salary));
        }
    }

}