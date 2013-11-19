package src;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrabalhoServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Visitante v = new Visitante();
        Carro c = new Carro();
        c.setPlaca(request.getParameter("placa"));
        c.setCor(request.getParameter("cor"));
        c.setModelo(request.getParameter("modelo"));
        c.setFabricante(request.getParameter("fabricante"));
        c.setRenavam(Integer.parseInt(request.getParameter("renavam")));
        v.setNome(request.getParameter("nome"));
        v.setCpf(Integer.parseInt(request.getParameter("cpf")));
        v.setRg(Integer.parseInt(request.getParameter("rg")));
        v.setCnh(Integer.parseInt(request.getParameter("cnh")));
        v.setEndereco(request.getParameter("endereco"));
        VisitanteDAO.inserir(v);
        CarroDao.inserir(c);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("Carro");
            out.println("Placa " + c.getPlaca());
            out.println("Cor " + c.getCor());
            out.println("Modelo " + c.getModelo());
            out.println("Fabricante " + c.getFabricante());
            out.println("Renavam " + c.getRenavam());
            out.println("-----------------------");
            out.println("Visitante");
            out.println("Nome " + v.getNome());
            out.println("CPF " + v.getCpf());
            out.println("RG " + v.getRg());
            out.println("CNH " + v.getCnh());
            out.println("Endereço " + v.getEndereco());
            out.println("</body>");
            out.println("</html>");
    }
}
