import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.ntnu.iir.bidata.entity.Ingredient;

public class IngredientTest {


    // --------------------------- Positiv TESTS ----------------------------------
    @Test
    public void createInstanceWithValidValues() {
        Ingredient ingredient = new Ingredient("kiwi", 10, 0, 100, "2023-04-25");
        
        String actualName = ingredient.getIngredientName();
        double actualAmount = ingredient.getAmount();
        String actualMesurment = ingredient.getMeasurment();
        double actualPrice = ingredient.getPrice();
        String actualExpireDate = ingredient.getExpireDate();

        assertEquals("Kiwi", actualName); // Assert
        assertEquals(10, actualAmount); // Assert
        assertEquals("Unit", actualMesurment); // Assert
        assertEquals(50, actualPrice); // Assert
        assertEquals("Expired", actualExpireDate); // Assert

  }

    
}
