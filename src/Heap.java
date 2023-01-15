import java.util.ArrayList;
import java.util.Comparator;

public class Heap {
    //Min-heap: as chaves dos filhos são maiores ou iguais às chaves dos pais

    ArrayList<No> heapArray;
    Comparator<Integer> comparaChaves = new Comparator<Integer>() {
        @Override
        public int compare(Integer chave1, Integer chave2) {
            // se a primeira chave é menor que a segunda, o método retorna um número negativo,"-1"
            if (chave1 < chave2) {
                return -1;
            }
            // se a primeira chave é maior que a segunda, o método retorna um número positivo,"1"
            if (chave1 > chave2) {
                return 1;
            }
            // se a primeira chave é igual à segunda, o método retorna "0"
            else {
                return 0;
            }

        }
    };

    public Heap() {
        this.heapArray = new ArrayList<>();
    }

    public void addChave(int chave, Object elemento) {
        heapArray.add(new No(chave, elemento));
        upHeap(heapArray.size() - 1);

    }

    public void upHeap(int index ) {
        int pai = (index - 1) / 2;
        if (index > 0 && comparaChaves.compare(heapArray.get(index).chave, heapArray.get(pai).chave) < 0){
            // se o index é maior que o pai é trocado o nó passado com o pai
            No temp = heapArray.get(index);
            heapArray.set(index,heapArray.get(pai));
            heapArray.set(pai, temp);
            // faz a mesma coisa para que o pai fique no local correto e continuar a ordem da heap
            upHeap(pai);
        }

    }

    public Object removeMin() throws InvalidKeyException {
        // checando se a heap ta vazia
        if (isEmpty()) {
            throw new InvalidKeyException("Não é possível excluir essa chave pois a heap se encontra vazia");
        }
        Object raiz = heapArray.get(0);
        // pegando o nó inicial é guardando ele na variável de raiz (só para fazer o return)
        // sempre é a raiz que vai ser removida
        heapArray.set(0, heapArray.get(heapArray.size()-1));
        // pegando o último nó e setando ele como raiz para depois fazer a ordenação
        heapArray.remove(heapArray.size() -1);
        // e agora remove esse elemento já que ele foi colocado no lugar do primiero
        downHeap(0);
        // checar o "raiz" para continuar com a ordem da heap
        return raiz;
        // retornando o raiz que foi removido
    }

    public void downHeap(int index){
        int filhoEsquerdo = 2 * index + 1;
        int filhoDireito = 2 * index + 2;
        // pegar os filhos desse index passado (contas loucas)
        int menor = index;
        // define que o menor index é esse passado no parâmetro (mesmo que não seja, é só para inicializar msm)
        if (filhoEsquerdo < heapArray.size() && comparaChaves.compare(heapArray.get(filhoEsquerdo).chave,
                (heapArray.get(menor).chave)) < 0){
            // verifica se o filho esuqerdo existe "(índex < heapArray.size())"
            // e compara a chave do filho esquerdo com o nó atual, se ele for menor entao:
            menor = filhoEsquerdo;
        }
        if(filhoDireito < heapArray.size() && comparaChaves.compare(heapArray.get(filhoDireito).chave,
                (heapArray.get(menor).chave)) < 0){
            // agora a mesma coisa, contudo com o filho direito
            menor = filhoDireito ;
        }
        if(menor != index){
            No temp = heapArray.get(index);
            heapArray.set(index, heapArray.get(menor));
            heapArray.set(menor, temp);
            // continuar com a ordem da heap
            downHeap(menor);
        }

    }

    public Object min() throws InvalidKeyException {
        // checando se a heap ta vazia
        if (isEmpty()) {
            throw new InvalidKeyException("Não é retornar essa chave pois a heap se encontra vazia");
        }
        return heapArray.get(0);
    }

    public boolean isEmpty() {
        return heapArray.size() == 0;
    }

    public int size() {
        return heapArray.size();
    }

    public void imprimirHeap() {
        for (int i = 0; i < heapArray.size(); i++) {
            System.out.println("Nó " + i + ": chave= " + heapArray.get(i).chave + " elemento= " + heapArray.get(i).elemento);

        }
    }
    }


