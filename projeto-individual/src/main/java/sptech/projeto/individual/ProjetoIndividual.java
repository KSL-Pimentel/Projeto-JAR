package sptech.projeto.individual;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Bruno Silva Pimentel
 */
public class ProjetoIndividual {
    
    void exibirEscolhas (){
        System.out.println("""
                           -----------------------------
                           | O que deseja fazer agora? |
                           -----------------------------
                           |(1) Melhorar habilidades   |
                           |(2) Visitar a loja         |
                           |(3) Explorar a masmorra    |
                           |(4) Lutar contra criaturas |
                           |(5) Voltar para a cidade   |
                           -----------------------------
                           """);
    }
    
    void exibirAtributos (){
        System.out.println("""
                           -----------------------------
                           | O que deseja melhorar?    |
                           -----------------------------
                           |(1) Aumentar Força         |
                           |(2) Aumentar Vida          |
                           |(3) Aumentar Mana          |
                           |(4) Aumentar Sorte         |
                           |(5) Voltar                 |
                           -----------------------------
                           """);
    }
    
    void exibirLoja (){
        System.out.println("""
                           --------------------------------
                           | O que deseja?                |
                           --------------------------------
                           |(1) Melhorar Espada    $15.00 |
                           |(2) Melhorar Escudo    $15.00 |
                           |(3) Poção de Cura      $10.00 |
                           |(4) Poção de Mana      $10.00 |
                           |(5) Sair da Loja              |
                           --------------------------------
                           """);
    }
    
    void exibirAcoesCombate (){
        System.out.println("""
                           --------------------------------
                           | Qual seu próximo movimento?  |
                           --------------------------------
                           |(1) Atacar com Espada         |
                           |(2) Usar Magia                |
                           |(3) Usar Poção de Cura        |
                           |(4) Usar Poção de Mana        |
                           |(5) Fugir                     |
                           --------------------------------
                           """);
    }
    
    void exibirMensagemPobreza (Double ouro){
        System.out.println(String.format("Você não tem ouro suficiente...\nOuro total: $%.2f", ouro));
    }
    
    Integer usarExperiencia (Integer pontosExperiencia){
        return pontosExperiencia - 1;
    }
    
    Integer melhorarForca (Integer ataque) {
        return ataque + 2;
    }
    
    Integer melhorarVida (Integer vidaMaxima) {
        return vidaMaxima + 5;
    }
    
    Integer melhorarMana (Integer manaMaxima) {
        return manaMaxima + 5;
    }
    
    Double melhorarSorte (Double sorte) {
        return sorte + 0.1;
    }
    
    Integer melhorarEspada (Integer ataque){
        return ataque + 2;
    }
    
    Integer melhorarEscudo (Integer defesa){
        return defesa + 1;
    }
    
    Integer comprarCura (Integer pocaoCura){
        return pocaoCura + 1;
    }
    
    Integer comprarMana (Integer pocaoMana){
        return pocaoMana + 1;
    }
    
    Double gastarOuro (Double ouro, Double ouroGasto){
        return ouro - ouroGasto;
    }
    
    Double ganharOuro (Double sorte, Double ouroDropado){
        return sorte * ouroDropado;
    }
    
    String sorteiaEvento (String evento){
        Integer eventoSorteado = ThreadLocalRandom.current().nextInt(1, 11);
        
        switch (eventoSorteado) {
            case 1:
                evento = "nada";
                break;
            case 2:
                evento = "comerciante";
                break;
            case 3:
                evento = "buraco";
                break;
            case 4:
                evento = "bandido";
                break;
            case  5:
                evento = "fada";
                break;
            case 6:
                evento = "dragão";
                break;
            case 7:
                evento = "gatinhos";
                break;
            case 8:
                evento = "anel";
                break;
            case 9:
                evento = "gritos";
                break;
        }
        return evento;
        
    }
    
    void mensagemEventoNada(){
        System.out.println("""
                           -----------------------------------
                           | Você anda, anda, anda mais e... |
                           | É isso, nada acontece.          |
                           -----------------------------------
                           """);
    }
    
    void mensagemEventoComerciante(){
        System.out.println("""
                           ---------------------------------------------
                           | Você encontra um comerciante perdido,     |
                           | então decide ajudá-lo á sair deste lugar. |
                           | Agradecido, ele te oferece $50.0          |
                           ---------------------------------------------
                           """);
    }
    
    void mensagemEventoBuraco(){
        System.out.println("""
                           ---------------------------------------------------
                           | Enquanto explorava o local, devido a escuridão, |
                           | você acaba caindo em um buraco, assim, perdendo |
                           | 30 pontos de vida.                              |
                           ---------------------------------------------------
                           """);
    }
    
    Integer cairBuraco(Integer vidaAtual){
        return vidaAtual - 30;
    }
    
    void mensagemEventoBandido(){
        System.out.println("""
                           ------------------------------------------------------
                           | Um bandido surge das sombras e abate sua carteira, |
                           | porém, durante a fuga ele deixa a carteira dele    |
                           | cair,qual coincidentemente havia o mesmo valor que |
                           | foi roubado.                                       |
                           ------------------------------------------------------
                           """);
    }
    
    void mensagemEventoFada(){
        System.out.println("""
                           -------------------------------------------------------------
                           | Você encontra uma fada prestes a ser engolida por         |
                           | um sapo. Ao ajudá-la ela te recompensa com um beijo       |
                           | na bochecha, você sente sua vida aumentando em 20 pontos. |
                           -------------------------------------------------------------
                           """);
    }
    
    Integer beijoFada(Integer vidaMaxima){
        return vidaMaxima + 20;
    }
    
    void mensagemEventoDragao(){
        System.out.println("""
                           -----------------------------------------------------
                           | Você encontra um dragão muito poderoso que decide |
                           | poupar sua vida em troca de todo o seu ouro.      |
                           -----------------------------------------------------
                           """);
    }
    
    void mensagemEventoGatinhos(){
        System.out.println("""
                           -------------------------------------------------------
                           | Você ao longe vê um grupo de filhotes de gatinhos   |
                           | brincando, apesar de ser uma visão muito fofa, você |
                           | sente que isso não vai mudar em nada sua vida.      |
                           -------------------------------------------------------
                           """);
    }
    
    void mensagemEventoAnel(){
        System.out.println("""
                           ----------------------------------------------------------
                           | Você encontra um anel brilhante, ao enfiar seu dedo,   |
                           | sente um impulso de magia fluindo pelo seu corpo e que |
                           | seu dedo gordinho ficou preso. Enfim, mais 20 pontos   |
                           | de mana máxima.                                        |
                           ----------------------------------------------------------
                           """);
    }
    
    Integer anelMagico (Integer manaMaxima) {
        return manaMaxima + 20;
    }
    
    void mensagemEventoGritos(){
        System.out.println("""
                           -----------------------------------------------------------------------
                           | Você gritos enquanto caminha, porém não consegue dizer de onde vem. |
                           | Quanto mais anda pior se fica, sente uma presença te observando na  |
                           | escuridão e então, desmaia... Ao acordar se sente mais fraco.       |
                           | Perdeu todos os pontos de mana e experiência, além de perder 50     |
                           | pontos de vida.                                                     |
                           -----------------------------------------------------------------------
                           """);
    }
    
    String sorteiaInimigo (String inimigo){
        Integer inimigoSorteado = ThreadLocalRandom.current().nextInt(1, 6);
        
        switch (inimigoSorteado) {
            case 1:
                inimigo = "Slime";
                break;
            case 2:
                inimigo = "Zumbi";
                break;
            case 3:
                inimigo = "Lobo";
                break;
            case 4:
                inimigo = "Goblin";
                break;
            case  5:
                inimigo = "Inseto Gigante";
                break;
        }
        return inimigo;
    }
    
    Integer atacarInimigo (Integer vidaInimigo, Integer ataque){
        return vidaInimigo - ataque;
    }
    
    Integer gastarMana (Integer manaAtual){
        return manaAtual - 20;
    }
    
    void mensagemFaltaMana(){
        System.out.println("""
                           -----------------------------------------------------
                           | Você não sente mais poder fluindo por suas veias, |
                           | mesmo assim tenta soltar um feitiço, então...     |
                           | Você não consegue, como esperado.                 |
                           -----------------------------------------------------
                           """);
    }
    
    Integer recuperarVida(Integer vidaAtual, Integer vidaMaxima){
        return vidaAtual = vidaMaxima;
    }
    
    Integer recuperarMana(Integer manaAtual, Integer manaMaxima){
        return manaAtual = manaMaxima;
    }
    
    Integer gastarPocao(Integer pocao){
        return pocao - 1;
    }
    
    void mensagemFaltaPocao(){
        System.out.println("""
                           -------------------------------------------------
                           | Você sente que é hora de se recuperar,        |
                           | porem, quando coloca a mão em sua mochila     |
                           | não consegue achar aquela poção tão desejada. |
                           -------------------------------------------------
                           """);
    }
    
    Integer inimigoAtaca(Integer vidaAtual, Integer ataqueInimigo, Integer critico, Integer defesa){
        return vidaAtual - (ataqueInimigo + critico - defesa);
    }
    
    void mensagemAtaqueSlime1(){
        System.out.println("""
                           --------------------------------------------
                           | O Slime se aproxima lentamente de seu pé |
                           | pensando que ele não teria capacidade de |
                           | te fazer mal algum, você apenas observa, |
                           | até que ele morde seu mindinho e...      |
                           | É, doeu um pouco mas foi só isso mesmo.  |
                           --------------------------------------------
                           | Você recebeu 5 pontos de dano.           |
                           --------------------------------------------
                           """);
    }
    
    void mensagemAtaqueSlime2(){
        System.out.println("""
                           ------------------------------------------
                           | No meio desta incrivel e emocionante   |
                           | batalha, você acidentalmente escorrega |
                           | no Slime e bate a cabeça.              |
                           ------------------------------------------
                           | Você recebeu 10 pontos de dano         |
                           ------------------------------------------
                           """);
    }
    
    void mensagemAtaqueZumbi1(){
        System.out.println("""
                           --------------------------------------------
                           | O Zumbi te da uma mordida, felizmente    |
                           | você esta com suas vacinas em dia.       |
                           | Mas ainda sim, doeu bastante.            |
                           --------------------------------------------
                           | Você recebeu 15 pontos de dano.          |
                           --------------------------------------------
                           """);
    }
    
    void mensagemAtaqueZumbi2(){
        System.out.println("""
                           ------------------------------------------
                           | O Zumbi te acerta um soco na cara, doi |
                           | bem menos que as mordidas, mas o dano  |
                           | é agravado pela sua frustração de não  |
                           | conseguir desviar de um ataque tão     |
                           | lento e previsível.                    |
                           ------------------------------------------
                           | Você recebeu 20 pontos de dano         |
                           ------------------------------------------
                           """);
    }
    
    void mensagemAtaqueLobo1(){
        System.out.println("""
                           --------------------------------------------
                           | O lobo te morde!                         |
                           | É isso que os lobos fazem né?            |
                           --------------------------------------------
                           | Você recebeu 12 pontos de dano.          |
                           --------------------------------------------
                           """);
    }
    
    void mensagemAtaqueLobo2(){
        System.out.println("""
                           ------------------------------------------
                           | O lobo te morde mais forte!            |
                           | Acho que é só isso mesmo...            |
                           ------------------------------------------
                           | Você recebeu 17 pontos de dano         |
                           ------------------------------------------
                           """);
    }
    
    void mensagemAtaqueGoblin1(){
        System.out.println("""
                           --------------------------------------------
                           | O goblin te da um chute na canela, você  |
                           | ri para desestabilizá-lo, mesmo tendo    |
                           | doído. Mas isso ele não precisa saber.   |
                           --------------------------------------------
                           | Você recebeu 10 pontos de dano.          |
                           --------------------------------------------
                           """);
    }
    
    void mensagemAtaqueGoblin2(){
        System.out.println("""
                           ------------------------------------------
                           | Cansado de seu desaforo, o goblin puxa |
                           | um canivete e parte pra cima.          |
                           ------------------------------------------
                           | Você recebeu 15 pontos de dano         |
                           ------------------------------------------
                           """);
    }
    
    void mensagemAtaqueInseto1(){
        System.out.println("""
                           --------------------------------------------
                           | Aquele inseto gigante e nojento encosta  |
                           | sua pata gigante e nojenta em você, não  |
                           | doeu nada, pelo menos não fisicamente... |
                           --------------------------------------------
                           | Você recebeu 8 pontos de dano.           |
                           --------------------------------------------
                           """);
    }
    
    void mensagemAtaqueInseto2(){
        System.out.println("""
                           ------------------------------------------
                           | O inseto cospe seu suco intestinal em  |
                           | você, verdade que levariam horas até   |
                           | isso começar a fazer efeito, mas ainda |
                           | ta ardendo um pouco.                   |
                           ------------------------------------------
                           | Você recebeu 12 pontos de dano         |
                           ------------------------------------------
                           """);
    }
    
    void mensagemVitoria(){
        System.out.println("""
                           --------------------------------------------
                           | Parabéns, você venceu esta batalha épica |
                           --------------------------------------------
                           """);
    }
    
    void mensagemFuga(){
        System.out.println("""
                           -------------------------------------
                           | Você decide que não vale mais     |
                           | a pena se arriscar nesta batalha, |
                           | então como um bom estrategista,   |
                           | você corre!!!                     |
                           -------------------------------------
                           """);               
    }
    
    void mensagemDerrota(){
        System.out.println("""
                           -----------------------------------------------
                           | Você não consegue mais continuar lutando... |
                           -----------------------------------------------
                           """);
    }
    
    void mensagemFinal(){
        System.out.println("""
                           ---------------------------------
                           | Sua Jornada chega ao fim...   |
                           | Você decide que já é hora de  |
                           | voltar para casa e descansar. |
                           ---------------------------------
                           """);
    }
}
