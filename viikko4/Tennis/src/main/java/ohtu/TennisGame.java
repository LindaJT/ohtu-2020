package ohtu;

public class TennisGame {
    
    private Player player1;
    private Player player2;

    public TennisGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name, 0);
        player2 = new Player(player2Name, 0);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.setScore(player1.getScore() +1);
        } else {
            player2.setScore(player2.getScore() +1);
        }
    }

    public String getScore() {
        String score = "";
        if (player1.getScore() == player2.getScore()) {
            score = tie(player1.getScore());
        } else if (player1.getScore()>=4 || player2.getScore()>=4) {
            score = winningSituation();
        } else {
            score = call(player1);
            score += "-";
            score += call(player2);
        }
        return score;
    }
    
    private String call(Player player) {
        switch(player.getScore())
                {
                    case 0:
                        return "Love";
                    case 1:
                        return "Fifteen";
                    case 2:
                        return "Thirty";
                    case 3:
                        return "Forty";
                }
        return "";
    }
    
    private String winningSituation() {
        int minusResult = player1.getScore()-player2.getScore();
            if (minusResult==1) return "Advantage player1";
            else if (minusResult ==-1) return "Advantage player2";
            else if (minusResult>=2) return "Win for player1";
            else return "Win for player2";
    }

    private String tie(int score) {
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
}