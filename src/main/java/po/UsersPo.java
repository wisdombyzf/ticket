package po;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "orderticket", catalog = "")
public class UsersPo
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersPo usersPo = (UsersPo) o;

        if (id != null ? !id.equals(usersPo.id) : usersPo.id != null) return false;
        if (accountNo != null ? !accountNo.equals(usersPo.accountNo) : usersPo.accountNo != null) return false;
        if (name != null ? !name.equals(usersPo.name) : usersPo.name != null) return false;
        if (password != null ? !password.equals(usersPo.password) : usersPo.password != null) return false;
        if (sex != null ? !sex.equals(usersPo.sex) : usersPo.sex != null) return false;
        if (phone != null ? !phone.equals(usersPo.phone) : usersPo.phone != null) return false;
        if (email != null ? !email.equals(usersPo.email) : usersPo.email != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountNo != null ? accountNo.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
