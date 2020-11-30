
package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author linjokin
 */
public class QueryBuilder {
    
    Matcher matcher;
    
    public QueryBuilder() {   
        this.matcher = new All();
    }
    
    public Matcher build() {
        return this.matcher;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(new PlaysIn(team), this.matcher);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int number, String command) {
        this.matcher = new And(new HasAtLeast(number, command), this.matcher);
        return this;
    }
    
    public QueryBuilder hasFewerThan(int number, String command) {
        this.matcher = new And(new HasFewerThan(number, command), this.matcher);
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matcher) {
        Matcher[] m = matcher;
        Matcher[] newM = new Matcher[m.length + 1];
        for (int i = 0; i < m.length; i ++) {
            newM[i] = m[i];
        }
        newM[newM.length-1] = this.matcher;
        this.matcher = new Or(newM);
        return this;
    }
    
}
