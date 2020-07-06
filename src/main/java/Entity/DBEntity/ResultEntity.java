package Entity.DBEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "result", schema = "bazabaka", catalog = "")
public class ResultEntity {
    private int idresult;
    private String score;
    private String set1;
    private String set2;
    private String set3;
    private String set4;
    private String set5;
    private String set6;
    private String set7;
    private Collection<MatchesLEntity> matchesLSByIdresult;

    @Id
    @Column(name = "idresult", nullable = false)
    public int getIdresult() {
        return idresult;
    }

    public void setIdresult(int idresult) {
        this.idresult = idresult;
    }

    @Basic
    @Column(name = "score", nullable = false, length = 3)
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Basic
    @Column(name = "set1", nullable = false, length = 5)
    public String getSet1() {
        return set1;
    }

    public void setSet1(String set1) {
        this.set1 = set1;
    }

    @Basic
    @Column(name = "set2", nullable = false, length = 5)
    public String getSet2() {
        return set2;
    }

    public void setSet2(String set2) {
        this.set2 = set2;
    }

    @Basic
    @Column(name = "set3", nullable = false, length = 5)
    public String getSet3() {
        return set3;
    }

    public void setSet3(String set3) {
        this.set3 = set3;
    }

    @Basic
    @Column(name = "set4", nullable = true, length = 5)
    public String getSet4() {
        return set4;
    }

    public void setSet4(String set4) {
        this.set4 = set4;
    }

    @Basic
    @Column(name = "set5", nullable = true, length = 5)
    public String getSet5() {
        return set5;
    }

    public void setSet5(String set5) {
        this.set5 = set5;
    }

    @Basic
    @Column(name = "set6", nullable = true, length = 5)
    public String getSet6() {
        return set6;
    }

    public void setSet6(String set6) {
        this.set6 = set6;
    }

    @Basic
    @Column(name = "set7", nullable = true, length = 5)
    public String getSet7() {
        return set7;
    }

    public void setSet7(String set7) {
        this.set7 = set7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultEntity that = (ResultEntity) o;

        if (idresult != that.idresult) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (set1 != null ? !set1.equals(that.set1) : that.set1 != null) return false;
        if (set2 != null ? !set2.equals(that.set2) : that.set2 != null) return false;
        if (set3 != null ? !set3.equals(that.set3) : that.set3 != null) return false;
        if (set4 != null ? !set4.equals(that.set4) : that.set4 != null) return false;
        if (set5 != null ? !set5.equals(that.set5) : that.set5 != null) return false;
        if (set6 != null ? !set6.equals(that.set6) : that.set6 != null) return false;
        if (set7 != null ? !set7.equals(that.set7) : that.set7 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idresult;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (set1 != null ? set1.hashCode() : 0);
        result = 31 * result + (set2 != null ? set2.hashCode() : 0);
        result = 31 * result + (set3 != null ? set3.hashCode() : 0);
        result = 31 * result + (set4 != null ? set4.hashCode() : 0);
        result = 31 * result + (set5 != null ? set5.hashCode() : 0);
        result = 31 * result + (set6 != null ? set6.hashCode() : 0);
        result = 31 * result + (set7 != null ? set7.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "result")
    public Collection<MatchesLEntity> getMatchesLSByIdresult() {
        return matchesLSByIdresult;
    }

    public void setMatchesLSByIdresult(Collection<MatchesLEntity> matchesLSByIdresult) {
        this.matchesLSByIdresult = matchesLSByIdresult;
    }

    public String[] setsToArrString() {
        return new String[]{set1,set2,set3,set4,set5,set6,set7};
    }
}
