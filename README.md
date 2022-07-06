# Java EE 7 com JSF, PrimeFaces e CDI por Thiago Faria
![Capa  do livro](./aux-data/book-1.png)\
Meus apontamentos feitos seguindo o livro com o titulo acima citado.
Neste projecto usei o Jakarta EE 9, preferi usar a última versão logo.\
## Feramentas Usadas

1. IntelliJ IDEA;
2. Jakarta EE 9;
3. Servidor Payara e Glassfish Full;
4. Banco de dados PostgreSQL;
5. Primefaces para a camada de visualização;
6. Gestão de dependencies com a implementação do próprio servidor.

## Notas
1. Imagem com os valores predefinidos possiveis para render e execute de um elemento ajax.
   1. ![Imagem com os valores predefinidos possiveis para render e execute de um elemento ajax.](./aux-data/13_7_palavras_chaves_para_render_e_execute.png)\
2. Ao inicia o servidor Glassfish, certifica-te que no teu domain/config/domain.xml não tem uma tag com  propriedade java-home="xyz", se tiver pode dar algum tipo de conflito.
   1. ![Ficheiro domain.xml](./aux-data/ficheiro-domain.xml.png)
3. Para iniciar a aplicação no servidor Glassfish deves fazer a configuração do datasource no connection pool e do JDBC Resource, veja a imagem abaixo para saber como configurar.
   1. ![Adicionando a lib e acesso a area de criação de datasource - Configuração do datasource glassfish](./aux-data/glassfish-datasource-config.png)
   2. ![Acessando a area de criação de pools - Configuração do datasource glassfish](./aux-data/glassfish-datasource-config-1.png)
   3. ![Definindo os primeiros dados da configuração - Configuração do datasource glassfish](./aux-data/glassfish-datasource-config-2.png)
   4. ![Acessando a area de criação de pools- Configuração do datasource glassfish](./aux-data/glassfish-datasource-config-3.png)
   5. ![Acessando a area de criação de pools- Configuração do datasource glassfish](./aux-data/glassfish-datasource-config-4.png)
   6. ![Acessando a area de criação de pools- Configuração do datasource glassfish](./aux-data/glassfish-datasource-config-5.png)
   
*Após isso guarde as configurações e volte a acessar para pingar e checar se as configurações estão correctas.*\
*by **Edilson Alexandre Cuamba***
