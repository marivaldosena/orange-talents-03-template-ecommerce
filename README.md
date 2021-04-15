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
