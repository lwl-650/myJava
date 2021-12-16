package util.result;


import java.util.ArrayList;

public class R {

    /**成功且带数据**/
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    /**成功但不带数据**/
    public static Result success(){

        return success(new ArrayList<String>());
    }

    /**
     * 自定义成功
     * @param code
     * @param msg
     * @param object
     * @return
     */
    public static Result personalizado(Integer code,String msg,Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    /**失败**/
    public static Result error(){
        Result result = new Result();
        result.setCode(ResultEnum.USER_NOT_EXIST.getCode());
        result.setMsg(ResultEnum.USER_NOT_EXIST.getMsg());
        result.setData(new ArrayList<String>());
        return result;
    }

    /**
     *
     * @return
     */
    public static Result repeat(){
        Result result = new Result();
        result.setCode(ResultEnum.USER_IS_EXISTS.getCode());
        result.setMsg(ResultEnum.USER_IS_EXISTS.getMsg());
        result.setData(new ArrayList<String>());
        return result;
    }
}
