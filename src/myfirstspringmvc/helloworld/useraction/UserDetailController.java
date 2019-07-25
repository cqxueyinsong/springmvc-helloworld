package myfirstspringmvc.helloworld.useraction;

import com.alibaba.fastjson.JSONObject;
import myfirstspringmvc.helloworld.DBAssistant.UserDBAction;
import myfirstspringmvc.helloworld.publicmodels.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

class UserDetailParam {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

@Controller
@RequestMapping("/user")
public class UserDetailController {

    @ResponseBody
    @RequestMapping(value ="/getUser")
    public String say(UserDetailParam bean) {
        try {
            UserModel user = UserDBAction.fetchUserInfoWithUserId(bean.getUserId());
            if (user != null) {
                return JSONObject.toJSONString(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"code\": 2, \"msg\" : \"数据库查询错误\"}";
    }
}

