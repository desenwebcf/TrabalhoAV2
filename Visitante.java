
package modelo;




 public class Visitante {
    
    private String nome;
    private String endereco;
    private int cpf;
    private int rg;    
    private int cnh;  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    public void setcpf(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
/**
     * Invoca a classe DAO e incluir um cliente no banco de dados
     * */
public void incluir() {
        VisitanteDAO vdao = VisitanteDAO.getInstance();
        //endereco.incluir();
        vdao.incluir(this);
    }

 
