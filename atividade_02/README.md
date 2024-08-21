## 💻 Exercício: Leitura e Processamento de Dados de um Arquivo CSV

# Objetivo

1. Ler o arquivo CSV fornecido.
2. Converter cada linha do arquivo em uma instância de uma classe Java estruturada.
3. Calcular a média mensal de visitas para cada local e determinar qual local teve a maior média de visitas ao longo do ano.
Implemente um construtor para inicializar esses atributos..

# Passo 1: Criar a Classe Filial

Primeiro, vamos definir uma classe Filial para representar cada linha do CSV:
- String nome
- String endereco
- String cidade
- String codigoPostal;
- List<Integer> visitasMensais;
- int visitasAnuais;
- String geolocalizacao;

# Passo 2: Ler o Arquivo CSV e Converter para a Classe Filial

Agora vamos criar uma classe para ler o arquivo CSV, converter cada linha em um objeto Filial, e armazená-los em uma lista.

# Passo 3: Encontrar a Filial com a Maior Média de Visitas

Após ler os dados e convertê-los para objetos Filial, o programa calcula a média mensal de visitas para cada filial. Em seguida, ele identifica e exibe a filial que obteve a maior média de visitas ao longo do ano.

