import java.util.ArrayList;
import java.util.List;

interface ComponenteMenu {
    void exibir();
}

class ItemMenu implements ComponenteMenu {
    private final String nome;

    public ItemMenu(String nome) {
        this.nome = nome;
    }

    @Override
    public void exibir() {
        System.out.println("Item de menu: " + nome);
    }
}

class Submenu implements ComponenteMenu {
    private final String nome;
    private final List<ComponenteMenu> itens = new ArrayList<>();

    public Submenu(String nome) {
        this.nome = nome;
    }

    public void adicionar(ComponenteMenu item) {
        itens.add(item);
    }

    @Override
    public void exibir() {
        System.out.println("Submenu: " + nome);
        itens.forEach(ComponenteMenu::exibir);
    }
}

public class Cliente {
    public static void main(String[] args) {
        Submenu menuPrincipal = new Submenu("Menu Principal");
        ItemMenu item1 = new ItemMenu("Item 1");
        ItemMenu item2 = new ItemMenu("Item 2");

        Submenu submenu1 = new Submenu("Submenu 1");
        submenu1.adicionar(new ItemMenu("Subitem 1.1"));
        submenu1.adicionar(new ItemMenu("Subitem 1.2"));

        menuPrincipal.adicionar(item1);
        menuPrincipal.adicionar(item2);
        menuPrincipal.adicionar(submenu1);

        menuPrincipal.exibir();
    }
}
