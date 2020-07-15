package Entity.DBEntity;

import javax.persistence.*;
import java.util.Collection;

@NamedQueries({

        @NamedQuery(name = "Player.byName",
                query = "From PlayersEntity players " +
                        "WHERE name = :name ")

})

@Entity
@Table(name = "players", schema = "bazabaka", catalog = "")

public class PlayersEntity {
    private int idplayers;
    private String name;
    private Collection<MatchesLEntity> matchesByPlayer1;
    private Collection<MatchesLEntity> matchesByPlayer2;

    @Id
    @Column(name = "idplayers", nullable = false)
    public int getIdplayers() {
        return idplayers;
    }

    public void setIdplayers(int idplayers) {
        this.idplayers = idplayers;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
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

        PlayersEntity that = (PlayersEntity) o;

        if (idplayers != that.idplayers) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idplayers;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "player1")
    public Collection<MatchesLEntity> getMatchesByPlayer1() {
        return matchesByPlayer1;
    }

    public void setMatchesByPlayer1(Collection<MatchesLEntity> matchesLSByIdplayers) {
        this.matchesByPlayer1 = matchesLSByIdplayers;
    }

    @OneToMany(mappedBy = "player2")
    public Collection<MatchesLEntity> getMatchesByPlayer2() {
        return matchesByPlayer2;
    }

    public void setMatchesByPlayer2(Collection<MatchesLEntity> matchesLSByIdplayers_0) {
        this.matchesByPlayer2 = matchesLSByIdplayers_0;
    }

}
