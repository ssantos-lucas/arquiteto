package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Funcionario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-14T11:20:21")
@StaticMetamodel(Acesso.class)
public class Acesso_ { 

    public static volatile SingularAttribute<Acesso, String> emailFuncionario;
    public static volatile SingularAttribute<Acesso, Funcionario> funcionario;
    public static volatile SingularAttribute<Acesso, String> senhaFuncionario;

}