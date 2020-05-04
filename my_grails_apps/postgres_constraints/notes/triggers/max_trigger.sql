-- trigger for max constraint in postgres

create or replace function check_first_float_001() returns trigger as $body$
    begin
        IF new.first_float_field > 1000 THEN
            return NULL;
        END IF;
        return new;
     end;
$body$ language plpgsql;

create trigger check_first_float_trig_001
    BEFORE INSERT OR UPDATE on max_class
    for each row execute procedure check_first_float_001();

create or replace function check_first_int_001() returns trigger as $body$
    begin
        IF new.first_int_field > 1000 THEN
            return NULL;
        END IF;
        return new;
    end;
$body$ language plpgsql;

create  trigger check_first_int_trig_001
    BEFORE INSERT OR UPDATE on max_class
    for each row execute procedure check_first_int_001();
    
create or replace function check_first_date_001() returns trigger as $body$
    begin
        IF new.first_date_field > CURRENT_TIMESTAMP(0) THEN
            return NULL;
        END IF;
        return new;
    end;
$body$ language plpgsql;

create  trigger check_first_date_trig_001
    BEFORE INSERT OR UPDATE on max_class
    for each row execute procedure check_first_date_001();    

-- to drop trigger, put in name of table:    
-- drop trigger check_first_int_trig_001 on max_class;
-- to drop function, add args in parentheses:
-- drop function check_first_float_001();


