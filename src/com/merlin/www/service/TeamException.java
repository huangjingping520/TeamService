package com.merlin.www.service;

/**
 * @Description: 自定义异常
 * @version
 * @since
 * @return:
 * @author MerlinAlex hjp520xty@gmail.com
 * @date: 2021/4/14 15:12
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -33180000218183813L;

    public TeamException(){

    }
    public TeamException(String msg){
        super(msg);
    }
}
