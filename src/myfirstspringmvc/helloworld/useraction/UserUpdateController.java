package myfirstspringmvc.helloworld.useraction;


import myfirstspringmvc.helloworld.DBAssistant.UserDBAction;
import myfirstspringmvc.helloworld.publicmodels.MemberSex;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

class UserUpdateParam {
    private int userId;
    private int sex;
    private String name;
    private int age;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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
}

@Controller
@RequestMapping("/user")
public class UserUpdateController {
    @ResponseBody
    @RequestMapping(value ="/update")
    public String say(UserUpdateParam bean) {
        boolean success = UserDBAction.updateUserInfo(bean.getUserId(), bean.getName(), bean.getAge(), MemberSex.sexOfValue(bean.getSex()));
        if (success) {
            return "{\"code\": 0}";
        }
        return "{\"code\": 2, \"msg\" : \"数据库插入错误\"}";
    }
}
