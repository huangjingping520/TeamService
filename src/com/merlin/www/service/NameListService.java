package com.merlin.www.service;

import com.merlin.www.domain.*;
import org.w3c.dom.NameList;
import static com.merlin.www.service.Data.*;
/**
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 * @author MerlinAlex
 */

public class NameListService {
    private Employee[] employees;
    public NameListService(){
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipment;
            double bouns;
            int stock;

            switch (type){
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bouns = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name, age,salary,equipment,bouns);
                    break;
                case  ARCHITECT:
                    equipment = createEquipment(i);
                    bouns = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bouns,stock);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + type);
            }
        }
    }

    /**
     *
     * @Description 获取指定index上的员工的设备
     * @author MerlinAlex
     */
    private Equipment createEquipment(int index) {
        int key = Integer.parseInt(EQUIPMENTS[index][0]);

        String modelOrName = EQUIPMENTS[index][1];
        switch (key){
            case PC:
                String display = EQUIPMENTS[index][2];
                return new PC(modelOrName,display);
            case NOTEBOOK:
                double price  = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(modelOrName,price);
            case PRINTER:
                String type = EQUIPMENTS[index][2];
                return new Printer(modelOrName,type);
        }
        return null;
    }


    /**
     * @Description 获取所有员工
     * @author MerlinAlex
     * @return
     */
    public Employee[] getAllEmployees(){
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工");
    }
}
