/**
 * Created by IntelliJ IDEA.
 * User: matt
 * Date: 11-12-14
 * Time: 5:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class Token {
    
    public int type;
    public String text;
    public Token(int type, String text) { this.type = type; this.text = text; }
    public String toString() {
        String tname = ListLexer.tokenNames[type];
        return "<'" + text + "'," + tname + ">";
    }

    
    
}
