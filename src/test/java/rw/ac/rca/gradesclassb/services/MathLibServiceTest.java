package rw.ac.rca.gradesclassb.services;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.Assert;
import rw.ac.rca.gradesclassb.models.MathLib;
import rw.ac.rca.gradesclassb.repositories.IMathLibRepository;
import rw.ac.rca.gradesclassb.services.impl.MathLibServiceImpl;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class MathLibServiceTest {

    @Mock
    IMathLibRepository mathLibRepository;
    @InjectMocks
    private MathLibServiceImpl mathLibService;

    private MathLib mathLib2;

    private MathLib mathLib1;

    @Test void save_mathLib(){
        mathLib2 = new MathLib(1, 2, 3);
        mathLib2.setSum(5);
        mathLib2.setProduct(6);
        mathLib1 = new MathLib(1,2,3);
        when(mathLibRepository.save(mathLib1)).thenReturn(mathLib2);
        Assert.assertEquals(5, mathLibRepository.save(mathLib1).getSum());
        Assert.assertEquals(90,mathLibRepository.save(mathLib1).getProduct());
        System.out.println(mathLib2.getSum() + " " + mathLibRepository.save(mathLib1).getSum());
    }

    @Test
    void givenZeroAndANumber_whenMultiplied_ReturnZero(){
        mathLib2 = new MathLib(1, 2, 0);
        mathLib2.setSum(2);
        mathLib2.setProduct(0);

        mathLib1 = new MathLib(1,2,0);
        when(mathLibRepository.save(mathLib2)).thenReturn(mathLib1);
        Assert.assertEquals(0,mathLibRepository.save(mathLib2).getProduct());
    }


}
