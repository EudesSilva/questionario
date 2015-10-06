# questionario


BANCO:
O banco usado é o MYSQL.

Primeiro deve ser criado um schema no banco e depois
configurados os dados nas seguintes classes.


No pacote br.com.questionario.tool, na classe HibernateDLLGenerator
configure o usuario e senha do banco de dados, Execute esta classe.

Faça um INSERT manual no banco na tabela USUARIO


EMAIL:
no pacote br.com.questionario.util ,na classe SendMailConfig 
configure manualmente um email e senha , preferência no que foi testado
que o Gmail.
No mesmo pacote na classe SendMailStart configure o seu email de remetente;

OBS::  
Ao fazer os tests é necessário desabilitar o seu antivirus, e seu firewall.
Usando AVAST é gerado um erro .


SERVIDOR :
Utilizado Tomcat 7.0.41  ele tem que ser configurado para a porta 8084


APLICAÇÃO: Para utilizar a aplicação é necessário fazer o login com usuario ( admin ) e senha ( 123 )
Depois Crie um questionário com seu titulo e  suas perguntas.

Depois faça o envio do questionárioque deseja para (apenas 1 email e cada vez).


Acesse o email, e responda e questionário , depois tente responder novamente.



Ends ..
