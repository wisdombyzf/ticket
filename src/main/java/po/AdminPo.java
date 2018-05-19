package po;

import javax.persistence.*;

@Entity
@Table(name = "admin", schema = "orderticket", catalog = "")
public class AdminPo
{
    private String id;
    private String password;

    @Id
    @Column(name = "ID", nullable = false, length = 20)
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminPo adminPo = (AdminPo) o;

        if (id != null ? !id.equals(adminPo.id) : adminPo.id != null) return false;
        if (password != null ? !password.equals(adminPo.password) : adminPo.password != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
