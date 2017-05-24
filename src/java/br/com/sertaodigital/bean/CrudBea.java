/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sertaodigital.bean;

/**
 *
 * @author kecio
 */
public class CrudBea {

    private String estadoTela = "busca";//inserir, editar e buscar;
    //metodos para controle da tela
    public boolean isInserir(){
        return "inserir".equals(estadoTela);
    }
    public boolean isEditar(){
        return "inserir".equals(estadoTela);
    }
    public boolean isBuscar(){
        return "inserir".equals(estadoTela);
    }
    
    public void mudarParaInserir(){
        estadoTela = "inserir";
    }
    public void mudarParaEditar(){
        estadoTela = "editar";
    }
    public void mudarParaBuscar(){
        estadoTela = "Buscar";
    }
}