<!-- Badges -->
[orange-talents-badge]: https://img.shields.io/static/v1?label=Zup&message=Orange%20Talents&color=orange
[java-badge]: https://img.shields.io/static/v1?label=Java&message=11&color=orange
[spring-boot-badge]:  https://img.shields.io/static/v1?label=Spring%20Boot&message=2.4&color=orange
[kotlin-badge]:  https://img.shields.io/static/v1?label=Kotlin&message=1.4&color=orange
[micronaut-badge]:  https://img.shields.io/static/v1?label=Micronaut&message=2.3&color=orange

<!-- Imagens -->

<!-- Links -->
[orange-talents-url]: https://www.zup.com.br/orange-talents
[java-url]: https://www.oracle.com/java/
[spring-url]: https://spring.io/
[kotlin-url]: https://kotlinlang.org/
[micronaut-url]: https://micronaut.io/
[projeto-casa-do-codigo-url]: https://github.com/marivaldosena/orange-talents-03-template-casa-do-codigo
[projeto-casa-do-codigo-email-unico-url]: https://github.com/marivaldosena/orange-talents-03-template-casa-do-codigo#implementação-do-cadastro-de-email-único
[mercado-livre-produto-detalhes-url]: https://produto.mercadolivre.com.br/MLB-1279370191-bebedouro-bomba-eletrica-p-garrafo-galo-agua-recarregavel-_JM?variation=48969374724#reco_item_pos=0&reco_backend=navigation&reco_backend_type=function&reco_client=home_navigation-recommendations&reco_id=e55bf74a-9551-42d8-a43d-fb64fa3117d4&c_id=/home/navigation-recommendations/element&c_element_order=1&c_uid=761d5d17-5baf-4fd8-be79-fc65ee66a6fb
[hibernate-interceptadores-e-eventos-url]: https://docs.jboss.org/hibernate/stable/orm/userguide/html_single/Hibernate_User_Guide.html#events
[blog-domine-o-spring-url]: https://domineospring.wordpress.com/2015/06/08/lidando-com-eventos-dentro-do-spring/
[blog-baeldung-url]: https://www.baeldung.com/spring-events
[blog-reflactoring-url]: https://reflectoring.io/spring-boot-application-events-explained/#:~:text=Spring%20application%20events%20allow%20us%20to%20throw%20and,modify%20subscribers%20without%20affecting%20the%20publishers%20and%20vice-versa
[spring-doc-eventos-url]: https://docs.spring.io/spring-integration/reference/html/event.html
[mercado-livre-produto-detalhes-variacao-url]: https://produto.mercadolivre.com.br/MLB-1279370191-bebedouro-bomba-eletrica-p-garrafo-galo-agua-recarregavel-_JM?quantity=1&variation=49037204722&onAttributesExp=true

<!-- Conteúdo -->
# Zup Orange Talents | Desafio Mercado Livre

[![Zup Orange Talents][orange-talents-badge]][orange-talents-url]
[![Java][java-badge]][java-url]
[![Spring][spring-boot-badge]][spring-url]
[![Kotlin][kotlin-badge]][kotlin-url]
[![Micronaut][micronaut-badge]][micronaut-url]

O Zup Orange Talents é um programa da Zup para suprir a escassez de profissionais do ramo de Tecnologia da Informação.

# Tópicos

- [Tópicos](#tópicos)
- [Grade Curricular](#grade-curricular)
- [Desafio Mercado Livre](#desafio-mercado-livre)
- [Atividades](#atividades)
- [Outros Projetos Relacionados](#outros-projetos-relacionados)
  - [Cadastro de novo usuário](#cadastro-de-novo-usuário)
    - [Implementação de Cadastro de novo usuário](#implementação-de-cadastro-de-novo-usuário)
    - [Alterações de Cadastro de novo usuário](#[alterações-de-cadastro-de-novo-usuário)
  - [Email único](#email-único)
    - [Implementação de Email único](#implementação-de-email-único)
  - [Cadastro de categorias](#cadastro-de-categorias)
    - [Implementação de Cadastro de categorias](#implementação-de-cadastro-de-categorias)
  - [Autenticação de usuário](#autenticação-de-usuário)
    - [Implementação de Autenticação de usuário](#implementação-de-autenticação-de-usuário)
  - [Usuário logado cadastra novo produto](#usuário-logado-cadastra-novo-produto)
    - [Implementação de Usuário logado cadastra novo produto](#implementação-de-usuário-logado-cadastra-novo-produto)
    - [Alterações de Usuário logado cadastra novo produto](#alterações-de-usuário-logado-cadastra-novo-produto)
  - [Usuário logado adiciona imagem no seu produto](#usuário-logado-adiciona-imagem-no-seu-produto)
    - [Implementação de Usuário logado adiciona imagem no seu produto](#implementação-de-usuário-logado-adiciona-imagem-no-seu-produto)
  - [Adicione uma opinião sobre um produto](#adicione-uma-opinião-sobre-um-produto)
    - [Implementação de Adicione uma opinião sobre um produto](#implementação-de-adicione-uma-opinião-sobre-um-produto)
  - [Faça uma pergunta](#faça-uma-pergunta)
    - [Implementação de Faça uma pergunta](#implementação-de-faça-uma-pergunta)
    - [Sugestões a respeito de Faça uma pergunta](#sugestões-a-respeito-de-faça-uma-pergunta)
  - [Página de detalhes](#página-de-detalhes)
    - [Implementação de Página de detalhes
](#implementação-de-página-de-detalhes
)
  - [Primeira parte do processo de compras](#primeira-parte-do-processo-de-compras)
    - [Implementação de Primeira parte do processo de compras](#implementação-de-primeira-parte-do-processo-de-compras)
  - [Segunda parte do processo de compras](#segunda-parte-do-processo-de-compras)
    - [Implementação de Segunda parte do processo de compras](#implementação-de-segunda-parte-do-processo-de-compras)
  
# Grade Curricular

Serão abordados os seguintes temas:

- Java
- Spring Boot
- Kotlin
- Micronaut
- Microsserviços
- Testes Unitários
- DevOps
- Entre outros

[Voltar ao menu](#tópicos)

# Outros Projetos Relacionados

Antes desse desafio, tivemos que implementar um referente à Casa do Codigo.

Para visualizá-lo, clique em [Desafio Casa do Código][projeto-casa-do-codigo-url].

[Voltar ao menu](#tópicos)

# Desafio Mercado Livre

Este primeiro desafio é uma forma de pôr em prática os conceitos 
ensinados ao longo das primeiras semanas.

# Atividades

Ao longo deste projeto, será necessária a realização de algumas atividades para atestar o conhecimento adquirido. As atividades devem ser resolvidas estritamente de acordo com o enunciado.

[Voltar ao menu](#tópicos)

## Cadastro de novo usuário

Precisamos saber o instante do cadastro, login e senha.

### Restrições

- <span style="color: green;">&check;</span> O instante não pode ser nulo e não pode ser no futuro
- <span style="color: green;">&check;</span> O login não pode ser em branco ou nula
- <span style="color: green;">&check;</span> O login precisa ter o formato do email
- <span style="color: green;">&check;</span> A senha não pode ser branca ou nula
- <span style="color: green;">&check;</span> A senha precisa ter no mínimo 6 caracteres
- <span style="color: green;">&check;</span> A senha deve ser guardada usando algum algoritmo de hash da sua escolha.

### Resultado esperado

- <span style="color: green;">&check;</span> O usuário precisa estar criado no sistema
- <span style="color: green;">&check;</span> O cliente que fez a requisição precisa saber que o usuário foi criado. Apenas um retorno com status 200 está suficente.
- <span style="color: green;">&check;</span> Em caso de falha de validação status 400

[Voltar ao menu](#tópicos)

### Implementação de Cadastro de novo usuário

Para o cadastro de novo usuário, é necessário criar uma entidade específica para armazenar os dados. Esta entidade conterá email, senha, e data de criação. O campo de criação deve ser anotado com <code>@CreationTimestamp</code> para persistir a data e horário de criação. O atributo para e-mail deve ser anotado com <code>@Column(nullable = false, unique)</code> para que seja obrigatório e único. No caso de senha, a anotação é <code>@Column(nullable = false)</code> para informar a sua obrigatoriedade.

**Observação:** *a senha nunca pode ser armazenada como texto simples, já que isso pode facilitar a exposição de dados sensíveis dos clientes. Por este motivo, é interessante usar mecanismos de encriptação com algoritmos do tipo BCrypt ou equivalente, hashing, salting, entre outros. Outro ponto que pode ser interessante é a utilização de tokens de autenticação do tipo JWT para verificar se as credenciais de acesso são válidas.*

Para a validação na fronteira de entrada de dados, é interessante usar um Form Value Object. Deve haver um atributo para e-mail com anotação <code>@Email</code> para informar que deve ser um formato de e-mail válido, <code>@NotNull</code> para torná-lo obrigatório e uma outra anotação para verificar se o campo é único. Para senha, as anotações devem ser <code>@Size(min = 6)</code> para informar que a senha deve conter mais de 6 caracteres e <code>@NotNull</code> para informar que este campo não pode ser nulo.

Para a persistência de dados propriamente dita, é necessária a criação de um repositório. Para comunicação entre cliente e servidor, é obrigatório o uso de controlador com endpoint que aceita requisições do tipo POST.

Para a informar que o cadastro teve êxito, é importante usar um DTO para apresentar os dados relevantes ao cliente, isto é, que não sejam sensíveis.

[Voltar ao menu](#tópicos)

### Alterações de Cadastro de novo usuário

Durante a implementação, tive algumas ideias que decidi implementar. Uma delas foi o uso de Tokens de Acesso usando o JWT. Para tanto, decidi criar uma classe para gerenciar usuários, fazer a encriptação e verificação de senhas, geração de tokens e persistência de usuários.

Adotei essa abordagem para concentrar funções semelhantes e relacionadas a todos os usuários. No entanto, usei a composição de classes, isto é, usar uma instância do gerenciador na entidade de usuário para o possamos fazer chamadas também por usuário sem nos preocuparmos como ele o faz.

[Voltar ao menu](#tópicos)

## Email único

Não podemos ter dois usuários com o mesmo email.

### Restrições

Só pode existir um usuário com o mesmo email.

### Resultado esperado

- <span style="color: green;">&check;</span> Status 400 informando que não foi possível realizar um cadastro com este email.

[Voltar ao menu](#tópicos)

### Implementação de Email único

Criaria um Constraint e um Validator para verificar a unicidade de e-mail e anotaria o atributo email do Form Value Object com esse Constraint.

Vide [Implementação do Cadastro de email único][projeto-casa-do-codigo-email-unico-url].

[Voltar ao menu](#tópicos)

## Cadastro de categorias

No mercado livre você pode criar hierarquias de categorias livres. Ex: Tecnologia -> Celulares -> Smartphones -> Android,Ios etc. Perceba que o sistema precisa ser flexível o suficiente para que essas sequências sejam criadas.

- <span style="color: green;">&check;</span> Toda categoria tem um nome
- <span style="color: green;">&check;</span> A categoria pode ter uma categoria mãe

### Restrições

- <span style="color: green;">&check;</span> O nome da categoria é obrigatório
- <span style="color: green;">&check;</span> O nome da categoria precisa ser único

### Resultado esperado

- <span style="color: green;">&check;</span> categoria criada e status 200 retornado pelo endpoint.
- <span style="color: green;">&check;</span> caso exista erros de validação, o endpoint deve retornar 400 e o json dos erros.

[Voltar ao menu](#tópicos)

## Implementação de Cadastro de categorias

Para o cadastro de categoria, acredito que seja necessário a criação de uma entidade com os seguintes campos:

- nome do tipo String contendo o nome da categoria e cuja anotação é <code>@Column(nullable = false)</code>.
- mae do tipo Categoria cujas anotações são: <code>@OneToOne</code> para informar que a categoria deve pertencer a, no máximo, uma outra categoria e <code>@JoinColumn</code> para informar o nome da coluna e se o atributo é obrigatório.
- filhas do tipo Set<Categoria> para informar que as categorias podem conter outras e que estas devem ser únicas. A anotação que utilizaria aqui é <code>@OneToMany(mappedBy = "mae")</code> para designar o tipo de relacionamento com suas respectivas filhas e como acessar a categoria mãe.

Para a criação de categoria, iremos seguir a notória receita de:

|Componente|Descrição|
|-|-|
|Controlador|Serve para a entrada de dados|
|Form Value Object| Para validação e consistência de dados|
|Repositório| Persistência de dados e gerenciamento de entidades|
|Entidade|Estrutura e persistência de dados|
|DTO|Comunicação entre camadas e resposta da requisição|

[Voltar ao menu](#tópicos)

## Autenticação de usuário

Você precisa configurar um mecanismo de autenticação via token, provavelmente com o Spring Security, para permitir a autenticação.

[Voltar ao menu](#tópicos)

### Implementação de Autenticação de usuário

Para configurar autenticação de usuário na aplicação, é importante criar alguns elementos necessários.

O primeiro passo é criar uma classe que herde de <code>WebSecurityConfigurerAdapter</code> com duas anotações: <code>@Configuration</code> para informar que é uma configuração gerenciada pelo Spring e <code>@EnableWebSecurity</code> para informar que a segurança da aplicação será habilitada e seguirá as configurações definidas.

A classe que herda de <code>WebSecurityConfigurerAdapter</code> deverá sobrescrever o método cuja assinatura é <code>AuthenticationManager authenticationManager() throws Exception</code> e deverá conter a anotação <code>@Bean</code> para informar ao Spring que ele deverá gerenciá-lo como um Java Bean.

Além desse método, o <code>void configure(AuthenticationManagerBuilder auth) throws Exception</code> também deverá ser sobrescrito para que o Spring saiba qual classe será responsável por verificar a existência de usuários autenticados e como obter os dados necessários. Além disso, é possível escolher o padrão de Hashing com este método.

Outro método relevante que deve ser sobrescrito é o <code>void configure(HttpSecurity http) throws Exception</code> para configurar quais serão os endpoints permitidos sem a necessidade de autenticação, qual a classe responsável pelo gerenciamento de tokens de acesso, o tipo de política de sessão, entre outros.

A classe responsável por gerenciar os tokens de acesso deve herdar de <code>OncePerRequestFilter</code> para que o sistema faça somente uma verificação de token por requisição. Para verificar se o token é válido, devemos sobrescrever o método <code>void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException</code>.

Para gerenciar usuários, é necessário utilizar uma classe que implemente a interface <code>UserDetailsService</code>. Esta interface possui um método com a assinatura <code>UserDetails loadUserByUsername(String username) throws UsernameNotFoundException</code>. É neste método que devemos fazer a verificação de existência de usuário.

A classe que herda de <code>UserDetailsService</code> trabalha apenas com a interface <code>UserDetails</code>, ou seja, ela não sabe como são os detalhes de usuário além dos definidos por esta interface. Dessa forma, podemos ter duas abordagens: uma classe que contenha todos os dados necessários ao nosso usuário ou uma classe à parte responsável que implemente apenas os detalhes de autenticação.

Na primeira abordagem teremos uma classe extensa com diversos métodos obrigatórios devido a esta interface. Na segunda, teremos duas classes menores com responsabilidades distintas, ou seja, podemos alterar detalhes de implementação sem nos afetar o usuário e podemos acrescentar mais dados ao usuário sem afetar a autenticação mantendo ambas classes coesas e especializadas em suas respectivas funções.

[Voltar ao menu](#tópicos)

## Usuário logado cadastra novo produto

Aqui a gente vai permitir o cadastro de um produto por usuário logado.

### Necessidades

- <span style="color: green;">&check;</span> Tem um nome
- <span style="color: green;">&check;</span> Tem um valor
- <span style="color: green;">&check;</span> Tem quantidade disponível
- <span style="color: green;">&check;</span> Características(cada produto pode ter um conjunto de características diferente). [Da uma olhada na parte de outras características nos detalhes de produtos do Mercado Livre][mercado-livre-produto-detalhes-url]. Cada característica tem um nome e uma descricao associada.
- <span style="color: green;">&check;</span> Tem uma descrição
- <span style="color: green;">&check;</span> Pertence a uma categoria
- <span style="color: green;">&check;</span> Instante de cadastro

### Restrições

- <span style="color: green;">&check;</span> Nome é obrigatório
- <span style="color: green;">&check;</span> Valor é obrigatório e maior que zero
- <span style="color: green;">&check;</span> Quantidade é obrigatório e >= 0
- <span style="color: green;">&check;</span> O produto possui pelo menos três características
- <span style="color: green;">&check;</span> Descrição é obrigatória e tem máximo de 1000 caracteres.
- <span style="color: green;">&check;</span> A categoria é obrigatória

### Resultado esperado

- <span style="color: green;">&check;</span> Um novo produto criado e status 200 retornado
- <span style="color: green;">&check;</span> Caso dê erro de validação retorne 400 e o json dos erros

[Voltar ao menu](#tópicos)

### Implementação de Usuário logado cadastra novo produto

Para o cadastro de produtos, utilizaria uma entidade Produto que teria os seguintes campos:

- nome do tipo String com anotação <code>@Column(nullable = false)</code> para torná-lo obrigatório.

- valor do tipo BigDecimal com anotação <code>@Column(nullable = false)</code> para informar sua obrigatoriedade e <code>@Min(0.01)</code> para informar que deve ser um valor positivo e de, ao menos, um centavo.

- quantidade do tipo Integer com anotação <code>@Column(nullable = false)</code> para torná-lo obrigatório e <code>@Min(0)</code> para informar que deve ser maior ou igual a zero.

- caracteristicas do tipo Set&lt;CaracteristicasDeProduto&gt; com anotação <code>@ManyToMany</code> para relacionamento muitos-para-muitos, já que um produto pode ter diversas características e uma característica pode estar presente em diversos produtos. Para atender ao requisito de, ao menos, três características de produtos, será necessário usar um ConstraintValidator para impor esta regra. Usando um Set nos ajuda a evitar características repetidas.

- descricao do tipo String com anotação <code>@Column(nullable = false, length = 1000)</code> para informar que é obrigatório e deve conter, no máximo, mil caracteres.

- categoria do tipo Categoria com anotação <code>@ManyToOne</code> e <code>@JoinColumn(name = "categoria_id")</code> para informar que todo produto deve pertencer a apenas uma categoria e que uma categoria pode possuir diversos produtos e cujo identificador será armazenado na coluna categoria_id.

- dataDoCadastro do tipo LocalDateTime com anotação <code>@CreationTimestamp</code> para armazenar o instante de cadastro do produto e <code>@Column(name = "data_cadastro")</code> para definir o nome da coluna como data_cadastro.

Além dessa entidade, é necessário criar outra para características de produto. Para tanto, utilizaria os seguintes atributos:

- nome do tipo String com anotação <code>@Column(nullable = false)</code> para torná-lo obrigatório.
- descricao do tipo String com anotação <code>@Column(nullable = false, length = 1000)</code> para impor as mesmas restrições do atributo homônimo da entidade Produto.

Criaria um Form Value Object para validar produto e característica, repositórios de persistência de dados para ambos e controladores seguindo o padrão já acordado, vide [Casa do Código][projeto-casa-do-codigo-url].

[Voltar ao menu](#tópicos)

### Alterações de Usuário logado cadastra novo produto

Para a validação de características de produtos não foi necessário a criação de ValidatorConstraint, apenas o uso de @UniqueElements com sobrescrita os de equals e hashCode para impedir elementos com o mesmo nome no mesmo produto.

No entanto, produtos distintos podem ter os mesmos atributos e descrição. Portanto, é interessante realizar a busca destes produtos ao invés de criar produtos novos.

[Voltar ao menu](#tópicos)

## Usuário logado adiciona imagem no seu produto

Com um produto cadastrado, um usuário logado pode adicionar imagens ao seu produto. Não precisa salvar a imagem em algum cloud ou no próprio sistema de arquivos. Cada arquivo de imagem pode virar um link ficticio que pode ser adicionado ao produto.

### Necessidades

- <span style="color: green;">&check;</span> Adicionar uma ou mais imagens a um determinado produto do próprio usuário

### Restrições

- <span style="color: green;">&check;</span> Tem uma ou mais fotos
- <span style="color: green;">&check;</span> Só pode adicionar fotos ao produto que pertence ao próprio usuário

### Resultado esperado

- <span style="color: green;">&check;</span> Imagens adicionadas e 200 como retorno
- <span style="color: green;">&check;</span> Caso dê erro de validação retorne 400 e o json dos erros
- <span style="color: green;">&check;</span> Caso tente adicionar imagens a um produto que não é seu retorne 403.

[Voltar ao menu](#tópicos)

### Implementação de Usuário logado adiciona imagem no seu produto

Para armazenar imagens, é preciso criar uma entidade para armazenar uma lista de objetos a serem tradados pelo servidor. Esta entidade deve conter o nome do arquivo e o local de armazenamento.

Para o armazenamento propriamente dito, no lado cliente, precisamos enviar o arquivo por intermédio de um formulário do tipo Multipart e, no lado servidor, precisamos obter os bytes do arquivo e escrevê-lo em disco ou outro meio de armazenamento, sendo o AWS S3 (ou similar) uma opção viável.

[Voltar ao menu](#tópicos)

## Adicione uma opinião sobre um produto

Um usuário logado pode opinar sobre um produto. Claro que o melhor era que isso só pudesse ser feito depois da compra, mas podemos lidar com isso depois.

### Necessidades

- <span style="color: green;">&check;</span> Tem uma nota que vai de 1 a 5
- <span style="color: green;">&check;</span> Tem um título. Ex: espetacular, horrível...
- <span style="color: green;">&check;</span> Tem uma descrição
- <span style="color: green;">&check;</span> O usuário logado que fez a pergunta (aqui pode usar usar o approach de definir um usuário na primeira linha do controller e depois trabalhar com o logado de verdade)
- <span style="color: green;">&check;</span> O produto que para o qual a pergunta foi direcionada

### Restrições

- <span style="color: green;">&check;</span> A restrição óbvia é que a nota é no mínimo 1 e no máximo 5
- <span style="color: green;">&check;</span> Título é obrigatório
- <span style="color: green;">&check;</span> Descrição é obrigatório e tem no máximo 500 caracteres
- <span style="color: green;">&check;</span> Usuário é obrigatório
- <span style="color: green;">&check;</span> O produto relacionado é obrigatório

### Resultado esperado

- <span style="color: green;">&check;</span> Uma nova opinião é criada e status 200 é retornado
- <span style="color: green;">&check;</span> Em caso de erro de validação, retorne 400 e o json com erros.

[Voltar ao menu](#tópicos)

### Implementação de Adicione uma opinião sobre um produto

Para cadastrar a opinião do usuário a respeito de um produto, é necessário criar uma entidade para abstrair os detalhes de opinião.

Esta entidade deve ter atributos para encapsular a nota que varia de 1 a 5, título, descrição e o usuário autenticado.

A anotação para restrição de intervalo de notas é <code>@Size(min = 1, max = 5)</code>. Para obrigatoriedade de campos é <code>@Column(nullable = false)</code> para a entidade e <code>@NotNull</code> para o Form Value Object. Referente ao tamanho máximo de caracteres, podemos usar <code>@Size(max = 500)</code> para o Form Value e <code>@Column(length = 500)</code> para a entidade.

Para obter as credenciais de usuário autenticado, devemos usar a anotação <code>@AuthenticationPrincipal</code> UserCredentials, pois a entidade UserCredentails implementa a interface UserDetails necessária para o usuário vigente.

[Voltar ao menu](#tópicos)

## Faça uma pergunta

Um usuário logado pode fazer uma pergunta sobre o produto

### Necessidades

- <span style="color: green;">&check;</span> A pergunta tem um título
- <span style="color: green;">&check;</span> Tem instante de criação
- <span style="color: green;">&check;</span> O usuário que fez a pergunta
- <span style="color: green;">&check;</span> O produto relacionado a pergunta
- <span style="color: green;">&check;</span> O vendedor recebe um email com a pergunta nova
- <span style="color: green;">&check;</span> O email não precisa ser de verdade. Pode ser apenas um print no console do servidor com o corpo.

### Restrições

- <span style="color: green;">&check;</span> O título é obrigatório
- <span style="color: green;">&check;</span> O produto é obrigatório
- <span style="color: green;">&check;</span> O usuário é obrigatório

### Resultado esperado

- <span style="color: green;">&check;</span> Uma nova pergunta é criada e é retornada. Status 200
- <span style="color: green;">&check;</span> Em caso de erro de validação, retorne 400 e o json com erros.

[Voltar ao menu](#tópicos)

### Implementação de Faça uma pergunta

Para permitir que um usuário questione sobre mais detalhes a respeito de um produto, é necessário criar uma entidade para conter todos os questionamentos e outra para as respostas desse questionamento.

Como são dois usuários, sendo um o anunciante do produto e o outro o comprador em potencial, será necessário trabalhar com autorização para impedir que o anunciante faça uma pergunta a respeito do próprio produto e, no caso do comprador em potencial, impedir que responda a questionamentos a respeito de um produto o qual não é o anunciante.

A entidade para questionamentos deve conter:

- título obrigatório do tipo String
- instante de criação do tipo LocalDateTime
- referência ao questionante do tipo String para UUID
- referência ao produto do tipo String para UUID

As anotações para obrigatoriedade são: <code>@NotNull</code> no Form Value Object e <code>@Column(nullable = false)</code> para a entidade.
Para o instante de criação é <code>@CreationTimestamp</code>.

O relacionamento entre a entidade de questionamento e produtos e/ou usuários deve ser do tipo muitos-para-um, ou seja, um usuário pode fazer diversas perguntas a respeito de um produto e um produto pode ter muitos questionamentos. Aqui é importante notar que um usuário pode questionar mais de uma vez a respeito de um produto, no entanto, esse questionamento não deve conter o mesmo título para caracterizá-lo como novo.

As anotações usadas para os relacionamentos são: na entidade para questionamentos, <code>@ManyToOne</code> nos atributos de produto e usuário e, nas entidades produto e usuário, <code>@OneToMany</code> para o atributo do tipo lista de questionamentos.

Acredito que seja interessante criar uma interface para abstrair os detalhes de implementação do envio de e-mail. Dessa forma, será mais fácil mudar a implementação ou testá-la com objetos do tipo Mock.

Outro ponto que é interessante abordar é a utilização de interceptadores e eventos do Hibernate. Com a utilização deles é possível enviar o e-mail somente após a operação  de persistência de dados ter obtido êxito. Caso contrário, o e-mail não será enviado.

Dessa forma, conseguimos desacoplar a entidade de questionamentos do envio de e-mail por intermédio de delegação, ou seja, usamos a associação de objetos do tipo agregação para encapsular os detalhes de envio. No entanto, o ponto negativo será o aumento de complexidade de código.

Para obter mais informações a respeito de interceptadores e eventos, sugiro ir em [Interceptadores e Eventos do Hibernate][hibernate-interceptadores-e-eventos-url].

Para entidade de respostas, é necessário termos uma referência ao questionamento e outro atributo para a resposta propriamente dita.

Devemos criar dois repositórios: uma para questionamentos e outro para repostas. Dois controladores para lidar com as requisições de ambos.

[Voltar ao menu](#tópicos)


### Sugestões a respeito de Faça uma pergunta

Durante o desenvolvimento, tive algumas ideias a respeito de implementação e optei pelo uso da anotação <code>@PostPersist</code> para que, assim que a pergunta fosse persistida em banco de dados, o e-mail seja enviado. No entanto, essa solução possui alto acomplamento, já que a implementação está na própria entidade de perguntas.

Há outras alternativas mais elegantes para este problema. Um deles é permitir que o uso de Injeção de Dependência por intermédio de <code>@Component</code> e <code>@Primary</code>. Além dessa, há o uso de uma classe específica no Spring: a ApplicationEvent. Outra possível é a anotação <code>@EventListener</code>.

Para obter mais detalhes e inspiração das alternativas possíveis, você pode consultar os seguintes links: [Lidando com eventos dentro do Spring][blog-domine-o-spring-url], [Spring Events][blog-baeldung-url], [Spring Boot Application Events Explained][blog-reflactoring-url] e, por último e não menos importante, [a documentação oficial do Spring][spring-doc-eventos-url].

[Voltar ao menu](#tópicos)

## Página de detalhes

O front precisa montar essa página do [Mercado Livre][mercado-livre-produto-detalhes-variacao-url].

Não temos todas as informações, mas já temos bastante coisa. Faça, do jeito que achar melhor o código necessário para que o endpoint retorne as informações para que o front monte a página.

### Informações que já temos como retornar

- <span style="color: green;">&check;</span> Links para imagens
- <span style="color: green;">&check;</span> Nome do produto
- <span style="color: green;">&check;</span> Preço do produto
- <span style="color: green;">&check;</span> Características do produto
- <span style="color: green;">&check;</span> Des​crição do produto
- <span style="color: green;">&check;</span> Média de notas do produto
- <span style="color: green;">&check;</span> Número total de notas do produto
- <span style="color: green;">&check;</span> Opiniões sobre o produto
- <span style="color: green;">&check;</span> Perguntas para aquele produto

[Voltar ao menu](#tópicos)

### Implementação de Página de detalhes

Criaria um DTO para disponibilizar as informações solicitadas e um endpoint que poderia ser no mesmo controlador de cadastro de produto.

[Voltar ao menu](#tópicos)

## Primeira parte do processo de compras

Aqui a gente vai simular uma integração com um gateway como paypal, pagseguro etc. O fluxo geralmente é o seguinte:

- O sistema registra uma nova compra e gera um identificador de compra que pode ser passado como argumento para o gateway.
- O cliente efetua o pagamento no gateway
- O gateway invoca uma url do sistema passando o identificador de compra do próprio sistema e as informações relativas a transação em si.

Então essa é a parte 1 do processo de finalização de compra. Onde apenas geramos a compra no sistema. Não precisamos da noção de um carrinho compra. Apenas temos o usuário logado comprando um produto.

### Necessidades

- A pessoa pode escolher a quantidade de itens daquele produto que ela quer comprar
- O estoque do produto é abatido 
- Um email é enviado para a pessoa que é dona(o) do produto informando que um usuário realmente disse que queria comprar seu produto.
- Uma compra é gerada informando o status INICIADA e com as seguintes informações:
  - gateway escolhido para pagamento
  - produto escolhido
  - quantidade
  - comprador(a)
  - Valor do produto naquele momento
- Suponha que o cliente pode escolher entre pagar com o Paypal ou Pagseguro.

### Restrições

- A quantidade é obrigatória
- A quantidade é positiva
- Precisa ter estoque para realizar a compra

### Resultado esperado

- Caso a pessoa escolha o paypal seu endpoint deve gerar o seguinte redirect(302):
  - Retorne o endereço da seguinte maneira: <code>paypal.com?buyerId={idGeradoDaCompra}&redirectUrl={urlRetornoAppPosPagamento}</code>
- Caso a pessoa escolha o pagseguro o seu endpoint deve gerar o seguinte redirect(302):
  - Retorne o endereço da seguinte maneira: </code>pagseguro.com?returnId={idGeradoDaCompra}&redirectUrl={urlRetornoAppPosPagamento}</code>
- Caso aconteça alguma restrição retorne um status 400 informando os problemas. 

[Voltar ao menu](#tópicos)

### Implementação de Primeira parte do processo de compras

Para a atividade de compra de produtos, devemos criar uma entidade para armazenar os dados.

A entidade de compra deve conter os seguintes atributos:

- produto para fazer referência ao produto adquirido. Também podemos usar uma lista de produtos para referenciar vários adquiridos na mesma compra. Como o enunciado não especifica qual é a forma pretendida de modo explícito, manterei como único neste momento, pois é o que inferi pelo quarto item da seção Necessidades.
- status do tipo StatusProdutoEnum para armazenar o status da compra. Os status podem ser iniciada, finalizada ou cancelada. É possível ter outros tipos de status, tais como: pendente de pagamento, produtos indisponíveis, pendente de entrega, entre outros. No entanto, está mais relacionada ao status de entrega de produto e, acredito eu, que os status aqui definidos devem estar relacionados ao status de pagamento.
- gateway de pagamento, ou seja, qual foi o serviço de pagamento utilizado. Neste caso, usamos apenas o PayPal e o PagSeguro.

Há algumas coisas que podemos fazer para ampliar este exercício e o torná-lo mais real, tal como inserir o conceito de estoque como entidade separada para acompanhar a evolução e o histórico de entrada e saída de produtos. No entanto, aumentará a complexidade além de não estar no escopo da atividade.

Para fazer requisições a serviços externos, teremos que utilizar o Feign, pois é uma das dependências obrigatórias do projeto.

[Voltar ao menu](#tópicos)

## Segunda parte do processo de compras

Aqui estamos lidando com o retorno do gateway de pagamento.

### Necessidades

O meio de pagamento(pagseguro ou paypal) redireciona para a aplicação passando no mínimo 3 argumentos:

- id da compra no sistema de origem
- id do pagamento na plataforma escolhida
- status da compra. Para o status vamos assumir os dois básicos(Sucesso, Falha). Os gateways de pagamento informam isso de maneira distinta.
- Paypal retorna o número 1 para sucesso e o número 0 para erro.
- Pagseguro retorna a string SUCESSO ou ERRO.

Temos alguns passos aqui.

- Precisamos registrar a tentativa de pagamento com todas as informações envolvidas. Além das citadas, é necessário registrar o exato instante do processamento do retorno do pagamento.
- Caso a compra tenha sido concluída com sucesso:
  - precisamos nos comunicar com o setor de nota fiscal que é um outro sistema. Ele precisa receber apenas receber o id da compra e o id do usuário que fez a compra.
  - Neste momento você não precisa criar outro projeto para simular isso. Crie um controller com um endpoint fake e faça uma chamada local mesmo.
  - Também precisamos nos comunicar com o sistema de ranking dos vendedores. Esse sistema recebe o id da compra e o id do vendedor.
  - Neste momento você não precisa criar outro projeto para simular isso. Faça uma chamada local mesmo.
- Para fechar precisamos mandar um email para quem comprou avisando da conclusão com sucesso. Pode colocar o máximo de informações da compra que puder.
- Caso a compra não tenha sido concluída com sucesso, precisamos:
  - enviar um email para o usuário informando que o pagamento falhou com o link para que a pessoa possa tentar de novo.

### Restrição

- Id de compra, id de transação e status são obrigatórios para todas urls de retorno de dentro da aplicação.
- O id de uma transação que vem de alguma plataforma de pagamento só pode ser processado com sucesso uma vez.
- Uma transação que foi concluída com sucesso não pode ter seu status alterado para qualquer coisa outra coisa.
- Uma compra não pode ter mais de duas transações concluídas com sucesso associada a ela.

### Resultado esperado

- Status 200 dizendo retornando o status do pagamento.
- Em caso de erro de validação, retorne 400 e o json com erros.

[Voltar ao menu](#tópicos)

### Implementação de Segunda parte do processo de compras

Para esta atividade eu criaria alguns atributos na entidade de compras, entre eles o identificador de meio de  pagamento e o momento da execução. É possível criar uma entidade apenas para armazenar os dados referentes ao pagamento, mas acredito ser desnecessário neste exercício.

Utilizaria eventos do Spring para comunicar com os sistemas de Notas Fiscais e de Classificação de Vendedores.
O mesmo vale para comunicar se ao comprador se houve sucesso ou falha na compra.

[Voltar ao menu](#tópicos)
