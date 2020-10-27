

import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test 
    public void searchReturnsCorrectPlayer() {
        Player player = stats.search("Semenko");
        assertEquals("EDM", player.getTeam());
    }
    
    @Test
    public void searchReturnsNullWhenPlayerNotOnList() {
        Player player = stats.search("Hölöpöti");
        assertEquals(null, player);
    }
    
    @Test
    public void teamSearchReturnsCorrectList() {
        List<Player> searchResult = stats.team("EDM");
        assertEquals(3, searchResult.size());
    }
    
    @Test
    public void nonExistingTeamReturnsEmptyList() {
        List<Player> searchResult = stats.team("HKI");
        assertEquals(0, searchResult.size());
    }
    
    @Test
    public void correctAmountofTopScorers() {
        List<Player> topScorers = stats.topScorers(2);
        assertEquals(3, topScorers.size());
    }
    
    @Test
    public void topScorerAtTheTopOfTheList() {
        List<Player> topScorers = stats.topScorers(2);
        assertEquals("Gretzky", topScorers.get(0).getName());
    }
}
       