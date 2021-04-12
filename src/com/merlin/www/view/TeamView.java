package com.merlin.www.view;

import com.merlin.www.service.NameListService;
import com.merlin.www.service.TeamService;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    private void enterMainMenu(){
        boolean loopFlag = true;

        while (loopFlag){
            listAllEmployee();
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");
            char menu = TSUtility.readMenuSelection();
            switch (menu){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("是否退出(Y/N): ");
                    char isExit = TSUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        loopFlag = false;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + menu);
            }
        }
    }
    /**
     * @Description: 显示所有的员工信息
     * @version
     * @since
     * @return:
     * @author MerlinAlex hjp520xty@gmail.com
     * @date: 2021/4/12 22:37
     */
    private void listAllEmployee(){
        System.out.println("显示员工信息");
    }

    private void getTeam(){
        System.out.println("查看开发团队情况");
    }

    private  void addMember(){
        System.out.println("添加团队成员");
    }

    private void deleteMember(){
        System.out.println("删除团队成员");
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
