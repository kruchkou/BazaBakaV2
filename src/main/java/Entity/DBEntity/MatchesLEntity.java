package Entity.DBEntity;

import javax.persistence.*;

@NamedQueries({

        @NamedQuery(name = "Match.byParams",
                query = "From MatchesLEntity match " +
                        "LEFT JOIN fetch match.player1 p1 " +
                        "LEFT JOIN fetch match.player2 p2 " +
                        "LEFT JOIN fetch match.result r " +
                        "LEFT JOIN fetch match.league l " +
                        "WHERE p1.name = :p1name " +
                        "and p2.name = :p2name " +
                        "and r.score = :score " +
                        "and r.set1 = :set1 " +
                        "and r.set2 = :set2 " +
                        "and r.set3 = :set3 " +
                        "and r.set4 = :set4 " +
                        "and r.set5 = :set5 " +
                        "and r.set6 = :set6 " +
                        "and r.set7 = :set7 " +
                        "and match.date = :date " +
                        "and l.name = :league " +
                        "order by match.date desc"),

        @NamedQuery(name = "Match.getMatches",
                query = "From MatchesLEntity match " +
                        "LEFT JOIN fetch match.player1 p1 " +
                        "LEFT JOIN fetch match.player2 p2 " +
                        "LEFT JOIN fetch match.result r " +
                        "LEFT JOIN fetch match.league l " +
                        "WHERE l.name like :league " +
                        "order by match.date desc"),

        @NamedQuery(name = "Match.get2PlMatches",
                query = "From MatchesLEntity match " +
                        "LEFT JOIN fetch match.player1 p1 " +
                        "LEFT JOIN fetch match.player2 p2 " +
                        "LEFT JOIN fetch match.result r " +
                        "LEFT JOIN fetch match.league l " +
                        "WHERE (p1.name = :p1name or p2.name = :p1name)" +
                        "and (p1.name = :p2name or p2.name = :p2name)" +
                        "and l.name like :league " +
                        "order by match.date desc"),

        @NamedQuery(name = "Match.getPlMatches",
                query = "From MatchesLEntity match " +
                        "LEFT JOIN fetch match.player1 p1 " +
                        "LEFT JOIN fetch match.player2 p2 " +
                        "LEFT JOIN fetch match.result r " +
                        "LEFT JOIN fetch match.league l " +
                        "WHERE (p1.name = :p1name or p2.name = :p1name) " +
                        "and l.name like :league " +
                        "order by match.date desc"),

        @NamedQuery(name = "Match.getPlMatchesByDate",
                query = "From MatchesLEntity match " +
                        "LEFT JOIN fetch match.player1 p1 " +
                        "LEFT JOIN fetch match.player2 p2 " +
                        "LEFT JOIN fetch match.result r " +
                        "LEFT JOIN fetch match.league l " +
                        "WHERE (p1.name = :p1name or p2.name = :p1name) " +
                        "and l.name like :league " +
                        "and match.date like :date " +
                        "order by match.date desc")
})

@Entity
@Table(name = "matchesL", schema = "bazabaka")
public class MatchesLEntity {
    private int idmatches;
    private String date;
    private PlayersEntity player1;
    private PlayersEntity player2;
    private ResultEntity result;
    private LeaguesEntity league;
    private Double winR1;
    private Double winR2;

    @Id
    @Column(name = "idmatches", nullable = false)
    public int getIdmatches() {
        return idmatches;
    }

    public void setIdmatches(int idmatches) {
        this.idmatches = idmatches;
    }

    @Basic
    @Column(name = "date", nullable = false, length = 45)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "winR1", nullable = true, precision = 0)
    public Double getWinR1() {
        return winR1;
    }

    public void setWinR1(Double winR1) {
        this.winR1 = winR1;
    }

    @Basic
    @Column(name = "winR2", nullable = true, precision = 0)
    public Double getWinR2() {
        return winR2;
    }

    public void setWinR2(Double winR2) {
        this.winR2 = winR2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchesLEntity that = (MatchesLEntity) o;

        if (idmatches != that.idmatches) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (winR1 != null ? !winR1.equals(that.winR1) : that.winR1 != null) return false;
        if (winR2 != null ? !winR2.equals(that.winR2) : that.winR2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmatches;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (winR1 != null ? winR1.hashCode() : 0);
        result = 31 * result + (winR2 != null ? winR2.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "player1", referencedColumnName = "idplayers", nullable = false)
    public PlayersEntity getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayersEntity playersByPlayer1) {
        this.player1 = playersByPlayer1;
    }

    @ManyToOne
    @JoinColumn(name = "player2", referencedColumnName = "idplayers", nullable = false)
    public PlayersEntity getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayersEntity playersByPlayer2) {
        this.player2 = playersByPlayer2;
    }

    @ManyToOne
    @JoinColumn(name = "result", referencedColumnName = "idresult", nullable = false)
    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity resultByResult) {
        this.result = resultByResult;
    }

    @ManyToOne
    @JoinColumn(name = "league", referencedColumnName = "idleague", nullable = false)
    public LeaguesEntity getLeague() {
        return league;
    }

    public void setLeague(LeaguesEntity leaguesByLeague) {
        this.league = leaguesByLeague;
    }

}
