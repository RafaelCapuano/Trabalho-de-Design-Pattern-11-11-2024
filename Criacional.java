interface Veiculo {
    void executarAcao();
}

enum TipoAmbiente {
    CIDADE, CAMPO
}

class FabricaDeVeiculos {
    public static Veiculo criarVeiculo(TipoAmbiente ambiente, Class<? extends Veiculo> tipoVeiculo) {
        if (ambiente == TipoAmbiente.CIDADE) {
            if (tipoVeiculo == Carro.class) return new CarroCidade();
            if (tipoVeiculo == Bicicleta.class) return new BicicletaCidade();
            if (tipoVeiculo == Caminhao.class) return new CaminhaoCidade();
        } else if (ambiente == TipoAmbiente.CAMPO) {
            if (tipoVeiculo == Carro.class) return new CarroCampo();
            if (tipoVeiculo == Bicicleta.class) return new BicicletaCampo();
            if (tipoVeiculo == Caminhao.class) return new CaminhaoCampo();
        }
        return null;
    }
}

class CarroCidade implements Veiculo {
    public void executarAcao() {
        System.out.println("Dirigindo carro na cidade.");
    }
}

class BicicletaCidade implements Veiculo {
    public void executarAcao() {
        System.out.println("Pedalando bicicleta na cidade.");
    }
}

class CaminhaoCidade implements Veiculo {
    public void executarAcao() {
        System.out.println("Carregando caminhão na cidade.");
    }
}

class CarroCampo implements Veiculo {
    public void executarAcao() {
        System.out.println("Dirigindo carro no campo.");
    }
}

class BicicletaCampo implements Veiculo {
    public void executarAcao() {
        System.out.println("Pedalando bicicleta no campo.");
    }
}

class CaminhaoCampo implements Veiculo {
    public void executarAcao() {
        System.out.println("Carregando caminhão no campo.");
    }
}

class Cliente {
    public static void main(String[] args) {
        fabricaVeiculos(TipoAmbiente.CIDADE);
        fabricaVeiculos(TipoAmbiente.CAMPO);
    }

    static void fabricaVeiculos(TipoAmbiente ambiente) {
        Veiculo carro = FabricaDeVeiculos.criarVeiculo(ambiente, Carro.class);
        Veiculo bicicleta = FabricaDeVeiculos.criarVeiculo(ambiente, Bicicleta.class);
        Veiculo caminhao = FabricaDeVeiculos.criarVeiculo(ambiente, Caminhao.class);

        carro.executarAcao();
        bicicleta.executarAcao();
        caminhao.executarAcao();
    }
}
