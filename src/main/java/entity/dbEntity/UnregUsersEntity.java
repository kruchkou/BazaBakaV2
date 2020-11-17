package entity.dbEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "unregUsers", schema = "bazabaka", catalog = "")
public class UnregUsersEntity {
    private int id;
    private String userId;
    private String nickname;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "nickname", nullable = false, length = 20)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnregUsersEntity that = (UnregUsersEntity) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(nickname, that.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, nickname);
    }
}
