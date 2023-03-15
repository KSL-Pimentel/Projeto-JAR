package sptech.projeto.individual;

import java.util.Scanner;

/**
 *
 * @author Bruno Silva Pimentel
 */
public class TesteProjetoIndividual {
    public static void main(String[] args) {
        
        ProjetoIndividual rpg = new ProjetoIndividual();
        Scanner leitor = new Scanner(System.in);
        
        Integer escolha;
        Integer escolhaAtributos;
        Integer escolhaLoja;
        Integer escolhaCombate = 0;
        
        Integer pontosExperiencia = 0;
        Integer ataque = 5;
        Integer magia = 20;
        Integer vidaMaxima = 100;
        Integer vidaAtual = 100;
        Integer manaMaxima = 100;
        Integer manaAtual = 100;
        Integer defesa = 0;
        Integer pocaoCura = 0;
        Integer pocaoMana = 0;
        Double ouro = 0.0;
        Double sorte = 1.0;
        
        String evento = "";
        
        String inimigo = "";
        Integer vidaInimigo;
        Integer ataqueInimigo;
        
        Integer inimigosDerrotados = 0;
        Integer slimesDerrotados = 0;
        Integer zumbisDerrotados = 0;
        Integer lobosDerrotados = 0;
        Integer goblinsDerrotados = 0;
        Integer insetosDerrotados = 0;
        
        do {
            rpg.exibirEscolhas();
            escolha = leitor.nextInt();
            
            switch (escolha) {
                
                // Melhorar suas habilidades
                case 1 -> {
                    System.out.println("""
                                       ------------------------------------------------------
                                       | Você se senta perto de uma fogueira para descansar |
                                       | e refletir sobre suas experiências.                |
                                       ------------------------------------------------------
                                       """);
                    do {
                        rpg.exibirAtributos();
                        escolhaAtributos = leitor.nextInt();
                        
                        if (pontosExperiencia > 0) {
                            switch (escolhaAtributos) {
                                case 1:
                                    ataque = rpg.melhorarForca(ataque);
                                    pontosExperiencia = rpg.usarExperiencia(pontosExperiencia);
                                
                                    System.out.println(String.format("Você se sente mais forte!\nAtaque atual: %d\nPontos de experiência: %d", ataque, pontosExperiencia));
                                    break;
                                case 2:
                                    vidaMaxima = rpg.melhorarVida(vidaMaxima);
                                    pontosExperiencia = rpg.usarExperiencia(pontosExperiencia);
                                
                                    System.out.println(String.format("Você se sente mais disposto!\nVida máxima: %d\nPontos de experiência: %d", vidaMaxima, pontosExperiencia));
                                    break;
                                case 3:
                                    manaMaxima = rpg.melhorarMana(manaMaxima);
                                    pontosExperiencia = rpg.usarExperiencia(pontosExperiencia);
                                
                                    System.out.println(String.format("Você se sente mais poderoso!\nMana máxima: %d\nPontos de experiência: %d", manaMaxima, pontosExperiencia));
                                    break;
                                case 4:
                                    sorte = rpg.melhorarSorte(sorte);
                                    pontosExperiencia = rpg.usarExperiencia(pontosExperiencia);
                                
                                    System.out.println(String.format("Você se sente mais sortudo!\nPontos de experiência: %d", pontosExperiencia));
                                    break;
                            }
                        } else {
                            System.out.println("""
                                               --------------------------------------
                                               | Você não possui experiências novas |
                                               | que precisam ser refletidas        |
                                               --------------------------------------
                                               """);
                        }
                    } while (escolhaAtributos != 5);
                    break;
                }
                
                // Visitar a Lojinha
                case 2 -> {
                    System.out.println("""
                                       --------------------------------
                                       | Bem vindo(a) aventureiro(a)! |
                                       --------------------------------
                                       """);
                    do {
                        rpg.exibirLoja();
                        escolhaLoja = leitor.nextInt();
                        
                        switch (escolhaLoja) {
                            case 1:
                                if (ouro >= 15.0) {
                                    ataque = rpg.melhorarEspada(ataque);
                                    ouro = rpg.gastarOuro(ouro, 15.0);
                                
                                    System.out.println(String.format("Seu Ataque aumentou em 5 pontos!\nAtaque atual: %d\nOuro total: $%.2f", ataque, ouro));
                                } else {
                                    rpg.exibirMensagemPobreza(ouro);
                                }
                                break;
                            case 2:
                                if (ouro >= 15.0) {
                                    defesa = rpg.melhorarEscudo(defesa);
                                    ouro = rpg.gastarOuro(ouro, 15.0);
                                
                                    System.out.println(String.format("Sua defesa aumentou em 5 pontos!\nDefesa atual: %d\nOuro total: $%.2f", defesa, ouro));
                                } else {
                                    rpg.exibirMensagemPobreza(ouro);
                                }
                                break;
                            case 3:
                                if (ouro >= 10.0) {
                                    pocaoCura = rpg.comprarCura(pocaoCura);
                                    ouro = rpg.gastarOuro(ouro, 10.0);
                                
                                    System.out.println(String.format("Você comprou uma poção de Cura!\nPoções de Cura: %d\nOuro total: $%.2f", pocaoCura, ouro));
                                } else {
                                    rpg.exibirMensagemPobreza(ouro);
                                }
                                break;
                            case 4:
                                if (ouro >= 10.0) {
                                    pocaoMana = rpg.comprarMana(pocaoMana);
                                    ouro = rpg.gastarOuro(ouro, 10.0);
                                
                                    System.out.println(String.format("Você comprou uma poção de Mana!\nPoções de Mana: %d\nOuro total: $%.2f", pocaoMana, ouro));
                                } else {
                                    rpg.exibirMensagemPobreza(ouro);
                                }
                                break;
                        }
                    } while (escolhaLoja != 5);
                    
                    System.out.println("""
                                       --------------------------------
                                       | Volte sempre!                |
                                       --------------------------------
                                       """);
                }
                
                // Exibir um evento de exploração aleatorio
                case 3 -> {
                    evento = rpg.sorteiaEvento(evento);
                    
                    if (evento.equals("nada")){
                        rpg.mensagemEventoNada();
                    } else if (evento.equals("comerciante")){
                        rpg.mensagemEventoComerciante();
                        ouro += rpg.ganharOuro(1.0, 50.0);
                    } else if (evento.equals("buraco")){
                        rpg.mensagemEventoBuraco();
                        vidaAtual = rpg.cairBuraco(vidaAtual);
                    } else if (evento.equals("bandido")){
                        rpg.mensagemEventoBandido();
                    } else if (evento.equals("fada")){
                        rpg.mensagemEventoFada();
                        vidaMaxima = rpg.beijoFada(vidaMaxima);
                    } else if (evento.equals("dragão")){
                        rpg.mensagemEventoDragao();
                        ouro = 0.0;
                    } else if (evento.equals("gatinhos")){
                        rpg.mensagemEventoGatinhos();
                    } else if (evento.equals("anel")) {
                        rpg.mensagemEventoAnel();
                        manaMaxima = rpg.anelMagico(manaMaxima);
                    } else {
                        rpg.mensagemEventoGritos();
                        manaAtual = 0;
                        pontosExperiencia = 0;
                        vidaAtual -= 50;
                    }
                }
                
                // Batalha contra os inimigos da masmorra
                case 4 -> {
                    
                    if(vidaAtual > 0){
                        
                    inimigo = rpg.sorteiaInimigo(inimigo);
                    System.out.println(String.format("Você avança cada vez mais na masmorra até que um %s aparece!!!", inimigo));
                    Integer turno = 0;
                    
                    // Batalha contra o Slime
                    if (inimigo.equals("Slime")) {
                        vidaInimigo = 20;
                        ataqueInimigo = 5;
                                               
                        while(vidaInimigo > 0 && escolhaCombate != 5){
                            System.out.println(String.format("%s\nVida: %d\n-------------------------------------------------------------", inimigo, vidaInimigo));
                            System.out.println(String.format("Você\nVida: %d | Mana: %d\nPoções Cura: %d | Poções Mana: %d", vidaAtual, manaAtual, pocaoCura, pocaoMana));
                            rpg.exibirAcoesCombate();
                            escolhaCombate = leitor.nextInt();
                            
                            switch (escolhaCombate) {
                                case 1:
                                    vidaInimigo = rpg.atacarInimigo(vidaInimigo, ataque);
                                    break;
                                case 2:
                                    if (manaAtual >= 20) {
                                        vidaInimigo = rpg.atacarInimigo(vidaInimigo, magia);
                                        manaAtual = rpg.gastarMana(manaAtual);
                                    } else {
                                        rpg.mensagemFaltaMana();
                                    }
                                    break;
                                case 3:
                                    if (pocaoCura >= 1) {
                                        pocaoCura = rpg.gastarPocao(pocaoCura);
                                        vidaAtual = rpg.recuperarVida(vidaAtual, vidaMaxima);
                                    } else {
                                        rpg.mensagemFaltaPocao();
                                    }
                                    break;
                                case 4:
                                    if (pocaoMana >= 1) {
                                        pocaoMana = rpg.gastarPocao(pocaoMana);
                                        manaAtual = rpg.recuperarMana(manaAtual, manaMaxima);
                                    } else {
                                        rpg.mensagemFaltaPocao();
                                    }
                                    break;
                                case 5:
                                    rpg.mensagemFuga();
                            }
                            
                            turno++;
                            
                            if(escolhaCombate != 5){
                                if(vidaInimigo > 0 && escolhaCombate != 5){
                                    if (turno % 3 == 0) {
                                        vidaAtual = rpg.inimigoAtaca(vidaAtual, ataqueInimigo, 5, defesa);
                                        rpg.mensagemAtaqueSlime2();
                                    } else {
                                        vidaAtual = rpg.inimigoAtaca(vidaAtual, ataqueInimigo, 0, defesa);
                                        rpg.mensagemAtaqueSlime1();
                                    }
                                } else {
                                    inimigosDerrotados++;
                                    slimesDerrotados++;
                                    ouro += rpg.ganharOuro(sorte, 5.0);
                                    pontosExperiencia++;
                                    rpg.mensagemVitoria();
                                    System.out.println(String.format("Você ganhou $%.2f e 1 ponto de esxperiência.", rpg.ganharOuro(sorte, 5.0)));
                                }
                            }
                            
                            if(vidaAtual <= 0){
                                rpg.mensagemDerrota();
                                break;
                            }
                        }
                        
                    // Batalha contra o Zumbi
                    } else if (inimigo.equals("Zumbi")) {
                        vidaInimigo = 50;
                        ataqueInimigo = 15;
                        
                        while(vidaInimigo > 0 && escolhaCombate != 5){
                            System.out.println(String.format("%s\nVida: %d\n-------------------------------------------------------------", inimigo, vidaInimigo));
                            System.out.println(String.format("Você\nVida: %d | Mana: %d\nPoções Cura: %d | Poções Mana: %d", vidaAtual, manaAtual, pocaoCura, pocaoMana));
                            rpg.exibirAcoesCombate();
                            escolhaCombate = leitor.nextInt();
                            
                            switch (escolhaCombate) {
                                case 1:
                                    vidaInimigo = rpg.atacarInimigo(vidaInimigo, ataque);
                                    break;
                                case 2:
                                    if (manaAtual >= 20) {
                                        vidaInimigo = rpg.atacarInimigo(vidaInimigo, magia);
                                        manaAtual = rpg.gastarMana(manaAtual);
                                    } else {
                                        rpg.mensagemFaltaMana();
                                    }
                                    break;
                                case 3:
                                    if (pocaoCura >= 1) {
                                        pocaoCura = rpg.gastarPocao(pocaoCura);
                                        vidaAtual = rpg.recuperarVida(vidaAtual, vidaMaxima);
                                    } else {
                                        rpg.mensagemFaltaPocao();
                                    }
                                    break;
                                case 4:
                                    if (pocaoMana >= 1) {
                                        pocaoMana = rpg.gastarPocao(pocaoMana);
                                        manaAtual = rpg.recuperarMana(manaAtual, manaMaxima);
                                    } else {
                                        rpg.mensagemFaltaPocao();
                                    }
                                    break;
                                case 5:
                                    rpg.mensagemFuga();
                            }
                            
                            turno++;
                            
                            if(escolhaCombate != 5){
                                if(vidaInimigo > 0 && escolhaCombate != 5){
                                    if (turno % 3 == 0) {
                                        vidaAtual = rpg.inimigoAtaca(vidaAtual, ataqueInimigo, 5, defesa);
                                        rpg.mensagemAtaqueZumbi2();
                                    } else {
                                        vidaAtual = rpg.inimigoAtaca(vidaAtual, ataqueInimigo, 0, defesa);
                                        rpg.mensagemAtaqueZumbi1();
                                    }
                                } else {
                                    inimigosDerrotados++;
                                    zumbisDerrotados++;
                                    ouro += rpg.ganharOuro(sorte, 15.0);
                                    pontosExperiencia++;
                                    rpg.mensagemVitoria();
                                    System.out.println(String.format("Você ganhou $%.2f e 1 ponto de esxperiência.", rpg.ganharOuro(sorte, 15.0)));
                                }
                            }
                            
                            if(vidaAtual <= 0){
                                rpg.mensagemDerrota();
                                break;
                            }
                        }
                        
                    // Batalha contra o Lobo    
                    } else if (inimigo.equals("Lobo")) {
                        vidaInimigo = 40;
                        ataqueInimigo = 12;
                        
                        while(vidaInimigo > 0 && escolhaCombate != 5){
                            System.out.println(String.format("%s\nVida: %d\n-------------------------------------------------------------", inimigo, vidaInimigo));
                            System.out.println(String.format("Você\nVida: %d | Mana: %d\nPoções Cura: %d | Poções Mana: %d", vidaAtual, manaAtual, pocaoCura, pocaoMana));
                            rpg.exibirAcoesCombate();
                            escolhaCombate = leitor.nextInt();
                            
                            switch (escolhaCombate) {
                                case 1:
                                    vidaInimigo = rpg.atacarInimigo(vidaInimigo, ataque);
                                    break;
                                case 2:
                                    if (manaAtual >= 20) {
                                        vidaInimigo = rpg.atacarInimigo(vidaInimigo, magia);
                                        manaAtual = rpg.gastarMana(manaAtual);
                                    } else {
                                        rpg.mensagemFaltaMana();
                                    }
                                    break;
                                case 3:
                                    if (pocaoCura >= 1) {
                                        pocaoCura = rpg.gastarPocao(pocaoCura);
                                        vidaAtual = rpg.recuperarVida(vidaAtual, vidaMaxima);
                                    } else {
                                        rpg.mensagemFaltaPocao();
                                    }
                                    break;
                                case 4:
                                    if (pocaoMana >= 1) {
                                        pocaoMana = rpg.gastarPocao(pocaoMana);
                                        manaAtual = rpg.recuperarMana(manaAtual, manaMaxima);
                                    } else {
                                        rpg.mensagemFaltaPocao();
                                    }
                                    break;
                                case 5:
                                    rpg.mensagemFuga();
                            }
                            
                            turno++;
                            
                            if(escolhaCombate != 5){
                                if(vidaInimigo > 0 && escolhaCombate != 5){
                                    if (turno % 3 == 0) {
                                        vidaAtual = rpg.inimigoAtaca(vidaAtual, ataqueInimigo, 5, defesa);
                                        rpg.mensagemAtaqueLobo2();
                                    } else {
                                        vidaAtual = rpg.inimigoAtaca(vidaAtual, ataqueInimigo, 0, defesa);
                                        rpg.mensagemAtaqueLobo1();
                                    }
                                } else {
                                    inimigosDerrotados++;
                                    lobosDerrotados++;
                                    ouro += rpg.ganharOuro(sorte, 12.0);
                                    pontosExperiencia++;
                                    rpg.mensagemVitoria();
                                    System.out.println(String.format("Você ganhou $%.2f e 1 ponto de esxperiência.", rpg.ganharOuro(sorte, 12.0)));
                                }
                            }
                            
                            if(vidaAtual <= 0){
                                rpg.mensagemDerrota();
                                break;
                            }
                        }
                        
                    // Batalha contra o Goblin
                    } else if (inimigo.equals("Goblin")) {
                        vidaInimigo = 30;
                        ataqueInimigo = 10;
                        
                        while(vidaInimigo > 0 && escolhaCombate != 5){
                            System.out.println(String.format("%s\nVida: %d\n-------------------------------------------------------------", inimigo, vidaInimigo));
                            System.out.println(String.format("Você\nVida: %d | Mana: %d\nPoções Cura: %d | Poções Mana: %d", vidaAtual, manaAtual, pocaoCura, pocaoMana));
                            rpg.exibirAcoesCombate();
                            escolhaCombate = leitor.nextInt();
                            
                            switch (escolhaCombate) {
                                case 1:
                                    vidaInimigo = rpg.atacarInimigo(vidaInimigo, ataque);
                                    break;
                                case 2:
                                    if (manaAtual >= 20) {
                                        vidaInimigo = rpg.atacarInimigo(vidaInimigo, magia);
                                        manaAtual = rpg.gastarMana(manaAtual);
                                    } else {
                                        rpg.mensagemFaltaMana();
                                    }
                                    break;
                                case 3:
                                    if (pocaoCura >= 1) {
                                        pocaoCura = rpg.gastarPocao(pocaoCura);
                                        vidaAtual = rpg.recuperarVida(vidaAtual, vidaMaxima);
                                    } else {
                                        rpg.mensagemFaltaPocao();
                                    }
                                    break;
                                case 4:
                                    if (pocaoMana >= 1) {
                                        pocaoMana = rpg.gastarPocao(pocaoMana);
                                        manaAtual = rpg.recuperarMana(manaAtual, manaMaxima);
                                    } else {
                                        rpg.mensagemFaltaPocao();
                                    }
                                    break;
                                case 5:
                                    rpg.mensagemFuga();
                            }
                            
                            turno++;
                            
                            if(escolhaCombate != 5){
                                if(vidaInimigo > 0 && escolhaCombate != 5){
                                    if (turno % 3 == 0) {
                                        vidaAtual = rpg.inimigoAtaca(vidaAtual, ataqueInimigo, 5, defesa);
                                        rpg.mensagemAtaqueGoblin2();
                                    } else {
                                        vidaAtual = rpg.inimigoAtaca(vidaAtual, ataqueInimigo, 0, defesa);
                                        rpg.mensagemAtaqueGoblin1();
                                    }
                                } else {
                                    inimigosDerrotados++;
                                    goblinsDerrotados++;
                                    ouro += rpg.ganharOuro(sorte, 10.0);
                                    pontosExperiencia++;
                                    rpg.mensagemVitoria();
                                    System.out.println(String.format("Você ganhou $%.2f e 1 ponto de esxperiência.", rpg.ganharOuro(sorte, 10.0)));
                                }
                            }
                            
                            if(vidaAtual <= 0){
                                rpg.mensagemDerrota();
                                break;
                            }
                        }
                        
                    // Batalha contra o Inseto Gigante
                    } else {
                        vidaInimigo = 40;
                        ataqueInimigo = 8;
                        
                        while(vidaInimigo > 0 && escolhaCombate != 5){
                            System.out.println(String.format("%s\nVida: %d\n-------------------------------------------------------------", inimigo, vidaInimigo));
                            System.out.println(String.format("Você\nVida: %d | Mana: %d\nPoções Cura: %d | Poções Mana: %d", vidaAtual, manaAtual, pocaoCura, pocaoMana));
                            rpg.exibirAcoesCombate();
                            escolhaCombate = leitor.nextInt();
                            
                            switch (escolhaCombate) {
                                case 1:
                                    vidaInimigo = rpg.atacarInimigo(vidaInimigo, ataque);
                                    break;
                                case 2:
                                    if (manaAtual >= 20) {
                                        vidaInimigo = rpg.atacarInimigo(vidaInimigo, magia);
                                        manaAtual = rpg.gastarMana(manaAtual);
                                    } else {
                                        rpg.mensagemFaltaMana();
                                    }
                                    break;
                                case 3:
                                    if (pocaoCura >= 1) {
                                        pocaoCura = rpg.gastarPocao(pocaoCura);
                                        vidaAtual = rpg.recuperarVida(vidaAtual, vidaMaxima);
                                    } else {
                                        rpg.mensagemFaltaPocao();
                                    }
                                    break;
                                case 4:
                                    if (pocaoMana >= 1) {
                                        pocaoMana = rpg.gastarPocao(pocaoMana);
                                        manaAtual = rpg.recuperarMana(manaAtual, manaMaxima);
                                    } else {
                                        rpg.mensagemFaltaPocao();
                                    }
                                    break;
                                case 5:
                                    rpg.mensagemFuga();                                    
                            }
                            
                            turno++;
                            
                            if(escolhaCombate != 5){
                                if(vidaInimigo > 0){
                                    if (turno % 3 == 0) {
                                        vidaAtual = rpg.inimigoAtaca(vidaAtual, ataqueInimigo, 5, defesa);
                                        rpg.mensagemAtaqueInseto2();
                                    } else {
                                        vidaAtual = rpg.inimigoAtaca(vidaAtual, ataqueInimigo, 0, defesa);
                                        rpg.mensagemAtaqueInseto1();
                                    }
                                } else {
                                    inimigosDerrotados++;
                                    insetosDerrotados++;
                                    ouro += rpg.ganharOuro(sorte, 8.0);
                                    pontosExperiencia++;
                                    rpg.mensagemVitoria();
                                    System.out.println(String.format("Você ganhou $%.2f e 1 ponto de esxperiência.", rpg.ganharOuro(sorte, 8.0)));
                                }
                            }
                            
                            if(vidaAtual <= 0){
                                rpg.mensagemDerrota();
                                break;
                            }
                        }
                    }
                    escolhaCombate = 0;
                    
                    break;
                     
                    } else {
                        rpg.mensagemDerrota();
                    }
                }
                
                // Encerra o programa
                case 5 -> {
                    rpg.mensagemFinal();
                    
                    System.out.println(String.format("Você derrotou %d inimigos\n%d Slimes\n%d Zumbis\n%d Lobos\n%d Goblins\n%d Insetos Gigantes", inimigosDerrotados, slimesDerrotados, zumbisDerrotados, lobosDerrotados, goblinsDerrotados, insetosDerrotados));
                }
            }
        } while (escolha != 5);
    }
}
