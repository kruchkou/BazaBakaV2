package Entity.DBEntity;

import javax.persistence.*;

@Entity
@Table(name = "Appusers", schema = "bazabaka", catalog = "")
public class AppusersEntity {
    private int id;
    private String username;
    private String mac;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 40)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "mac", nullable = false, length = 17)
    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppusersEntity that = (AppusersEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (mac != null ? !mac.equals(that.mac) : that.mac != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (mac != null ? mac.hashCode() : 0);
        return result;
    }
}
