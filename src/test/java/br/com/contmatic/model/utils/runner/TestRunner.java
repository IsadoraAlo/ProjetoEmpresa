package br.com.contmatic.model.utils.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.model.contato.CelularTest;
import br.com.contmatic.model.contato.ContatoTest;
import br.com.contmatic.model.contato.EmailTest;
import br.com.contmatic.model.contato.TelefoneTest;
import br.com.contmatic.model.empresa.EmpresaTest;
import br.com.contmatic.model.empresa.FuncionarioTest;
import br.com.contmatic.model.empresa.ProdutoTest;
import br.com.contmatic.model.endereco.EnderecoTest;
import br.com.contmatic.model.endereco.MunicipioTest;
import br.com.contmatic.model.endereco.UFTest;

@RunWith(Suite.class)
@SuiteClasses({
  
    // CLASSES DE CONTATO 
    CelularTest.class, ContatoTest.class, EmailTest.class, TelefoneTest.class,
    
    // CLASSES DE EMPRESA
    EmpresaTest.class, FuncionarioTest.class, ProdutoTest.class,
    
    // CLASSES DE ENDEREÇO
    EnderecoTest.class, MunicipioTest.class, UFTest.class,
    
})
public class TestRunner {
    
    public static void main(String[] args) {
        
        Result result = JUnitCore.runClasses(TestRunner.class);
        
        for(Failure fail: result.getFailures()) {
            System.out.print(fail.toString());
        }
        
    }
    
}
