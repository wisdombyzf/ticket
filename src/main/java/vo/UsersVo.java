package vo;

import javax.persistence.*;

public class UsersVo
{
    private String id;
    private String accountNo;
    private String name;
    private String password;
    private String sex;
    private String phone;
    private String email;

    @Basic
    @Column(name = "ID", nullable = false, length = 20)
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Id
    @Column(name = "ACCOUNT_NO", nullable = false, length = 20)
    public String getAccountNo()
    {
        return accountNo;
    }

    public void setAccountNo(String accountNo)
    {
        this.accountNo = accountNo;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 20)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 20)
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Basic
    @Column(name = "SEX", nullable = true, length = 2)
    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    @Basic
    @Column(name = "PHONE", nullable = true, length = 20)
    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 30)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


}
