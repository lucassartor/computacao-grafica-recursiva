# Introdução à Análise de Algoritmos - EP 1
Progama que desenvolve imagens digitais atráves de algoritmos recursivos na linguagem Java.
Feito como Exercício Programa da disciplina de Introdução à Análise de Algoritmos (ACH2002).


<img src="saidas/exemplo1.png" alt="Exemplo de Saída 1" width="400" heigth="400"/> <img src="saidas/exemplo2.png" alt="Exemplo de Saída 2" width="400" heigth="400"/> <img src="saidas/exemplo4.png" alt="Exemplo de Saída 4" width="400" heigth="400"/> <img src="saidas/exemplo5.png" alt="Exemplo de Saída 5" width="400" heigth="400"/>


## Como Usar

**Observação**: é necessário ter o Java instalado para a execução e compilação do programa.

**1.** Descompacte em uma pasta os arquivos dentro do `.zip`
   
**2.** Crie um arquivo de entrada no formato `.txt` com os comandos e seus respectivos paramêtros. Há exemplos de entradas na pasta `entradas` e na seção [Comandos e Paramêtros](#comandos-e-paramêtros) estão listados todos os comandos e paramêtros disponíveis.
   
**3.** Compile a classe Main com o comando: 
   ```cli
    javac Main.java
   ```

**4.** Execute o comando com o nome de sua entrada `.txt` e o nome do arquivo `.png` que será criado:
   ```cli
    java Main entrada.txt saida.png
   ```
   Por conta da natureza da linguagem Java algumas entradas podem estourar o limite de memória (sobretudo as que utilizam o comando `REGION_FILL`). Portanto para rodar alguns casos é necessário aumentar a memória utilizada pelo Java, usando, por exemplo, o comando:
   ```cli
    java -Xss250M Main entrada.txt saida.png
   ``` 

## Como Funciona

### Arquivo de Entrada
O arquivo de entrada é um arquivo em formato `.txt` que contem as definições para criação de uma imagem (dimensões e cor de fundo), bem como comandos de desenho a serem executados. A imagem resultante da execução dos comandos deve ser salva como nome de arquivo especicado no segundo parâmetro. O arquivo de entrada possui o seguinte formato:
```txt
    LARGURA ALTURA FUNDO_R FUNDO_G FUNDO_B
    COMANDO1 PARAM_1 PARAM_2 ... PARAM_N
    COMANDO2 PARAM_1 PARAM_2 ... PARAM_N
    ...
    COMANDON PARAM_1 PARAM_2 ... PARAM_N
```
Há exemplos de entradas na pasta `entradas`.

### Comandos e Paramêtros
Há 5 comandos disponíveis para serem usados no arquivo de entrada e na construção de uma imagem:

####  **`SET_COLOR`**
Define uma cor *RGB* que será utilizada pelos próximos comandos.

**Paramêtros:** devem ser especificados 3 parâmetros inteiros, correspondentes às componentes *r*,*g* e *b* da cor de primeiro plano (cor esta que será usada pelos comandos de desenho subsequentes). 

**Exemplo:**
   ```txt
      SET_COLOR 255 255 255  
   ```

####  **`SET_PIXEL`**
Colore um pixel em uma coordenada na imagem.

**Paramêtros:** devem ser especificados 2 parâmetro inteiros, que são as coordenadas *x* e *y* do pixel a ser colorido.

**Exemplo:**
   ```txt
      SET_PIXEL 0 512  
   ```

####  **`DRAW_LINE`**
Colore uma linha a partir da coordenal de um pixel inicial e de um pixel final.

**Paramêtros:** devem ser especificados 4 valores inteiros: *x1* e *y1*, (coordenadas de um dos pontos da reta), e *x2* e *y2* (coordenadas do outro ponto da reta).

**Exemplo:**
   ```txt
      DRAW_LINE 150 150 250 150 
   ```   

####  **`KOCH_CURVE`**
Faz uma Curva de Koch a partir de um ponto inicial, um ponto final e um limiar (quanto menor, mais iterações da curva).

Exemplo com dois limiares diferentes:

<img src="saidas/exemplo6.png" width="400" alt="Exemplo Curva de Koch">

**Paramêtros:** devem ser especificados 5 valores inteiros: *x1* e *y1* (coordenada do ponto P), *x2* e *y2* (coordenada do ponto Q),e o valor *l* do limiar.

**Exemplo:**
   ```txt
      KOCH_CURVE 0 200 512 200 10
   ```

####  **`REGION_FILL`**
Colore uma região inteira a partir da coordenada de um pixel. Semelhante à lata de tinta do Paint.

**Paramêtros:** devem ser especificados 2 valores inteiros referentes às coordenadas *x* e *y* do ponto apartir do qual o preenchimento será feito.

**Exemplo:**
   ```txt
      REGION_FILL 250 250
   ```