/**
 * Created by IntelliJ IDEA.
 * User: matt
 * Date: 11-12-14
 * Time: 5:45 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Lexer {

    char c;
    public static final char EOF = (char)-1;
    public static final int EOF_TYPE = 1;
    String input;
    int p = 0;

    public abstract Token nextToken();
    public abstract String getTokenName(int tokenType);

    public Lexer(String input) { 
        this.input = input;
        c = input.charAt(p);
    }

    void consume() {
        p++;
        if( p >= input.length() ) c = EOF;
        else c = input.charAt(p);
    }

    void match(char x) {
        if (c==x) consume();
        else throw new Error("expecting "+x+"; found "+c);
    }

    
}
