/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

/**
 *
 * @author Anderson
 */
public class DadosJogo extends Jogo {

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public int getQuantidadeJogos() {
        return quantidadeJogos;
    }

    public void setQuantidadeJogos(int quantidadeJogos) {
        this.quantidadeJogos = quantidadeJogos;
    }
    
    private int pontuacao;
    private int record;
    private int quantidadeJogos;
}
