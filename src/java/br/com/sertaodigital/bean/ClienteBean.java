
package br.com.sertaodigital.bean;

import br.com.sertaodigital.entity.Cliente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class ClienteBean {

    private Cliente cliente = new Cliente();
    //private ClienteDao clienteDao = new ClienteDao();
    private List<Cliente> listacliente;
    
            
    public ClienteBean() {
    }
    
    public String adicinoarCliente(){
        
        cliente.setNome(cliente.getNome());
        cliente.setCpf(cliente.getCpf());
        cliente.setDataNascimento(cliente.getDataNascimento());
        cliente.setEndereco(cliente.getEndereco());
        //clienteDao.addCliente(cliente);
        return "index.jsf";
    }
    public String removercliente(){
        //clienteDao.removeCliente(cliente);
        return "Removido com Sucesso!";
    }
  
      public List getListarCliente(){
           Client c= Client.create();
        WebResource wr = c.resource("http://localhost:8080/WS_NetVendas/webresources/NetVEndas/Cliente/list");
        String json = wr.get(String.class);
        
       Gson gson = new Gson();
       return gson.fromJson(json, new TypeToken<List<Cliente>>(){}.getType()); 
        
        
        //listacliente = clienteDao.getList();
        //return this.clienteDao.getList();
    }/*
    public Cliente getListaCliente(String nome){
        Client c= Client.create();
        WebResource wr = c.resource("http://localhost:8080/WS_NetVendas/webresources/NetVEndas/Cliente/list");
        String json = wr.get(String.class);
        
       Gson gson = new Gson();
       return gson.fromJson(json, new TypeToken<List<Cliente>>(){}.getType()); 
        
        
        
        //listacliente = clienteDao.getList();
       // ClienteDao clienteDao = new ClienteDao();
       // List lista = clienteDao.getListJQL(nome);
        
       // return (Cliente) lista.get(0);
    }
*/
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteBean other = (ClienteBean) obj;
        return Objects.equals(this.cliente, other.cliente);
    }
    
}
