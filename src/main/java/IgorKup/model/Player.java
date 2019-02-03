package IgorKup.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {
    @Id
//    @GeneratedValue(generator = "increment")
//    @GenericGenerator(name="increment" , strategy = "increment")
    private int id;
    @Column
    private String nickName;
    @Column
    private int bet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (id != player.id) return false;
        if (bet != player.bet) return false;
        return nickName.equals(player.nickName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nickName.hashCode();
        result = 31 * result + bet;
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", bet=" + bet +
                '}';
    }
}
