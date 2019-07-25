package myfirstspringmvc.helloworld.DBAssistant;

import myfirstspringmvc.helloworld.publicmodels.MemberSex;
import myfirstspringmvc.helloworld.publicmodels.UserModel;

import java.lang.reflect.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class UserUpdateSqlMaker {

    private String sqlStr = "set";

    public String getSqlStr() {
        return sqlStr;
    }

    private int userId;

    public void setUserId(int userId) {
        this.sqlStr = String.format("%s where id=%d", sqlStr, userId);
        this.userId = userId;
    }

    public void setNameStr(String nameStr) {
        this.sqlStr = String.format("%s name=\"%s\"", sqlStr, nameStr);
        this.nameStr = nameStr;
    }

    public void setAge(int age) {
        this.sqlStr = String.format("%s, age=%d", sqlStr, age);
        this.age = age;
    }

    public void setSex(MemberSex sex) {
        this.sqlStr = String.format("%s, gender=%d", sqlStr, sex.getStatus());
        this.sex = sex;
    }

    private String nameStr;
    private int age;
    private MemberSex sex;

    UserUpdateSqlMaker(int userId, String nameStr, int age, MemberSex sex) {
        this.setNameStr(nameStr);
        this.setAge(age);
        this.setSex(sex);
        this.setUserId(userId);
    }
}

public class UserDBAction {
    public static UserModel fetchUserInfoWithUserId(int userId) throws Exception {
        try {
            // 创建Statement对象
            Statement stmt = DBConnection.shareInstance().createStatement();
            // 执行SQL语句
            String sqlStr = "select * from testDataBase.user where id=" + String.valueOf(userId);
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()) {
                return new UserModel(rs.getInt(1), rs.getString(2),
                        MemberSex.sexOfValue(rs.getInt(3)), rs.getInt(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Boolean registerNewUser(String nameStr, int age, MemberSex sex) {
        Boolean success = false;
        try {
            Statement stmt = DBConnection.shareInstance().createStatement();
            String sqlStr = String.format("insert into testDataBase.user(name, gender, age) values(\"%s\", %d, %d)", nameStr, sex.getStatus(), age);
            int effectLines = stmt.executeUpdate(sqlStr);
            success = effectLines > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public  static Boolean updateUserInfo(int userId, String nameStr, int age, MemberSex sex) {
        UserUpdateSqlMaker updater = new UserUpdateSqlMaker(userId, nameStr, age, sex);
        Boolean success = false;
        try {
            Statement stmt = DBConnection.shareInstance().createStatement();
            String sqlStr = String.format("update testDataBase.user %s", updater.getSqlStr());
            int effectLines = stmt.executeUpdate(sqlStr);
            success = effectLines > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
