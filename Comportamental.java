import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void comunicar(Dispositivo origem, String mensagem);
}

abstract class Dispositivo {
    protected Mediator mediador;
    protected String nome;

    public Dispositivo(Mediator mediador, String nome) {
        this.mediador = mediador;
        this.nome = nome;
    }

    public void enviarMensagem(String mensagem) {
        mediador.comunicar(this, mensagem);
    }

    public abstract void receberMensagem(String mensagem);
}

class MediadorRede implements Mediator {
    private final List<Dispositivo> dispositivos = new ArrayList<>();

    public void adicionarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void comunicar(Dispositivo origem, String mensagem) {
        dispositivos.stream()
                .filter(d -> d != origem)
                .forEach(d -> d.receberMensagem(mensagem));
    }
}

class DispositivoLuz extends Dispositivo {
    public DispositivoLuz(Mediator mediador, String nome) {
        super(mediador, nome);
    }

    public void receberMensagem(String mensagem) {
        System.out.println(nome + " recebeu a mensagem: " + mensagem);
    }
}

class DispositivoFechadura extends Dispositivo {
    public DispositivoFechadura(Mediator mediador, String nome) {
        super(mediador, nome);
    }

    public void receberMensagem(String mensagem) {
        System.out.println(nome + " recebeu a mensagem: " + mensagem);
    }
}

class DispositivoCamera extends Dispositivo {
    public DispositivoCamera(Mediator mediador, String nome) {
        super(mediador, nome);
    }

    public void receberMensagem(String mensagem) {
        System.out.println(nome + " recebeu a mensagem: " + mensagem);
    }
}

public class Cliente {
    public static void main(String[] args) {
        MediadorRede mediador = new MediadorRede();

        Dispositivo luz = new DispositivoLuz(mediador, "Luz");
        Dispositivo fechadura = new DispositivoFechadura(mediador, "Fechadura");
        Dispositivo camera = new DispositivoCamera(mediador, "Câmera de Segurança");

        mediador.adicionarDispositivo(luz);
        mediador.adicionarDispositivo(fechadura);
        mediador.adicionarDispositivo(camera);

        luz.enviarMensagem("Ligando a luz da sala.");
        fechadura.enviarMensagem("Fechando a porta de entrada.");
        camera.enviarMensagem("Iniciando gravação de segurança.");
    }
}
