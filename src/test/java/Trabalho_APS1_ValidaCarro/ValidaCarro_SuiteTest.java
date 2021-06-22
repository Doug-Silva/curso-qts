package Trabalho_APS1_ValidaCarro;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ValidaAnoFabricacaoTest.class, ValidaCarroTest.class, ValidaMarcaCarroTest.class,
		ValidaModelCarroTest.class, ValidaPlacaCarroTest.class, ValidaPrecoFabricacaoTest.class })
public class ValidaCarro_SuiteTest {

}
