package br.com.sertaodigital.dao;

import br.com.sertaodigital.entity.Cliente;
import br.com.sertaodigital.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {

    private Session se;
    private Transaction trans;
    //private List<Cliente> list;

    public List<Cliente> getList() {
       Session sessao  = HibernateUtil.getSession().openSession();
        Transaction trans = sessao .beginTransaction();
        
        Criteria cri = sessao .createCriteria(Cliente.class);
        //this.list = cri.list();
        return cri.list();
    }
    
     public List<Cliente> getListJQL(String nome) {
        Session sessao  = HibernateUtil.getSession().openSession();
        //Transaction trans = sessao .beginTransaction();
        Query query = sessao.createQuery("from Cliente where nome LIKE :nome");
        query.setParameter("nome", "%"+nome +"%");
        return query.list();
        //Criteria cri = sessao.createCriteria(Fornecedor.class);
       
        //return cri.list();
    }
    
    
    public void addCliente(Cliente d){
        try {
          //  sessao = HibernateUtil.getSession().getCurrentSession();
          //trans = sessao.beginTransaction();
        
        Cliente cliente = new Cliente();
        cliente.setNome(d.getNome());
        cliente.setCpf(d.getCpf());
        cliente.setDataNascimento(d.getDataNascimento());
        cliente.setEndereco(d.getEndereco());
        
        Session se = HibernateUtil.getSession().openSession();
        Transaction trans = se.beginTransaction();
        se.save(cliente);
        trans.commit();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    public void removeCliente(Cliente c){
         try {
            
       
           Session se = HibernateUtil.getSession().openSession();
        Transaction trans = se.beginTransaction();
        se.delete(c);
       trans.commit();
            
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
           se.close();
        }
    }

    public void salvar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cliente> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
