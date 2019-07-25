package myfirstspringmvc.helloworld.useraction;

import com.alibaba.fastjson.JSONObject;
import myfirstspringmvc.helloworld.DBAssistant.UserDBAction;
import myfirstspringmvc.helloworld.publicmodels.MemberSex;
import myfirstspringmvc.helloworld.publicmodels.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

class UserRegistParam {
    private int sex;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;
}

@Controller
@RequestMapping("/user")
public class UserRegisterController {
    @ResponseBody
    @RequestMapping(value ="/regist")
    public String say(UserRegistParam bean) {
        boolean success = UserDBAction.registerNewUser(bean.getName(), bean.getAge(), MemberSex.sexOfValue(bean.getSex()));
        if (success) {
            return "{\"code\": 0}";
        }
        return "{\"code\": 2, \"msg\" : \"数据库插入错误\"}";
    }
}
