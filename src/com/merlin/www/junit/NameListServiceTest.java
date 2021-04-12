package com.merlin.www.junit;
import com.merlin.www.domain.Employee;
import com.merlin.www.service.NameListService;
import com.merlin.www.service.TeamException;
import org.junit.Test;
/**
 * @Description: 对NameListService类进行测试
 * @version
 * @since
 * @return: Null
 * @author MerlinAlex hjp520xty@gmail.com
 * @date: 2021/4/11 16:05
 */
public class NameListServiceTest {

    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();

        Employee[] employees = service.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();

        int id = 1;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());;
        }
    }
}
