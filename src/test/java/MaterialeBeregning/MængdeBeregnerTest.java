package MaterialeBeregning;

import FunctionLayer.*;
import PresentationLayer.Register;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MængdeBeregnerTest {
    @Test
    public void testMB() throws LoginSampleException {
        User user = new User("Test","Test","Test","test","test","test",1234);

        Carport carport = new Carport(1,540, 320, 1, 15, 4);
       Ordre x = new Ordre(carport, user);
        MængdeBeregner TestRegner = new MængdeBeregner(x);

        //Expected
        int TestRes = 6;
        //aktual
        int TestOrdreRes = TestRegner.antalStolper();
        Assert.assertEquals(TestRes, TestOrdreRes);
    }
}