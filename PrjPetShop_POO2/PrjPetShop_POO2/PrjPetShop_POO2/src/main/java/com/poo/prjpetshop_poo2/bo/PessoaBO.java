package com.poo.prjpetshop_poo2.bo;

import com.poo.prjpetshop_poo2.dao.PessoaDAO;
import com.poo.prjpetshop_poo2.objects.Pessoa;
import java.util.List;

/**
 *
 * @author IFTM
 */
public class PessoaBO {
    PessoaDAO pDAO;

    public PessoaBO(){
        pDAO = new PessoaDAO();
    }
    
    public Pessoa salvar(Pessoa p){
        return pDAO.salvar(p);
    }
    public List<Pessoa> getPessoas(){
        return pDAO.getPessoas();
    }
    
    public List<Pessoa> getPessoas(String nome){
        return pDAO.getPessoas(nome);
    }
}
