package Entity.DBEntity;

import javax.persistence.*;

@Entity
@Table(name = "WinLs", schema = "bazabaka", catalog = "")
public class WinLsEntity {
    private int id;
    private String date;
    private double winL;
    private LeaguesEntity leaguesByLeagueid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = false, length = 10)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "winL", nullable = false, precision = 0)
    public double getWinL() {
        return winL;
    }

    public void setWinL(double winL) {
        this.winL = winL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinLsEntity that = (WinLsEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.winL, winL) != 0) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        temp = Double.doubleToLongBits(winL);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "leagueid", referencedColumnName = "idleague", nullable = false)
    public LeaguesEntity getLeaguesByLeagueid() {
        return leaguesByLeagueid;
    }

    public void setLeaguesByLeagueid(LeaguesEntity leaguesByLeagueid) {
        this.leaguesByLeagueid = leaguesByLeagueid;
    }
}
