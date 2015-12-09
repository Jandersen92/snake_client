package spil;

/**
 * Created by johanandersen on 04/12/2015.
 */
public class Gamer extends User {

    private int score;
    private int totalScore;
    private int kills;
    private String controls;
    private boolean Winner;

    public int getScore() {
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public String getControls() {
        return controls;
    }

    public void setControls(String controls) {
        this.controls = controls;
    }

    public boolean isWinner() {
        return Winner;
    }

    public void setWinner(boolean winner) {
        Winner = winner;
    }
}
