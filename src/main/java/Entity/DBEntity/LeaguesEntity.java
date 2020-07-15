package Entity.DBEntity;

import javax.persistence.*;
import java.util.Collection;

@NamedQueries({

        @NamedQuery(name = "League.byName",
                query = "From LeaguesEntity leagues " +
                        "WHERE name = :name ")

})

@Entity
@Table(name = "leagues", schema = "bazabaka", catalog = "")
public class LeaguesEntity {
    private int idleague;
    private String name;
    private Double winL;
    private Collection<WinLsEntity> winLsByIdleague;
    private Collection<MatchesLEntity> matchesLSByIdleague;

    @Id
    @Column(name = "idleague", nullable = false)
    public int getIdleague() {
        return idleague;
    }

    public void setIdleague(int idleague) {
        this.idleague = idleague;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "WinL", nullable = true, precision = 0)
    public Double getWinL() {
        return winL;
    }

    public void setWinL(Double winL) {
        this.winL = winL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaguesEntity that = (LeaguesEntity) o;

        if (idleague != that.idleague) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (winL != null ? !winL.equals(that.winL) : that.winL != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idleague;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (winL != null ? winL.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "leaguesByLeagueid")
    public Collection<WinLsEntity> getWinLsByIdleague() {
        return winLsByIdleague;
}

    public void setWinLsByIdleague(Collection<WinLsEntity> winLsByIdleague) {
        this.winLsByIdleague = winLsByIdleague;
    }

    @OneToMany(mappedBy = "league")
    public Collection<MatchesLEntity> getMatchesLSByIdleague() {
        return matchesLSByIdleague;
    }

    public void setMatchesLSByIdleague(Collection<MatchesLEntity> matchesLSByIdleague) {
        this.matchesLSByIdleague = matchesLSByIdleague;
    }
}
