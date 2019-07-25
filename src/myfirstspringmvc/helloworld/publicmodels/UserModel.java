package myfirstspringmvc.helloworld.publicmodels;

public class UserModel {
    public UserModel(int userId, String name, MemberSex sex, int age) {
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String name;
    private MemberSex sex = MemberSex.unknow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberSex getSex() {
        return sex;
    }

    public void setSex(MemberSex sex) {
        this.sex = sex;
    }

    public int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
