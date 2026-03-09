package com.poo.prjpetshop_poo2.dao;

import com.poo.prjpetshop_poo2.objects.Pet;
import com.poo.prjpetshop_poo2.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PetDAO {
    Connection conn; 

    public PetDAO() {
        conn = new Conexao().conectar();
    }
    
    public Pet salvar(Pet pet) {
        try{
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO pet(nome,especie,raca, porte, cor, data_nascimento, idpessoa) values(?,?,?,?,?,?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getEspecie());
            stmt.setString(3, pet.getRaca());
            stmt.setString(4, pet.getPorte());
            stmt.setString(5, pet.getCor());
            stmt.setDate(6, Date.valueOf(pet.getData_nascimento()));
            stmt.setObject(7, pet.getIdpessoa());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                pet.setIdpet(rs.getInt("idpet"));
            }
            else{
                pet.setIdpet(-1);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return pet;
    }
}
