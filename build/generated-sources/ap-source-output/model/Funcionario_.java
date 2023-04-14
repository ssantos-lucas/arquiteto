package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Acesso;
import model.Departamento;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-14T11:20:21")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, Departamento> idDepartamento;
    public static volatile SingularAttribute<Funcionario, Double> salarioFuncionario;
    public static volatile SingularAttribute<Funcionario, String> emailFuncionario;
    public static volatile SingularAttribute<Funcionario, Acesso> acesso;
    public static volatile SingularAttribute<Funcionario, String> cargoFuncionario;
    public static volatile SingularAttribute<Funcionario, String> nomeFuncionario;

}