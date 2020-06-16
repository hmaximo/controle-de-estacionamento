package challenge;

import java.util.LinkedList;

public class Estacionamento {

    private LinkedList<Carro> vagas = new LinkedList<Carro>();

    public void estacionar(Carro carro) {
        carro.getMotorista().validaCarteiraMotorista();
        boolean removeu = false;
        if (carrosEstacionados() >= 10)
            for (int i = vagas.size() - 1; i >= 0 && !removeu; i--) {
                if (vagas.get(i).getMotorista().getIdade() <= 55) {
                    vagas.remove(i);
                    removeu = true;
                }
            }
        
        
        if (carrosEstacionados() < 10)
            this.vagas.addFirst(carro);
        else 
            throw new EstacionamentoException("Nao ha vagas!");

    }

    public int carrosEstacionados() {
        return vagas.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return vagas.contains(carro);
    }
}
