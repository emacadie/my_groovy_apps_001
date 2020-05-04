This is a Grails app that I will use to see how I can recreate all the Grails constraints on fields in a PostGreSQL database.    

See http://grails.org/doc/latest/ref/Constraints/Usage.html   
See also http://grails.org/doc/latest/guide/GORM.html#gormConstraints   
See also http://grails.org/doc/latest/guide/validation.html   

It is better to use triggers rather than constraints. You may add a constraint to a table that already has data in it. Some of that pre-existing data may violate your constraint.  

For the Grails constraint maximum, here is an example in the Grails app: 
```groovy
    static constraints = {
        firstIntField max: 1000
        firstFloatField max: 1000.0f
        firstDateField max: new Date()
    }
```

Here is a simple function and a trigger:  
```sql
create or replace function check_second_float_001() returns trigger as $body$
        begin
                IF new.second_float_field > 1000 THEN
                    return NULL;
                END IF;
                return new;
        end;
$body$ language plpgsql;

create trigger check_second_float_trig_001
        BEFORE INSERT OR UPDATE on max_class
        for each row execute procedure check_second_float_001();
```



