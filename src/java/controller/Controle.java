package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Acesso;
import model.Departamento;
import model.EmpresaDAO;

@WebServlet(name = "Controle", urlPatterns = {"/Controle"})
public class Controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String flag, mensagem;
        flag = request.getParameter("flag");
        if (flag.equals("login")) {
            String u, s;
            u = request.getParameter("usuario");
            s = request.getParameter("senha");
            EmpresaDAO dao = new EmpresaDAO();
            Acesso acesso = dao.validarLogin(u, s);
            if (acesso == null) {
                request.setAttribute("m", "Usuário");
                RequestDispatcher disp = request.getRequestDispatcher("Mensagens.jsp");
                disp.forward(request, response);
            } else {
                String nome, cargo;
                nome = acesso.getFuncionario().getNomeFuncionario();
                cargo = acesso.getFuncionario().getCargoFuncionario();
                mensagem = "Bem vindo, " + nome + "(" + cargo + ")";
                request.setAttribute("m", mensagem);
                if (cargo.equalsIgnoreCase("Gerente")) {
                    RequestDispatcher disp = request.getRequestDispatcher("AcessoGerente.jsp");
                    disp.forward(request, response);
                } else if (cargo.equalsIgnoreCase("Vendedor")) {
                    RequestDispatcher disp = request.getRequestDispatcher("AcessoVendedor.jsp");
                    disp.forward(request, response);
                } else {
                    RequestDispatcher disp = request.getRequestDispatcher("AcessoOutro.jsp");
                    disp.forward(request, response);
                }
            }
        } else if (flag.equalsIgnoreCase("CadastroDepartamento")) {
            Departamento dep = new Departamento();
            dep.setIdDepartamento(request.getParameter("idDepartamento"));
            dep.setNomeDepartamento(request.getParameter("nomeDepartamento"));
            dep.setFoneDepartamento(request.getParameter("telefoneDepartamento"));

            int resultado = new EmpresaDAO().salvarDepartamento(dep);
            switch (resultado) {
                case 1:
                    mensagem = "Departamento salvo com sucesso";
                    break;
                case 2:
                    mensagem = "Departamento já cadastrado";
                    break;
                default:
                    mensagem = "Erro: Entre em contato com o administrador";
                    break;
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("Mensagens.jsp");
            disp.forward(request, response);

        } else if (flag.equalsIgnoreCase("listarDepartamentos")) {

            List<Departamento> departamentos = new EmpresaDAO().listarDepartamentos();
            request.setAttribute("listaDepartamentos", departamentos);
            RequestDispatcher disp = request.getRequestDispatcher("listarDepartamentos.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("consultarDepartamentos")) {
            //Recebe o nome do departamento digitado do formulário 
            String nomeDep = request.getParameter("nomeDepartamento");
            //Cria-se esse DAO para ter acesso aos metodos da classe empresaDAO
            EmpresaDAO dao = new EmpresaDAO();
            //Chama o metodo consultar departamento passando o nome do departamento e recebe a lista devolvida pelo metodo
            List<Departamento> departamentos = dao.consultarDepartamentos(nomeDep);
            //Enviar a lista de departamentos para o arquivo ListarDepartamentos.jsp
            request.setAttribute("listaDepartamentos", departamentos);
            RequestDispatcher disp = request.getRequestDispatcher("listarDepartamentos.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("excluirDepartamento")) {
            String idDep = request.getParameter("idDep");
            EmpresaDAO dao = new EmpresaDAO();
            int resultado = dao.excluirDepartamento(idDep);
            if (resultado == 1) {
                mensagem = "Departamento excluído com sucesso";
            } else {
                mensagem = "Erro ao tentar excluir o departamento";
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("Mensagens.jsp");
            disp.forward(request, response);

        } else if (flag.equalsIgnoreCase("alterarDepartamento")) {
            String idDep = request.getParameter("idDep");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
