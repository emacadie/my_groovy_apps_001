package activejdbc.examples.simple;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table

@Table( 'book' )
public class Book extends Model {
    
    Book() {
        super()
        version = 0
    }
}

