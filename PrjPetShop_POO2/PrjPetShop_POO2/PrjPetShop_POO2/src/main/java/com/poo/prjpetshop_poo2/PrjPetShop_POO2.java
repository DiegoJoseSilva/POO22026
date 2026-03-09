package com.poo.prjpetshop_poo2;

import com.poo.prjpetshop_poo2.dao.PessoaDAO;
import com.poo.prjpetshop_poo2.forms.FormCadastroPessoa;
import com.poo.prjpetshop_poo2.util.Conexao;
import java.sql.SQLException;
import com.poo.prjpetshop_poo2.objects.Pessoa;
import com.poo.prjpetshop_poo2.objects.Pet;

public class PrjPetShop_POO2 {

    public static void main(String[] args){
        Pessoa p = new Pessoa();
        
        p.setNome("Teste 01-2026");
        p.setCpf("12723843943");
        p.setData_nasc("25/03/2000");
        
        Pet pet = new Pet();
        pet.setNome("Ringo");
        pet.setEspecie("Canina");
        pet.setRaca("SRD");
        pet.setPorte("Grande");
        pet.setCor("Branco");
        pet.setData_nascimento("2010- 01- 01");
        pet.setIdpessoa(p); 
        
    }
}
