DELIMITER $$
 
CREATE TRIGGER before_insert_max_class
     BEFORE INSERT ON max_class FOR EACH ROW
     BEGIN
          IF NEW.first_int_field > 1000
          THEN
               SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'first_int_field must be less than 1000';
          END IF;
          
          IF NEW.first_float_field > 1000
          THEN
               SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'first_float_field must be less than 1000';
          END IF;
          
          IF NEW.first_date_field > NOW()
          THEN
               SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'first_date_field must be no later than current time';
          END IF;
          
     END;
$$
 
CREATE TRIGGER before_update_max_class
     BEFORE UPDATE ON max_class  FOR EACH ROW
     BEGIN
          IF NEW.first_int_field > 1000
          THEN
               SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'first_int_field must be less than 1000';
          END IF;
          
          IF NEW.first_float_field > 1000
          THEN
               SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'first_float_field must be less than 1000';
          END IF;
          
          IF NEW.first_date_field > NOW()
          THEN
               SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'first_date_field must be no later than current time';
          END IF;
     END;
$$


