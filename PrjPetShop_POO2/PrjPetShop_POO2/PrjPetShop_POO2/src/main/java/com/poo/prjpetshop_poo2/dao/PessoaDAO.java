package com.poo.prjpetshop_poo2.dao;

import com.poo.prjpetshop_poo2.objects.Pessoa;
import com.poo.prjpetshop_poo2.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory.Result;


public class PessoaDAO {
    private Connection conn;
    
    public PessoaDAO(){
        conn = new Conexao().conectar();
    }
    public Pessoa salvar(Pessoa p) {
        try{
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO pessoa(nome, cpf, data_nascimento) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setDate(3, Date.valueOf(p.getData_nasc()));
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                p.setIdpessoa(rs.getInt("idpessoa"));
            }
            else{
                p.setIdpessoa(-1);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return p;
    }
    
    public List<Pessoa> getPessoas(){
        List<Pessoa> lstP = new ArrayList<>();
        ResultSet rs;
        
        try{
            PreparedStatement ppStmt = conn.prepareStatement("SELECT * FROM pessoa");
            rs = ppStmt.executeQuery();
            while(rs.next()){
                lstP.add(getPessoa(rs));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return lstP;
    }
    
    private Pessoa getPessoa(ResultSet rs) throws SQLException{
        Pessoa p = new Pessoa();
        
        p.setIdpessoa(rs.getInt("idpessoa"));
        p.setNome(rs.getString("nome"));
        p.setCpf(rs.getString("cpf"));
        p.setData_nasc(rs.getString("data_nascimento"));
        
        return p;
    }
    
    public List<Pessoa> getPessoas(String nome){
        List<Pessoa> lstP = new ArrayList<>();
        ResultSet rs;
        
        try{
            PreparedStatement ppStmt = conn.prepareStatement("SELECT * FROM pessoa WHERE nome ILIKE ?");
            ppStmt.setString(1,nome+"%");
            rs = ppStmt.executeQuery();
            while(rs.next()){
                lstP.add(getPessoa(rs));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return lstP;
    }
}
