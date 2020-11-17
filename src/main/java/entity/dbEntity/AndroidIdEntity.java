package entity.dbEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AndroidId", schema = "bazabaka", catalog = "")
public class AndroidIdEntity {
    private int id;
    private String androidId;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "android_id", nullable = false, length = 40)
    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AndroidIdEntity that = (AndroidIdEntity) o;
        return id == that.id &&
                Objects.equals(androidId, that.androidId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, androidId, name);
    }
}
