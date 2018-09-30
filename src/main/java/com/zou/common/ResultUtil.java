package com.zou.common;


/**
 * @author zou
 * @date 2017/8/20
 */
public class ResultUtil<T> {
	/**
     * 请求成功返回
     * @param object
     * @return
     */
    public static Msg success(Object object,int total){
        Msg msg=new Msg();
        msg.setCode(200);
        msg.setMsg("SUCCESS");
        msg.setData(object);
        msg.setTotal(total);
        return msg;
    }
    public static Msg success(){
		return success(null, 0);
    }
 
    public static Msg error(Integer code,String resultmsg){
        Msg msg=new Msg();
        msg.setCode(code);
        msg.setMsg(resultmsg);
        return msg;
    }
}
