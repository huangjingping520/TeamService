package com.merlin.www.service;

import com.merlin.www.domain.Architect;
import com.merlin.www.domain.Designer;
import com.merlin.www.domain.Employee;
import com.merlin.www.domain.Programmer;

/**
 * @Description: 关于开发团队的管理
 * @version
 * @since
 * @return:
 * @author MerlinAlex hjp520xty@gmail.com
 * @date: 2021/4/11 16:49
 */
public class TeamService {
    // 给memberId赋值
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    //保存开发团队成员
    private Programmer[] team = new Programmer[MAX_MEMBER];
    //记录开发团队中实际的人数
    private int total;

    public TeamService() {
    }

    /**
     * @Description: 获取开发团队中的成员
     * @version
     * @since
     * @return:
     * @author MerlinAlex hjp520xty@gmail.com
     * @date: 2021/4/12 21:09
     */
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }
    /**
     * @Description:  将指定员工添加到开发团队中
     * @version
     * @since
     * @return:
     * @author MerlinAlex hjp520xty@gmail.com
     * @date: 2021/4/12 21:13
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }

        if (!(e instanceof  Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }

        if(isExist(e)){
            throw new TeamException("该员工已经在开发团队中");
        }

        //一定不会出现ClassCastException
        Programmer p = (Programmer) e;
        if("BUSY".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工已是某团队成员");
        }else if("VOCATION".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工正在休假，无法添加");
        }

        /*
        至多一名架构师
        至多两名设计师
        至多三名程序员
         */

        //获取team中已有成员中架构师，设计师，程序员人数
        int numOfArch = 0,numOfDes = 0,numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect){
                numOfArch++;
            }else if(team[i] instanceof Designer){
                numOfDes++;
            }else if(team[i] instanceof Programmer){
                numOfPro++;
            }
        }

        if (p instanceof Architect){
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多有一名架构师");
            }else if (numOfDes >= 2) {
                throw new TeamException("团队中至多有两名设计师");
            }else if (numOfPro >= 3) {
                throw new TeamException("团队中至多有三名程序员");
            }
        }

        team[total] = p;
        total++;
        //p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }
    /**
     * @Description: 判断指定的员工是否已经存在于现有的开发团队中
     * @version
     * @since
     * @return:
     * @author MerlinAlex hjp520xty@gmail.com
     * @date: 2021/4/12 21:24
     */
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if(team[i].getId() == e.getId()){
                return true;
            }
        }
        return false;
    }
    /**
     * @Description: 从团队中删除成员
     * @version
     * @since
     * @return:
     * @author MerlinAlex hjp520xty@gmail.com
     * @date: 2021/4/12 22:15
     */
    public void removeMermber(int memberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        //为找到指定memberId的情况
        if (i == total){
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }

        //后一个元素向前覆盖，实现删除操作
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }

        team[total -1] = null;
        total--;
    }
}